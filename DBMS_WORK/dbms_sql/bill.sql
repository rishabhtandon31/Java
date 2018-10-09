CREATE TABLE Bill
	(
		billID number(10) primary Key,
		noOfLocalSMS number(4),
		noOfStdSMS number(4),
		noOfLocalCalls number(4),
		noOfStdCalls number(4),
		internetDataUsageUnits number(8),
		internetDataUsageUnitsAmount number(5),
		billMonth number(2),
		stateGST number(5),
		centralGST number(5),
		totalBillAmount number(5),
		localSMSAmount number(5),
		stdSMSAmount number(5),
		localCALLAmount number(5)
	);
	