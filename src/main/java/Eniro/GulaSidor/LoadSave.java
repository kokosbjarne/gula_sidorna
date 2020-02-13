package Eniro.GulaSidor;
import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;

public class LoadSave{

    private String path = "Contacts.json";
    Person person;

    public ContactBook Load()
	{
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