-- Create book table
CREATE TABLE IF NOT EXISTS Books
(
    id     INT NOT NULL auto_increment,
    title  NVARCHAR(100) DEFAULT NULL,
    author NVARCHAR(50)  DEFAULT NULL,
    primary key (id)
);

-- Add some sample books
INSERT INTO Books(title, author) VALUE ('Hamlet', 'William Shakespeare');
INSERT INTO Books(title, author) VALUE ('Moby-Dick', 'Herman Melville');
INSERT INTO Books(title, author) VALUE ('The Odyssey', 'Homer');
INSERT INTO Books(title, author) VALUE ('To Kill a Mockingbird', 'Harper Lee');
INSERT INTO Books(title, author) VALUE ('Bleak House', 'Charles Dickens');
