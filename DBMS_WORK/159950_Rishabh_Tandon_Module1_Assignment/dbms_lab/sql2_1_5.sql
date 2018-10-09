SELECT staff_name, staff_sal, 
	case 
		when staff_sal > = 50000 then 'A'
		when staff_sal > = 25000 and staff_sal< 50000 then 'B'
		when staff_sal > = 10000 and staff_sal< 25000 then 'C'
		ELSE 'D'
	END
	FROM Staff_master;