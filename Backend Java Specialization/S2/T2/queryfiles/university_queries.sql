-- Return a list with the first last name, second last name, and first name of all the students. The list must be ordered alphabetically.
SELECT last_name1, last_name2, first_name
FROM person
WHERE type = 'student'
ORDER BY last_name1, last_name2, first_name;

-- Find out the first and last names of students who have not registered their phone number in the database.
SELECT first_name, last_name1, last_name2
FROM person
WHERE type = 'student' AND phone IS NULL;

-- Returns the list of students who were born in 1999.
SELECT first_name, last_name1, last_name2
FROM person
WHERE type = 'student' AND EXTRACT(YEAR FROM birth_date) = 1999;

-- Returns the list of teachers who have not registered their phone number in the database and also their NIF ends in K.
SELECT first_name, last_name1, last_name2
FROM person
WHERE type = 'professor' AND phone IS NULL AND nif LIKE '%K';

-- Returns the list of subjects that are taught in the first semester, in the third year of the degree that has the identifier 7.
SELECT name
FROM subject
WHERE id_degree = 7 AND semester = 1 AND course = 3;

-- Returns a list of professors along with the name of the department to which they are linked. Sorted alphabetically.
SELECT p.last_name1, p.last_name2, p.first_name, d.name
FROM person p
JOIN professor pr ON p.id = pr.id_professor
JOIN department d ON pr.id_department = d.id
WHERE type = 'professor'
ORDER BY p.last_name2, p.first_name;

-- Returns a list with the name of the subjects, start year, and end year of the student's school year with NIF 26902806M.
SELECT p.first_name, y.start_year, y.end_year
FROM person p
JOIN student_enrolls_subject se ON p.id = se.id_student
JOIN school_year y ON se.id_student = y.id
JOIN subject s ON se.id_subject = s.id
WHERE p.nif = '26902806M';

-- Returns a list with the name of all the departments that have professors who teach a subject in the Degree in Computer Science (2015 plan).
SELECT DISTINCT d.name
FROM department d
JOIN professor p ON p.id_department = d.id
JOIN subject s ON p.id_professor = s.id_professor
JOIN degree de ON de.id = s.id_degree
WHERE de.name = 'Bachelor in Computer Science (2015 Plan)';

-- Returns a list of all students who have enrolled in a subject during the 2018/2019 school year.
SELECT DISTINCT p.last_name1, p.last_name2, p.first_name
FROM person p
JOIN student_enrolls_subject se ON p.id = se.id_student
JOIN school_year y ON se.id_school_year = y.id
WHERE y.start_year = 2018 AND y.end_year = 2019 AND p.type = 'student';

-- LEFT JOIN and RIGHT JOIN Queries
-- Returns a list with the names of all the professors and the departments they are linked to.
-- The list must also show those professors who do not have any associated department.
-- The listing must return four columns, department name, first last name, second last name and teacher's name.
-- The result will be sorted alphabetically from lowest to highest by department name, last name and first name.
SELECT d.name AS department_name, p.last_name1 AS last_name1, p.last_name2 AS last_name2, p.first_name AS first_name
FROM department d
LEFT JOIN professor pr ON d.id = pr.id_department
RIGHT JOIN person p ON pr.id_professor = p.id
WHERE p.type = 'professor'
ORDER BY department_name ASC, last_name1 ASC, last_name2 ASC, first_name ASC;

-- Returns a list of professors who are not associated with a department.
SELECT d.name AS department_name, p.last_name1 AS last_name1, p.last_name2 AS last_name2, p.first_name AS first_name
FROM department d
LEFT JOIN professor pr ON d.id = pr.id_department
RIGHT JOIN person p ON pr.id_professor = p.id
WHERE d.name IS NULL AND p.type = 'professor';

-- Returns a list of departments that do not have associate professors.
SELECT d.name AS department_name
FROM department d
LEFT JOIN professor pr ON d.id = pr.id_department
WHERE pr.id_professor IS NULL;

-- Returns a list of teachers who do not teach any subjects.
SELECT p.first_name AS first_name, p.last_name1 AS last_name1, p.last_name2 AS last_name2
FROM person p
LEFT JOIN professor pr ON p.id = pr.id_professor
LEFT JOIN subject s ON pr.id_professor = s.id_professor
WHERE s.id_professor IS NULL AND p.type = 'professor';

-- Returns a list of subjects that do not have an assigned teacher.
SELECT s.name AS subject_name, s.type AS subject_type
FROM subject s
LEFT JOIN professor pr ON s.id_professor = pr.id_professor
WHERE pr.id_professor IS NULL;

