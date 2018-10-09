SELECT s.staff_code, s.staff_name, d.dept_name
from staff_master s
	join department_master d on s.dept_code = d.dept_code
	where s.staff_code IN (SELECT s.staff_code from staff_master s
					join book_transactions t on s.staff_code= t.staff_code
					group by s.staff_code
					having count(t.book_code)>1;