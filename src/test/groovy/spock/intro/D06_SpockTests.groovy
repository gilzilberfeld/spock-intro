package spock.intro
import spock.lang.Specification

class D06_SpockTests extends Specification {

	// Use string names for display
	def "Simple Comparison"() {
		// Assertion replacement
		expect:
			'Tony' != 'Cap'
	}
	
	// Parameterized test
    def "is #name part of the Avengers? #result"() {
    	given:
			def avengers = new Team()
			avengers.addMember('Tony')
			avengers.addMember('Cap')
			
		expect:
			avengers.includes(name) == result	

        where:
        name  | result
        'Tony'  | true   
        'Cap'	| true
		'Thanos'| false
    }
	
	def "given-when-then example"() {
    	given:
			def avengers = new Team()
			def avenger1 = new Avenger('Tony')
			def avenger2 = new Avenger('Cap')
			def badGuy = new BadGuy('Thanos')
			avengers.addMember(avenger1)
			avengers.addMember(avenger2)
			avengers.setBadGuy(badGuy)
 
		when:
			avengers.fight()
 
		then:
        	avengers.fightResult() == 'Yeah, after five years'
	}
	
	
}