function convertToINR()
{
	//read the dollar input and store in a variable
	const dollar=document.getElementById("dollarinput").value;
	
	//convert the dollar to INR
	const INR=parseFloat(dollar*82.89)
	
	//set the output to INR output field
	document.getElementById("inroutput").value=INR.toFixed(2);
}