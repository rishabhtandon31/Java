CREATE TABLE Plan
	(
		planId number,
		monthlyrental number,
		freeLocalCalls number,
		freeStdCalls number,
		freeLocalSMS number,
		freeStdSMS number,
		freeInternetDataUsageUnits number,
		localCallRate number,
		stdCallrate number,
		localSMSrate number,
		stdSMSRate number,
		internetDataUsageRate number,
		planCircle varchar(10),
		planName varchar2(10),
		PRIMARY KEY (planId)
	);
	

INSERT ALL
	INTO PLAN VALUES
	(
		11234,1000,150,20,100,50,100,1.5,2.5,200,32,20
	)
	INTO PLAN VALUES
	(
		1113,1000,150,50,100,50,100,1.5,2.5,200,32,20
	)
	INTO PLAN VALUES
	(
		1114,1000,150,50,100,50,400,1.5,2.5,200,32,20
	)
	INTO PLAN VALUES
	(
		1115,1000,150,50,100,50,900,1.5,2.5,200,32,20
	)
	INTO PLAN VALUES
	(
		1116,1000,150,50,100,50,100,1.5,2.5,200,32,20
	)
	INTO PLAN VALUES
	(
		1117,1000,150,50,100,50,800,1.5,2.5,200,32,20
	)
	INTO PLAN VALUES
	(
		1118,1000,150,50,100,50,10,1.5,2.5,200,32,20
	)
	INTO PLAN VALUES
	(
		1119,1000,150,50,10,50,100,1.5,2.5,200,32,20
	)
	INTO PLAN VALUES
	(
		1111,1000,150,50,10,50,100,1,2,200,32,20
	)
	INTO PLAN VALUES
	(
		1123,1000,150,50,100,50,100,1.5,2.5,200,32,20
	)
	select * from dual;
