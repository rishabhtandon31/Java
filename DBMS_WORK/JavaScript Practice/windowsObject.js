var myWindow;
function showAlertBox(){
	window.alert("Alert Message");
}

function showConfirmationBox(){
	var statuts = window.confirm();
}

function showInputBox(){
	var name= window.prompt("Enter Name ");
	window.alert("Entered Name "+name);
}

function openIt()
{
	myWindow = open('','mywin','height=300,width=300,scrollbars=yes');
	myWindow.document.writeln("<html><head><title>fun</title></head><body>");
	myWindow.document.writeln("<table bgcolor='#ffcc66' border='1' width=600><tr><td>");
	myWindow.document.writeln("<h1>Java Script</h1><br><br><br></table></body></html>");
	myWindow.document.close();
	myWindow.focus();
	myWindow.maximize();
	myWindow.alert("Hello World");
}
