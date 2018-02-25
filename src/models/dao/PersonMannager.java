package models.dao;

import java.util.ArrayList;

import models.entities.Person;

public class PersonMannager {
	
	private ArrayList<Person> personList;
	
	public PersonMannager() {
		personList = new ArrayList<>();
	}
	
	public void addPerson(Person person){
		personList.add(person);
	}
	
	public int calculateAffinity(Person man, Person woman){
		int result = 0;
		if ((man.isMovie() && woman.isMovie())||(!man.isMovie() && !woman.isMovie())) {
			result +=1 ;
		}
		if ((man.isMusic() && woman.isMusic())||(!man.isMusic() && !woman.isMusic())) {
			result +=1 ;
		}
		if ((man.isWalk() && woman.isWalk())||(!man.isWalk() && !woman.isWalk())) {
			result +=1 ;
		}
		return (result*100)/3;
	}
	public Person searchPerson(int id){
		Person personResult = null;
		for (Person person : personList) {
			if (person.getIdPerson() == id) {
				personResult = person;
			}
		}
		return personResult;
	}
	
	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public int generateId() {
		int id = 0;
		for (Person person : personList) {
			id = person.getIdPerson() +1;
		}
		return id;
	}

	public void createArrayPerson(ArrayList<Person> readFile) {
		for (Person person : readFile) {
			personList.add(person);
		}
	}
	
}
