function validateForm(){
	//Read the form data
	var proId=document.getElementById('proId').value
	var proName=document.getElementById('proName').value
	var proPrice=document.getElementById('proPrice').value
	var proBrand=document.getElementById('proBrand').value
	var proMadeIn=document.getElementById('proMadeIn').value
	
	if(proId.trim()==="" ||proName.trim()==="" ||proPrice.trim()==="" ||proBrand.trim()==="" ||proMadeIn.trim()==="" ){
		alert("all fields must be filled out")
		return false
	}
	if(parseFloat(proPrice)<0){
		alert("proPrice must not be a negative value")
		return false
	}
	if(proName.length>50 ||proBrand.length>50){
		alert("proName and proBrand must be less than 50 characters")
		return false
	}
	//get the mfg and exp dates
	var proMnfgDate=document.getElementById('proMnfgDate').value
	var proExpDate=document.getElementById('proExpDate').value
	//convert it into date format
	var manfacturingDateobj=new Date(proMnfgDate)
	var experingDateobj=new Date(proExpDate)
	// check the validation of dates
	if(manfacturingDateobj>experingDateobj){
		alert("manufacturing date must not be greater than expiray date")
		return false
	}
	return true
	
}