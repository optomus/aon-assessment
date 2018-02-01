package aon.platform.api;

import aon.iplatform.InsurancePlatformApp;
import aon.iplatform.domain.model.common.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InsurancePlatformApp.class)
@AutoConfigureMockMvc
public class InsuranceControllerIntTest {

    @Autowired
    private MockMvc mvc;

    private byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    @Test
    public void testGetQuotes() throws Exception {

        Customer customer = new Customer();
        customer.setPostcode("2000");
        customer.setOccupation("Builder");
        customer.setAnnualTurnover(new BigDecimal("600000"));

        mvc.perform(MockMvcRequestBuilders.post("/api/v1/customer/quotes")
                .content(convertObjectToJsonBytes(customer))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
