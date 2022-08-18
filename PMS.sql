USE master
GO

/* Object:  Database PARKING */
IF DB_ID('PMS') IS NOT NULL
    DROP DATABASE [PMS]
GO

DROP DATABASE IF EXISTS [PMS]
GO

CREATE DATABASE [PMS]
GO

USE [PMS]
GO

/* Object:  Table [dbo].[Employee] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee]
(
    [employeeId]        [BIGINT] IDENTITY (1,1) NOT NULL,
    [employeeName]      [varchar](50)           NOT NULL,
    [sex]               [varchar](1)            NOT NULL,
    [employeeBirthdate] [date],
    [employeeAddress]   [varchar](50),
    [employeePhone]     [varchar](11)           NOT NULL,
    [employeeEmail]     [varchar](50) UNIQUE,
    [account]           [varchar](50)           NOT NULL,
    [password]          [varchar](20)           NOT NULL,
    [department]        [varchar](10)           NOT NULL,
    [role]              [varchar](20)           NOT NULL,

    CONSTRAINT [PK_Employee_employeeId] PRIMARY KEY CLUSTERED ([employeeId] ASC)
)
GO


/* Object:  Table [dbo].[Trip] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Trip]
(
    [tripId]                    [bigint] IDENTITY (1,1) NOT NULL,
    [bookedTicketNumber]        [int],
    [carType]                   [varchar](50)           NOT NULL,
    [departureDate]             [date]                  NOT NULL,
    [departureTime]             [time]                  NOT NULL,
    [destination]               [varchar](50)           NOT NULL,
    [driver]                    [varchar](50)           NOT NULL,
    [maximumOnlineTicketNumber] [int]                   NOT NULL,

    CONSTRAINT [PK_Trip_tripId] PRIMARY KEY CLUSTERED ([tripId] ASC),
)
GO


/* Object:  Table [dbo].[Car] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ParkingLot]
(
    [parkId]     [bigint] IDENTITY (1,1) NOT NULL,
    [parkArea]   [bigint],
    [parkName]   [varchar](50)           NOT NULL,
    [parkPlace]  [varchar](20)           NOT NULL,
    [parkPrice]  [bigint],
    [parkStatus] [varchar](50),


    CONSTRAINT [PK_ParkingLot_parkId] PRIMARY KEY CLUSTERED ([parkId] ASC),
)
GO


/* Object:  Table [dbo].[Car] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Car]
(
    [licensePlate] [varchar](50) NOT NULL,
    [carColor]     [varchar](20) NOT NULL,
    [carType]      [varchar](50),
    [company]      [varchar](50),
    [parkId]       [BIGINT],

    CONSTRAINT [PK_Car_licensePlate] PRIMARY KEY CLUSTERED ([licensePlate] ASC),

    CONSTRAINT [FK_parkId] FOREIGN KEY ([parkId]) REFERENCES [ParkingLot] ([parkId])
        ON DELETE CASCADE
        ON UPDATE NO ACTION,
)
GO


/* Object:  Table [dbo].[Ticket] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ticket]
(
    [ticketId]     [BIGINT] IDENTITY (1,1) NOT NULL,
    [bookTime]     [time],
    [customerName] [varchar](50)           NOT NULL,
    [licensePlate] [varchar](50)           NOT NULL,
    [tripId]       [BIGINT],

    CONSTRAINT [PK_Ticket_ticketId] PRIMARY KEY CLUSTERED ([ticketId] ASC),

    CONSTRAINT [FK_tripId] FOREIGN KEY ([tripId]) REFERENCES [Trip] ([TripId])
        ON DELETE CASCADE
        ON UPDATE NO ACTION,

    CONSTRAINT [FK_licensePlate] FOREIGN KEY ([licensePlate]) REFERENCES [Car] ([licensePlate])
        ON DELETE CASCADE
        ON UPDATE NO ACTION,
)
GO


/* Object:  Table [dbo].[BookingOffice] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookingOffice]
(
    [officeId]              [bigint] IDENTITY (1,1) NOT NULL,
    [officeName]            [varchar](50)           NOT NULL,
    [officePhone]           [varchar](11)           NOT NULL,
    [officePlace]           [varchar](50),
    [officePrice]           [bigint]                NOT NULL,
    [startContractDeadline] [date],
    [endContractDeadline]   [date],
    [tripId]                [bigint],

    CONSTRAINT [PK_BookingOffice_officeId] PRIMARY KEY CLUSTERED ([officeId] ASC),

    CONSTRAINT [FK_Trip_tripId] FOREIGN KEY ([tripId]) REFERENCES [Trip] ([tripId])
        ON DELETE CASCADE
        ON UPDATE NO ACTION,
)
GO



/* Insert data in to ParkingLot Table */
SET IDENTITY_INSERT [dbo].[BookingOffice] OFF
SET IDENTITY_INSERT [dbo].[ParkingLot] ON
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (1, 320, 'FPT Hanoi', 'Hanoi', 4000, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (2, 200, 'FPT Saigon', 'Sai Gon', 6500, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (3, 330, 'FPT Danang ', 'Da Nang', 5000, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (4, 320, 'Viking 1', 'Hanoi', 4000, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (5, 250, 'Viking 2', 'Sai Gon', 7500, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (6, 270, 'Viking 3', 'Da Nang', 3000, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (7, 450, 'Aeon Park', 'Hanoi', 5000, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (8, 370, '143 Park', 'Sai Gon', 4500, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (9, 290, 'Tay Park', 'Da Nang', 5500, 'Available');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES (10, 340, 'Seaside', 'Da Nang', 4500, 'Available');
SET IDENTITY_INSERT [dbo].[ParkingLot] OFF
GO



/* Insert data in to Employee Table */
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('David Beckham', 'M', '1975-05-02', 'England', '0123456789', 'lovefootball01@gmail.com', 'beckham147',
        'lovefootball01', 'Manager', 'admin');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Luong Phuc Hoa', 'F', '1994-10-30', 'Vietnam', '0963301099', 'shiroya@gmail.com', 'fuka', '123456', 'Manager',
        'admin');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Bill Gates', 'M', '1955-10-28', 'USA', '0123578964', 'mbilldollar@gmail.com', 'mrbill', 'lovework', 'Manager',
        'admin');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Messi Lionel', 'M', '1975-04-24', 'Argentina', '0258147369', 'lovefootball02@gmail.com', 'messi258',
        'lovefootball02', 'Vice-M', 'staff');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Hope Solo', 'F', '1901-05-04', 'USA', '0741852963', 'lovefootballreverse@gmail.com', 'solosquad369',
        'lovefootball03', 'Account', 'staff');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Elon Musk', 'M', '1971-06-28', 'South Africa', '0258143469', 'mrmuskdollar@gmail.com', 'mrelon', 'lovework',
        'Support', 'staff');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Kana Hanazawa', 'F', '1989-02-25', 'Japan', '0741369852', 'seiyuu@gmail.com', 'Sei2505', 'durarara', 'Account',
        'staff');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Will Smith', 'M', '1968-09-25', 'USA', '0245147369', 'lovemovie00@gmail.com', 'WifiWill', 'lovemovie00',
        'Support', 'staff');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Kim Kardashian', 'F', '1980-10-21', 'USA', '0741856203', 'lovemovie01@gmail.com', 'KimChi', 'lovemovie01',
        'Sale', 'staff');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password],
 [department], [role])
