package com.flp.fms.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.flp.ems.domain.Film;
import com.flp.fms.Exceptions.RecordNotFoundException;

public interface IFilmService {
	
	String addFilm(Map<Integer, Object> filmDetails);

	boolean removeFilm(Short film_id) throws RecordNotFoundException;

	Film searchFilm(Short film_id);

	List<Film> getAllFilm();


String modifyFilm(Map<Integer,Object> actorDetails);

	



	
	

}
