
package Eniro.GulaSidor;

import java.util.ArrayList;
import java.util.Random;

/** 
 * Skriver en Randomize för att få fram olika kontakter
*/
public class RandomizeContacts {

	/**
	 * 	3 listor av Strängar förnamn, efternamn, nummer
	 * 	1 lista för att sedan spara personer
	 */
	
	ArrayList<String> fnamn = new ArrayList<String>();
	ArrayList<String> enamn = new ArrayList<String>();
	ArrayList<String> number = new ArrayList<String>();
	ArrayList<Person> person = new ArrayList<Person>();

	/**
	* kallar på min RandomPeople function för att slumpa fram personer
	* jag skapar en ny contactbook för att spara det sedan till Json
	* sen använder jag LoadSave scriptet för att spara personerna till min Json
	*/

	public void main() {
		RandomPeople(person);
		LoadSave ls = new LoadSave();
		ContactBook book = new ContactBook();
		book.p = person;
		ls.Save(book);
	}

	/** 
	* kör en fori loop som statar på 721456 <- bara för att nummrerna ska inte bara vara 072000001 osv.
	* lägger till förnamn i fnamn.
	* genererar efternamn baserad på förnamnet (lägger bara till sson)
	* sen genererar jag bara nya personer baserat på för/efter namn och nummer
	*/

	public void RandomPeople(ArrayList<Person> p) {
		for (int i = 721456; i < 1000000; i++) {

			number.add("072" + String.valueOf(i));
		}

		fnamn.add("Liam");
		fnamn.add("Emma");
		fnamn.add("Noah");
		fnamn.add("Olivia");
		fnamn.add("William");
		fnamn.add("Ava");
		fnamn.add("James");
		fnamn.add("Isabella");
		fnamn.add("Oliver");
		fnamn.add("Sophia");
		fnamn.add("Benjamin");
		fnamn.add("Charlotte");
		fnamn.add("Elijah");
		fnamn.add("Mia");
		fnamn.add("Lucas");
		fnamn.add("Amelia");
		fnamn.add("Mason");
		fnamn.add("Harper");
		fnamn.add("Logan");
		fnamn.add("Evelyn");

		for (int i = 0; i < fnamn.size(); i++) {
			enamn.add(fnamn.get(i) + "sson");
		}

		for (int i = 0; i < 500; i++) {

			Random rnd1 = new Random();
			Random rnd2 = new Random();

			Person person = new Person();
			person.fname = new String(fnamn.get(rnd1.nextInt(fnamn.size())));
			person.lname = new String(enamn.get(rnd2.nextInt(enamn.size())));
			person.number = number.get(i);
			p.add(person);
		}
	}
}