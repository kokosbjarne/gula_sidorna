Projekt Gula Sidorna 
Den här applikationen kan man söka efter telefonnummer till sina vänner. 

Att starta upp det De här instruktionerna kommer ge dig en kopia över vad du behöver för att få applikationen att köra på din lokala maskin för att testa och köra det. Följ anvisningarna här så kan ni köra programmet. 

Förutsättning 
Du behöver en dator av vilket slag som helst. Vill du se allt så behöver du Eclipse eller liknande program för att kunna se kod och vad vi gjort. Vill du bara köra filen så kan du använda vår JAR-fil för att köra. 

Installera / Köra
1. Clona projektet via Github. 
2. Dubbelklicka på JAR-filen. 
3. Eller kör via Main i Eclipse eller liknande. 
4. Sedan så lägger du till kontakter via Add. 
5. Du tar bort kontakter via Remove. 
6. Tryck på Contactbook så går du tillbaka till listan. 
7. Om du vill söka så skriv in namn och sök via Searchknappen, eller telefonnummer.

Köra testerna 
Vi har använt Jenkins för att automatisera våra tester. JUnit har också använts för att testa våra metoder. Bland annat har vi gjort tester för lägga till, sök och ta bort ur kontaktlistan. 

Ett exempel: 
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

Built With 
- IDE Eclipse 
- IDE Visual Studio Code 
- Git - Gitsmart, Git Bash Maven 
- Dependency Management 
- Jenkins 
- Automated tests 

Version Gula Sidorna 1.1 

Authors 
Erik Manfredsson 
Peter Ihm 
Simon Södergren 

Licens Det här projektet är licenserat under GOAT License. 

Erkännande Big up till Logan Logansson! 
