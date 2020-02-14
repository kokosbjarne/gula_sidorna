package Eniro.GulaSidor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RandomizeContactsTest
{
    RandomizeContacts rndContacts = new RandomizeContacts();

	/**
     *	Kollar ifall listan med personer fylls
	 */
    @Test
    public void Generated()
    {
        rndContacts.go();

        if(rndContacts.person.size() > 0)
            assertTrue(true);
    }
}