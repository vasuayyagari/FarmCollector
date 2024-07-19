package com.farm.collector.integrationTestCase.controller;

import com.farm.collector.FarmCollectorApplication;
import com.farm.collector.entity.Planted;
import com.farm.collector.model.HarvestedDTO;
import com.farm.collector.model.PlantedDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FarmCollectorApplication.class)
@AutoConfigureMockMvc
public class PlantedIntegrationTest {

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("All Planted Info - Success")
	public void test_planedDetails() throws Exception {

		//Act
		List<PlantedDTO> plantedDTOS = getPlantedDetails();

		//Assert
		assertTrue(!plantedDTOS.isEmpty());
		assertEquals(plantedDTOS.get(0).getExpectedProduct(), 69.3);
		assertEquals(plantedDTOS.get(0).getCropName(), "corn");
	}


	@Test
	@DisplayName("All Planted Info - Fail 405")
	public void harvestedDetails_WithFail_WithWrongHttpMethod() throws Exception {
		mockMvc.perform(post("/planted/testfarm").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isMethodNotAllowed());
	}


	private List<PlantedDTO> getPlantedDetails() throws Exception {

		MvcResult result = mockMvc.perform(get("/planted/testfarm").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andReturn();

		ArrayList<Object> returnedResult = objectMapper.readValue(result.getResponse().getContentAsString(),
				ArrayList.class);
		return convertResponseIntoJsonList(returnedResult);
	}

	private List<PlantedDTO> convertResponseIntoJsonList(ArrayList<Object> response)
			throws JsonProcessingException {
		List<PlantedDTO> items = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		for (Object test : response) {
			String jsonString = new Gson().toJson(test, Map.class);
			items.add(mapper.readValue(jsonString, new TypeReference<PlantedDTO>() {
			}));
		}
		return items;
	}

}
