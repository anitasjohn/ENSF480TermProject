
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

ALTER TABLE REGISTERED_USERS AUTO_INCREMENT = 100;

INSERT INTO REGISTERED_USERS (FirstName, LastName, Email, Pw, FullAdress)
VALUES
('Jan', 'Petallo', 'jp@email.com', 'ensf480', '2500 University Drive NW Calgary Alberta Canada T2N 1N4'),
('Anita', 'John', 'jp@email.com', 'ensf480', '2501 University Avenue NW Calgary Alberta Canada T2N 1N4');


DROP TABLE IF EXISTS FLIGHTS;
CREATE TABLE FLIGHTS (
    FlightNumber        int not null AUTO_INCREMENT,
    Departure           varchar(50),
    Destination         varchar(50),
    DepartureAirport    varchar(50),
    DestinationAirport  varchar(50),
    Duration            varchar(25),
    FlightTime          varchar(50),
    Price               int,
    primary key (FlightNumber)
);

ALTER TABLE FLIGHTS AUTO_INCREMENT = 1000;

INSERT INTO FLIGHTS (Departure, Destination, DepartureAirport, DestinationAirport, Duration, FlightTime, Price)
VALUES
('Calgary', 'Vancouver', 'YYC', 'YVR', '1h 41m', 'Nov 29, 2023 7:50 pm–8:31 pm', 201 ),
('Calgary', 'Vancouver', 'YYC', 'YVR', '1h 29m', 'Nov 30, 2023 9:15 pm – 11:44 pm', 167),
('Calgary', 'Vancouver', 'YYC', 'YVR', '1h 35m', 'Dec 01, 2023 2:55 pm – 5:30 pm', 175 ),
('Calgary', 'Vancouver', 'YYC', 'YVR', '1h 25m', 'Dec 02, 2023 8:40 pm – 11:05 pm', 182),
('Calgary', 'Vancouver', 'YYC', 'YVR', '1h 31m', 'Dec 03, 2023 7:30 am – 10:01 am', 205),
('Calgary', 'Vancouver', 'YYC', 'YVR', '1h 29m', 'Dec 04, 2023 8:40 pm – 11:05 pm', 172),
('Calgary', 'Vancouver', 'YYC', 'YVR', '1h 45m', 'Dec 05, 2023 6:15 pm – 7:00 pm', 158),
('Calgary', 'Vancouver', 'YYC', 'YVR', '1h 35m', 'Dec 06, 2023 8:20 pm – 10:55 pm', 163),

('Calgary', 'Toronto', 'YYC', 'YYZ', '3h 44m', 'Nov 29, 2023 1:05 am – 6:49 am', 214 ),
('Calgary', 'Toronto', 'YYC', 'YYZ', '3h 55m', 'Nov 30, 2023 5:05 pm – 11:00 pm', 241),
('Calgary', 'Toronto', 'YYC', 'YYZ', '3h 55m', 'Dec 01, 2023 2:20 pm – 8:15 pm ', 243 ),
('Calgary', 'Toronto', 'YYC', 'YYZ', '3h 48m', 'Dec 02, 2023 6:55 am – 12:53 pm', 255),
('Calgary', 'Toronto', 'YYC', 'YYZ', '3h 44m', 'Dec 03, 2023 1:05 am – 6:49 am', 214 ),
('Calgary', 'Toronto', 'YYC', 'YYZ', '3h 55m', 'Dec 04, 2023 5:05 pm – 11:00 pm', 241),
('Calgary', 'Toronto', 'YYC', 'YYZ', '3h 55m', 'Dec 05, 2023 2:20 pm – 8:15 pm ', 243 ),
('Calgary', 'Toronto', 'YYC', 'YYZ', '3h 48m', 'Dec 06, 2023 6:55 am – 12:53 pm', 255),

