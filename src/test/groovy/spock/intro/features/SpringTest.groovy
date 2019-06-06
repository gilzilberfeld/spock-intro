package spock.intro.features

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Ignore
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Ignore
@Title("Avengers Assemble")
@Narrative("This avengers can")
@AutoConfigureMockMvc()
@WebMvcTest()
class SpringTest extends Specification {

    @Autowired
    private MockMvc mockMvc


    def "the mockMvc is loaded"() {
        expect: 
        	"the MockMvc is created"
        mockMvc != null
    }
	
	def "Simple Get works"() {
		expect: 
			"Status is 200 and the response is 'Welcome !'"
        
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn().
			response.contentAsString == "Welcome !"
    }
}


