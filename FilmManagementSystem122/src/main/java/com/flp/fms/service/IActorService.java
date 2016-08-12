package com.flp.fms.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.flp.ems.domain.Actor;
import com.flp.fms.Exceptions.RecordNotFoundException;

public interface IActorService {

	boolean removeActor(Short actor_id) throws RecordNotFoundException;
	Object searchActor(Short actor_id) throws RecordNotFoundException;
	List getAllActor();                                                                                                                                                                                                                                                                                                       
	Actor addActor(String first_name, String last_name);
	String modifyActor(short actor_id,String first_name,String last_name);

	

}
