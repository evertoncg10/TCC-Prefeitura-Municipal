package com.poctcc.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ConsultaPessoaTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void test() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/pessoas/06368529032"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
