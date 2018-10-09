SELECT staff_code, staff_name, staff_sal from staff_master
	WHERE staff_sal = (select max(staff_sal) from staff_master
							where staff_sal < ((max(staff_sal) from staff_master));