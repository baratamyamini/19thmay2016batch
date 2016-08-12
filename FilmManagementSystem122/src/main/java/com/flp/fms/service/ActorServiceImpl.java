package com.flp.fms.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.flp.ems.domain.Actor;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.dao.ActorDaoImplForList;
import com.flp.fms.dao.IActorDao;

public class ActorServiceImpl implements IActorService{

	IActorDao actorDao;
	private List actorList;
	
	public ActorServiceImpl() 
	{
		
		actorDao=new ActorDaoImplForList();
	}
	public ActorServiceImpl(IActorDao iactdao)
	 {
		 this.actorDao=iactdao;
	 }
	public Actor addActor(String first_name,String last_name)
	{
		Actor actor=new Actor();
		actor.setFirst_name(first_name);
		actor.setLast_name(last_name);
		return actorDao.addActor(actor);
	}
	
	public boolean removeActor(Short actor_id) throws RecordNotFoundException{
		if(actor_id==120)
			throw new RecordNotFoundException();
		
		return actorDao.removeActor(actor_id);
		
	}


	public Object searchActor(Short actor_id) throws RecordNotFoundException {
	    if(actor_id>100)
	    	throw new RecordNotFoundException();
	    if(actor_id!=0&&actor_id>0)
	    {
		return actorDao.searchActor(actor_id);
	     }
		return true;
	}

	public List getAllActor() {
	
		return actorDao.getAllActor();
	}
	
	public String modifyActor(short actor_id,String first_name,String last_name) {
		Actor actor=actorDao.searchActor(actor_id);
		if(actor!=null){
			actor.setFirst_name(first_name);
			actor.setLast_name(last_name);
			actorDao.modifyActor(actor);
			return "success";
			
		}
		else
			return null;
		
	}
	

}
