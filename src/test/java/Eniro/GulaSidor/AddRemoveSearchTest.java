package Eniro.GulaSidor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AddRemoveSearchTest {

	
	private Person person; 
	private ContactBook contactBook;
	private AddRemoveSearch ars; 
	
	/**
	 * Här testar vi om vi hittar en person eller inte
	 * första testet är finns personen? 
	 */
	
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
//		System.out.println(ars1.foundpeople.get(0).number);
		for (int i = 0; i < ars1.foundpeople.size(); i++) {				
				if(ars1.foundpeople.get(i).fname == p2.fname &&
					ars1.foundpeople.get(i).lname == p2.lname && 
					ars1.foundpeople.get(i).number == p2.number )
						assertTrue(true);
		}
	}
	
	/**
	 * Nedanför testar vi om vi söker på en person som inte finns
	 * returnerar grönt om personen vi söker inte finns. 
	 */
	
	@Test
	public void testFindPersonThatDoesntExist() throws IndexOutOfBoundsException {
	LoadSave ls = new LoadSave(); 
	contactBook = ls.Load();
	Person p3 = new Person(); 
	p3.fname="Simon";
	p3.lname="Södergren"; 
	p3.number="0721641288"; 
	AddRemoveSearch ars2 = new AddRemoveSearch(contactBook); 
	ars2.foundpeople.add(p3); 
	ars2.Search("Johannes Göranzon", "0725858585");
	for (int i = 0; i < ars2.foundpeople.size(); i++) {
		if(ars2.foundpeople.get(i).fname == p3.fname &&
			ars2.foundpeople.get(i).lname == p3.lname &&
			ars2.foundpeople.get(i).number == p3.number)
			assertTrue(false);
	}
}
	
}

