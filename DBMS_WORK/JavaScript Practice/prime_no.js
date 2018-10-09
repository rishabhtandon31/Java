var var1=20
var flag
for(var i=2;i<=var1;i++)
{
	flag=1
	for(var j=2;j<i/2;j++)
	{
		if(i%j ==0 )
		{
			flag=0
		}
		
	}
	if(flag==1)
	document.write("<br>"+i)
}