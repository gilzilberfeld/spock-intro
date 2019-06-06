package spock.intro;

import java.util.ArrayList;
import java.util.List;

public class Avenger {

	private String name;
	
	public Avenger(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override 
	public boolean equals(Object other) {
		Avenger otherAvenger = (Avenger) other;
		return this.name == otherAvenger.name;
	}
	
	public boolean canHandleItem(Hammer hammer) {
		boolean canLift = hammer.canLift();
		if (canLift)
			hammer.lift();
		return canLift;
	}

}
