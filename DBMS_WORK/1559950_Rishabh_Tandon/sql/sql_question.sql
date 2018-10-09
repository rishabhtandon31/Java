DROP TABLE electricity_Consumer CASCADE CONSTRAINTS;
DROP TABLE Electricity_bill;
DROP SEQUENCE billid_seq;

***********************************************************************************

CREATE TABLE electricity_Consumer
(
	consumerNo number(8) PRIMARY KEY,
	ConsumerName varchar2(20) NOT NULL,
	emailId varchar2(35),
	UnitsConsumed number
);


*************************************************************************************

CREATE TABLE electricity_Bill
(
	BillNo number PRIMARY KEY,
	consumerNo number REFERENCES electricity_Consumer(consumerNo),
	billAmount number,
	billPaidDate Date
);


**************************************************************************************

INSERT INTO electricity_consumer
values(1001,'Seema Joshi','Seema.joshi@gmail.com',250);

INSERT INTO electricity_consumer
values(1002,'Amey Joshi','Amey.j@cg.com',345);

INSERT INTO electricity_consumer
values(1003,'Pravin','Pravin.t@cg.com',457);

INSERT INTO electricity_consumer
values(1004,'Manoj Kulkarni','manoj@gmail.com',780);

INSERT INTO electricity_consumer
values(1005,'Shrikant Shinde','Shrikant.shinde@gmail.com',90);

INSERT INTO electricity_consumer
values(1006,'Mahesh B','bMahesh@yahoo.com',720);

********************************************************************************************

INSERT INTO electricity_bill
values(101,1001,440.45,to_date('25-May-2017','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(102,1002,690,to_date('02-Jun-2018','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(103,1001,675,to_date('05-Aug-2017','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(104,1004,678,to_date('05-Aug-2000','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(105,1005,643,to_date('08-Jan-2001','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(106,1004,900,to_date('08-Feb-2010','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(107,1003,842,to_date('12-May-2001','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(108,1002,421,to_date('18-Sep-2009','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(109,1005,346,to_date('20-Aug-2005','DD-MON-YYYY'));

INSERT INTO electricity_bill
values(110,1005,342,to_date('26-July-2001','DD-MM-YYYY'));

**************************************************************************************

CREATE SEQUENCE BillID_Seq START WITH 111;

**************************************************************************************
Q.1

select * from user_errors where type='PROCEDURE' and name='final_bill'

create or replace procedure final_bill(
		custmerNo in ELECTRICITY_CONSUMER.CONSUMERNO%TYPE
	) 
IS	
	CURSOR cursor_details IS SELECT * FROM ELECTRICITY_CONSUMER WHERE CONSUMERNO=cusNo;
	consumerRecord ELECTRICITY_CONSUMER%ROWTYPE;
	consumer_not_found EXCEPTION;
	resultant_bill number := 0;
	
begin

	IF cursor_details%ISOPEN
	THEN
		null;
	ELSE
		OPEN cursor_details;
	END IF;
  
  LOOP
		FETCH cursor_details into consumerRecord;
		IF cursor_details%NOTFOUND
			THEN
				RAISE consumer_not_found;
		ELSE
			IF consumerRecord.unitsconsumed<=100
				THEN
					resultant_bill = resultant_bill + (consumerRecord.unitsconsumed * 2.96);
			ELSE
				resultant_bill = resultant_bill + (consumerRecord.unitsconsumed * 2.96);
				resultant_bill = resultant_bill + ((consumerRecord.unitsconsumed-100) * 5.56);
        
      END IF;
    END;
	
	exec final_bill();
*****************************************************************************************

Q.2

1.
	SELECT consumerNo,consumerName from
		electricity_consumer
			where unitsConsumed = (SELECT max(unitsConsumed) from electricity_consumer);
		
		
3. 
	SELECT DISTINCT c.consumerName from 
		electricity_consumer c
		join electricity_bill b on c.consumerNo=b.consumerNo
		where trim(to_char(billPaidDate,'FMDD')) >15;
		
		
*******************************************************************************************
Q.3

ALTER TABLE electricity_consumer
add 
(
	billPaymentDate date,
	billPaymentDueDate date,
	CONSTRAINT chk_date CHECK (billPaymentDueDate>=billPaymentDate AND billPaymentDueDate<=(billPaymentDate+7))
);

***************************************************************************************************

