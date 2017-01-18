package oops;
import java.io.*;
class Employee {
	
		private int id;
		private String name;
		private int exp;
		private String loc;
		private long loan;
		private int emi;
		private long sal;
		private int ms;
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
		public int getExp()
		{
			return exp;
		}
		public void setExp(int exp)
		{
			this.exp=exp;
		}
		public String getLocation()
		{
			return loc;
		}
		public void setLocation(String loc)
		{
			this.loc=loc;
		}
		public long getLoan()
		{
			return loan;
		}
		public void setLoan(long loan)
		{
			this.loan=loan;
		}
		public int getEmi()
		{
			return emi;
		}
		public void setEmi(int emi)
		{
			this.emi=emi;
		}
		public long getSalary()
		{
			return sal;
		}
		public void setSalary(long sal)
		{
			this.sal=sal;;
		}
		public int getMs()
		{
			return ms;
		}
		public void setMs(int ms)
		{
			this.ms=ms;;
		}
		
}