package com.flp.fms.dao;

import java.util.List;

import com.flp.ems.domain.Actor;


public interface IActorDao {
	
	
	boolean removeActor(Short actor_id);
	Actor searchActor(Short actor_id);
	List<Actor> getAllActor();
	  Actor addActor(Actor actor);
		
	Actor modifyActor(Actor actor);
		
	}
	
	


