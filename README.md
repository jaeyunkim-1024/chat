# 채팅 소켓

# 개발 환경
JDK 최소 17 이상
H2 DataBase 사용 하였습니다.

# Package Tree

## 사용자
📦user <br/>
┣ 📂controller <br/>
┃ ┣ 📜JoinController.java <br/>
┃ ┗ 📜LoginController.java <br/>
┣ 📂dto <br/>
┃ ┣ 📜LoginRequestDto.java <br/>
┃ ┣ 📜UserDto.java <br/>
┃ ┗ 📜UserJoinRequestDto.java <br/>
┣ 📂entity <br/>
┃ ┣ 📜LoginHistory.java <br/>
┃ ┗ 📜User.java <br/>
┣ 📂repository <br/>
┃ ┣ 📜LoginHistoryRepository.java <br/>
┃ ┗ 📜UserRepository.java <br/>
┗ 📂service <br/>
┃ ┣ 📜JoinService.java <br/>
┃ ┗ 📜LoginService.java <br/>

## 채팅
📦chat <br/>
┣ 📂config <br/>
┃ ┣ 📜StompHandler.java <br/>
┃ ┗ 📜WebSocketConfig.java <br/>
┣ 📂controller <br/>
┃ ┗ 📜MessageController.java <br/>
┣ 📂dto <br/>
┃ ┗ 📜MessageDto.java <br/>
┣ 📂entity <br/>
┃ ┗ 📜Message.java <br/>
┣ 📂repo <br/>
┃ ┗ 📜MessageRepository.java <br/>
┗ 📂service <br/>
┃ ┗ 📜MessageService.java <br/>

