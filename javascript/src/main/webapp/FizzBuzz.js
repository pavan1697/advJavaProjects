let startnum=parseInt(prompt("enter the starting number"))
let endnum=parseInt(prompt("enter the ending number"))

if(startnum>0 && endnum>0)
{
	for(let i=startnum;i<=endnum;i++)
	{
		if(i%3===0)
			document.write("FIZZ")
		else if(i%5===0)
			document.write("BUZZ")
		else if(i%3===0 && i%5===0)
			document.write("FIZZBUZZ")
		else
			document.write(i)
	}
}