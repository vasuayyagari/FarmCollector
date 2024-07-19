package com.farm.collector.integrationTestCase.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.farm.collector.model.HarvestedDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.farm.collector.FarmCollectorApplication;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FarmCollectorApplication.class)
@AutoConfigureMockMvc
public class HarvestedIntegrationTest {

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("All Harvested Info - Success")
	public void test_harvestedDetails() throws Exception {

		//Act
		List<HarvestedDTO> harvestedDTOSReturned = getHarvestedDetails();

		//Assert
		assertTrue(!harvestedDTOSReturned.isEmpty());
		assertEquals(harvestedDTOSReturned.get(0).getHarvestedProduct(), 19.3);
		assertEquals(harvestedDTOSReturned.get(0).getCropName(), "corn");
	}


	@Test
	@DisplayName("All Harvested Info - Fail 405")
	public void harvestedDetails_WithFail_WithWrongHttpMethod() throws Exception {
		mockMvc.perform(post("/harvested/testfarm").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isMethodNotAllowed());
	}


	private List<HarvestedDTO> getHarvestedDetails() throws Exception {

		MvcResult result = mockMvc.perform(get("/harvested/testfarm").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andReturn();

		ArrayList<Object> returnedResult = objectMapper.readValue(result.getResponse().getContentAsString(),
				ArrayList.class);
		return convertResponseIntoJsonList(returnedResult);
	}

	private List<HarvestedDTO> convertResponseIntoJsonList(ArrayList<Object> response)
			throws JsonProcessingException {
		List<HarvestedDTO> items = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		for (Object test : response) {
			String jsonString = new Gson().toJson(test, Map.class);
			items.add(mapper.readValue(jsonString, new TypeReference<HarvestedDTO>() {
			}));
		}
		return items;
	}

}
