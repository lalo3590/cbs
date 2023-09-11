package com.hsbc.eep.cbs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DemoControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void getDemo() throws Exception{
		RequestBuilder rb= MockMvcRequestBuilders.get("/hola").accept(MediaType.APPLICATION_JSON);
		
		
		
		mvc.perform(rb)
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hola crayola")));
	}
	
	@Test
	public void getHello() throws Exception{
		ResponseEntity<String> response=template.getForEntity("/hola",String.class);
		
		assertThat(response.getBody().equals("Hola crayola"));
	}

}
