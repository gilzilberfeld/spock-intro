package spock.intro

// It's public by default
class D04_GroovyHelloWorld {
	
	static main(String[] args) {
		// Implicit imports
		// No parenthesis!
		// No semicolons!
		println "Hello World"
	}
	
	// type inference
	def aSimpleMethod() {

	// This will be very useful soon
	aLabel:	

		def aVariable = 3;
		return aVariable;
	}

}