package com.flp.fms.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.flp.ems.domain.Actor;
import com.flp.fms.Exceptions.FieldEmptyException;
import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.IActorService;

public class ActorTestCases {
@Mock
IActorDao iactdao;
IActorService iactser;

@Before
public void init(){
	MockitoAnnotations.initMocks(this);
	iactser=new ActorServiceImpl(iactdao);
}
//addACtor must return valid for valid inputs
@Test
public void addActorMustReturnValidForValidInput() throws FieldEmptyException
{
	Actor actor=new Actor();
	actor.setFirst_name("Yamini");
	actor.setLast_name("Baratam");
	Mockito.when(iactdao.addActor(actor)).thenReturn(actor);
	assertEquals(actor,iactser.addActor("Yamini","Baratam"));
}
//createActor must return null when any input is null
public void addActorMustReturnNullForNullInputs() throws FieldEmptyException, NegativeFieldException
{
	Actor actor=new Actor();
	String first_name=null;
	String last_name=null;
	iactser.addActor(first_name,last_name);

}
//removeActor must return valid for valid inputs
public void removeActorMustReturnValidForValidInputs() throws FieldEmptyException,NegativeFieldException,RecordNotFoundException {
	Mockito.when(iactdao.removeActor((short) 1)).thenReturn(true);
	assertEquals(true,iactser.removeActor((short) 1));
}
//removeActor must return null for null inputs
public void removeActorMustReturnNullForIdZero() throws FieldEmptyException,NegativeFieldException,RecordNotFoundException {
	Mockito.when(iactdao.removeActor((short) 0)).thenReturn(true);
	assertEquals(false,iactser.removeActor((short) 0));
}
//removeActor must return exception when record is not found
public void removeActorMustReturnExceptionWhenRecordIsNotFound() throws RecordNotFoundException {
	Mockito.when(iactdao.removeActor((short) 100)).thenReturn(true);
	assertEquals(false,iactser.removeActor((short) 100));
}
//removeActor must return exception if input is negative
public void removeActorMustReturnExceptionForNegativeNumber() throws FieldEmptyException,NegativeFieldException,RecordNotFoundException {
	iactser.removeActor((short) -10);
}
//searchActor must return exception for null inputs
public void whenTheidIsZeroInSearchActorThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
{
	iactser.searchActor((short) 0);
}
// searchActor must return exception for negative input
public void whenIdIsNegativeExceptionMustBeThrown() throws NegativeFieldException, RecordNotFoundException {
	iactser.searchActor((short)-10);
}
//searchActor must return exception when record does not found
public void whenIdDoesNotFoundExceptionMustBeThrown() throws RecordNotFoundException {
iactser.searchActor((short)100);
}
//searchActor must return valid for valid inputs
public void searchActorMustReturnValidForvalidInputs() throws FieldEmptyException,NegativeFieldException,RecordNotFoundException {
	iactser.searchActor((short)1);
}

}
