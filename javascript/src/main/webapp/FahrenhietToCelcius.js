function convertToCelcius()
{
	//read the fahrenheit input and store in a variable
	const fahrenheitinput=document.getElementById("fahrenheitinput").value;
	
	//convert the fahrenheit to celcius
	const celcius=parseFloat((fahrenheitinput-32)*5/9);
	
	//set the output to celcius output field
	document.getElementById("celciusoutput").value=celcius.toFixed(2);
}