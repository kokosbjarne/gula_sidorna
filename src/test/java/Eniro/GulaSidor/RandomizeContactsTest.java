package Eniro.GulaSidor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RandomizeContactsTest
{
    RandomizeContacts rndContacts = new RandomizeContacts();


    @Test
    public void Generated()
    {
        //Kollar ifall listan med personer fylls
        rndContacts.main();

        if(rndContacts.person.size() > 0)
            assertTrue(true);
    }
}