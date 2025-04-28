package com.mycom.springbootjpabasiccrudfind_pm.Phone.Service;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PhoneServiceCrudImpl implements PhoneServiceCrud {
    private final PhoneRepository phoneRepository;

    @Override
    public PhoneResultDto savePhone(PhoneDto phoneDto) {
        // #1 반환할 객체 선언
        PhoneResultDto phoneResultDto = new PhoneResultDto();

        // #2 PhoneDto -> Phone Entity
        Phone phone = Phone.builder()
                .company(phoneDto.getCompany())
                .model(phoneDto.getModel())
                .gb(phoneDto.getGb())
                .price(phoneDto.getPrice())
                .stock(phoneDto.getStock())
                .build();

        try{
            // #3 Repository를 통해 저장
            phoneRepository.save(phone);

            // 성공
            phoneResultDto.setResult("success");
        }catch(Exception e){
            // 실패
            e.printStackTrace();
            phoneResultDto.setResult("fail");
        }

        return phoneResultDto;
    }

    @Override
    public PhoneResultDto getAllPhone() {
        log.info("전체 휴대폰 목록 조회 시도");
        PhoneResultDto phoneResultDto = new PhoneResultDto();

        try{
            List<Phone> phoneEntityList = phoneRepository.findAll();

            List<PhoneDto> phoneDtoList = new ArrayList<>();

            for (Phone phone : phoneEntityList) {
                PhoneDto phoneDto = PhoneDto.builder()
                        .id(phone.getId())
                        .company(phone.getCompany())
                        .model(phone.getModel())
                        .price(phone.getPrice())
                        .build();
                phoneDtoList.add(phoneDto);
            }

            phoneResultDto.setResult("success");
            phoneResultDto.setPhoneList(phoneDtoList);
            phoneResultDto.setCount((long)phoneDtoList.size());

        }catch(Exception e){
            e.printStackTrace();
            phoneResultDto.setResult("fail");
        }
        return phoneResultDto;
    }

    @Override
    public PhoneResultDto updatePhone(PhoneDto phoneDto) {
        PhoneResultDto phoneResultDto = new PhoneResultDto();

        Phone phone = Phone.builder()
                .id(phoneDto.getId())
                .company(phoneDto.getCompany())
                .model(phoneDto.getModel())
                .price(phoneDto.getPrice())
                .build();
        try{
            phoneRepository.save(phone);
            phoneResultDto.setResult("success");
        }catch(Exception e){
            e.printStackTrace();
            phoneResultDto.setResult("fail");
        }
        return phoneResultDto;
    }

    @Override
    public PhoneResultDto deletePhone(int id) {
        PhoneResultDto phoneResultDto = new PhoneResultDto();
        try{
            phoneRepository.deleteById(id);
            phoneResultDto.setResult("success");
        }catch(Exception e){
            e.printStackTrace();
            phoneResultDto.setResult("fail");
        }
        return phoneResultDto;
    }

    @Override
    public PhoneResultDto getPhoneById(Integer id) {
        PhoneResultDto phoneResultDto = new PhoneResultDto();

        try{
            Optional<Phone> optionalPhone = phoneRepository.findById(id);

            optionalPhone.ifPresentOrElse(
                    phone -> {
                        PhoneDto phoneDto = PhoneDto.builder()
                                .id(phone.getId())
                                .company(phone.getCompany())
                                .model(phone.getModel())
                                .price(phone.getPrice())
                                .build();
                        phoneResultDto.setResult("success");
                    },
                    () -> {
                        phoneResultDto.setResult("notfound");
                    }
            );
        }catch(Exception e){
            e.printStackTrace();
            phoneResultDto.setResult("fail");
        }
        return phoneResultDto;
    }
}