('Calgary', 'Montreal', 'YYC', 'YUL', '4h 06m', 'Dec 01, 2023 7:00 am – 1:06 pm ', 237 ),
('Calgary', 'Montreal', 'YYC', 'YUL', '4h 09m', 'Dec 02, 2023 9:10 am – 3:19 pm', 597),
('Calgary', 'Montreal', 'YYC', 'YUL', '4h 19m', 'Dec 03, 2023 12:10 pm – 6:29 pm', 946 ),
('Calgary', 'Montreal', 'YYC', 'YUL', '8h 45m', 'Dec 04, 2023 7:30 am – 6:15 pm', 589),
('Calgary', 'Montreal', 'YYC', 'YUL', '4h 06m', 'Dec 05, 2023 7:00 am – 1:06 pm ', 237 ),
('Calgary', 'Montreal', 'YYC', 'YUL', '4h 09m', 'Dec 06, 2023 9:10 am – 3:19 pm', 597),
('Calgary', 'Montreal', 'YYC', 'YUL', '4h 19m', 'Dec 07, 2023 12:10 pm – 6:29 pm', 946 ),
('Calgary', 'Montreal', 'YYC', 'YUL', '8h 45m', 'Dec 08, 2023 7:30 am – 6:15 pm', 589),

('Calgary', 'Edmonton', 'YYC', 'YEG', '0h 50m', 'Dec 01, 2023 9:50 am – 10:40 am', 171 ),
('Calgary', 'Edmonton', 'YYC', 'YEG', '0h 59m', 'Dec 02, 2023 11:05 pm – 12:04 am', 250),
('Calgary', 'Edmonton', 'YYC', 'YEG', '0h 57m', 'Dec 03, 2023 8:00 pm – 8:57 pm', 371 ),
('Calgary', 'Edmonton', 'YYC', 'YEG', '0h 54m', 'Dec 04, 2023 2:30 pm – 3:24 pm', 354),
('Calgary', 'Edmonton', 'YYC', 'YEG', '0h 50m', 'Dec 05, 2023 9:50 am – 10:40 am', 171 ),
('Calgary', 'Edmonton', 'YYC', 'YEG', '0h 59m', 'Dec 06, 2023 11:05 pm – 12:04 am', 250),
('Calgary', 'Edmonton', 'YYC', 'YEG', '0h 57m', 'Dec 07, 2023 8:00 pm – 8:57 pm', 371 ),
('Calgary', 'Edmonton', 'YYC', 'YEG', '0h 54m', 'Dec 08, 2023 2:30 pm – 3:24 pm', 354),

('Vancouver', 'Calgary', 'YYC', 'YVR', '1h 41m', 'Nov 29, 2023 7:50 pm–8:31 pm', 201 ),
('Vancouver', 'Calgary', 'YYC', 'YVR', '1h 29m', 'Nov 30, 2023 9:15 pm – 11:44 pm', 167),
('Vancouver', 'Calgary', 'YYC', 'YVR', '1h 35m', 'Dec 01, 2023 2:55 pm – 5:30 pm', 175 ),
('Vancouver', 'Calgary', 'YYC', 'YVR', '1h 25m', 'Dec 02, 2023 8:40 pm – 11:05 pm', 182),
('Vancouver', 'Calgary', 'YYC', 'YVR', '1h 31m', 'Dec 03, 2023 7:30 am – 10:01 am', 205),
('Vancouver', 'Calgary', 'YYC', 'YVR', '1h 29m', 'Dec 04, 2023 8:40 pm – 11:05 pm', 172),
('Vancouver', 'Calgary', 'YYC', 'YVR', '1h 45m', 'Dec 05, 2023 6:15 pm – 7:00 pm', 158),
('Vancouver', 'Calgary', 'YYC', 'YVR', '1h 35m', 'Dec 06, 2023 8:20 pm – 10:55 pm', 163),

