package com.user.autoid;

import java.util.Random;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class GenerateOtp 
{

	private static String employeeOtp="0";
	private static GenerateOtp ref=new GenerateOtp();
	private GenerateOtp()
	{
		employeeOtp=employeeOtp+getUniqueNo();
		
	}
	
	public static String getEmployeeOtp()
	{		
		return employeeOtp;
		
	}
	
	private static String getUniqueNo()
	{
		String uniqueNo="";
		
		Random random=new Random();
			
		int randomValue=random.nextInt(99);
		int factorialValue=factorial(randomValue);
		Integer temVal=new Integer(factorialValue);
		String factVal=temVal.toString();
		int length=factVal.length();
		if(length<4)
		{
			for(int i=3;i>=0;i--)
			{
				try
				{
					uniqueNo=uniqueNo+factVal.charAt(i);
				}
				catch(Exception e)
				{
					uniqueNo=uniqueNo+"0";
				}
				
			}
			
		}
		else
		{
			for(int i=0;i<=3;i++)
			{
				uniqueNo=uniqueNo+factVal.charAt(i);
			}
			
			
		}
		
	
		
			
		return uniqueNo;
		
	}
	
	private static int factorial(int value)
	{
		int fact=1;
		for(int i=1;i<=value;i++)
		{
			fact=(fact*i)+value;
		}
		
		
		return fact;
		
	}

}
