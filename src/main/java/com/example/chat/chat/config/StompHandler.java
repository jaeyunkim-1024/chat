package com.example.chat.chat.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 99)

public class StompHandler implements ChannelInterceptor {
    // websocket을 통해 들어온 요청이 처리 되기전 실행됨
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        StompCommand command = accessor.getCommand();
        if(command == StompCommand.DISCONNECT){
            return message;
        }else{
            String joinChatNo = accessor.getFirstNativeHeader("joinChatNo");
            String isForbidden = accessor.getFirstNativeHeader("isForbidden");
            String destination = accessor.getDestination();
            if(joinChatNo != null && isForbidden != null && isForbidden.equals("N")){
                String target = "/send/" + joinChatNo;
                if(target.equals(destination)){
                    return message;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }

    }
}
