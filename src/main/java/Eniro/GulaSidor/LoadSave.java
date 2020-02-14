package Eniro.GulaSidor;
import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;

public class LoadSave{

	//har en path för min Json file
    private String path = "Contacts.json";
    Person person;

    public ContactBook Load()
	{
		//kör en try catch för att Ladda personer
		//använder googles Json API
		//converterar min Json file till en ContactBook som jag har skapat 
        try 
        {
			Gson gson = new Gson();
			return gson.fromJson(new FileReader(path), ContactBook.class);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return new ContactBook();
	}

	//Nästan samma sak som i Load
	//har min ContactBook och sparar det som en Json file
	public void Save(ContactBook contacts)
	{
		Gson gson = new Gson();
		String json = gson.toJson(contacts);

		try {
			FileWriter writer = new FileWriter(path);
			writer.write(json);
			writer.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}