SELECT STUDENT_NAME, to_char(student_dob, 'MONTH, MM YYYY') from student_master
where trim(to_char(student_dob,'DAY')) IN ('SATURDAY', 'SUNDAY');


define dateFormat="to_char(student_dob, 'MONTH, MM YYYY')";
define dayFormat="trim(to_char(student_dob,'DAY'))";
select student_name, &&dateFormat from student_master
where &&dayformat IN ('SATURDAY', 'SUNDAY');