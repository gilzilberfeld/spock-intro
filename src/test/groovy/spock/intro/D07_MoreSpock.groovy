package spock.intro
import spock.lang.Specification

class D07_MoreSpock extends Specification {

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
	
	
	
}