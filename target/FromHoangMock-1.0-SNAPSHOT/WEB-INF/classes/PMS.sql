USE master
GO

/* Object:  Database PARKING */
IF DB_ID('PMS') IS NOT NULL
    DROP DATABASE  [PMS]
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
CREATE TABLE [dbo].[Employee](
                                 [employeeId] [BIGINT] IDENTITY(1,1) NOT NULL,
                                 [employeeName] [varchar](50) NOT NULL,
                                 [sex] [varchar](1) NOT NULL,
                                 [employeeBirthdate] [date],
                                 [employeeAddress] [varchar](50),
                                 [employeePhone] [varchar](11) NOT NULL,
                                 [employeeEmail] [varchar](50) UNIQUE,
                                 [account] [varchar](50) NOT NULL UNIQUE,
                                 [password] [varchar](20) NOT NULL,
                                 [department] [varchar](10) NOT NULL,
                                 [role] [varchar](20) NOT NULL,

                                 CONSTRAINT [PK_Employee_employeeId] PRIMARY KEY CLUSTERED ([employeeId] ASC)
)
GO


/* Object:  Table [dbo].[Trip] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Trip](
                             [tripId] [bigint] IDENTITY(1,1) NOT NULL,
                             [bookedTicketNumber] [int],
                             [carType] [varchar](11) NOT NULL,
                             [departureDate] [date] NOT NULL,
                             [departureTime] [time] NOT NULL,
                             [destination] [varchar](50) NOT NULL,
                             [driver] [varchar](11) NOT NULL,
                             [maximumOnlineTicketNumber] [int] NOT NULL,

                             CONSTRAINT [PK_Trip_tripId] PRIMARY KEY CLUSTERED ([tripId] ASC),
)
GO


/* Object:  Table [dbo].[Car] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ParkingLot](
                                   [parkId] [bigint] IDENTITY(1,1) NOT NULL,
                                   [parkArea] [bigint],
                                   [parkName] [varchar](50) NOT NULL,
                                   [parkPlace] [varchar](11) NOT NULL,
                                   [parkPrice] [bigint],
                                   [parkStatus] [varchar](50) ,

                                   CONSTRAINT [PK_ParkingLot_parkId] PRIMARY KEY CLUSTERED ([parkId] ASC),
)
GO


/* Object:  Table [dbo].[Car] */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Car](
                            [licensePlate] [varchar](50)  NOT NULL,
                            [carColor] [varchar](11) NOT NULL,
                            [carType] [varchar](50),
                            [company] [varchar](50),
                            [parkId] [BIGINT],

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
CREATE TABLE [dbo].[Ticket](
                               [ticketId] [BIGINT] IDENTITY(1,1) NOT NULL,
                               [bookTime] [time],
                               [customerName] [varchar](11) NOT NULL,
                               [licensePlate] [varchar](50) NOT NULL,
                               [tripId] [BIGINT],

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
CREATE TABLE [dbo].[BookingOffice](
                                      [officeId] [bigint] IDENTITY(1,1) NOT NULL,
                                      [officeName] [varchar](50) NOT NULL,
                                      [officePhone] [varchar](11) NOT NULL,
                                      [officePlace] [varchar](50),
                                      [officePrice] [bigint] NOT NULL,
                                      [startContractDeadline] [date],
                                      [endContractDeadline] [date],
                                      [tripId] [bigint],

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
VALUES
(1, 11, 'Small', 'Hanoi', 20, 'Blank');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES
(2, 22, 'Medium', 'Sai Gon', 25, 'Blank');
INSERT INTO [dbo].[ParkingLot]
([parkId], [parkArea], [parkName], [parkPlace], [parkPrice], [parkStatus])
VALUES
(3, 33, 'Large', 'Da Nang', 30, 'Blank');
SET IDENTITY_INSERT [dbo].[ParkingLot] OFF
GO




/* Insert data in to Employee Table */
INSERT INTO [dbo].[Employee]
( [employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password], [department], [role])
VALUES
( 'David Beckham', 'M', '1975-05-02', 'England', '0123456789', 'lovefootball@gmail.com', 'beckham147', 'lovefootball01', 'Manager', 'admin');
INSERT INTO [dbo].[Employee]
( [employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password], [department], [role])
VALUES
( 'Messi Lionel', 'M', '1975-04-24', 'Argentina', '0258147369', 'lovefootball02@gmail.com', 'messi258', 'lovefootball02', 'Vice-M', 'staff');
INSERT INTO [dbo].[Employee]
([employeeName], [sex], [employeeBirthdate], [employeeAddress], [employeePhone], [employeeEmail], [account], [password], [department], [role])
VALUES
('Hope Solo', 'F', '1901-05-04', 'USA', '0741852963', 'lovefootballreverse@gmail.com', 'solosquad369', 'lovefootball03', 'Account', 'staff');
GO



SET IDENTITY_INSERT [dbo].[BookingOffice] OFF

/* Insert data in to Trip Table */
SET IDENTITY_INSERT [dbo].[Trip] ON
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver], [maximumOnlineTicketNumber])
VALUES
(1, 11, 'Sport', '1901-05-04', '12:30:00', 'Haiphong', 'Do Lo', 50);
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver], [maximumOnlineTicketNumber])
VALUES
(2, 22, 'Bugatti', '1901-05-04', '18:45:00', 'Saigon', 'Tran V', 45);
INSERT INTO [dbo].[Trip]
([tripId], [bookedTicketNumber], [carType], [departureDate], [departureTime], [destination], [driver], [maximumOnlineTicketNumber])
VALUES
(3, 33, 'CCXR', '1901-05-04', '07:15:00', 'Hanoi', 'Nguyen ', 40);
SET IDENTITY_INSERT [dbo].[Trip] OFF
GO


