1.
	DECLARE
		associateRecord associate%ROWTYPE;
	BEGIN
		SELECT * into associateRecord from associate
			where associateId=&Id;
		DBMS_OUTPUT.PUT_LINE('AssociateId ' || associateRecord.associateId);
		DBMS_OUTPUT.PUT_LINE('FirstName ' || associateRecord.firstName);
		DBMS_OUTPUT.PUT_LINE('LastName ' || associateRecord.lastName);
		DBMS_OUTPUT.PUT_LINE('EmailID ' || associateRecord.emailId);
	
	exception
		wHEN	
			NO_DATA_FOUND
		THEN
			DBMS_OUTPUT.PUT_LINE('No associate id found');
	
	END;
	
	
	
2.
	DECLARE
		TYPE custumType IS RECORD(
			fname Associate.firstName%Type,
			lname Associate.lastName%Type);
			fullName custumType;			
	BEGIN
		select firstName, lastName into fullName from associate where associateId=&id;
		DBMS_OUTPUT.PUT_LINE('FirstName ' || fullName.fName);
		DBMS_OUTPUT.PUT_LINE('lastName ' || fullName.lName);
	exception
		wHEN	
			NO_DATA_FOUND
		THEN
			DBMS_OUTPUT.PUT_LINE('No associate id found');
	
	END;
	
	
3.
	DECLARE
	n1 number(10) := 100;
	n2 number(10) := 20;
	begin
		if n1>n2
		then
			DBMS_OUTPUT.PUT_LINE(n1 || ' is greater than ' || n2);
		else
			DBMS_OUTPUT.PUT_LINE(n1 || ' is greater than ' || n2);
		end if;
	end;
	
	
	
4.	
	DECLARE
		n1 number(10) :=1;
	BEGIN
		WHILE n1<=10
			LOOP
				DBMS_OUTPUT.PUT_LINE(n1);
				n1:=n1+1;
			end loop;
	end;
	
	
	
5.	
	DECLARE
		n1 number(10) := &x;
	BEGIN
		if mod(n1,2) = 0
		THEN
			DBMS_OUTPUT.PUT_LINE('Number is even.');
		else
			DBMS_OUTPUT.PUT_LINE('Number is odd.');
		end if;
	END;
	
	
	
	
6.	
	DECLARE
		n1 number(10) := &x;
		c number(10) := 0;
	BEGIN
		while c <= n1
			LOOP
				if mod(c,2) != 0
				then
					DBMS_OUTPUT.PUT_LINE(c || ' ');
				end if;
				c:= c+1;
			end loop;
	end;

	
	
7.
	DECLARE 
		CURSOR cName IS SELECT * FROM Associate;
		associateRecord Associate%ROWTYPE;
	BEGIN
		IF cname%ISOPEN
		THEN
			NULL;
		ELSE
		OPEN cName;
		END IF;
		LOOP
			FETCH cName INTO associateRecord;
			EXIT WHEN cname%NOTFOUND;
			DBMS_OUTPUT.PUT_LINE(associateRecord.firstName || ' ' || associateRecord.lastname);
		end loop;
	END;
	
	
	
8.	Declaring the exception along with cursor

	DECLARE		
		CURSOR cName IS SELECT * FROM associate;
		associateRecord associate%ROWTYPE;
		associate_not_found EXCEPTION;
	
	BEGIN
		IF cname%ISOPEN
		THEN
			NULL;
		ELSE
		OPEN cName;
		END IF;
		FETCH cName INTO associateRecord;
		IF cName%NOTFOUND
			THEN	
				RAISE associate_not_found;
			ELSE
					DBMS_OUTPUT.PUT_LINE(associateRecord.firstName || ' ' || associateRecord.lastname);
		end if;
		EXCEPTION
			WHEN associate_not_found
			THEN	DBMS_OUTPUT.PUT_LINE('Associate Details Not Found');
	END;

	
	
9. Stored Procedures
	
	SELECT * from user_errors where type='PROCEDURE' and name='INSERT_ASSOCIATE';
	create or replace procedure insert_Associate(
		aId in Associate.associateId%Type,
		yInvestment in Associate.yearlyInvestmentUnder8oc%Type,
		fname in Associate.firstName%Type,
		lname in Associate.lastName%Type,
		dep in Associate.department%Type,
		desg in Associate.designation%Type,
		pCard in Associate.pancard%Type,
		eId in Associate.emailId%Type,
		mId1 in Associate.managerId%Type)
	is
	begin
		insert into Associate values(aId,yInvestment,fName,lName,dep,desg,pCard,eId,mId1);
	end;
	
	begin
		insert_Associate(106,154000,'Kunal','Sharma','ADM','Con','JDNK3430','kunal@gmail.com',1122);
	end;
	/
	
	
	
10.
	CREATE OR REPLACE FUNCTION associateCountForDepartment
		( depName in Associate.department%Type)
		return number IS
		associateCount number(10) :=0;
	begin
		select count(*) into associateCount from Associate where department=depName;
		return associateCount;
	end;
	
	begin
		DBMS_OUTPUT.PUT_LINE(associateCountForDepartment('YTP'));
	end;
	
	
	
	
	
11.
	create table associateLog(
		logMessage varchar2(50),
		insertDate Date
		);
		
	Create or replace trigger insert_associate_trigger
	after insert on associate for each row
	begin
		insert into associateLog values('Record Inserted', sysdate);
	end;


	
