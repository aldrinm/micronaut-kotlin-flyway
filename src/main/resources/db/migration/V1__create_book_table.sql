create table BOOK (
    ID int not null primary key,
    TITLE varchar(100) not null,
    PAGES int not null
);

CREATE SEQUENCE BOOK_SEQUENCE_ID START WITH (select max(ID) + 1 from BOOK);