package com.flp.fms.TestCases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.flp.ems.domain.Film;
import com.flp.fms.Exceptions.FieldEmptyException;
import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;

public class FilmTestCases {
	@Mock
	IFilmDao ifilmdao;
	IFilmService ifilmser;
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		ifilmser=new FilmServiceImpl(ifilmdao);
	}
	@Test
	public void removeFilmWillReturnValidWithValidInputs() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
		
		Mockito.when(ifilmdao.removeFilm((short)1)).thenReturn(true);
		
		assertEquals(true,ifilmser.removeFilm((short) 1));
	}
	//removeFilm must return null with null inputs
			@Test
			public void removeFilmWillReturnNullWithIdZero() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
				Mockito.when(ifilmdao.removeFilm((short)0)).thenReturn(true);
				assertEquals(true,ifilmser.removeFilm((short) 0));
			}
			

			//removeFilm must return null when record is not present
			
					@Test
					public void removeFilmWillReturnNullWithNoRecord() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
						Film film=new Film();
						Mockito.when(ifilmdao.searchFilm((short)120)).thenReturn(null);
						assertEquals(false,ifilmser.removeFilm((short)120));
					}
			
					//removeFilm must return null with invalid inputs

					@Test
					public void whenTheidIsZeroInRemoveFilmThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
					{
				              ifilmser.removeFilm((short)-10);
					}
			
}
