SELECT dept_code, SUM(staff_sal) 
from staff_master where mgr_code is NULL and staff_sal > 20000 group by dept_code;