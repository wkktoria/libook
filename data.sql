-- Create book table
CREATE TABLE IF NOT EXISTS Books
(
    id     INT NOT NULL auto_increment,
    title  NVARCHAR(100) DEFAULT NULL,
    author NVARCHAR(50)  DEFAULT NULL,
    status NVARCHAR(20)  DEFAULT NULL,
    primary key (id)
);

-- Add some sample books
INSERT INTO Books(title, author, status) VALUE ('Hamlet', 'William Shakespeare', 'plan to read');
INSERT INTO Books(title, author, status) VALUE ('Moby-Dick', 'Herman Melville', 'completed');
INSERT INTO Books(title, author, status) VALUE ('The Odyssey', 'Homer', 'plan to read');
INSERT INTO Books(title, author, status) VALUE ('To Kill a Mockingbird', 'Harper Lee', 'currently reading');
INSERT INTO Books(title, author, status) VALUE ('Bleak House', 'Charles Dickens', 'completed');
