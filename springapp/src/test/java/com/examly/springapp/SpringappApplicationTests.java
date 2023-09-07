package com.examly.springapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private  MockMvc mockMvc ;

	@Test
void addcategory() throws Exception {
    String st = "{\"id\":1001,\"name\": \"Demo\"}"; // Fix the JSON string

    mockMvc.perform(MockMvcRequestBuilders.post("/addcategory")
            .contentType(MediaType.APPLICATION_JSON)
            .content(st)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
           // .andExpect(jsonPath("$.success").value(true)) // Change "$" to "$.success"
            .andReturn();
}


	@Test
	void getAllCategories() throws Exception{	

		 mockMvc.perform(get("/getAllcategory")
		 				.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						//.andExpect(jsonPath("$.name").value("Demo"))
						.andReturn();
	}


@Test
    void addProduct() throws Exception {
        // Create a product JSON payload
        String productJson = "{\n" +
                "    \"productId\": 5004,\n" +
                "    \"productName\": \"Mobile\",\n" +
                "    \"price\": 2000.99,\n" +
                "    \"quantity\": 1,\n" +
                "    \"category\": {\n" +
                "        \"id\": 1001\n" +
                "    }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                ;
    }



	@Test
	void getProduct() throws Exception{	
		
		 mockMvc.perform(get("/GetProduct")
		 				.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						//.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	



	@Test
    void GetProductById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/GetProductByProductId/5004")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(5004))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("Mobile"));
    }


	@Test
    void GetProductsByCategory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/GetProductBycategoryId/1001")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].productId").value(5004))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].productName").value("Mobile"));
    }

}


	