VALUES ('Tiger Woods', 'M', '1975-12-30', 'USA', '0632052963', 'lovegolf@gmail.com', 'FloridaFly', 'lovegolf123',
        'Sale', 'staff');
GO



SET IDENTITY_INSERT [dbo].[BookingOffice] OFF

/* Insert data in to Trip Table */
SET IDENTITY_INSERT [dbo].[Trip] ON
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (1, 11, 'Sport', '2021-05-12', '12:30:00', 'Hai Phong', 'Do Long', 50);
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (2, 22, 'Bugatti', '2021-05-26', '18:45:00', 'Sai Gon', 'Tran Van', 45);
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (3, 33, 'CCXR', '2021-05-08', '07:15:00', 'Ha Noi', 'Nguyen Nhat', 40);

INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (4, 8, 'Audi A4', '2021-05-12', '12:30:00', 'Nha Trang', 'Do Long', 50);
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (5, 12, 'Ram 1500', '2021-05-26', '18:45:00', 'Hue', 'Tran Van', 45);
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (6, 20, 'Bolt EV', '2021-05-08', '07:15:00', 'Da Nang', 'Nguyen Nhat', 40);

INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (7, 8, 'Altis', '2021-05-12', '12:30:00', 'Quy Nhon', 'Do Long', 50);
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (8, 12, 'Leaf', '2021-05-26', '18:45:00', 'Ha Noi', 'Tran Van', 45);
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (9, 21, 'Sportage', '2021-05-08', '07:15:00', 'Do Long', 'Nguyen Nhat', 40);

INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver],
 [maximumOnlineTicketNumber])
VALUES (10, 18, 'Chrysler Pacifica', '2021-05-08', '07:15:00', 'Nha Trang', 'Nguyen Nhat', 40);
SET IDENTITY_INSERT [dbo].[Trip] OFF
GO


/* Insert data in to Car Table */
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('385-32', 'Black', 'Sport', 'Lexus', 3);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('123-21', 'White', 'Bugatti', 'La Voatio Noire', 2);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('456-54', 'Gray', 'CCXR Trevita', 'Koenigsegg', 1);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('382-98', 'Black', 'Chrysler Pacifica', 'Hybrid', 4);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('325-41', 'White', 'Audi A4', 'Audi', 5);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('102-69', 'Gray', 'Bolt EV', 'Chevrolet', 6);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('732-32', 'Red', 'Ram 1500', 'Ram', 7);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('256-120', 'White', 'Sportage', 'Kia ', 8);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('159-60', 'Gray', 'Jeep', 'Renegade ', 9);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('863-72', 'Red', 'Leaf', 'Nissan', 5);
INSERT INTO [dbo].[Car]
    ([licensePlate], [carColor], [carType], [company], [parkId])
VALUES ('301-12', 'White', 'Altis', 'Toyota', 4);
GO



/* Insert data in to Ticket Table */
SET IDENTITY_INSERT [dbo].[Ticket] ON
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (1, '07:00:00', 'Hoang', '385-32', 3);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (2, '08:00:00', 'Khang', '123-21', 2);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (3, '09:00:00', 'Kien', '456-54', 1);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (4, '17:20:00', 'Nhan', '325-41', 4);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (5, '18:50:00', 'Huyen', '102-69', 5);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (6, '19:15:00', 'Trang', '732-32', 6);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (7, '20:00:00', 'Ashe', '256-120', 7);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (8, '15:30:00', 'Lien', '159-60', 8);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (9, '13:25:00', 'Tong', '863-72', 9);
INSERT INTO [dbo].[Ticket]
    ([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES (10, '09:45:00', 'Duong', '301-12', 10);
SET IDENTITY_INSERT [dbo].[Ticket] OFF
GO



/* Insert data in to BookingOffice Table */
SET IDENTITY_INSERT [dbo].[BookingOffice] ON
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (1, 'Hildgar', '0123654789', 'Ha Noi', 5000, '2021-05-04', '2021-06-04', 3);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (2, 'Kinfolk', '0987654123', 'Da Nang', 6000, '2021-07-04', '2021-08-25', 2);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (3, '369', '0856314798', 'Sai Gon', 4000, '2021-06-04', '2021-07-25', 1);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (4, 'Doran Office', '0876524798', 'Ha Noi', 3000, '2021-07-04', '2021-10-25', 4);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (5, 'AWM', '0123589664', 'Hanoi', 4500, '2021-05-04', '2021-08-04', 5);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (6, 'Zone X', '0695231478', 'Da Nang', 7500, '2021-09-04', '2021-11-25', 6);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (7, 'FPT Booking', '0989233686', 'Sai Gon', 5500, '2021-05-04', '2021-06-25', 7);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (8, 'Hoa Office', '0632478965', 'Sai Gon', 6500, '2021-05-04', '2021-05-25', 8);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (9, 'Sai Gon 2', '0698532175', 'Sai Gon', 4000, '2021-11-04', '2021-12-25', 9);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline],
 [tripId])
VALUES (10, 'Hanoi Xin', '0632456852', 'Ha Noi', 8500, '2021-10-04', '2021-12-25', 4);
SET IDENTITY_INSERT [dbo].[BookingOffice] OFF
GO

-- SELECT * FROM Car;
-- SELECT * FROM BookingOffice;
-- SELECT * FROM Ticket;
-- SELECT * FROM Trip;
-- SELECT * FROM Employee;
-- SELECT * FROM ParkingLot;

-- SELECT [Employee].[employeeId], [Employee].[employeeName] FROM [dbo].[Employee] 
--     WHERE [Employee].[employeeEmail] = 'lovefootball02@gmail.com' AND [Employee].[Password] = 'lovefootball02';