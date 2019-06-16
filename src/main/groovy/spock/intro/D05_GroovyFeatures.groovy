package spock.intro

import groovy.json.JsonSlurper

class D05_GroovyFeatures {
	
	def someStrings() {
		def name1 = 'Cap'
		def name2 = 'Tony'
		
		// string interpolation
		def teamStatus= 
			"${name1} and ${name2} are avengers." 
		
		// assert is part of the standard language
		assert teamStatus == 'Cap and Tony are avengers.'
	}
	
	def someJson() {
		def jsonSlurper = new JsonSlurper()
		def cap = jsonSlurper.parseText('{ "name": "Steve Rogers" }') 
		
		// Easy Json navigation
		assert cap instanceof Map
		assert cap.name == 'Steve Rogers'
		
		// Easy parsing
		def appearances = 
				jsonSlurper.parseText('{ "movies": [1,2,3,4] }') 
		assert appearances.movies instanceof List 
		assert appearances.movies == [1,2,3,4]
	}
}