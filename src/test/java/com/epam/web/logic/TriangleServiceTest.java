package com.epam.web.logic;

import com.epam.web.StartApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void doServiceTest(){
        try {
            this.mockMvc.perform(get("/calculateTriangle?firstSide=3&secondSide=4&thirdSide=5"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"Triangle Square\":6.0,\"Triangle Perimeter\":12.0}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
