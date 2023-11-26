
DROP DATABASE IF EXISTS FLIGHT_SYSTEM;
CREATE DATABASE FLIGHT_SYSTEM;
USE FLIGHT_SYSTEM;


DROP TABLE IF EXISTS REGISTERED_USERS;
CREATE TABLE REGISTERED_USERS (
    UserID      int not null AUTO_INCREMENT,
    FirstName   varchar(25),
    LastName    varchar(25),
    Email       varchar(25),
    Pw          varchar(25),
    FullAdress  varchar(100),
    primary key (UserID)
);

INSERT INTO REGISTERED_USERS (FirstName, LastName, Email, Pw, FullAdress)
VALUES
('Jan', 'Petallo', 'jp@email.com', 'ensf480', '2500 University Drive NW Calgary Alberta Canada T2N 1N4'),
('Anita', 'John', 'jp@email.com', 'ensf480', '2501 University Avenue NW Calgary Alberta Canada T2N 1N4');

USE FLIGHT_SYSTEM;
SHOW TABLES;
SELECT * FROM REGISTERED_USERS;



