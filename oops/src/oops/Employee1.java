package oops;

import java.util.*;


class LoanException extends Exception
{
	public String toString(){
		return "no matching";
	}
}
class Employee1
{
		
		static Scanner sc=new Scanner(System.in);
		 Employee empBean;
		 
		 static ArrayList<Employee> al=new ArrayList<Employee>();
public void insert() throws Exception
{
	       
	        empBean=new Employee();
System.out.println("enter employee id");
empBean.setId(sc.nextInt());
System.out.println("enter name");
empBean.setName(sc.next());
System.out.println("enter location");
empBean.setLocation(sc.next());
System.out.println("enter salary");
empBean.setSalary(sc.nextInt());
System.out.println("enter exp");
empBean.setExp(sc.nextInt());

	
	
	 al.add(empBean);

	

	
	}
public void delete()throws Exception
{
	 System.out.println("enter the id to delete");
	    int m;
       m=sc.nextInt();
      
    	   Iterator<Employee> it= al.iterator();
    	   
    	  while(it.hasNext())
    	  {
    		Employee  emp=(Employee)it.next();
    		
    		if(m==emp.getId())
    	   {
    		   
    	     
    			it.remove();
    	        
    		  System.out.println("the id is deleted");
    		 System.out.println("there is another chance to fill the array"); 
    	   }
    	  
    	  
    		    else  if(emp.getId()!=m)
          		   System.out.println("id is not there");
}
    	  
}
    			 
      
    			 
    		 

public void update()throws Exception
{
	 System.out.println("enter the id to update");
     int j=sc.nextInt();
     
	
    	 Iterator<Employee> it= al.iterator();
    	 
    	
    	 while(it.hasNext())
  	   {
    		 Employee emp=(Employee)it.next();
	     if(emp.getId()==j)
	   {
	    	 
	  	   int n=al.indexOf(emp);
	    	 
		  System.out.println("enter name to update");
		  emp.setName(sc.next());
		  System.out.println("enter location to update");
		  emp.setLocation(sc.next());
		  System.out.println("enter sal to update");
		  emp.setSalary(sc.nextInt());
		  System.out.println("enter exp to update");
		  emp.setExp(sc.nextInt());
	   
		  al.set(n,emp);
		 
		
	   }
	     else if(emp.getId()!=j)
	    	 System.out.println("the id is not there");
		  }
	  
      
}
public void loan()throws Exception
{
	
	
	System.out.println("enter id for loan");
	int j=sc.nextInt();
	
	Iterator<Employee> it=al.iterator();
		while(it.hasNext())
		{
			Employee emp=(Employee)it.next();
			if(emp.getId()!=j)
				System.out.println("id is not there");
			else if(emp.getId()==j)
		{
			 int n=al.indexOf(emp);
		if(emp.getExp()>=2&&emp.getExp()<=3&&emp.getSalary()>=240000&&emp.getSalary()<=300000)
	{
			long h;
			h=emp.getSalary()/2;
			System.out.println("the loan will be" +h);
			int emi=(int)(h*14)/(9*100);
			emp.setEmi(emi);
			emp.setLoan(h);
			al.set(n,emp);
			
	}
		else if(emp.getExp()>=3&&emp.getSalary()>=300000)
		{
			long h;
			h=(3*emp.getSalary())/4;
			System.out.println("the loan will be" +h);
			int emi=(int)(h*14)/(9*100);
			emp.setEmi(emi);
			emp.setLoan(h);
			al.set(n,emp);
		}
		else 
	
		{
			try
			{
			throw new LoanException();
			}catch(Exception e)
			{
				System.out.println(e);
			}
	}
	}
		 
		 
	}
}
public void exit() throws Exception
{
	System.exit(0);
}
public void view() throws Exception
{
	System.out.println("enter id to view");
	int k=sc.nextInt();
	 Iterator<Employee> it= al.iterator();
	 while( it.hasNext())
	 {
		 Employee emp=(Employee)it.next();
		 if(emp.getId()==k)
		 {
		 System.out.println("id"+emp.getId());
		 System.out.println("name"+emp.getName());
		 System.out.println("location"+emp.getLocation());
		 System.out.println("salary"+emp.getSalary());
		 System.out.println("exp"+emp.getExp());
		 System.out.println("loan"+emp.getLoan());
		 System.out.println("emi"+emp.getEmi());
		 }
		 if(emp.getId()!=k)
			 System.out.println("the id is not there");
	 }
}
	public static void main(String args[]) throws Exception
	{
		
		Employee1 e1=new Employee1();
		while(true)
		{
		System.out.println("1.insert");
		
		System.out.println("2.update");
		System.out.println("3.delete");
		
		System.out.println("4.exit");
		System.out.println("5.loan");
		System.out.println("6.view");
		
		System.out.println("enter your choice");
		int s=sc.nextInt();
		switch(s)
		{
		case 1: e1.insert();
		       break;
		case 2: e1.update();
		        break;
		case 3: e1.delete();
		        break;
		     
		case 4: e1.exit();
		        break;
		case 5: e1.loan();
		        break;
		case 6: e1.view();
		        break;
		}
	}
}
}