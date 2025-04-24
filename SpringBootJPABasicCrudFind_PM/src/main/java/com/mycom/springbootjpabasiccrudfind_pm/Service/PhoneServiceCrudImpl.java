package com.mycom.springbootjpabasiccrudfind_pm.Service;

import com.mycom.springbootjpabasiccrudfind_pm.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PhoneServiceCrudImpl implements PhoneServiceCrud {
    private final PhoneRepository phoneRepository;

    @Override
    public Phone savePhone(Phone phone) {
        log.info("{}", phone);
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> getAllPhone() {
        log.info("전체 휴대폰 목록 조회 시도");
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> getPhoneById(int id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Optional<Phone> updatePhone(Phone phone) {
        Optional<Phone> existingPhone = phoneRepository.findById(phone.getId());
        if(!existingPhone.isEmpty()){
            return Optional.of(phoneRepository.save(phone));
        }
        return Optional.empty();
    }

    @Override
    public void deletePhone(int id) {
        phoneRepository.deleteById(id);
    }
}