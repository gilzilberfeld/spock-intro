package spock.intro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mcu")
public class MCUController {

	private Team theAvengers;
	
	@PostMapping("/team/create")
	public void createTeam(String name) {
		theAvengers = new Team(name);
	}

	@PostMapping("/avenger/add")
	public void addAvenger(String name) {
		theAvengers.addMember(new Avenger(name));
	}

	@PostMapping("/badguy/arrive")
	public void badGuyArrives(String name) {
		theAvengers.setBadGuy(new BadGuy(name));  
	}
    
    @PostMapping("team/fight")
    public void fight() {
    	theAvengers.fight();
    }
    
    @GetMapping("/result")
    public String saveTheWorld()     {
    	return theAvengers.fightResult();
    }

}
