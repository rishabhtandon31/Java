CREATE TABLE salary
	(
		associateId number(10) NOT NULL,
		basicSalary number, 
		hra number, 
		conveyenceAllowance number,
		otherAlloWance number, 
		personaAllowance number, 
		monthlytax number, 
		epf number, 
		companyPf number,
		gratuity number, 
		grossSalary number, 
		netSalary number
	);


	
	
INSERT INTO SALARY
	VALUES(30000,14800,2000,1000,1500,6000,2400,2000,1200,48900,54900);
INSERT INTO SALARY
	VALUES(60000,14800,2000,1000,1500,6000,2400,2000,5200,48900,54900);

INSERT INTO SALARY
	VALUES(30000,14800,2000,1000,1500,6000,2400,2000,9200,48900,54900);

INSERT INTO SALARY
	VALUES(30000,14800,2000,1000,1500,6000,2400,2000,1200,48900,54900);

INSERT INTO SALARY
	VALUES(80000,14800,2000,1000,1500,8000,2400,2000,1200,48900,54900);

INSERT INTO SALARY
	VALUES(30000,14800,2000,1000,1500,6000,2400,2000,1200,48900,54900);

INSERT INTO SALARY
	VALUES(30000,14800,2000,1000,1500,8000,2400,2000,4200,48900,54900);

INSERT INTO SALARY
	VALUES(90000,14800,2000,1000,1500,6000,2400,2000,1200,48900,54900);

INSERT INTO SALARY
	VALUES(60000,14800,2000,1000,1500,6000,2400,2000,3200,48900,54900);

INSERT INTO SALARY
	VALUES(10000,14800,2000,1000,1500,5000,2400,2000,1200,48900,54900);



INSERT INTO salary (basicSalary,hra,conveyenceAllowance,otherAlloWance,grossSalary)
	values(30000,3000,9000,8000,select basicSalary+hra+conveyenceAllowance+otherAlloWance from salary);
	
	INSERT INTO salary (basicSalary,hra,conveyenceAllowance,otherAlloWance,grossSalary)
	values(30000,3000,9000,8000,basicSalary+hra+conveyenceAllowance+otherAlloWance);