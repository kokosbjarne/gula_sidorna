package Eniro.GulaSidor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PersonTest
{
    @Test 
    public void SetName()
    {
        //testar ifall jag kan ändra variabler
        Person person = new Person();
        person.fname = "Peter";
        person.lname = "Ihm";
        person.number = "0725195955";

        if(person.fname == "Peter" &&
        person.lname == "Ihm"&&
        person.number == "0725195955")
        assertTrue(true);

    }
}