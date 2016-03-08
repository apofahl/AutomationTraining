CREATE DATABASE IF NOT EXISTS `dummyapp`;
GRANT DELETE, EXECUTE, INSERT, SELECT, SHOW VIEW, UPDATE ON dummyapp.* TO 'dummyapp'@'localhost';

USE `dummyapp`;

CREATE TABLE IF NOT EXISTS APP_SALON (
	Salon_LicNum VARCHAR(15) NOT NULL,
	Salon_Name VARCHAR(20) NOT NULL,
	Salon_Phone VARCHAR(15) NOT NULL,
	Salon_Street VARCHAR(20),
	Salon_City	VARCHAR(20),
	Salon_State VARCHAR(2),
	Salon_Zip VARCHAR(10) NOT NULL,
PRIMARY KEY (Salon_LicNum));

INSERT INTO APP_SALON (Salon_LicNum, Salon_Name, Salon_Phone, Salon_Zip) VALUES 
("205K03PK", "BANG Salon", "3082347863", "68845"),
("L67D459F", "Style Find", "3082369241", "68845");
INSERT INTO APP_SALON (Salon_LicNum, Salon_Name, Salon_Phone, Salon_Street, Salon_City, Salon_State, Salon_Zip) VALUES 
("83K72PD3", "Hair Care Central", "3082341390", "1730 Central Ave", "Kearney", "NE", "68847"), 
("09F436DS", "New U", "3082376107", "342 38th Street", "Kearney", "NE", "68847"), 
("73C6204JW", "Clippers", "3082330492", "4539 C Street", "Kearney", "NE", "68847");

CREATE TABLE IF NOT EXISTS APP_STYLIST (
	Stylist_LicNum VARCHAR(15) NOT NULL,
	Stylist_FName VARCHAR(20) NOT NULL,
	Stylist_LName VARCHAR(20) NOT NULL,
	Stylist_Phone VARCHAR(15),
	Stylist_Email VARCHAR(50) NOT NULL,
	Cash_Only BOOLEAN,
	Salon_ID VARCHAR(15),
PRIMARY KEY (Stylist_LicNum),
FOREIGN KEY (Salon_ID) REFERENCES APP_SALON(Salon_LicNum) ON UPDATE CASCADE);

INSERT INTO APP_STYLIST (Stylist_LicNum, Stylist_FName, Stylist_LName, Stylist_Email) VALUES 
("140234", "Hannah", "Smith", "hannah_joy@gmail.com"),
("120938", "Jamie", "Johnson", "jjohnson@yahoo.com"),
("103948", "Sam", "Thompson", "sam.thompson@gmail.com");
INSERT INTO APP_STYLIST (Stylist_LicNum, Stylist_FName, Stylist_LName, Stylist_Phone, Stylist_Email) VALUES
("109283", "Hannah", "Smith", "3084402905", "smith_girly@hotmail.com"), 
("130941", "Feliz", "Brown", "3084402907", "brownfc@lopers.unk.edu");

CREATE TABLE IF NOT EXISTS APP_CLIENT (
	Client_ID INT(11) NOT NULL AUTO_INCREMENT,
	Client_FName VARCHAR(20) NOT NULL,
	Client_LName VARCHAR(20) NOT NULL,
	Client_Phone VARCHAR(15),
	Client_Email VARCHAR(20) NOT NULL,
	Client_Zip VARCHAR(20),
	Stylist_ID VARCHAR(15),
PRIMARY KEY (Client_ID),
FOREIGN KEY (Stylist_ID) REFERENCES APP_STYLIST(Stylist_LicNum) ON UPDATE CASCADE);

INSERT INTO APP_CLIENT (Client_FName, Client_LName, Client_Email) VALUES 
("Haley", "Gordon", "h.gordon@yahoo.com"),
("Justin", "Clark", "j_the_man@hotmail.com"),
("Thalia", "Jackson", "jackson.t@gmail.com");
INSERT INTO APP_CLIENT (Client_FName, Client_LName, Client_Phone, Client_Email, Stylist_ID) VALUES 
("Darla", "James", "3086278625", "darla1993@yahoo.com", "130941"),
("Jackie", "Cash", "4025982147", "j.cash@gmail.com", "103948");

CREATE TABLE IF NOT EXISTS APP_SERVICETYPE (
	Type_ID INT(11) NOT NULL AUTO_INCREMENT,
	Description VARCHAR(20) NOT NULL,
PRIMARY KEY (Type_ID));

INSERT INTO APP_SERVICETYPE (Description) VALUES 
("Men's Cut"),
("Color"),
("Women's Cut"),
("Maicure"),
("Nose Wax");

CREATE TABLE IF NOT EXISTS APP_SERVICE (
	Service_Type INT NOT NULL,
	Stylist_ID VARCHAR(15) NOT NULL,
	Service_Price FLOAT(5,2) NOT NULL,
	Service_Time SMALLINT NOT NULL,
PRIMARY KEY (Service_Type, Stylist_ID),
FOREIGN KEY (Service_Type) REFERENCES APP_SERVICETYPE(Type_ID) ON UPDATE CASCADE,
FOREIGN KEY (Stylist_ID) REFERENCES APP_STYLIST(Stylist_LicNum) ON UPDATE CASCADE);

