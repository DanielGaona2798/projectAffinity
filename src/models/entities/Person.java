package models.entities;


public class Person {
	
	private int idPerson;
	private String namePerson;
	private Gender gender;
	private boolean movie;
	private boolean music;
	private boolean walk;
	
	public Person(int idPerson, String namePerson, Gender gender, boolean movie, boolean music, boolean walk) {
		this.idPerson = idPerson;
		this.namePerson = namePerson;
		this.gender = gender;
		this.movie = movie;
		this.music = music;
		this.walk = walk;
	}


	public int getIdPerson() {
		return idPerson;
	}


	public String getNamePerson() {
		return namePerson;
	}


	public Gender getGender() {
		return gender;
	}


	public boolean isMovie() {
		return movie;
	}


	public boolean isMusic() {
		return music;
	}
	
	

	public boolean isWalk() {
		return walk;
	}


	public Object[] toObjectVector(){
		return new Object[]{idPerson, namePerson, gender};
	}


	@Override
	public String toString() {
		return idPerson + "#" + namePerson + "#"+ gender+ "#" + movie + "#" + music + "#" + walk;
	}
	
	
}
