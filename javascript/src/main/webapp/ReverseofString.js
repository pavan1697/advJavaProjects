function reverseofString()
{
	const name=document.getElementById("name").value
	
	var rev=""
	for( i=name.length-1;i>=0;i--)
		rev=rev+name[i]
		
		document.getElementById("nameoutput").value=rev;
}