function validation()
{
var empid=document.getElementById(employeeId).value;
if(empid==" "||empid==null)
	{
	alert("please enter id");
	return false;
	}
return true;
}
