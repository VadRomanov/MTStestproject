drop table if exists CLIENTS;
drop table if exists ACCOUNTS;

create table CLIENTS
(
    ID                         int auto_increment primary key,
    LAST_NAME                  varchar(255) not null,
    FIRST_NAME                 varchar(255) not null,
    PATRONYMIC                 varchar(255) not null,
    DOCUMENT_TYPE              varchar(255) not null,
    SERIES_AND_DOCUMENT_NUMBER varchar(255) not null,
    DATE_OF_BIRTH              date         not null
);

create table ACCOUNTS
(
    ACCOUNT_NUMBER   bigint auto_increment primary key,
    ACCOUNT_CURRENCY int not null,
    CLIENT_ID        int not null
);

alter table ACCOUNTS
    add foreign key (CLIENT_ID) references CLIENTS (ID)