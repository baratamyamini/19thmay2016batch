package com.flp.fms.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;

import com.flp.ems.domain.Actor;
import com.flp.ems.domain.Category;
import com.flp.ems.domain.Film;
import com.flp.ems.domain.Language;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.dao.FilmDaoImplForList;
import com.flp.fms.dao.IFilmDao;

public class FilmServiceImpl implements IFilmService{

	IFilmDao filmDao;
	
	public FilmServiceImpl() 
	{
	filmDao=new FilmDaoImplForList();

	}
	public FilmServiceImpl(IFilmDao filmDao)
	{
		this.filmDao=filmDao;
	}
	public String addFilm(Map<Integer,Object> filmDetails) {
		Film film=new Film();
				film.setTitle((String) filmDetails.get(1));
				film.setDescription((String) filmDetails.get(2));
				film.setRelease_year((Date) filmDetails.get(3));
				film.setRental_duration((Short) filmDetails.get(4));
				film.setRental_rate((Float) filmDetails.get(5));
				film.setLength((Short) filmDetails.get(6));
				film.setReplacement_cost((Long) filmDetails.get(7));
				film.setRating((Float) filmDetails.get(8));
				film.setSpecial_features((String) filmDetails.get(9));
				
				Language language=new Language();
				language.setName((String) filmDetails.get(10));
				film.setLanguage(language);
				
				Category category=new Category();
				category.setName((String) filmDetails.get(11));
				film.setCategory(category);
					for(int i=12;i<filmDetails.size();i++)
							{
								Actor actor=new Actor();
						Map<Integer,Object>  actorDetails= (Map)filmDetails.get(i);
								actor.setFirst_name((String) actorDetails.get(1));
								actor.setLast_name((String) actorDetails.get(2));
								film.getActors().add(actor);
							}
					return	filmDao.addFilm(film);
			}
	
	public String  modifyFilm(Map<Integer,Object> filmDetails) {
		Film film=filmDao.searchFilm((Short)filmDetails.get(1));
		if(film!=null)
		{
		if(filmDetails.get(2)!=null)
		{	
		film.setTitle((String) filmDetails.get(2));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		
		else if(filmDetails.get(3)!=null)
		{
		film.setDescription((String) filmDetails.get(3));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(4)!=null)
		{
		film.setRelease_year((Date) filmDetails.get(4));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(5)!=null)
		{
		film.setRental_duration((Short) filmDetails.get(5));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(6)!=null)
		{
		film.setRental_rate((Float) filmDetails.get(6));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(7)!=null)
		{
		film.setLength((Short) filmDetails.get(7));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(8)!=null)
		{
		film.setReplacement_cost((Long) filmDetails.get(8));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(9)!=null)
		{
		film.setRating((Float) filmDetails.get(9));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(10)!=null)
		{
		film.setSpecial_features((String) filmDetails.get(10));
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(11)!=null)
		{
		Language language=new Language();
		language.setName((String) filmDetails.get(11));
		film.setLanguage(language);
		filmDao. modifyFilm(film);
		 return "modified";
		}
		else if(filmDetails.get(12)!=null)
		{
		Category category=new Category();
		category.setName((String) filmDetails.get(12));
		film.setCategory(category);
		filmDao. modifyFilm(film);
		 return "modified";
		}
		
		else if(filmDetails.get(13)!=null)
		for(int i=13;i<filmDetails.size();i++)
		{
			Actor actor=new Actor();
			Map actorDetails= (Map) filmDetails.get(i);
			actor.setFirst_name((String) actorDetails.get(1));
			actor.setLast_name((String) actorDetails.get(2));
			film.getActors().add(actor);
			filmDao. modifyFilm(film);
			 return "modified";
		}
		else if (filmDetails.get(1)==null)
		{
			return " not found id";
		}
		
	}
		return null;
		
}
	
	public boolean removeFilm(Short film_id) throws RecordNotFoundException{
            if(film_id==120)
			throw new RecordNotFoundException();
		return filmDao.removeFilm(film_id);
	   
	    }
	

	public Film searchFilm(Short film_id) {
		
		return filmDao.searchFilm(film_id);
	}

	public List<Film> getAllFilm() {
		
		return filmDao.getAllFilm();
	}

}

	

	

	