/* Insert data in to Car Table */
INSERT INTO [dbo].[Car]
([licensePlate], [carColor], [carType], [company], [parkId])
VALUES
('385-32', 'Black', 'Sport', 'Lexus', 3);
INSERT INTO [dbo].[Car]
([licensePlate], [carColor], [carType], [company], [parkId])
VALUES
('123-21', 'White', 'Bugatti', 'La Voatio Noire', 2);
INSERT INTO [dbo].[Car]
([licensePlate], [carColor], [carType], [company], [parkId])
VALUES
('456-54', 'Gray', 'CCXR Trevita', 'Koenigsegg ', 1);
GO



/* Insert data in to Ticket Table */
SET IDENTITY_INSERT [dbo].[Ticket] ON
INSERT INTO [dbo].[Ticket]
([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES
(1, '07:00:00', 'Hoang', '385-32', 3);
INSERT INTO [dbo].[Ticket]
([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES
(2, '08:00:00', 'Khang', '123-21', 2);
INSERT INTO [dbo].[Ticket]
([ticketId], [bookTime], [customerName], [licensePlate], [tripId])
VALUES
(3, '09:00:00', 'Kien', '456-54', 1);
SET IDENTITY_INSERT [dbo].[Ticket] OFF
GO



/* Insert data in to BookingOffice Table */
SET IDENTITY_INSERT [dbo].[BookingOffice] ON
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline], [tripId])
VALUES
(1, 'Nhanh nhu phi', '0123654789', 'Hanoi', 5000, '1901-05-04', '1901-05-04', 3);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline], [tripId])
VALUES
(2, 'Nhanh nhu bay', '0987654123', 'Danang', 6000, '1901-05-04', '1901-05-04', 2);
INSERT INTO [dbo].[BookingOffice]
([officeId], [officeName], [officePhone], [officePlace], [officePrice], [startContractDeadline], [endContractDeadline], [tripId])
VALUES
(3, 'Nhanh nhu gio', '0856314798', 'Saigon', 4000, '1901-05-04', '1901-05-04', 1);
SET IDENTITY_INSERT [dbo].[BookingOffice] OFF
GO

SELECT * FROM Car;
SELECT * FROM BookingOffice;
SELECT * FROM Ticket;
SELECT * FROM Trip;
SELECT * FROM Employee;
SELECT * FROM ParkingLot;

-- SELECT [Employee].[employeeId], [Employee].[employeeName] FROM [dbo].[Employee] 
--     WHERE [Employee].[employeeEmail] = 'lovefootball02@gmail.com' AND [Employee].[Password] = 'lovefootball02';