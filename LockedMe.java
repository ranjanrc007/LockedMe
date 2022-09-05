package com.LockedMe.org;



import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class LockedMe 
{
	
	static final String projectLocation="E:\\Ranjan\\ProjectFSDPhase1";
	
	public static void main(String[] args) 
	{
		File path = new File(projectLocation);
		Scanner obj = new Scanner(System.in);
		int val=0;
		try 
		{
			do 
			{
				displayOptions();
				System.out.println("Enter your choice:\n");
				val = Integer.parseInt(obj.nextLine());
				switch(val) {
				case 1:
					displayFiles(path);
					break;
				case 2:
					createFile(obj);
					break;
				case 3:
					searchFile(obj);
					break;
				case 4:
					deleteFile(obj);
					break;
				case 5:
					System.out.println("\nApplication Closed");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option\n");
					
				}			
			}
			while(val>0&&val<=6);
		}
		
		catch(Exception e) 
		{
			System.out.println("Make sure to give interger values.\nContact Administrator\n ");
		}
		
		finally
		{
			obj.close();
		}
	}
	
	
	public static void displayOptions() 
	{
		System.out.println("************************************************************");
		System.out.println("                LockedMe.com");
		System.out.println("           Developed by Ranjan R C");   
		System.out.println("************************************************************");
		System.out.println("\t1. Display Contents of the Main Directory");
		System.out.println("\t2. Add file to Main Directory");
		System.out.println("\t3. Search Main Directory for file");
		System.out.println("\t4. Delete file from Main Directory");
		System.out.println("\t5. Exit");
		System.out.println("************************************************************");
	}
	
	
	
	public static void displayFiles(File folder) 
	{
		try 
		{
			if(folder.listFiles().length==0)
			{
				System.out.println("\tNo files present in Root directory\n");
			}
			if(folder.getAbsolutePath().equals(projectLocation))
			{
				System.out.println(folder.getName()+":\n");
			}
			for(File file:folder.listFiles())
			{
				if(file.isDirectory())
				{
					if(file.listFiles().length==0)
					{
						System.out.println("\tNo files present in directory "+file.getName());
					}
					else 
					{
						displayFiles(file);
					}
				}
				else 
				{
					System.out.println("\t"+file);
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println("LockedMe Root Directory Not Found/Error Occured. Contact Administrator\n");
		}
	}
	
	
	
	public static void createFile(Scanner obj)
	{
		try
		{
			String fileName;
			int lines=0;
			
			System.out.println("\nEnter Name of the New File to be created:\n");
			fileName = obj.nextLine();
			System.out.println("\nEnter Number of lines to be written int the file:\n");
			lines = Integer.parseInt(obj.nextLine());
			FileWriter writer = new FileWriter(projectLocation+"\\"+fileName);
			
			for(int i=0; i<lines; i++) {
				System.out.println("\nEnter text to be written into the file:");
				writer.write(obj.nextLine()+System.lineSeparator());
			}
			writer.close();
			System.out.println("File "+fileName+" successfully created");
		}
		catch(Exception e)
		{
			System.out.println("Some Error Occured\n");
		}
		
	}
	
	
	
	public static void deleteFile(Scanner obj) 
	{
		try 
		{
			String fileName;
			System.out.println("Enter File to be deleted:\n");
			fileName = obj.nextLine();
			File handler = new File(projectLocation+"\\"+fileName);
			if(handler.exists())
			{
				if(handler.delete())
				{
					System.out.println("Deleted the"+fileName+" Successfully\n");
				}
				else
				{
					System.out.println("Unable to delete file\n");
				}
			}
			else {
				System.out.println("File doesn't exist\n");
			}
		}
		catch(Exception e) {
			System.out.println("Some Error Occured\n");
		}
	}
	
	
	public static void searchFile(Scanner obj) {
		try 
		{
			String fileName;
			System.out.println("Enter File to be searched:\n");
			fileName = obj.nextLine();
			File handler = new File(projectLocation+"\\"+fileName);
			if(handler.exists())
			{
				System.out.println("File "+fileName+" is available\n");
			}
			else
			{
				System.out.println("File doesn't exist\n");
			}

		}
		catch(Exception e) {
			System.out.println("Some Error occured\n");
		}
	}
}