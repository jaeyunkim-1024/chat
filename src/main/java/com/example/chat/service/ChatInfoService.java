package com.example.chat.service;

import com.example.chat.dto.ChatDto;
import com.example.chat.entity.ChatInfo;
import com.example.chat.entity.ChatUserList;
import com.example.chat.repo.ChatInfoRepository;
import com.example.chat.repo.ChatUserListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ChatInfoService {
    @Autowired
    private ChatInfoRepository chatInfoRepository;

    @Autowired
    private ChatUserListRepository chatUserListRepository;

    public List<ChatDto> getChatList(){
        List<ChatInfo> list = chatInfoRepository.findChatInfosByChatEnable("Y");
        return list.stream().map(ChatDto::fromEntity).toList();
    }

    public void join(Long chatNo, Long custIdx){
        List<ChatUserList> chatUserList = chatUserListRepository.findChatUserListsByChatNo(chatNo);
        HashSet<Long> userList = new HashSet<>(chatUserList.stream().map(ChatUserList::getCustIdx).toList());
        if(!userList.contains(custIdx)){
            ChatUserList newChatUserList = new ChatUserList(
                    null,
                    chatNo,
                    custIdx,
                    null
            );
            chatUserListRepository.save(newChatUserList);
        }
    }

    public ChatDto create(ChatDto dto,Long custIdx){
        ChatInfo entity = ChatInfo.toEntity(dto,custIdx);
        ChatInfo result = chatInfoRepository.save(entity);
        ChatUserList chatUserList = new ChatUserList(null,result.getChatNo(),custIdx,null);
        chatUserListRepository.save(chatUserList);

        return ChatDto.fromEntity(result);
    }

    public void exit(Long chatNo, Long custIdx){
        ChatUserList chatUserList = new ChatUserList(
                null,
                chatNo,
                custIdx,
                null
        );
        chatUserListRepository.delete(chatUserList);
    }
}
