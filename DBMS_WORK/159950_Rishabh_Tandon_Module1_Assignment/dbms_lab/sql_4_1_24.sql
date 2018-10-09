Create view accsvw10 
	as select * from accountsMaster
		with read only constraint view_read_only;