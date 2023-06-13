CREATE TABLE FIGHTER(
             F_ID      INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
             NAME          VARCHAR(50),
             AGE            INTEGER Not NULL ,
             RECORD         VARCHAR(15),
             RANK           INTEGER NOT NULL,
            DIVISION           VARCHAR(15)

);


CREATE TABLE TEAM_MEMBERS(
            TM_ID  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
            F_ID  INTEGER NOT NULL ,
            FOREIGN KEY  (F_ID)  REFERENCES  FIGHTER(F_ID)
);

CREATE TABLE TEAM(
                     T_ID           INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
                     NAME                VARCHAR(15),
                     TM_ID                INTEGER NOT NULL,
                     FOREIGN KEY  (TM_ID) REFERENCES  TEAM_MEMBERS(TM_ID)
);

CREATE TABLE MATCHES(
    M_ID  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    T_IDA INTEGER NOT NULL,
    T_IDB INTEGER NOT NULL,
    FOREIGN KEY (T_IDA) references TEAM(T_ID),
    FOREIGN KEY (T_IDB) references TEAM(T_ID)
);

CREATE TABLE U_USER (
                         U_ID           INT NOT NULL CONSTRAINT U_PK PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         U_FIRST_NAME        VARCHAR(15),
                         U_LAST_NAME         VARCHAR(25),
                         U_PASSWORD          VARCHAR(30),
                         U_EMAIL             VARCHAR(30),
                         U_AGE               INT
);
