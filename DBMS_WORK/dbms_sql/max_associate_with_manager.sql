ALTER TABLE associate
	add column managerId number(5);

Insert Into associate
	values
	(
		2,10000,'Rohit','Sharma','ADM','Senior Analyst','AUPL1322','rtandon1@gmail.com',11
	);
	
	
Insert Into associate
	values
	(
		3,10000,'Deepak','Sharma','ADM','Senior Analyst','AUPL1323','rtandon1@gmail.com',12
	);
	
Insert Into associate
	values
	(
		4,10000,'Abhi','Sharma','ADM','Senior Analyst','AUPL1373','rtandon16@gmail.com',13
	);
	
	

select managerId, count(*) from associate
  group by managerId 
  having count(*)= (SELECT MAX(C) FROM (SELECT COUNT(*) AS C from associate group by managerId));