('Toronto', 'Calgary', 'YYC', 'YYZ', '3h 44m', 'Nov 29, 2023 1:05 am – 6:49 am', 214 ),
('Toronto', 'Calgary', 'YYC', 'YYZ', '3h 55m', 'Nov 30, 2023 5:05 pm – 11:00 pm', 241),
('Toronto', 'Calgary', 'YYC', 'YYZ', '3h 55m', 'Dec 01, 2023 2:20 pm – 8:15 pm ', 243 ),
('Toronto', 'Calgary', 'YYC', 'YYZ', '3h 48m', 'Dec 02, 2023 6:55 am – 12:53 pm', 255),
('Toronto', 'Calgary', 'YYC', 'YYZ', '3h 44m', 'Dec 03, 2023 1:05 am – 6:49 am', 214 ),
('Toronto', 'Calgary', 'YYC', 'YYZ', '3h 55m', 'Dec 04, 2023 5:05 pm – 11:00 pm', 241),
('Toronto', 'Calgary', 'YYC', 'YYZ', '3h 55m', 'Dec 05, 2023 2:20 pm – 8:15 pm ', 243 ),
('Toronto', 'Calgary', 'YYC', 'YYZ', '3h 48m', 'Dec 06, 2023 6:55 am – 12:53 pm', 255),

('Montreal', 'Calgary', 'YYC', 'YUL', '4h 06m', 'Dec 01, 2023 7:00 am – 1:06 pm ', 237 ),
('Montreal', 'Calgary', 'YYC', 'YUL', '4h 09m', 'Dec 02, 2023 9:10 am – 3:19 pm', 597),
('Montreal', 'Calgary', 'YYC', 'YUL', '4h 19m', 'Dec 03, 2023 12:10 pm – 6:29 pm', 946 ),
('Montreal', 'Calgary', 'YYC', 'YUL', '8h 45m', 'Dec 04, 2023 7:30 am – 6:15 pm', 589),
('Montreal', 'Calgary', 'YYC', 'YUL', '4h 06m', 'Dec 05, 2023 7:00 am – 1:06 pm ', 237 ),
('Montreal', 'Calgary', 'YYC', 'YUL', '4h 09m', 'Dec 06, 2023 9:10 am – 3:19 pm', 597),
('Montreal', 'Calgary', 'YYC', 'YUL', '4h 19m', 'Dec 07, 2023 12:10 pm – 6:29 pm', 946 ),
('Montreal', 'Calgary', 'YYC', 'YUL', '8h 45m', 'Dec 08, 2023 7:30 am – 6:15 pm', 589),

('Edmonton', 'Calgary', 'YYC', 'YEG', '0h 50m', 'Dec 01, 2023 9:50 am – 10:40 am', 171 ),
('Edmonton', 'Calgary', 'YYC', 'YEG', '0h 59m', 'Dec 02, 2023 11:05 pm – 12:04 am', 250),
('Edmonton', 'Calgary', 'YYC', 'YEG', '0h 57m', 'Dec 03, 2023 8:00 pm – 8:57 pm', 371 ),
('Edmonton', 'Calgary', 'YYC', 'YEG', '0h 54m', 'Dec 04, 2023 2:30 pm – 3:24 pm', 354),
('Edmonton', 'Calgary', 'YYC', 'YEG', '0h 50m', 'Dec 05, 2023 9:50 am – 10:40 am', 171 ),
('Edmonton', 'Calgary', 'YYC', 'YEG', '0h 59m', 'Dec 06, 2023 11:05 pm – 12:04 am', 250),
('Edmonton', 'Calgary', 'YYC', 'YEG', '0h 57m', 'Dec 07, 2023 8:00 pm – 8:57 pm', 371 ),
('Edmonton', 'Calgary', 'YYC', 'YEG', '0h 54m', 'Dec 08, 2023 2:30 pm – 3:24 pm', 354);

USE FLIGHT_SYSTEM;
SHOW TABLES;
SELECT * FROM REGISTERED_USERS;
SELECT * FROM FLIGHTS;



