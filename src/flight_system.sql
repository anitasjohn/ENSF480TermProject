
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
('Anita', 'John', 'aj@email.com', 'ensf480', '2501 University Avenue NW Calgary Alberta Canada T2N 1N4'),
('Shane', 'Abdi', 'shane@email.com', 'shane', '1307 Lakeview Cape, Victoria, BC V2N 6N8'),
('Corinne', 'de Lima', 'corrine@email.com', 'corrine', '8854 Fiftieth Parkway NW, Calgary, Alberta T7A 8N1'),
('Heba', 'Leon', 'heba@email.com', 'heba', '1594 Mountain View, Calgary, Alberta T5E 2B1'),
('Geo', 'Zaman', 'geo@email.com', 'geo', '#9652 - 3507 Eighth Passage NW, Calgary, Alberta, T5W 8T5');


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


DROP TABLE IF EXISTS FLIGHT_ATTENDANTS;
CREATE TABLE FLIGHT_ATTENDANTS (
    FA_Number   int not null AUTO_INCREMENT,
    FName       varchar(50),
    Email       varchar(50),
    Pw          varchar(25),
    primary key (FA_Number)
);

ALTER TABLE FLIGHT_ATTENDANTS AUTO_INCREMENT = 1;

INSERT INTO FLIGHT_ATTENDANTS (FName, Email, Pw)
VALUES
('Karla Audet', 'karla@flightattendant.ca', 'karla'),
('Marcel Gonzalez', 'marcel@flightattendant.ca', 'marcel'),
('Philip Richards', 'philip@flightattendant.ca', 'philip'),
('Andrea Santiago', 'andrea@flightattendant.ca', 'andrea'),
('Lorena Choi', 'lorena@flightattendant.ca', 'lorena'),
('Travis Larouche', 'travis@flightattendant.ca', 'travis'),
('Tatyana Carey', 'tatyana@flightattendant.ca', 'tatyana'),
('Kai Thibault', 'kai@flightattendant.ca', 'kai'),
('Kate Frechette', 'kate@flightattendant.ca', 'kate');

DROP TABLE IF EXISTS TICKETS;
CREATE TABLE TICKETS (
    TicketNum       int not null AUTO_INCREMENT,
    FlightNumber    int,
    FName           varchar(50),
    SeatNum         int,
    primary key (TicketNum),
    foreign key (FlightNumber) REFERENCES FLIGHTS(FlightNumber)
);

ALTER TABLE TICKETS AUTO_INCREMENT = 2000;

INSERT INTO TICKETS (FlightNumber, FName, SeatNum)
VALUES
(1000, 'Jan Petallo', 5),
(1000, 'Anita John', 10),
(1000, 'Katherine Tubang', 15),
(1000, 'Josh Debele', 20),
(1000, 'Heba Leon', 21),
(1000, 'Carly Corbett', 22),
(1000, 'Zaman Zaman', 23),
(1000, 'Rashid Audet', 25),
(1000, 'André Cross', 30),
(1000, 'Carly Corbett', 31),
(1000, 'Santosh Dinh', 32),
(1000, 'Tricia Hay', 33),

(1001, 'Jan Petallo', 5),
(1001, 'Anita John', 10),
(1001, 'Katherine Tubang', 15),
(1001, 'Josh Debele', 20),
(1001, 'Heba Leon', 21),
(1001, 'Carly Corbett', 22),
(1001, 'Zaman Zaman', 23),
(1001, 'Rashid Audet', 25),
(1001, 'André Cross', 30),
(1001, 'Carly Corbett', 31),
(1001, 'Santosh Dinh', 32),
(1001, 'Tricia Hay', 33),

(1002, 'Jan Petallo', 5),
(1002, 'Anita John', 10),
(1002, 'Katherine Tubang', 15),
(1003, 'Josh Debele', 20),
(1004, 'Heba Leon', 21),
(1005, 'Carly Corbett', 22),
(1006, 'Zaman Zaman', 23),
(1007, 'Rashid Audet', 25),
(1008, 'André Cross', 30),
(1009, 'Carly Corbett', 31),
(1010, 'Santosh Dinh', 32),
(1011, 'Tricia Hay', 33),

(1012, 'Jan Petallo', 5),
(1012, 'Anita John', 10),
(1012, 'Katherine Tubang', 15),
(1012, 'Josh Debele', 20),
(1012, 'Heba Leon', 21),
(1012, 'Carly Corbett', 22),
(1013, 'Zaman Zaman', 23),
(1013, 'Rashid Audet', 25),
(1013, 'André Cross', 30),
(1013, 'Carly Corbett', 31),
(1013, 'Santosh Dinh', 32),
(1011, 'Tricia Hay', 33);


USE FLIGHT_SYSTEM;
SHOW TABLES;
SELECT * FROM REGISTERED_USERS;
SELECT * FROM FLIGHTS;
SELECT * FROM FLIGHT_ATTENDANTS;
SELECT * FROM TICKETS;



