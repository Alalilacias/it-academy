DROP DATABASE IF EXISTS university;
CREATE DATABASE university CHARACTER SET utf8mb4;
USE university;

CREATE TABLE department (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE person (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nif VARCHAR(9) UNIQUE,
    first_name VARCHAR(25) NOT NULL,
    last_name1 VARCHAR(50) NOT NULL,
    last_name2 VARCHAR(50),
    city VARCHAR(25) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phone VARCHAR(9),
    birth_date DATE NOT NULL,
    gender ENUM('M', 'F') NOT NULL,
    type ENUM('professor', 'student') NOT NULL
);

CREATE TABLE professor (
    id_professor INT UNSIGNED PRIMARY KEY,
    id_department INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_professor) REFERENCES person(id),
    FOREIGN KEY (id_department) REFERENCES department(id)
);

CREATE TABLE degree (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE subject (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    credits FLOAT UNSIGNED NOT NULL,
    type ENUM('basic', 'mandatory', 'elective') NOT NULL,
    course TINYINT UNSIGNED NOT NULL,
    semester TINYINT UNSIGNED NOT NULL,
    id_professor INT UNSIGNED,
    id_degree INT UNSIGNED NOT NULL,
    FOREIGN KEY(id_professor) REFERENCES professor(id_professor),
    FOREIGN KEY(id_degree) REFERENCES degree(id)
);

CREATE TABLE school_year (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    start_year YEAR NOT NULL,
    end_year YEAR NOT NULL
);

CREATE TABLE student_enrolls_subject (
    id_student INT UNSIGNED NOT NULL,
    id_subject INT UNSIGNED NOT NULL,
    id_school_year INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_student, id_subject, id_school_year),
    FOREIGN KEY (id_student) REFERENCES person(id),
    FOREIGN KEY (id_subject) REFERENCES subject(id),
    FOREIGN KEY (id_school_year) REFERENCES school_year(id)
);
 
/* Department */
INSERT INTO department VALUES (1, 'Computer Science');
INSERT INTO department VALUES (2, 'Mathematics');
INSERT INTO department VALUES (3, 'Economics and Business');
INSERT INTO department VALUES (4, 'Education');
INSERT INTO department VALUES (5, 'Agronomy');
INSERT INTO department VALUES (6, 'Chemistry and Physics');
INSERT INTO department VALUES (7, 'Philology');
INSERT INTO department VALUES (8, 'Law');
INSERT INTO department VALUES (9, 'Biology and Geology');

/* Person */
INSERT INTO person VALUES (1, '26902806M', 'Salvador', 'Sanchez', 'Perez', 'Almeria', 'C/ Real del barrio alto', '950254837', '1991/03/28', 'M', 'student');
INSERT INTO person VALUES (2, '89542419S', 'Juan', 'Saez', 'Vega', 'Almeria', 'C/ Mercurio', '618253876', '1992/08/08', 'M', 'student');
INSERT INTO person VALUES (3, '11105554G', 'Zoe', 'Ramirez', 'Gea', 'Almeria', 'C/ Mars', '618223876', '1979/08/19', 'F', 'professor');
INSERT INTO person VALUES (4, '17105885A', 'Pedro', 'Heller', 'Pagac', 'Almeria', 'C/ Shooting Star', NULL, '2000/10/05', 'M', 'student');
INSERT INTO person VALUES (5, '38223286T', 'David', 'Schmidt', 'Fisher', 'Almeria', 'C/ Venus', '678516294', '1978/01/19', 'M', 'professor');
INSERT INTO person VALUES (6, '04233869Y', 'Jose', 'Koss', 'Bayer', 'Almeria', 'C/ Jupiter', '628349590', '1998/01/28', 'M', 'student');
INSERT INTO person VALUES (7, '97258166K', 'Ismael', 'Strosin', 'Turcotte', 'Almeria', 'C/ Neptune', NULL, '1999/05/24', 'M', 'student');
INSERT INTO person VALUES (8, '79503962T', 'Cristina', 'Lemke', 'Rutherford', 'Almeria', 'C/ Saturn', '669162534', '1977/08/21', 'F', 'professor');
INSERT INTO person VALUES (9, '82842571K', 'Ramon', 'Herzog', 'Tremblay', 'Almeria', 'C/ Uranus', '626351429', '1996/11/21', 'M', 'student');
INSERT INTO person VALUES (10, '61142000L', 'Esther', 'Spencer', 'Lakin', 'Almeria', 'C/ Pluto', NULL, '1977/05/19', 'F', 'professor');
INSERT INTO person VALUES (11, '46900725E', 'Daniel', 'Herman', 'Pacocha', 'Almeria', 'C/ Andarax', '679837625', '1997/04/26', 'M', 'student');
INSERT INTO person VALUES (12, '85366986W', 'Carmen', 'Streich', 'Hirthe', 'Almeria', 'C/ Almanzora', NULL, '1971-04-29', 'F', 'professor');
INSERT INTO person VALUES (13, '73571384L', 'Alfredo', 'Stiedemann', 'Morissette', 'Almeria', 'C/ Guadalquivir', '950896725', '1980/02/01', 'M', 'professor');
INSERT INTO person VALUES (14, '82937751G', 'Manolo', 'Hamill', 'Kozey', 'Almeria', 'C/ Duero', '950263514', '1977/01/02', 'M', 'professor');
INSERT INTO person VALUES (15, '80502866Z', 'Alejandro', 'Kohler', 'Schoen', 'Almeria', 'C/ Tajo', '668726354', '1980/03/14', 'M', 'professor');
INSERT INTO person VALUES (16, '10485008K', 'Antonio', 'Fahey', 'Considine', 'Almeria', 'C/ Sierra de los Filabres', NULL, '1982/03/18', 'M', 'professor');
INSERT INTO person VALUES (17, '85869555K', 'Guillermo', 'Ruecker', 'Upton', 'Almeria', 'C/ Sierra de Gador', NULL, '1973/05/05', 'M', 'professor');
INSERT INTO person VALUES (18, '04326833G', 'Micaela', 'Monahan', 'Murray', 'Almeria', 'C/ Veleta', '662765413', '1976/02/25', 'M', 'professor');
INSERT INTO person VALUES (19, '11578526G', 'Inma', 'Lakin', 'Yundt', 'Almeria', 'C/ Picos de Europa', '678652431', '1998/09/01', 'F', 'student');
INSERT INTO person VALUES (20, '79221403L', 'Francesca', 'Schowalter', 'Muller', 'Almeria', 'C/ Quinto pino', NULL, '1980/10/31', 'M', 'professor');
INSERT INTO person VALUES (21, '79089577Y', 'Juan', 'Gutierrez', 'Lopez', 'Almeria', 'C/ Los pinos', '678652431', '1998/01/01', 'M', 'student');
INSERT INTO person VALUES (22, '41491230N', 'Antonio', 'Dominguez', 'Guerrero', 'Almeria', 'C/ Cabo de Gata', '626652498', '1999/02/11', 'M', 'student');
INSERT INTO person VALUES (23, '64753215G', 'Irene', 'Hernandez', 'Martinez', 'Almeria', 'C/ Zapillo', '628452384', '1996/03/12', 'F', 'student');
INSERT INTO person VALUES (24, '85135690V', 'Sonia', 'Gea', 'Ruiz', 'Almeria', 'C/ Mercurio', '678812017', '1995/04/13', 'F', 'student');