INSERT INTO APP_SERVICE (Service_Type, Stylist_ID, Service_Price, Service_Time) VALUES 
(5, "109283", 15.00, 10),
(4, "109283", 20.00, 30),
(1, "103948", 10.00, 25),
(2, "103948", 50.00, 60),
(3, "103948", 25.00, 45);

CREATE TABLE IF NOT EXISTS APP_APPOINTMENT (
	Appointment_ID INT(11) NOT NULL AUTO_INCREMENT,
	Client_ID INT NOT NULL,
	Service_Type INT NOT NULL,
	Stylist_ID VARCHAR(15) NOT NULL,
	App_Date DATE,
	Time_Start TIME,
	Time_End TIME,
	Client_Note VARCHAR(150),
PRIMARY KEY (Appointment_ID),
FOREIGN KEY (Client_ID) REFERENCES APP_CLIENT(Client_ID) ON UPDATE CASCADE,
FOREIGN KEY (Service_Type) REFERENCES APP_SERVICE(Service_Type) ON UPDATE CASCADE,
FOREIGN KEY (Stylist_ID) REFERENCES APP_STYLIST(Stylist_LicNum) ON UPDATE CASCADE);

INSERT INTO APP_APPOINTMENT (Client_ID, Service_Type, Stylist_ID, App_Date) VALUES 
(1, 1, "103948", '2015-10-30'),
(5, 5, "109283", '2015-11-03'),
(5, 5, "109283", '2015-12-22'),
(2, 2, "103948", '2015-11-14'),
(4, 3, "103948", '2015-10-28');

CREATE TABLE IF NOT EXISTS APP_PHOTO (
	Photo_ID INT(11) NOT NULL AUTO_INCREMENT,
	Photo VARCHAR(15) NOT NULL,
	Appointment_ID INT,
PRIMARY KEY (Photo_ID),
FOREIGN KEY (Appointment_ID) REFERENCES APP_APPOINTMENT(Appointment_ID) ON UPDATE CASCADE);

INSERT INTO APP_PHOTO (Photo, Appointment_ID) VALUES 
("before.jpg", 00004),
("after.jpg", 00004),
("justin.jpg", 00001),
("sweetcut.png", 00005);
INSERT INTO APP_PHOTO (Photo) VALUES
("me.gif");

CREATE TABLE IF NOT EXISTS APP_REVIEW (
	Review_ID INT(11) NOT NULL AUTO_INCREMENT,
	Client_ID INT NOT NULL,
	Stylist_ID VARCHAR(15) NOT NULL,
	Review_Date DATE NOT NULL,
	Review_Rate FLOAT(2,1) NOT NULL,
	Review_Note VARCHAR(150),
PRIMARY KEY (Review_ID),
FOREIGN KEY (Client_ID) REFERENCES APP_CLIENT(Client_ID) ON UPDATE CASCADE,
FOREIGN KEY (Stylist_ID) REFERENCES APP_STYLIST(Stylist_LicNum) ON UPDATE CASCADE);

INSERT INTO APP_REVIEW (Client_ID, Stylist_ID, Review_Date, Review_Rate) VALUES 
(1, "103948", '2015-09-27', 4.5),
(2, "109283", '2015-09-13', 3.5),
(3, "140234", '2015-10-22', 5.0),
(2, "109283", '2015-11-02', 4.0),
(5, "103948", '2015-10-16', 4.0);
INSERT INTO APP_REVIEW (Client_ID, Stylist_ID, Review_Date, Review_Rate, Review_Note) VALUES 
(2, "109283", '2015-12-29', 4.5, "Made time for me during the busy holidays and turned out great!"),
(4, "130941", '2015-09-13', 3.5, "It was alright. Nothing too fantastic.");


CREATE TABLE IF NOT EXISTS APP_SALE (
	Sale_ID INT(11) NOT NULL AUTO_INCREMENT,
	Start_Date DATE NOT NULL,
	End_Date DATE NOT NULL,
	Description VARCHAR(50) NOT NULL,
	Stylist_ID VARCHAR(15),
	Salon_ID VARCHAR(15),
PRIMARY KEY (Sale_ID),
FOREIGN KEY (Stylist_ID) REFERENCES APP_STYLIST(Stylist_LicNum) ON UPDATE CASCADE,
FOREIGN KEY (Salon_ID) REFERENCES APP_SALON(Salon_LicNum) ON UPDATE CASCADE);

INSERT INTO APP_SALE (Start_Date, End_Date, Description, Stylist_ID) VALUES 
('2015-09-15', '2015-09-29', "Redken Liter Sale", "140234"),
('2015-09-27', '2015-10-11', "Liter Sale", "120938"),
('2015-10-02', '2015-10-29', "1/2 Off Color", "130941");

INSERT INTO APP_SALE (Start_Date, End_Date, Description, Salon_ID) VALUES 
('2015-11-12', '2015-11-17', "10% Off All Product", "09F436DS"),
('2015-10-15', '2015-11-15', "Book Now For 20% Off", "L67D459F");

	