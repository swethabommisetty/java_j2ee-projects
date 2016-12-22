package prgrm;

import java.io.*;
import java.util.Scanner;
class LoanException extends Exception
{
	public String toString()
	{
		return "you are not eligible";
	}
}

public class Test implements Serializable {
	
	static Scanner sc=new Scanner(System.in);
	static int n;
	static Employee[] empArray;
	public void insert() throws Exception
	{
		 Employee empBean;
	        for(int i=0;i<=n-1;i++)
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
	 empArray[i]=empBean;
}
	
	        FileOutputStream fos=new FileOutputStream("D:/harshu.txt");
	           ObjectOutputStream oos=new ObjectOutputStream(fos);
	           oos.writeObject(empArray);
	           
	           System.out.println("serialization done");

	       
	       
}
	
	public void delete()throws Exception
	{
		FileInputStream fis=new FileInputStream("D:/harshu.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Object obj=ois.readObject();
        Employee[] empArray=(Employee[])obj;
		 System.out.println("enter the id to delete");
		    int tempid;
	       tempid=sc.nextInt();
	       for(int i=0;i<=n-1;i++)
	       {
	    	   Employee emp=(Employee)empArray[i];
	    	  if(empArray[i]==null)
	    	  {
	    		  System.out.println("this id is not present");
	    	  }
	    	  else if(tempid==emp.getId())
	    	   {
	    	     
	    	      emp.setId(0);
	    	      emp.setName(null);
	    	      emp.setLocation(null);
	    	      emp.setExp(0);
	    	      emp.setSalary(0);
	    		  empArray[i]=emp;
	    		  System.out.println("the id"+tempid+"is deleted");
	    	   }
	    	  else if(tempid!=emp.getId())
	    		  System.out.println("the id is not present");
	    	  
	    	  if(emp.getId()==0)
	    		  System.out.println("there is another chance to full the array size");
	       }
	       FileOutputStream fos=new FileOutputStream("D:/harshu.txt");
           ObjectOutputStream oos=new ObjectOutputStream(fos);
           oos.writeObject(empArray);
           
           System.out.println("serialization done");

	       }
	
	public void update()throws Exception
	{
		FileInputStream fis=new FileInputStream("D:/harshu.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Object obj=ois.readObject();
        Employee[] empArray=(Employee[])obj;
		 System.out.println("enter the id to update");
         int j=sc.nextInt();
         for(int i=0;i<=n-1;i++)
          {
  	
  	   Employee emp=(Employee)empArray[i];
  	   if(empArray[i]==null)
  	   {
  		 System.out.println("this id is not present");  
  	   }
  	   if(emp.getId()!=j)
  		   System.out.println("the id is not there");
  	   else  if(emp.getId()==j)
  	   {
  		  System.out.println("enter name to update");
  		  emp.setName(sc.next());
  		  System.out.println("enter location to update");
  		  emp.setLocation(sc.next());
  		  System.out.println("enter sal to update");
  		  emp.setSalary(sc.nextInt());
  		  System.out.println("enter exp to update");
  		  emp.setExp(sc.nextInt());
  		  empArray[i]=emp;
 	   System.out.println(i+1 +"details");
 	   System.out.println("id= "+ emp.getId());
 	   System.out.println("name ="+ emp.getName());
 	   System.out.println("location= "+ emp.getLocation());
 	   System.out.println("loan= "+ emp.getLoan());
 	   System.out.println("salary= "+ emp.getSalary());
 	   System.out.println("emi= "+ emp.getEmi());
 	   System.out.println("experience= "+ emp.getExp());
  	   }
  	   else if(emp.getId()!=j)
  		   System.out.println("the id is not present");
          }
    
         FileOutputStream fs=new FileOutputStream("D:/harshu.txt");
         ObjectOutputStream os=new ObjectOutputStream(fs);
         os.writeObject(empArray);
         
         System.out.println("serialization done");  
	}
	public void loan()throws Exception
	{
		FileInputStream fis=new FileInputStream("D:/harshu.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Object obj=ois.readObject();
        Employee[] empArray=(Employee[])obj;
		System.out.println("enter id for loan");
		int sw=sc.nextInt();
		
		for(int i=0;i<=n-1;i++)
        {
	       Employee emp=(Employee)empArray[i];
	       if(empArray[i]==null)
	       {
	    	   System.out.println("this id is not present");
	       }
	       if(emp.getId()!=sw)
	    	   System.out.println("the id is not present");
	       else   if(emp.getId()==sw)
	       {
	    	   
	       if(emp.getExp()>=2&&emp.getExp()<3&&emp.getSalary()>=240000&&emp.getSalary()<300000)
	       {
	    	   
	    	   System.out.println("you are eligible for half packge");
	    	   int loan=(emp.getLoan())+(emp.getSalary()/2);
	    	   int emi=(loan*14)/900;
	    	   emp.setLoan(loan);
	    	   emp.setEmi(emi);   
	    	   empArray[i]=emp;
	    	   System.out.println("id= "+ emp.getId());
	    	   System.out.println("name ="+ emp.getName());
	    	   System.out.println("location= "+ emp.getLocation());
	    	   System.out.println("salary= "+ emp.getSalary());
	    	   System.out.println("loan= "+ emp.getLoan());
	    	   System.out.println("emi= "+ emp.getEmi());
	    	   System.out.println("experience= "+ emp.getExp());
          }
	       
	       else if(emp.getExp()>=3&&emp.getSalary()>=300000)
	       {
	    	   System.out.println("you are eligible for 3/4th packge");
	    	   int loan=(emp.getLoan())+(emp.getSalary()*3/4);
	    	   int emi=(loan*14)/900;
	    	   emp.setLoan(loan);
	    	   emp.setEmi(emi);
	    	   empArray[i]=emp;
	    	   System.out.println("id= "+ emp.getId());
	    	   System.out.println("name ="+ emp.getName());
	    	   System.out.println("location= "+ emp.getLocation());
	    	   System.out.println("salary= "+ emp.getSalary());
	    	   System.out.println("loan= "+ emp.getLoan());
	    	   System.out.println("emi= "+ emp.getEmi());
	    	   System.out.println("experience= "+ emp.getExp());
          
	       }
	       else
	       {
	    	   try
	    	   {
	    		   throw new LoanException();
	    	   }
	    	 
	    	   catch(Exception e)
	    	   {
	    	   System.out.println(e);
	    	   }
	       }
	       }
	     
        }
		FileOutputStream fs=new FileOutputStream("D:/harshu.txt");
        ObjectOutputStream os=new ObjectOutputStream(fs);
        os.writeObject(empArray);
        
        System.out.println("serialization done");  
		
	}
	public void view()throws Exception
	{
		FileInputStream fis=new FileInputStream("D:/harshu.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Object obj=ois.readObject();
        Employee[] empArray=(Employee[])obj;
		int ms;
	     System.out.println("enter id to view");
        int k=sc.nextInt();
        for(int i=0;i<=n-1;i++)
        {
       	Employee emp=(Employee)empArray[i];
       	if(empArray[i]==null)
       	{
       		System.out.println("this id is not present");
       	}
       	else if(emp.getId()==k)
       	{
       	 ms=(emp.getSalary()-emp.getEmi());
       	 emp.setMs(ms);
       	 empArray[i]=emp;
       	System.out.println(i+1 +"details");
 	   System.out.println("id= "+ emp.getId());
 	   System.out.println("name ="+ emp.getName());
 	   System.out.println("location= "+ emp.getLocation());
 	   System.out.println("salary= "+ emp.getSalary());
 	   System.out.println("loan= "+ emp.getLoan());
 	   System.out.println("emi= "+ emp.getEmi());
 	   System.out.println("experience= "+ emp.getExp());
 	   System.out.println("ms= "+ emp.getMs());
        }
       	else if(emp.getId()!=k)
       		System.out.println("the id is not present");
        }
 
	}
	public static void main(String[] args) throws Exception
	{
	   System.out.println("enter no of employees");
	    n=sc.nextInt();
	   empArray=new Employee[n];
		Test t=new Test();
		
		while(true)
		{
		System.out.println("1.insert");
		System.out.println("2.delete");
		System.out.println("3.update");
		System.out.println("4.loan");
		System.out.println("5.view");
		System.out.println("6.exit");
		System.out.println("enter your choice");
		int s=sc.nextInt();
		
		
		
		switch(s)
		{
		case 1:   t.insert(); 
		       
			               
		        break;
		       
		case 2:  
		         t.delete();
			   
		      
		       break;
		case 3: 
			   t.update();
			   
	          break;
	           
		case 4:    t.loan();
			       break;
		          
		case 5:  t.view();
		         break;
		case 6: System.exit(0);
		        break;
		default: System.out.println("no case");
	             break;
		
		
	}
	
	}
}
}