Create view Acc_view (customerCode, AccountHolderName, AccountNumber, Type , Balance)
as SELECT customerId , customerName, accountName, accounttype, ledgerbalance from accountsmaster;