package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import models.entities.Gender;
import models.entities.Person;


public class TextFileManager {

	public TextFileManager() {
	}
	public ArrayList<Person> readFile(String path) throws IOException{
		List<String> line = Files.readAllLines(Paths.get(path));
		ArrayList<Person> personList = new ArrayList<>();
		for (String string : line) {
			String c[] = string.split("#");
			personList.add(new Person(Integer.parseInt(c[0]), c[1], getGender(c[2]), Boolean.parseBoolean(c[3]), Boolean.parseBoolean(c[4]),Boolean.parseBoolean(c[5])));
		}
		return personList;
	}
	private Gender getGender(String gender){
		Gender genderFind = null;
		switch (gender) {
		case "MALE":
			genderFind = Gender.MALE;
			break;
		case "FEMALE":
			genderFind = Gender.FEMALE;
			break;
		}
		return genderFind;
	}
	
	public void writeFile(ArrayList<Person> list, String path) {
		ArrayList<String> listAux = new ArrayList<>();
		for (Person person : list) {
			listAux.add(person.toString());
		}
		try {
			Files.delete(Paths.get(path));
			Files.write(Paths.get(path), listAux, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}