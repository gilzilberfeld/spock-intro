package spock.intro;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private List<Avenger> avengers;
	private String name;
	private BadGuy badGuy;
	
	public Team(String name) {
		this.name = name;
		avengers = new ArrayList();
	}

	public void fight() {
	}


	public String fightResult() {
		return "Yeah, after five years";
	}

	public void addMember(Avenger avenger) {
		avengers.add(avenger);
	}

	public void addMember(String name) {
		avengers.add(new Avenger(name));
	}

	public void setBadGuy(BadGuy badGuy) {
		this.badGuy = badGuy;
	}
	
	public boolean includes(String name) {
		return this.avengers.contains(new Avenger(name));
	}

}
