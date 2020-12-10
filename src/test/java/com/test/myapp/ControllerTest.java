package com.test.myapp;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration  스프링 4.3.8 버전으로 변경해야함  Junit은 4.11 이상 버전으로 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);
	
	@Inject
	private WebApplicationContext webApplicationContext;
	/*  버전 업해야 되는듯
	private MockMvc mocMvc;
	
	@Before
	public void setUp() {
		this.mocMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		logger.info("setUp...");
	}
	
	@Test
	public void testDoA() throws Exception{
		mocMvc.perform(MockMvcequestBuilders.get("/doA"))
			  .andDO(print())
			  .andExpect(status().isOK());
	}
	
	
	@Test
	public void testDoB() throws Exception{
		mocMvc.perform(MockMvcequestBuilders.get("/doB"))
			  .andDO(print())
			  .andExpect(status().isOK());
	}
	
	
	@Test
	public void testDoC() throws Exception{
		mocMvc.perform(MockMvcequestBuilders.get("/doC?msg=world"))
			  .andDO(print())
			  .andExpect(status().isOK());
	}
	
	
	@Test
	public void testDoD() throws Exception{
		mocMvc.perform(MockMvcequestBuilders.get("/doD"))
			  .andDO(print())
			  .andExpect(status().isOK())
			  .andExpect(model().attributeExists("productVO"));
	}
	
	@Test
	public void testDoE() throws Exception{
		mocMvc.perform(MockMvcequestBuilders.get("/doE"))
			  .andDO(print())
			  .andExpect(status().isOK())
			  .andExpect(rediectedUrl("/doF?msg=this+is+the+message+with+redirected"));
	}
	
	@Test
	public void testDoJson() throws Exception{
		mocMvc.perform(MockMvcequestBuilders.get("/doJson"))
			  .andDO(print())
			  .andExpect(status().isOK())
			  .andExpect(content().contentType("application/json;charset=utf-8");
	}
	*/
}
