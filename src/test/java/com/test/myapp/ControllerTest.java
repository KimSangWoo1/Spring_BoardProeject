package com.test.myapp;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);
	
	@Inject
	private WebApplicationContext webApplicationContext;

	private MockMvc mocMvc;
	
	@Before
	public void setUp() {
		this.mocMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		logger.info("setUp...");
	}
	
	@Test
	public void testDoA() throws Exception{
		mocMvc.perform(MockMvcRequestBuilders.get("/doA"))
		  .andDo(print())
		  .andExpect(status().isOk());
	}
	
	
	@Test
	public void testDoB() throws Exception{
		mocMvc.perform(MockMvcRequestBuilders.get("/doB"))
			  .andDo(print())
			  .andExpect(status().isOk());
	}
	
	
	@Test
	public void testDoC() throws Exception{
		mocMvc.perform(MockMvcRequestBuilders.get("/doC?msg=world"))
			  .andDo(print())	
			  .andExpect(status().isOk());
	}
	
	
	@Test
	public void testDoD() throws Exception{
		mocMvc.perform(MockMvcRequestBuilders.get("/doD"))
		 .andDo(print())
		  .andExpect(status().isOk())
			  .andExpect(model().attributeExists("productVO"));
	}
	
	@Test
	public void testDoE() throws Exception{
		mocMvc.perform(MockMvcRequestBuilders.get("/doE"))
		 .andDo(print())
		  .andExpect(status().isOk())
		.andExpect(redirectedUrl("/doF?msg=this+is+the+message+with+redirected"));
	}
	
	@Test
	public void testDoJson() throws Exception{
		mocMvc.perform(MockMvcRequestBuilders.get("/doJson"))
		 
			.andDo(print())
		  .andExpect(status().isOk());
		// 방법 도저히 모르겠음
		//.andExpect(content().contentType("application/json;charset=utf-8"));
	}
	
}
