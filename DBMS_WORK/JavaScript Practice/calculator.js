var num1,num2,myWindow,num3;

function add_number()
{
	num1= parseInt(document.arithmatic.num1.value);
	num2=parseInt(document.arithmatic.num2.value);
	num3= num1+num2;
	
}


function sub_number()
{
	num1= parseInt(document.arithmatic.num1.value);
	num2=parseInt(document.arithmatic.num2.value);
	num3= num1-num2;
	}

function openIt()
{
	myWindow=open('','mywin','height=300,width=300,scrollbars=yes');
	document.getElementById("sub").onclick = function(){sub_number()};
	document.getElementById("add").onclick = function(){add_number()};
	
	/*document.arithmatic.add.onclick = add_number();
	document.arithmatic.sub.onclick = sub_number();*/
	/*if (document.arithmatic.add.check== True)
	{
		add_number();
	}
	else(document.arithmatic.sub.onclick)
	{
		sub_number();
	}*/
	
	
	
	
	myWindow.document.writeln("<html><head><title>fun</title></head><body>");
	myWindow.document.writeln("OutPut :"+ num3);
	myWindow.document.writeln("</body></html>");
	myWindow.document.close();
	myWindow.focus();
	
	
}