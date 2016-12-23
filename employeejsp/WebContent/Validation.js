function validation()
{
var empid=document.getElementById("employeeid").value;
if(empid==""||empid==null)
	{
	document.getElementById("error").innerHTML="please enter id ";
	return false;
	}
else
return true;
}
function clearField()
{
	document.getElementById("error").innerHTML=" ";
}