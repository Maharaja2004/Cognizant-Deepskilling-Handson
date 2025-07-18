CREATE TABLE department (
    dp_id INT PRIMARY KEY AUTO_INCREMENT,
    dp_name VARCHAR(45)
);

CREATE TABLE skill (
    sk_id INT PRIMARY KEY AUTO_INCREMENT,
    sk_name VARCHAR(45)
);

CREATE TABLE employee (
    em_id INT PRIMARY KEY AUTO_INCREMENT,
    em_name VARCHAR(45),
    em_salary DECIMAL(10,2),
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE employee_skill (
    es_id INT PRIMARY KEY AUTO_INCREMENT,
    es_em_id INT,
    es_sk_id INT,
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);
