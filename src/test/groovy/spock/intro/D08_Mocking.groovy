package spock.intro
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class D08_Mocking extends Specification {

	private Hammer mockHammer;
	
	def setup() {
		mockHammer = Mock()
	}

	def "Cap can use Thor's hammer"() {
		setup:
			mockHammer.canLift() >> true
		when:
			def cap = new Avenger("Cap")
		then:
			assert cap.canLift(mockHammer);
	}
	
	def "Tony can't use Thor's hammer"() {
		setup:
			mockHammer.canLift() >> {return false}
		when:
			def tony = new Avenger("Iron Man")
		then:
			!tony.canLift(mockHammer)
			0 * mockHammer.lift() 
	}
	
	
}