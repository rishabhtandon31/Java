SELECT student_code, student_name,
decode(dept_code,10,'Electricals',30,'Electronics','Others')
from student_master;