var ratanmass=parseFloat(prompt("enter the mass of ratan"))
var ratanheight=parseInt(prompt("enter the height of ratan"))
var anumass=parseFloat(prompt("enter the mass of anu"))
var anuheight=parseInt(prompt("enter the height of anu"))

var ratanBMI=ratanmass/(ratanheight/100*ratanheight/100)
var anuBMI=anumass/(anuheight/100*anuheight/100)

console.log("Ratan's BMI is "+ratanBMI)
console.log("Anu's BMI is "+anuBMI)

document.write("Ratan has BMI of "+ratanBMI)  
document.write("Anu has BMI of "+anuBMI)

var ratanHigherBMI

if(ratanBMI<anuBMI)
	ratanHigherBMI=false
else
	ratanHigherBMI=true

console.log("ratan has higher BMI"+ratanHigherBMI)
document.write("ratan has higher BMI"+ratanHigherBMI)