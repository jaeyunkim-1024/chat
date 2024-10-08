-- 테이블 생성 SQL - CUSTOMER
CREATE TABLE CUSTOMER
(
    `CUST_IDX`  INT            NOT NULL    AUTO_INCREMENT COMMENT 'CUST_IDX. 인덱스',
    `LOGIN_ID`  VARCHAR(50)    NOT NULL    COMMENT 'LOGIN_ID. 로그인 아이디',
    `CUST_PWD`  VARCHAR(50)    NOT NULL    COMMENT 'CUST_PWD. 비밀번호',
    `CUST_NM`   VARCHAR(50)    NOT NULL    COMMENT 'CUST_NM. 사용자 이름',
    PRIMARY KEY (CUST_IDX)
);

-- 테이블 Comment 설정 SQL - CUSTOMER
-- ALTER TABLE CUSTOMER COMMENT '사용자. 사용자 테이블';

-- Unique Index 설정 SQL - CUSTOMER(LOGIN_ID)
CREATE UNIQUE INDEX UQ_CUSTOMER_1
    ON CUSTOMER(LOGIN_ID);

-- 테이블 생성 SQL - CHAT_INFO
CREATE TABLE CHAT_INFO
(
    `CHAT_NO`      INT            NOT NULL    AUTO_INCREMENT COMMENT 'CHAT_NO. 채팅방 번호',
    `ADMIN_IDX`    VARCHAR(50)    NOT NULL    COMMENT 'ADMIN_IDX. 관리자 인덱스',
    `CHAT_TITLE`   VARCHAR(50)    NOT NULL    COMMENT 'CHAT_TITLE. 채팅방 제목',
    `CHAT_ENABLE`  CHAR(1)        NOT NULL    DEFAULT 'Y' COMMENT 'CHAT_ENABLE. 채팅방 활성 여부',
    PRIMARY KEY (CHAT_NO)
);

-- 테이블 Comment 설정 SQL - CHAT_INFO
-- ALTER TABLE CHAT_INFO COMMENT '채팅방 정보. 채팅방 정보';

-- 테이블 생성 SQL - CHAT_USER_LIST
CREATE TABLE CHAT_USER_LIST
(
    `CHAT_USER_LIST_IDX`      INT            NOT NULL    AUTO_INCREMENT COMMENT 'CHAT_USER_LIST. 인덱스',
    `CHAT_NO`        INT              NOT NULL    COMMENT 'CHAT_NO. 채팅방 번호',
    `CUST_IDX`      INT    NOT NULL    COMMENT 'CUST_IDX_LIST. 채팅 참여자',
    `JOIN_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '채팅 참여 시간',
    PRIMARY KEY (CHAT_USER_LIST_IDX)
);

-- 테이블 생성 SQL - MESSAGE
CREATE TABLE MESSAGE
(
    `MESSAGE_SEQ`  INT     NOT NULL    AUTO_INCREMENT COMMENT 'MESSAGE_SEQ',
    `CUST_IDX`     INT     NULL        COMMENT 'CUST_IDX',
    `CHAT_NO`      INT     NULL        COMMENT 'CHAT_NO',
    `MSG`          LONGTEXT    NULL        COMMENT 'MSG',
    `SEND_AT`      TIMESTAMP    DEFAULT CURRENT_TIMESTAMP        COMMENT 'SEND_AT',
    PRIMARY KEY (MESSAGE_SEQ)
);
