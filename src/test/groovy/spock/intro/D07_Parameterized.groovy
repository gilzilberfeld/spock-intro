package spock.intro
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class D07_ParameterizedTest extends Specification {

    def "Is #name part of the Avengers? #result"() {
    	given:
			def avengers = new Team()
			avengers.addMember('Tony')
			avengers.addMember('Cap')
			
		expect:
			avengers.includes(name) == result	

        where:
	        name  	| result
	        'Tony'  | true   
	        'Cap'	| true
			'Thanos'| false
    }
	
}