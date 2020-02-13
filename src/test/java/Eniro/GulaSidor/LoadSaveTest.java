package Eniro.GulaSidor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import Eniro.GulaSidor.ContactBook;
import Eniro.GulaSidor.LoadSave;

public class LoadSaveTest {
		
	LoadSave ls;
	ContactBook cb;
	RandomizeContacts rc;
	
	@Before
	public void initiateClasses() {
		cb = new ContactBook();
		ls = new LoadSave();
		rc = new RandomizeContacts();
		System.out.println("yo");
	}
	
    @Test
    public void FindingFile()
    {
        assertEquals(cb.getClass(), ls.Load().getClass()); 
    }
    
    /*
     *  Testar RandomPeople metoden i RandomizeContactsklassen. Testet kollar att ArrayListen people
     *  fylls med kontakter när metoden körs.
     */
    
    @SuppressWarnings("static-access")
	@Test
    public void testRandomizeContacts() {
		rc.RandomPeople(cb.p);
		assertEquals(500, cb.p.size());

    }
}