/* Professor */
INSERT INTO professor VALUES (3, 1);
INSERT INTO professor VALUES (5, 2);
INSERT INTO professor VALUES (8, 3);
INSERT INTO professor VALUES (10, 4);
INSERT INTO professor VALUES (12, 4);
INSERT INTO professor VALUES (13, 5);
INSERT INTO professor VALUES (14, 6);
INSERT INTO professor VALUES (15, 7);
INSERT INTO professor VALUES (16, 8);
INSERT INTO professor VALUES (17, 9);
INSERT INTO professor VALUES (18, 10);
INSERT INTO professor VALUES (20, 11);

/* Student */
INSERT INTO student VALUES (1, 'computer science', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (2, 'mathematics', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (4, 'education', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (6, 'biology and geology', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (7, 'biology and geology', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (9, 'chemistry and physics', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (11, 'economics and business', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (19, 'law', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (21, 'agr

onomy', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (22, 'agr

onomy', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (23, 'law', '2021/09/15', '2025/06/30');
INSERT INTO student VALUES (24, 'computer science', '2021/09/15', '2025/06/30');

/* Phone */
INSERT INTO phone VALUES (1, 'mobile', '950254837');
INSERT INTO phone VALUES (2, 'mobile', '618253876');
INSERT INTO phone VALUES (3, 'mobile', '618223876');
INSERT INTO phone VALUES (5, 'mobile', '678516294');
INSERT INTO phone VALUES (6, 'mobile', '628349590');
INSERT INTO phone VALUES (7, 'mobile', '618223876');
INSERT INTO phone VALUES (8, 'mobile', '669162534');
INSERT INTO phone VALUES (9, 'mobile', '626351429');
INSERT INTO phone VALUES (10, 'mobile', '679837625');
INSERT INTO phone VALUES (11, 'mobile', '950896725');
INSERT INTO phone VALUES (12, 'mobile', '950263514');
INSERT INTO phone VALUES (13, 'mobile', '668726354');
INSERT INTO phone VALUES (14, 'mobile', '678652431');
INSERT INTO phone VALUES (15, 'mobile', '678652431');
INSERT INTO phone VALUES (16, 'mobile', '626652498');
INSERT INTO phone VALUES (17, 'mobile', '628452384');
INSERT INTO phone VALUES (18, 'mobile', '678812017');

/* Email */
INSERT INTO email VALUES (1, 'salvador@example.com');
INSERT INTO email VALUES (2, 'juan@example.com');
INSERT INTO email VALUES (3, 'zoe@example.com');
INSERT INTO email VALUES (5, 'pedro@example.com');
INSERT INTO email VALUES (6, 'david@example.com');
INSERT INTO email VALUES (7, 'jose@example.com');
INSERT INTO email VALUES (8, 'ismael@example.com');
INSERT INTO email VALUES (9, 'cristina@example.com');
INSERT INTO email VALUES (10, 'ramon@example.com');
INSERT INTO email VALUES (11, 'esther@example.com');
INSERT INTO email VALUES (12, 'daniel@example.com');
INSERT INTO email VALUES (13, 'carmen@example.com');
INSERT INTO email VALUES (14, 'alfredo@example.com');
INSERT INTO email VALUES (15, 'manolo@example.com');
INSERT INTO email VALUES (16, 'alejandro@example.com');
INSERT INTO email VALUES (17, 'antonio@example.com');
INSERT INTO email VALUES (18, 'guillermo@example.com');
INSERT INTO email VALUES (19, 'micaela@example.com');
INSERT INTO email VALUES (20, 'inma@example.com');
INSERT INTO email VALUES (21, 'francesca@example.com');
INSERT INTO email VALUES (22, 'juan@example.com');
INSERT INTO email VALUES (23, 'irene@example.com');
INSERT INTO email VALUES (24, 'sonia@example.com');