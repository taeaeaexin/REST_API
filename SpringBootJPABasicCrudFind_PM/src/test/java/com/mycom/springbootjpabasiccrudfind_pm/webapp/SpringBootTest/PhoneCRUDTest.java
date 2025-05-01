package com.mycom.springbootjpabasiccrudfind_pm.webapp.SpringBootTest;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller.PhoneControllerCrud;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Repository.PhoneRepository;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceFind;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PhoneCRUDTest {
    // Controller
    @Autowired
    private PhoneControllerCrud phoneControllerCrud;
    @Autowired
    private HttpSession httpSession;

    @Test
    public void testPhoneCRUDController() {
        PhoneResultDto phoneResultDto =
                phoneControllerCrud.listPhone().getBody();
        assertEquals("success", phoneResultDto.getResult());
    }

    // Service
    @Autowired
    private PhoneServiceFind phoneServiceFind;

    @Test
    public void testPhoneCRUDService() {
        List<Phone> phoneList = phoneServiceFind.findByModelAndCompany("Galaxy S23","SAMSUNG");
        assertNotNull(phoneList);
        assertFalse(phoneList.isEmpty());
        assertEquals("Galaxy S23", phoneList.get(0).getModel());
    }

    // Repository
    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void testPhoneCRUDRepository() {
        Optional<Phone> optionalPhone = phoneRepository.findById(1);
    }

}
