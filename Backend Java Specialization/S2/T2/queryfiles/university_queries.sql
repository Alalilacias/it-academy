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
SELECT subject_name
FROM subject
WHERE degree_id = 7 AND semester = 1 AND year = 3;

-- Returns a list of professors along with the name of the department to which they are linked. Sorted alphabetically.
SELECT p.first_last_name, p.second_last_name, p.first_name, d.department_name
FROM professor p
JOIN department d ON p.department_id = d.department_id
ORDER BY p.second_last_name, p.first_name;

-- Returns a list with the name of the subjects, start year, and end year of the student's school year with NIF 26902806M.
SELECT s.subject_name, c.start_year, c.end_year
FROM student st
JOIN student_enrollment se ON st.id = se.student_id
JOIN course_school_year c ON se.course_school_year_id = c.course_school_year_id
JOIN subject s ON se.subject_id = s.subject_id
WHERE st.nif = '26902806M';

-- Returns a list with the name of all the departments that have professors who teach a subject in the Degree in Computer Engineering (Plan 2015).
SELECT DISTINCT d.department_name
FROM department d
JOIN professor p ON d.department_id = p.department_id
JOIN subject s ON p.id = s.professor_id
JOIN degree de ON s.degree_id = de.degree_id
WHERE de.plan = '2015';

-- Returns a list of all students who have enrolled in a subject during the 2018/2019 school year.
SELECT DISTINCT st.first_name, st.last_name
FROM student st
JOIN student_enrollment se ON st.id = se.student_id
JOIN course_school_year c ON se.course_school_year_id = c.course_school_year_id
WHERE c.start_year = 2018 AND c.end_year = 2019;

-- LEFT JOIN and RIGHT JOIN Queries
-- Returns a list with the names of all the professors and the departments they are linked to. Also shows professors without any associated department.
SELECT d.department_name, p.first_last_name, p.second_last_name, p.first_name
FROM professor p
LEFT JOIN department d ON p.department_id = d.department_id
ORDER BY d.department_name, p.second_last_name, p.first_name;

-- Returns a list of professors who are not associated with a department.
SELECT p.first_last_name, p.second_last_name, p.first_name
FROM professor p
LEFT JOIN department d ON p.department_id = d.department_id
WHERE d.department_id IS NULL;

-- Returns a list of departments that do not have associate professors.
SELECT d.department_name
FROM department d
LEFT JOIN professor p ON d.department_id = p.department_id
WHERE p.department_id IS NULL;

-- Returns a list of teachers who do not teach any subjects.
SELECT p.first_last_name, p.second_last_name, p.first_name
FROM professor p
LEFT JOIN subject s ON p.id = s.professor_id
WHERE s.subject_id IS NULL;

-- Returns a list of subjects that do not have an assigned teacher.
SELECT s.subject_name
FROM subject s
LEFT JOIN professor p ON s.professor_id = p.id
WHERE p.id IS NULL;

-- Returns a list of all departments that have not taught subjects in any school year.
SELECT d.department_name
FROM department d
LEFT JOIN professor p ON d.department_id = p.department_id
LEFT JOIN subject s ON p.id = s
