package spock.intro.features


import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Title

@Ignore
@Title("Testing file extension validation method")
class MoreTest extends Specification {
   
	def "get and set fields"() {
		given: "myclass instance"
			def myclass = new MyClass()
		when: "setting a message through private setter"
			myclass.message = 'message'
		then: "set message is correct through private getter"
			assert myclass.message == 'message'
	}

	def "mocking"() {
		given:
			def mockDependency = Mock(ADependency)
			def myclass = new MyClass(mockDependency)
		when:
			def result = myclass.getDependencyValue()
		then:
			1* mockDependency.getValue()
	}

	def "stubbing"() {
		given:
			def stubDependency = Stub(ADependency)
			def myclass = new MyClass(stubDependency)
			stubDependency.getValue() >> "Mocked"
		when:
			def result = myclass.getDependencyValue()
		then:
			result == "Mocked"
	}

	//
//	@Unroll
//	@Ignore
//   def "extensions with multiple values"() {
//       when: "validator checks filename"
//   			def isValid = validate fileToValidate
//       
//	   then: "return appropriate result"
//		   isValid == expectedResult
//       
//	where: "input files are"
//       fileToValidate || expectedResult
//       'some.jpeg'    || true
//       'some.jpg'     || true
//       'some.tiff'    || false
//       'some.bmp'     || true
//       'some.png'     || false
//   }
   
}