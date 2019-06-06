package spock.intro.cucumber;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import spock.intro.AvengersConfiguration;

@SpringBootTest
@ContextConfiguration(classes = AvengersConfiguration.class)
@AutoConfigureMockMvc()
public class D03_StepDefinitions {

	@Autowired
	private MockMvc mockMvc;

	@Given("The {string} can be assembled")
	public void the_Avengers_can_be_assembled(String teamName) {
		try {
			mockMvc.perform(post("/mcu/team/create")
					.param("name", teamName))
					.andExpect(status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Given("{string} joins")
	public void joiningTeam(String name) {
		try {
			mockMvc.perform(post("/mcu/avenger/add").param("name", name)).andExpect(status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@When("They fight {string}")
	public void theyFight(String name) {
		try {
			mockMvc.perform(post("/mcu/badguy/arrive").param("name", name)).andExpect(status().isOk());
			mockMvc.perform(post("/mcu/team/fight")).andExpect(status().isOk());

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Then("It takes five years to beat him but they do")
	public void theyBeatHimAfterFiveYears() {
		try {
			mockMvc.perform(get("/mcu/result")).andExpect(status().isOk())
					.andExpect(content().string("Yeah, after five years"));
		} catch (Exception e) {
			fail();
		}
	}


}

