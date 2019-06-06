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
public class AvengerTests2 {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void CaptainAmericaAndIronMan_SaveTheWorld() {
		try {
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
			mockMvc.perform(
					post("/mcu/team/fight"))
					.andExpect(status().isOk());
			mockMvc.perform(
					get("/mcu/result"))
					.andExpect(status().isOk())
					.andExpect(content().string("Yeah, after five years"));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
