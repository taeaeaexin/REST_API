package com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 250429 ResponseEntity 적용
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PhoneControllerCrud {
    private final PhoneServiceCrud phoneServiceCrud;

    @GetMapping("/phones")
    public ResponseEntity<PhoneResultDto> listPhone(){
        try{
            PhoneResultDto phoneResultDto = phoneServiceCrud.getAllPhone();
//            PhoneResultDto phoneResultDto = null;
            return ResponseEntity
                    .ok()
                    .body(phoneResultDto);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .internalServerError()
                    .build();
        }
    }

    @PostMapping("/phones")
    public PhoneResultDto insertPhone(@RequestBody PhoneDto phoneDto){
        return phoneServiceCrud.savePhone(phoneDto);
    }

    @GetMapping("/phones/{id}")
    public PhoneResultDto detailPhone(@PathVariable("id") Integer id){
        return phoneServiceCrud.getPhoneById(id);
    }

    @PutMapping("/phones/{id}")
    public PhoneResultDto updatePhone(@PathVariable("id") Integer id, @RequestBody PhoneDto phoneDto){
        phoneDto.setId(id);
        return phoneServiceCrud.updatePhone(phoneDto);
    }

    @DeleteMapping("/phones/{id}")
    public PhoneResultDto deletePhoneById(@PathVariable("id") Integer id){
        phoneServiceCrud.deletePhone(id);
        return phoneServiceCrud.deletePhone(id);
    }
}
