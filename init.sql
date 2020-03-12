 CREATE TABLE department (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE employee (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 isActive BOOLEAN NOT NULL,
 departmentId INT,
 PRIMARY KEY (id),
 FOREIGN KEY (departmentId) REFERENCES department(id));

INSERT INTO department(id,name)
VALUES
   (1, "Tech"),
   (2, "Support"),
   (3, "Business"),
   (4, "Test"),
   (5, "Marketing"),
   (6, "Management"),
   (7, "HR");


INSERT INTO employee(id, name, isActive, departmentId)
VALUES
    (1, "John Smith", TRUE, 1),
    (2, "Donald Trump", TRUE, 3),
    (3, "Princess Diana", FALSE, 2),
    (4, "Madonna", TRUE, 4),
    (5, "Oprah Winfrey",TRUE, 7),
    (6, "Elvis Presley",FALSE, 7),
    (7, "Johnny Depp",TRUE, 6),
    (8, "Tom Cruise",TRUE, 5),
    (9, "Will Smith",FALSE, 4),
    (10, "Steven Spielberg",TRUE, 3);