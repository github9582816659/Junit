package com.test.junit.endpoint;

import com.test.junit.model.Item;
import com.test.junit.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemApi.class)
class ItemApiTest {

    @MockBean
    ItemService itemService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testSave() throws Exception {
        // call "/items"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);

        String jsonContent = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Ball\",\n" +
                "    \"price\": 10,\n" +
                "    \"quantity\": 100\n" +
                "}";

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(jsonContent))
                .andReturn();

    }

    @Test
    void testFind() throws Exception {

        Item item = Item.builder().id(1).name("Ball").price(10).quantity(100).build();
        when(itemService.findById(anyString())).thenReturn(item);

        // call "/items"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/items-from-business")
                .accept(MediaType.APPLICATION_JSON);

        String jsonContent = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Ball\",\n" +
                "    \"price\": 10,\n" +
                "    \"quantity\": 100\n" +
                "}";

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(jsonContent))
                .andReturn();

    }

}
