package prgrms;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

public class Test 
{

	
	static Scanner input=new Scanner(System.in);
		Employee employeeBean=new Employee();
		DataBaseOperations dbo=new DataBaseOperations();
		public void insert()
		{
		System.out.println("enter employee Id");
		employeeBean.setEmployeeId(input.nextInt());
		System.out.println("enter employee name");
		employeeBean.setEmployeeName(input.next());
		System.out.println("enter location");
		employeeBean.setEmployeeLoc(input.next());
		System.out.println("enter employee salary");
		employeeBean.setEmployeeSlary(input.nextInt());
		System.out.println("enter loan");
		employeeBean.setEmployeeLoan(input.nextInt());
		System.out.println("enter employee exp");
		employeeBean.setEmployeeExp(input.nextInt());
		
		
		
		/*int result=dbo.insertData(employeeBean);*/
		
		int result=dbo.insertDataUsingPrepared(employeeBean);
		System.out.println(result+ " data inserted");
		}
		public void search()
		{
		System.out.println("enter employee Id to search");
		int employeeId=input.nextInt();
		
		  ArrayList<Employee> listOfEmp=  dbo.search(employeeId);
		  Iterator<Employee> itr=listOfEmp.iterator();
		 Employee employee=null;
		 System.out.println("Id \t Name \t salary \t location \t loan \t experience");
		  while(itr.hasNext())
		  {
			  employee=(Employee)itr.next();
			  
			  System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmployeeSlary()+"\t \t"+employee.getEmployeeLoc()+"\t \t"+employee.getEmployeeLoan()+"\t \t"+employee.getEmployeeExp());
		  }
		}
		public void delete()
		{
		System.out.println("enter id to delete");
		int empId=input.nextInt();
		dbo.delete(empId);
		}
		public void update()
		{
        System.out.println("enter id to update");
        int eid=input.nextInt();
        System.out.println("enter name to update");
        String empName=input.next();
        System.out.println("enter salary to update");
        int empSal=input.nextInt();
        System.out.println("enter location to update");
        String empLoc=input.next();
        System.out.println("enter loan to update");
        int empLoan=input.nextInt();
        System.out.println("enter exp to update");
        int empExp=input.nextInt();
         dbo.update(eid,empName,empSal,empLoc,empLoan,empExp);
		}
		public void loan()throws Exception
		{
         System.out.println("enter employee Id to apply for loan");
			int empid=input.nextInt();
			int eLoan=20;
			dbo.loan(eLoan,empid); 
		}
			public static void main(String[] args) throws Exception
			{
				Test t=new Test();
		while(true)
		{
			System.out.println("1.insert");
			System.out.println("2.delete");
			System.out.println("3.update");
			System.out.println("4.loan");
			System.out.println("5.search");
			System.out.println("6.exit");
			System.out.println("enter choice");
			int ch=input.nextInt();
			switch(ch)
			{
			case 1: t.insert();
			        break;
			case 2: t.delete();
			        break;
			case 3: t.update();
			        break;
			case 4: t.loan();
			        break;
			case 5: t.search();
			        break;
			case 6: System.exit(0);
			        break;
		 default: System.out.println("no case");
			}
		}
	}

}