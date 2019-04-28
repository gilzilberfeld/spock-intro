package spock.intro.examples

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title
import org.springframework.test.web.servlet.MockMvc


@Title("Spring Specification")
@Narrative("Controller testing")
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