-- Returns a list of all departments that have not taught subjects in any school year.
SELECT d.department_name
FROM department d
LEFT JOIN professor p ON d.department_id = p.department_id
LEFT JOIN subject s ON p.id = s

-- Summary Queries:
-- Returns the total number of students.
SELECT COUNT(*) AS total_students
FROM person
WHERE type = 'student';

-- Calculate how many students were born in 1999.
SELECT COUNT(*) AS students_born_in_1999
FROM person
WHERE type = 'student' AND YEAR(birth_date) = 1999;

-- Calculate how many teachers there are in each department.
--The result should only show two columns, one with the name of the department and another with the number of teachers in that department.
-- The result must only include the departments that have associate professors and must be ordered from highest to lowest by the number of professors.
SELECT d.name AS department_name, COUNT(p.id) AS number_of_teachers
FROM department d
LEFT JOIN professor pr ON d.id = pr.id_department
LEFT JOIN person p ON pr.id_professor = p.id
WHERE p.type = 'professor'
GROUP BY d.id
ORDER BY number_of_teachers DESC;

-- Returns a list with all the departments and the number of professors in each of them.
-- Keep in mind that there may be departments that do not have associate professors. These departments must also appear in the list.
SELECT d.name AS department_name, COUNT(pr.id_professor) AS number_of_professors
FROM department d
LEFT JOIN professor pr ON d.id = pr.id_department
GROUP BY d.id
ORDER BY number_of_professors DESC;

-- Returns a list with the name of all the existing degrees in the database and the number of subjects each one has.
-- Note that there may be degrees that do not have associated subjects. These degrees must also appear in the listing.
-- The result must be ordered from highest to lowest by the number of subjects.
SELECT d.name AS degree_name, COUNT(s.id) AS number_of_subjects
FROM degree d
LEFT JOIN subject s ON d.id = s.id_degree
GROUP BY d.id
ORDER BY number_of_subjects DESC;

-- Returns a list with the name of all the existing degrees in the database that have more than 40 associated subjects, and the number of subjects each has.
SELECT d.name AS degree_name, COUNT(s.id) AS number_of_subjects
FROM degree d
LEFT JOIN subject s ON d.id = s.id_degree
GROUP BY d.id
HAVING number_of_subjects > 40
ORDER BY number_of_subjects DESC;

-- Returns a list showing the name of the degrees and the sum of the total number of credits for each subject type.
-- The result must have three columns: name of the degree, type of subject and the sum of the credits of all subjects of that type.
SELECT d.name AS degree_name, s.type AS subject_type, SUM(s.credits) AS total_credits
FROM degree d
LEFT JOIN subject s ON d.id = s.id_degree
GROUP BY d.id, s.type;

-- Returns a list that shows how many students have enrolled in a subject in each of the school years.
-- The result must show two columns, one column with the start year of the school year and another with the number of enrolled students.
SELECT sy.start_year AS school_year_start_year, COUNT(DISTINCT ses.id_student) AS enrolled_students
FROM school_year sy
LEFT JOIN student_enrolls_subject ses ON sy.id = ses.id_school_year
GROUP BY sy.id;

-- Returns a list with the number of subjects taught by each teacher.
-- The list must take into account those professors who do not teach any subjects.
-- The result will show five columns: id, name, first last name, second last name and number of subjects.
-- The result will be ordered from highest to lowest by the number of subjects.
SELECT p.id AS professor_id, p.first_name AS first_name, p.last_name1 AS last_name1, p.last_name2 AS last_name2, COUNT(s.id) AS number_of_subjects
FROM person p
LEFT JOIN professor pr ON p.id = pr.id_professor
LEFT JOIN subject s ON pr.id_professor = s.id_professor
GROUP BY p.id, first_name, last_name1, last_name2
ORDER BY number_of_subjects DESC;

-- Returns all data for the youngest student.
SELECT *
FROM person
WHERE type = 'student'
ORDER BY birth_date DESC LIMIT 1;

-- Returns a list of professors who have an associated department and who do not teach any subjects.
SELECT p.id AS professor_id, p.first_name AS first_name, p.last_name1 AS last_name1, p.last_name2 AS last_name2
FROM person p
INNER JOIN professor pr ON p.id = pr.id_professor
LEFT JOIN subject s ON pr.id_professor = s.id_professor
WHERE p.type = 'professor' AND s.id IS NULL;