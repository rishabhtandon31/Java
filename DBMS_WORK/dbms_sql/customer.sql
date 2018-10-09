CREATE TABLE Customer
	(
		customerId varchar(10) PRIMARY KEY, 
		firstName varchar(10),
		mobileNo number(10),
		emailId varchar(20),
		adharNo number(20),
		pancardNo number(10),
		dateOfBirth date
	);
	
	
INSERT ALL 
	INTO Customer values
	(
		11223344, 'Rishabh1', 44544552,'rtandon1@gmail.com',44663377,'AAU564L',TO_DATE('29-10-1995','DD-MM-YYYY')
	)
	INTO Customer values
	(
		112233441, 'Rishabh12',44445522,'rtandon12@gmail.com',44556672,'AU456L2',TO_DATE('19-10-1995','DD-MM-YYYY')
	)
	INTO Customer values
	(
		112233443, 'Rishabh13',44445523,'rtandon13@gmail.com',44556673,'A4564L3',TO_DATE('9-10-1995','DD-MM-YYYY')
	)
	INTO Customer values
	(
		112233444, 'Rishabh14',44445524,'rtandon14@gmail.com',4433774,'AA564L4',TO_DATE('4-10-1995','DD-MM-YYYY')
	)
	INTO Customer values
	(
		112233445, 'Rishabh15',44445525,'rtandon15@gmail.com',4633775,'AA564L5',TO_DATE('29-1-1995','DD-MM-YYYY')
	)
	INTO Customer values
	(
		112233446, 'Rishabh16',4445526,'rtandon16@gmail.com',4433776,'AA564L6',TO_DATE('29-10-1965','DD-MM-YYYY')
	)
	INTO Customer values
	(
		112233447, 'Rishabh17',44445527,'rtandon17@gmail.com',443777,'AAU64L7',TO_DATE('29-10-1997','DD-MM-YYYY')
	)
	INTO Customer values
	(
		112233448, 'Rishabh18',44445528,'rtandon18@gmail.com',443778,'AAU64L8',TO_DATE('29-10-1998','DD-MM-YYYY')
	)
	INTO Customer values
	(
		11223349, 'Rishabh19', 44445529,'rtandon19@gmail.com',445779,'A4564L9',TO_DATE('8-10-1995','DD-MM-YYYY')
	)
	INTO Customer values
	(
		1122332, 'Rishabh133', 444455211,'rtandon111@gmail.com',437711,'A4564L1',TO_DATE('29-10-1995','DD-MM-YYYY')
	)
	select * from dual;