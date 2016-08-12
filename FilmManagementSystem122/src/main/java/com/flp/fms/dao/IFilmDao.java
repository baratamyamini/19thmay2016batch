package com.flp.fms.dao;

import java.util.ArrayList;
import java.util.List;

import com.flp.ems.domain.Film;

public interface IFilmDao {

	 String  modifyFilm(Film film);
	boolean removeFilm(Short film_id);
	Film searchFilm(Short film_id);
	List<Film> getAllFilm();
	String addFilm(Film film);
	
	
	

}
