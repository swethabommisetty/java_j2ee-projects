package prgrm;
import java.io.*;
class Employee implements Serializable{
	private int id,exp;
	int emi,loan,salary;
	int ms;
	private String name,location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location=location;
	}
	public int getLoan()
	{
		return loan;
	}
	public void setLoan(int loan)
	{
	  this.loan=loan;
	}
	public int getSalary()
	{
		return salary;
	}
	public void setSalary(int salary)
	{
		this.salary=salary;
	}
	public int getEmi()
	{
		return emi;
	}
	public void setEmi(int emi)
	{
		this.emi=emi;
	}
	public int getExp()
	{
		return exp;
	}
	public void setExp(int exp)
	{
		this.exp=exp;
	}
	public int getMs()
	{
		return ms;
	}
	public void setMs(int ms)
	{
		this.ms=ms;
	}

}
