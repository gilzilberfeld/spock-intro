package spock.intro

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title("Avengers Assemble")
@Narrative("This avengers can sometimes be called to save the world")
@AutoConfigureMockMvc()
@ContextConfiguration(classes = AvengersConfiguration.class)
@WebMvcTest()
class D08_SpockAPITest extends Specification {

	@Autowired
	private MockMvc mockMvc

	def "Cap and Iron Man Beat Thanos"() {
		given:
			mockMvc.perform(
					post("/mcu/team/create")
					.param("name", "Avengers"))
					.andExpect(status().isOk());
			mockMvc.perform(
					post("/mcu/avenger/add")
					.param("name", "Captain America"))
					.andExpect(status().isOk());
			mockMvc.perform(
					post("/mcu/avenger/add")
					.param("name", "Iron Man"))
					.andExpect(status().isOk());
			mockMvc.perform(
					post("/mcu/badguy/arrive")
					.param("name", "Thanos"))
					.andExpect(status().isOk());

		when:
			mockMvc.perform(
					post("/mcu/team/fight"))
					.andExpect(status().isOk());


		then:
			mockMvc.perform(
					get("/mcu/result"))
					.andExpect(status().isOk())
					.andExpect(content().string("Yeah, after five years"));
	}
}