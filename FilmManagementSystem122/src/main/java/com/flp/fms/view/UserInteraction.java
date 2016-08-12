package com.flp.fms.view;


import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.flp.ems.domain.Actor;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;

public class UserInteraction {
	Scanner sc=new Scanner(System.in);
	IFilmService filmService;
	IActorService actorService;
	public UserInteraction()
	{
		filmService=new FilmServiceImpl();
		actorService=new ActorServiceImpl();
	}

	public void addFilm() throws ParseException
	    {
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		Map<Integer,Object> filmDetails=new HashMap();
		System.out.println("Enetr Title:");
		filmDetails.put(1,sc.next());
		System.out.println("enter description:");
		filmDetails.put(2,sc.next());
		System.out.println("enter release_year");
		filmDetails.put(3,dateFormat.parse(sc.next()));
		System.out.println("enter rental_duration:");
		filmDetails.put(4,sc.nextShort());
		System.out.println("enter rental_rate:");
		filmDetails.put(5,sc.nextFloat());
		System.out.println("enter length:");
		filmDetails.put(6,sc.nextShort());
		System.out.println("enter replacement_cost:");
		filmDetails.put(7,sc.nextLong());
		System.out.println("enter rating");
		filmDetails.put(8,sc.nextFloat());
		//System.out.println("enter last_update:");
		//filmDetails.add(dateFormat.parse(sc.next()));
		System.out.println("enter special_features:");
		filmDetails.put(9,sc.next());

		System.out.println("Enetr the language Name");
		filmDetails.put(10,sc.next());

		System.out.println("Enetr the category Name");
		filmDetails.put(11,sc.next());
		
		System.out.println("Enetr the Number of actors");
int j=12;
					int noofactors=sc.nextInt();
					for(int i=1;i<=noofactors;i++){
					Map<Integer,Object> actorDetails=new HashMap();
					System.out.println("Enter the actor first name");
					actorDetails.put(1,sc.next());
					System.out.println("Enter the actor last name");
					actorDetails.put(2,sc.next());
					filmDetails.put(j,actorDetails);
					  j++;
					}
		    System.out.println(filmService.addFilm(filmDetails));
		    
	     }
	    

	public void  modifyFilm() throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		Map<Integer,Object> filmDetails=new HashMap();
		System.out.println("enter film_id to modify");
		filmDetails.put(1, sc.nextShort());
		System.out.println("Enter Choie for modifying film details");
	    int choice=sc.nextInt();
	    switch(choice)
	    {
	    case 1:System.out.println("Enter Title:");
		filmDetails.put(2,sc.next());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 2:System.out.println("enter description:");
		filmDetails.put(3,sc.next());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 3:System.out.println("enter release_year");
		filmDetails.put(4,dateFormat.parse(sc.next()));
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 4:System.out.println("enter rental_duration:");
		filmDetails.put(5,sc.nextShort());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 5:System.out.println("enter rental_rate:");
		filmDetails.put(6,sc.nextFloat());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 6:System.out.println("enter length:");
		filmDetails.put(7,sc.nextShort());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 7:System.out.println("enter replacement_cost:");
		filmDetails.put(8,sc.nextLong());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 8:System.out.println("enter rating");
		filmDetails.put(9,sc.nextFloat());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
		//System.out.println("enter last_update:");
		//filmDetails.add(dateFormat.parse(sc.next()));
	    case 9:System.out.println("enter special_features:");
		filmDetails.put(10,sc.next());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 10:
		System.out.println("Enetr the language Name");
		filmDetails.put(11,sc.next());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    case 11:
		System.out.println("Enetr the category Name");
		filmDetails.put(12,sc.next());
		System.out.println(filmService.modifyFilm(filmDetails));
		break;
	    
	    case 12:System.out.println("Enter the Number of actors");
		int j=13;
			int noofactors=sc.nextInt();
			for(int i=1;i<=noofactors;i++){
			Map<Integer,Object> actorDetails=new HashMap();
			System.out.println("Enter the actor first name");
			actorDetails.put(1,sc.next());
			System.out.println("Enter the actor last name");
			actorDetails.put(2,sc.next());
			filmDetails.put(j,actorDetails);
			  j++;
		   }
			break;
			default:System.out.println("invalid selection");
			break;
	       }
	}	
	public void removeFilm() throws RecordNotFoundException {
	System.out.println("enter film id to remove");
	Short film_id=sc.nextShort();
	if(filmService.removeFilm(film_id))
	{
		System.out.println("film removed successfully");
		
	}
	else
	{
		System.out.println("film id entered is not found");
	}
	
	}
	
	public void searchFilm()
	    {
		System.out.println("enter film id to search");
		Short film_id=sc.nextShort();
		if((filmService.searchFilm(film_id))!=null)
		{
			System.out.println("film is found");
		}
		else
		{
			System.out.println("film id entered is not found");
		}
	    }
	
	public void getAllFilm()
	  {
		System.out.println("all film details are:"+filmService.getAllFilm());
	  }

	public Actor addActor() 
	 {
    System.out.println("enter actor first name:");
     String first_name=sc.next();
     System.out.println("enter actor last name:");
     String last_name=sc.next();
     System.out.println("actor details entered successfully");
     return actorService.addActor(first_name,last_name);
	}

	public void modifyActor() 
	    {
		//Map<Integer,Object> actorDetails=new HashMap();
		System.out.println("enter id to modify");
		Short actor_id=sc.nextShort();
		System.out.println("enter first name of actor");
		String first_name=sc.next();
		System.out.println("enter last name of actor");
		String last_name=sc.next();
		actorService.modifyActor(actor_id,first_name,last_name);
	    }

	public void removeActor() throws RecordNotFoundException {
		System.out.println("enter the actor_id to remove");
		Short actor_id=sc.nextShort();
		if(actorService.removeActor(actor_id))
		{
			System.out.println("actor removed");
		}
		else
		{
			System.out.println("actor_id not found");
		}
	}

	public void searchActor() throws RecordNotFoundException
	{
		System.out.println("enter actor id to search");
		Short actor_id=sc.nextShort();
		if((actorService.searchActor(actor_id))!=null)
		{
			System.out.println("actor is found");
		}
		else
		{
			System.out.println("actor id entered is not found");
		}
	    }

	public void getAllActor() 
	{
		List<Actor> actors= actorService.getAllActor();
		System.out.println("all actor details are:"+actors);
		
	}

}
