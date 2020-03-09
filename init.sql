 CREATE TABLE Department (
  ID INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID));

CREATE TABLE Employee (
 ID INT NOT NULL AUTO_INCREMENT,
 Name VARCHAR(255) NOT NULL,
 DepartmentID INT,
 PRIMARY KEY (ID),
 FOREIGN KEY (DepartmentID) REFERENCES Department(ID));

INSERT INTO Department(ID,Name)
VALUES
   (1, "Tech"),
   (2, "Support"),
   (3, "Business"),
   (4, "Test"),
   (5, "Marketing"),
   (6, "Management"),
   (7, "HR");


INSERT INTO Employee(ID, Name, DepartmentID)
VALUES
    (1, "John Smith", 1),
    (2, "Donald Trump", 3),
    (3, "Princess Diana", 2),
    (4, "Madonna", 4),
    (5, "Oprah Winfrey", 7),
    (6, "Elvis Presley", 7),
    (7, "Johnny Depp", 6),
    (8, "Tom Cruise", 5),
    (9, "Will Smith", 4),
    (10, "Steven Spielberg", 3);