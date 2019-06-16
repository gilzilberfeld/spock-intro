package spock.intro;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AvengersConfiguration.class)
@AutoConfigureMockMvc()
public class D01_AvengerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void CaptainAmericaAndIronMan_SaveTheWorld() {
		createTeam("Avengers");
		addAvenger("Captain America");
		addAvenger("Iron Man");
		badGuyArrives("Thanos");

		fight();

		assertTrue(avengersSavedTheWorld());
	}

	private void createTeam(String teamName) {
		try {
			mockMvc.perform(post("/mcu/team/create")
					.param("name", teamName))
					.andExpect(status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	private void addAvenger(String name) {
		try {
			mockMvc.perform(
					post("/mcu/avenger/add")
					.param("name", name))
					.andExpect(status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	private void badGuyArrives(String name) {
		try {
			mockMvc.perform(
					post("/mcu/badguy/arrive")
					.param("name", name))
					.andExpect(status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	private void fight() {
		try {
			mockMvc.perform(
					post("/mcu/team/fight")).
					andExpect(status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	private boolean avengersSavedTheWorld() {
		try {
			mockMvc.perform(get("/mcu/result"))
				.andExpect(status().isOk())
				.andExpect(content().string("Yeah, after five years"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
