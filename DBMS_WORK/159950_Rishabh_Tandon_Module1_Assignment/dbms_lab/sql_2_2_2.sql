SELECT dept_code, count(mgr_code) as "Total Number of Managers"
from staff_master group by dept_code;