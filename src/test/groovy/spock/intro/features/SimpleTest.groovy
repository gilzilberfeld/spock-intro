package spock.intro.features

import spock.lang.Specification 

class SimpleTest extends Specification {

	def "simple comp"() {
		expect:
			1 == 1
	}
	
    def "datarow test max(#a,#b) == #c"() {
        expect:
        // This class is in our Java code
        MyClass.max(a, b) == c

        where:
        a  | b   | c
        1  | 2   | 2
        42 | -12 | 42
        42 | -12 | 42
    }
	
	def "gwt example"() {
		given:
        	def list1 = [1, 2, 3, 4]
 
		when:
			list1.remove(0)
 
		then:
        	list1 == [2, 3, 4]
	}
	
	
}