package com.mycom.springbootjpabasiccrudfind_pm.webapp.SpringBootTest;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller.PhoneControllerCrud;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Repository.PhoneRepository;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceCrud;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceFind;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PhoneTest {
    // Controller
    @Autowired
    private PhoneControllerCrud phoneControllerCrud;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private PhoneServiceCrud phoneServiceCrud;

    @Test
    public void testPhoneCRUDController() {
        PhoneResultDto phoneResultDto =
                phoneControllerCrud.listPhone().getBody();
        assertEquals("success", phoneResultDto.getResult());
    }

    // Service
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PhoneServiceFind phoneServiceFind;

    // PhoneServiceCrud
    @Test
    public void test_PhoneServiceCrud_savePhone() throws Exception {
        this.mockMvc.perform(
                get("/api/phones")
                        .param("company","Samsung")
                        .param("model","Galaxy S23")
                        .param("price","100_000")
        )
        .andExpect(status().isOk());
    }

    // PhoneServiceFind
    @Test
    public void test_ServicePhoneFind() {
        List<Phone> phoneList = phoneServiceFind.findByModelAndCompany("Galaxy A52","Samsung");
        assertNotNull(phoneList);
        assertFalse(phoneList.isEmpty());
        assertEquals("Galaxy A52", phoneList.get(0).getModel());
    }

    // Repository
    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void testPhoneCRUDRepository() {
        Optional<Phone> optionalPhone = phoneRepository.findById(1);
    }
}