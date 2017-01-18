function validation()
{
var empid=document.getElementById("employeeid").value;
var empname=document.getElementById("employeename").value;
var empsal=document.getElementById("employeesalary").value;
if(empid==""||empid==null)
	{
	document.getElementById("error").innerHTML="please enter id ";
	return false;
	}

if(empname==""||empname==null)
{
document.getElementById("error").innerHTML="please enter name ";
return false;
}
if(empsal==""||empsal==null)
{
document.getElementById("error").innerHTML="please enter salary ";
return false;
}
else
return true;
}
function clearField()
{
	document.getElementById("error").innerHTML=" ";
}