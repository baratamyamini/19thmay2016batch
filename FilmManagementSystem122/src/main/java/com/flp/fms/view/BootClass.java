package com.flp.fms.view;

import java.text.ParseException;
import java.util.Scanner;



import com.flp.fms.Exceptions.RecordNotFoundException;

public class BootClass {
	     static BootClass bc=new BootClass();
	     UserInteraction usi=new UserInteraction();
         static Scanner sc=new Scanner(System.in);
        
public static void main(String[] args) throws ParseException, RecordNotFoundException
    {
	while(true)
	{
		System.out.println("Menu");
		System.out.println("1.AddFilm\n"+"2.ModifyFilm\n"+"3.RemoveFilm\n"+"4.Searchfilm\n"+"5.getAllFilm");
		System.out.println("6.AddActor\n"+"7.ModifyActor\n"+"8.RemoveActor\n"+"9.SearchActor\n"+"10.getAllActor\n"+"11.Exit");
	    System.out.println("Enter Choice");
	    int choice=sc.nextInt();
	    bc.menuSelection(choice);
	}
	
	}
private void menuSelection(int choice) throws ParseException, RecordNotFoundException 
    {
	switch(choice)
	{
	case 1:usi.addFilm();
          break;
    case 2:usi.modifyFilm();
          break;
    case 3:usi.removeFilm();
           break;
    case 4:usi.searchFilm();
           break;
    case 5:usi.getAllFilm();
           break;
    case 6:usi.addActor();
           break;
    case 7:usi.modifyActor();
           break;
    case 8:usi.removeActor();
           break;
    case 9:usi.searchActor();
           break;
    case 10:usi.getAllActor();
           break;
    default:System.out.println("choice enetred is not in the list");
           break;
    case 11:System.exit(0);
            break;
	}
    }
}
