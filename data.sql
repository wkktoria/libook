-- Create status table
CREATE TABLE IF NOT EXISTS Status
(
    id INT NOT NULL AUTO_INCREMENT,
    description NVARCHAR(20) NOT NULL,
    primary key (id)
);

-- Create book table
CREATE TABLE IF NOT EXISTS Books
(
    id     INT NOT NULL AUTO_INCREMENT,
    title  NVARCHAR(100) DEFAULT NULL,
    author NVARCHAR(50)  DEFAULT NULL,
    status_id INT DEFAULT NULL,
    primary key (id),
    foreign key (status_id) REFERENCES Status(id)
);

-- Add status
INSERT INTO Status(description) VALUE ('plan to read');
INSERT INTO Status(description) VALUE ('currently reading');
INSERT INTO Status(description) VALUE ('completed');

-- Add some sample books
INSERT INTO Books(title, author, status_id) VALUE ('Hamlet', 'William Shakespeare', 1);
INSERT INTO Books(title, author, status_id) VALUE ('Moby-Dick', 'Herman Melville', 3);
INSERT INTO Books(title, author, status_id) VALUE ('The Odyssey', 'Homer', 1);
INSERT INTO Books(title, author, status_id) VALUE ('To Kill a Mockingbird', 'Harper Lee', 2);
INSERT INTO Books(title, author, status_id) VALUE ('Bleak House', 'Charles Dickens', 3);
