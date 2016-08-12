package com.flp.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.ems.domain.Actor;

public class ActorDaoImplForList implements IActorDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
	EntityManager em=emf.createEntityManager();
	private String first_name;
	
	public Actor addActor(Actor actor)
	{
			em.getTransaction().begin();
			em.persist(actor);
			em.getTransaction().commit();
			return actor;
		
	}
	
	public Actor modifyActor(Actor actor) {
		
				em.getTransaction().begin();
				em.persist(actor);
				em.getTransaction().commit();
		        return actor;
	}

	public boolean removeActor(Short actor_id) {
		Actor actor=searchActor(actor_id);
		if(actor!=null)
		{
			em.getTransaction().begin();
			em.remove(actor);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public Actor searchActor(Short actor_id) {
		
		return em.find(Actor.class, actor_id);
	}

	public List<Actor> getAllActor() {
		TypedQuery<Actor> query=em.createQuery("Select a from Actor a",Actor.class);
		return query.getResultList();
	}

	

}
