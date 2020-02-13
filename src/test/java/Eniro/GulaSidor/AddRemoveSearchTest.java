package Eniro.GulaSidor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.runner.Version;
import org.junit.jupiter.api.Test;

import Eniro.GulaSidor.AddRemoveSearch;
import Eniro.GulaSidor.ContactBook;
import Eniro.GulaSidor.LoadSave;
import Eniro.GulaSidor.Person;

public class AddRemoveSearchTest {

	
	private Person person; 
	private ContactBook contactBook;
	private AddRemoveSearch ars; 
	
	
	@Test 
	public void testFindPerson() throws IndexOutOfBoundsException {
//		System.out.println(Version.id());
		LoadSave ls = new LoadSave();
		contactBook = ls.Load();
		Person p2 = new Person(); 
		p2.fname="Simon";
		p2.lname="Södergren";
		p2.number="0721641288"; 
		AddRemoveSearch ars1 = new AddRemoveSearch(contactBook);
		ars1.Search("Simon Södergren", "0721641288");
		System.out.println(ars1.foundpeople.get(0).number);
		//assertEquals(ars1.foundpeople.get(0), p2);
		for (int i = 0; i < ars1.foundpeople.size(); i++) {				
				if(ars1.foundpeople.get(i).fname == p2.fname &&
					ars1.foundpeople.get(i).lname == p2.lname && 
					ars1.foundpeople.get(i).number == p2.number )
						assertTrue(true);
		}
	}
	
//	@Test
//	public void testFindPersonThatDoesntExist() throws IndexOutOfBoundsException {
//	Person p3 = new Person(); 
//	p3.name="Simon Södergren"; 
//	p3.number="0721641288"; 
//	AddRemoveSearch ars2 = new AddRemoveSearch(); 
//	ars2.foundpeople.add(p3); 
//	ars2.Search("Johannes Göranzon", "0725858585");
//	assertNotSame(ars2.foundpeople.get(0), p3); 
//	}
	
}

