package com.flp.fms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.ems.domain.Film;

public class FilmDaoImplForList implements IFilmDao {
	EntityManagerFactory emf;
	EntityManager em;
	public FilmDaoImplForList(){
	emf=Persistence.createEntityManagerFactory("hello");
	em=emf.createEntityManager();
	}
	public String addFilm(Film film) 
	{
		em.getTransaction().begin();
		em.persist(film);
		em.getTransaction().commit();
		return "success";
	}

	public String modifyFilm(Film film)
	             {
						em.getTransaction().begin();
						em.persist(film);
						em.getTransaction().commit();
				        return "success";
	              } 

	public boolean removeFilm(Short film_id) {
		Film film=searchFilm(film_id);
		if(film!=null)
		{
			em.getTransaction().begin();
			em.remove(film);
			em.getTransaction().commit();
			return true;
		}
		else
		{
		return false;
		}
	
	}

	public Film searchFilm(Short film_id) {
		
		return em.find(Film.class,film_id);
	}

	public List<Film> getAllFilm() {
		
		TypedQuery<Film> query=em.createQuery("Select f from Film f",Film.class);
		return query.getResultList();
	}

	

	

}
