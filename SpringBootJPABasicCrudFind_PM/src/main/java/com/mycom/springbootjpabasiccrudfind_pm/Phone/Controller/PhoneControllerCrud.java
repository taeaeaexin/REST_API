package com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceCrud;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 250429 ResponseEntity 적용
// 250429 Swagger 적용
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

@Tag(name="test", description = "test")
public class PhoneControllerCrud {
    private final PhoneServiceCrud phoneServiceCrud;

    @Operation(summary="휴대폰 목록 조회", description = "전체 휴대폰 목록 조회")
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

    @Operation(summary="휴대폰 추가", description = "휴대폰 추가") //, hidden = true) 이런것도 있다~
    @PostMapping("/phones")
    public ResponseEntity<PhoneResultDto> insertPhone(@RequestBody PhoneDto phoneDto){
        PhoneResultDto phoneResultDto = phoneServiceCrud.savePhone(phoneDto);
        return switch (phoneResultDto.getResult()) {
            case "success" -> ResponseEntity.ok().body(phoneResultDto);
            case "notfound" -> ResponseEntity.notFound().build();
            default -> ResponseEntity.internalServerError().build();
        };
    }

    @Operation(summary="휴대폰 상세 조회", description = "휴대폰 상세 조회", deprecated = true)
    @GetMapping("/phones/{id}")
    public ResponseEntity<PhoneResultDto> detailPhone(@PathVariable("id") Integer id){
        try {
            PhoneResultDto phoneResultDto = phoneServiceCrud.getPhoneById(id);
            if (phoneResultDto == null || phoneResultDto.getPhoneList().isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(phoneResultDto);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/phones/{id}")
    public ResponseEntity<PhoneResultDto> updatePhone(@PathVariable("id") Integer id, @RequestBody PhoneDto phoneDto){
        try{
            PhoneResultDto phoneResultDto = phoneServiceCrud.getPhoneById(id);
            switch (phoneResultDto.getResult()){
                case "success" :
                    phoneDto.setId(id);
                    phoneResultDto = phoneServiceCrud.updatePhone(phoneDto);
                    return ResponseEntity
                            .ok()
                            .body(phoneResultDto);
                case "notfound" : return ResponseEntity.notFound().build();
                default : return ResponseEntity.internalServerError().build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
//        phoneDto.setId(id);
//        return phoneServiceCrud.updatePhone(phoneDto);
    }

    @DeleteMapping("/phones/{id}")
    public ResponseEntity<PhoneResultDto> deletePhoneById(@PathVariable("id") Integer id){
        try{
            PhoneResultDto phoneResultDto = phoneServiceCrud.getPhoneById(id);
            switch (phoneResultDto.getResult()){
                case "success" :
                    phoneServiceCrud.deletePhone(id);
                    return ResponseEntity
                            .ok()
                            .body(phoneResultDto);
                case "notfound" : return ResponseEntity.notFound().build();
                default : return ResponseEntity.internalServerError().build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
//        phoneServiceCrud.deletePhone(id);
//        return phoneServiceCrud.deletePhone(id);
    }
}
