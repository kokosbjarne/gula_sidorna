package Eniro.GulaSidor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class ContactBookTest  {
	
	private Person person;
	private ContactBook contactBook;
	/**
	 * Här testar vi om vi kan lägga till personer 
	 * och ta bort personer, vi börjar med att alltid 
	 * lägga till en person oavsett. 
	 */
	
	@Before 
	public void addPerson() {
	Person person = new Person(); 
	person.fname = "Simon"; 
	person.lname="Södergren";
	person.number = "0721641288"; 
	contactBook = new ContactBook();

	}
	
	/**
	 * 	Testar att lägga till en person i kontaktboken
	 */
	
	@Test
	public void testAddToContactBook() {
	contactBook.p.add(person); 
	assertEquals(person, contactBook.p.get(0)); 
		
	}
	
	/**
	 * 	Här testar vi om två personer inte är samma 
	 * person i kontaktboken.
	 */
	
	@Test 
	public void testNotEqualPersonsInContactBook() {
		Person p2 = new Person(); 
		p2.fname = "Peter"; 
		p2.lname="Ihm";
		p2.number = "0721585813"; 
		contactBook.p.add(person); 
		assertNotEquals(person, p2);
	}
	
	/**
	 * 	Här testas det om personen vi söker 
	 * är samma person i listan. 
	 */
	
	@Test 
	public void testTwoEqualPersonsInContactBook() {
		Person p3 = new Person(); 
		p3.fname="Simon"; 
		p3.lname="Södergren"; 
		p3.number="0721641288"; 
		contactBook.p.add(p3); 
		assertEquals(p3, contactBook.p.get(0)); 
	}
	
	/**
	 * Om vi vill ta bort personer kan det 
	 * vara bra att ha test för det också. 
	 * Så nedanför utför vi det testet. 
	 */
	
	@Test 
	public void RemovePerson() {
	Person p2 = new Person(); 
	p2.fname = "Erik"; 
	p2.lname="Manfredsson";
	p2.number = "07521285959"; 
	contactBook = new ContactBook();
	contactBook.p.remove(p2); 
	assertNotEquals(0, contactBook.p.size()-1); 
		
	}
	

}
	

