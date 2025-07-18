
CREATE DATABASE IF NOT EXISTS ormlearn;
USE ormlearn;


CREATE TABLE user (
    us_id INT PRIMARY KEY AUTO_INCREMENT,
    us_name VARCHAR(255)
);

CREATE TABLE question (
    qu_id INT PRIMARY KEY AUTO_INCREMENT,
    qu_text VARCHAR(500)
);

CREATE TABLE quiz_option (
    op_id INT PRIMARY KEY AUTO_INCREMENT,
    op_text VARCHAR(255),
    op_score DOUBLE,
    op_qu_id INT,
    FOREIGN KEY (op_qu_id) REFERENCES question(qu_id)
);


CREATE TABLE attempt (
    at_id INT PRIMARY KEY AUTO_INCREMENT,
    at_us_id INT,
    at_date DATETIME,
    FOREIGN KEY (at_us_id) REFERENCES user(us_id)
);


CREATE TABLE attempt_question (
    aq_id INT PRIMARY KEY AUTO_INCREMENT,
    aq_qu_id INT,
    aq_at_id INT,
    FOREIGN KEY (aq_qu_id) REFERENCES question(qu_id),
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id)
);

CREATE TABLE attempt_option (
    ao_id INT PRIMARY KEY AUTO_INCREMENT,
    ao_op_id INT,
    ao_aq_id INT,
    ao_selected BOOLEAN,
    FOREIGN KEY (ao_op_id) REFERENCES quiz_option(op_id),
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id)
);


INSERT INTO user (us_name) VALUES ('Alice'), ('Bob');


INSERT INTO question (qu_text) VALUES 
('What is the extension of the hyper text markup language file?'),
('What is the maximum level of heading tag can be used in a HTML page?'),
('The HTML document itself begins with <html> and ends </html>. State True or False'),
('Choose the right option to store text value in a variable');

-- Insert data into quiz_option
INSERT INTO quiz_option (op_text, op_score, op_qu_id) VALUES 
('.xhtm', 0.0, 1),
('.ht', 0.0, 1),
('.html', 1.0, 1),
('.htmx', 0.0, 1),

('5', 0.0, 2),
('3', 0.0, 2),
('4', 0.0, 2),
('6', 1.0, 2),

('false', 0.0, 3),
('true', 1.0, 3),

("'John'", 0.5, 4),
('John', 0.0, 4),
('"John"', 0.5, 4),
('/John/', 0.0, 4);


INSERT INTO attempt (at_us_id, at_date) VALUES (1, NOW());


INSERT INTO attempt_question (aq_qu_id, aq_at_id) VALUES 
(1, 1), (2, 1), (3, 1), (4, 1);


INSERT INTO attempt_option (ao_op_id, ao_aq_id, ao_selected) VALUES
(1, 1, false),
(2, 1, false),
(3, 1, true),
(4, 1, false),

(5, 2, false),
(6, 2, true),
(7, 2, false),
(8, 2, false),

(9, 3, false),
(10, 3, true),

(11, 4, true),
(12, 4, false),
(13, 4, false),
(14, 4, false);
