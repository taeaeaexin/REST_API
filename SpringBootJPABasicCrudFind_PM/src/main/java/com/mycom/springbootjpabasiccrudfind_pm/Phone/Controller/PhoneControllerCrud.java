package com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PhoneControllerCrud {
    private final PhoneServiceCrud phoneServiceCrud;

    @PostMapping("/phones")
    public PhoneResultDto insertPhone(PhoneDto phoneDto){
        return phoneServiceCrud.savePhone(phoneDto);
    }

    @GetMapping("/phones")
    public PhoneResultDto listPhone(){
        return phoneServiceCrud.getAllPhone();
    }

    @GetMapping("/phones/{id}")
    public PhoneResultDto detailPhone(@PathVariable("id") Integer id){
        return phoneServiceCrud.getPhoneById(id);
    }

    @PutMapping("/phones/{id}")
    public PhoneResultDto updatePhone(@PathVariable("id") Integer id, PhoneDto phoneDto){
        phoneDto.setId(id);
        return phoneServiceCrud.updatePhone(phoneDto);
    }

    @DeleteMapping("/phones/{id}")
    public PhoneResultDto deletePhoneById(@PathVariable("id") Integer id){
        phoneServiceCrud.deletePhone(id);
        return phoneServiceCrud.deletePhone(id);
    }
}
