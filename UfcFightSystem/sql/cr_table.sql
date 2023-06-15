CREATE TABLE FIGHTER(
             F_ID      INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
             NAME          VARCHAR(50),
             AGE            INTEGER Not NULL ,
             RECORD         VARCHAR(15),
             RANK           INTEGER NOT NULL,
             PHOTO          VARCHAR(100),
             Nickname       VARCHAR(50),
            DIVISION           VARCHAR(15)

);




CREATE TABLE MATCHES(
    M_ID  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    NAME VARCHAR(50),
    F_IDA INTEGER NOT NULL,
    F_IDB INTEGER NOT NULL,
    FOREIGN KEY (F_IDA) references FIGHTER(F_ID),
    FOREIGN KEY (F_IDA) references FIGHTER(F_ID)
);

CREATE TABLE U_USER (
                         U_ID           INT NOT NULL CONSTRAINT U_PK PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         U_FIRST_NAME        VARCHAR(15),
                         U_LAST_NAME         VARCHAR(25),
                         U_PASSWORD          VARCHAR(30),
                         U_EMAIL             VARCHAR(30),
                         U_AGE               INT
);
