ALTER TABLE AccountMaster 
add constraint balance_check check (ledgerBalance > 5000); 