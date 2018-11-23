package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactsControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        // 构造MockMvc
        mvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void testaddAddressBook() throws Exception
    {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", "xxx");
        map.add("number", "24");

        String result = mvc.perform(MockMvcRequestBuilders.post("/contacts/add")
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
    @Test
    public void testUpdateAddressBook() throws Exception
    {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", "xxx11");
        map.add("number", "2455555");
        map.add("id", "1");
        String result = mvc.perform(MockMvcRequestBuilders.post("/contacts/update")
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void testfindAllAddressBook() throws Exception
    {
        String result = mvc.perform(MockMvcRequestBuilders.get("/contacts/all")
            .param("pageNum","1").param("pageSize","3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


}
