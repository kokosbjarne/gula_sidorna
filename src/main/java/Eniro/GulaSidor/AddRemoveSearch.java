package Eniro.GulaSidor;

import java.util.ArrayList;

public class AddRemoveSearch {

        ContactBook cb = new ContactBook(); 
        public ArrayList<Person> foundpeople = new ArrayList<Person>(); 

        AddRemoveSearch(ContactBook book)
        {
            cb = book;
        }

        /**
         * Lägger till en ny person i listan
        */

        public void Add(String a, String b) {
            String[] tempname = {"", ""};        int tempcounter = 0;
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) == ' ')
                    tempcounter ++;
                else
                    tempname[tempcounter] += a.charAt(i); 
            } 
            Person person = new Person();
            person.fname = tempname[0];
            person.lname = tempname[1];
            person.number = b;
            cb.p.add(person); 
            System.out.println(cb.p.get(cb.p.size()-1).fname + " " + cb.p.get(cb.p.size()-1).lname + " lades till");
            LoadSave ls = new LoadSave(); 
            ls.Save(cb);
        }    
    /**
     * Går igenom ArrayList och om det matchar namn eller nummer så raderas den 
     */ 
    public void Remove(String a, String b) {
        String[] tempname = {"", ""};
        int tempcounter = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == ' ')
                tempcounter ++;
            else
                tempname[tempcounter] += a.charAt(i); 
        }
        Person person = new Person();
        person.fname = tempname[0];
        person.lname = tempname[1];
        person.number = b;
        String tempPerson = person.fname + " " + person.lname + " " + person.number;

        for (int i = 0; i < cb.p.size(); i++) {

            String inputPerson = cb.p.get(i).fname + " " + cb.p.get(i).lname + " " + cb.p.get(i).number;
            
            if(inputPerson.matches(tempPerson))
            {
                cb.p.remove(i);
                System.out.println("Removed: " + tempPerson);
                
            }
        }
    }
    /**
     *Vid sökning så öppnas en tom ArrayList som fylls på med namn/nummer som matchar sökningen
     */
    public void Search (String a, String b) 
    {    	
        foundpeople = new ArrayList<Person>();
        for (int i = 0; i < cb.p.size(); i++) 
        {            
            if(a.length() > 0)
                if(cb.p.get(i).fname.matches(".*" + a + ".*"))                    
                    foundpeople.add(cb.p.get(i));
                
            if(a.length() > 0)
                if(cb.p.get(i).lname.matches(".*" + a + ".*"))                    
                    foundpeople.add(cb.p.get(i));

            if(b.length() > 0)
                if(cb.p.get(i).number.matches(".*" + b + ".*"))                    
                    foundpeople.add(cb.p.get(i));
                    
            
            String temp = a + " " + b;
            String temp2 = cb.p.get(i).fname + " " + cb.p.get(i).lname + " " + cb.p.get(i).number;
            
            if(a != null)
            if(temp2.matches(".*" + temp + ".*"))
            {
                foundpeople.add(cb.p.get(i));
            }

            for (int j = 0; j < foundpeople.size(); j++) {
                if(j > 0)
                {
                    if(foundpeople.get(j) == foundpeople.get(j - 1))
                    foundpeople.remove(j);
                }
            }
            
        }
    }
}