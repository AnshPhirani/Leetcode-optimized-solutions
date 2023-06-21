# Write your MySQL query statement below
SELECT student_id, student_name, subject_name, (SELECT COUNT(*) FROM Examinations e WHERE stu.student_id = e.student_id AND sub.subject_name = e.subject_name) 'attended_exams' FROM Students stu, Subjects sub ORDER BY stu.student_id, sub.subject_name;