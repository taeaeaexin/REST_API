package com.mycom.springbootjpabasiccrudfind_pm.Controller;

import com.mycom.springbootjpabasiccrudfind_pm.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Service.PhoneServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Phone")
public class PhoneControllerCrud {
    private final PhoneServiceCrud phoneServiceCrud;

    @PostMapping("/insert")
    public Phone insertPhone(Phone phone){
        return phoneServiceCrud.savePhone(phone);
    }

    @GetMapping("/list")
    public List<Phone> listPhone(){
        return phoneServiceCrud.getAllPhone();
    }

    @GetMapping("/detail/{id}")
    public Optional<Phone> detailPhone(@PathVariable("id") Integer id){
        return phoneServiceCrud.getPhoneById(id);
    }

    @PutMapping("/update")
    public Optional<Phone> updatePhone(Phone phone){
        return phoneServiceCrud.updatePhone(phone);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhoneById(@PathVariable("id") Integer id){
        phoneServiceCrud.deletePhone(id);
    }
}
