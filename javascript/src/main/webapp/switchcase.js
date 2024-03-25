var day=prompt("enter the day")
switch(day)
{
	case "mon":document.write("mondays are bad")
			break;
	case "tue":
	case "wed":
	case "thr":document.write("mid days are ok ok")
			break;
	case "fri":document.write("friday is good")
			break;
	case "sat":
	case "sun":document.write("weekends are party days")
			break;
}