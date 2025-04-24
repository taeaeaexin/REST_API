package com.mycom.springbootjpabasiccrudfind_pm.Service;

import com.mycom.springbootjpabasiccrudfind_pm.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Repository.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceCrudImpl implements PhoneServiceCrud {
    private final PhoneRepository phoneRepository;

    public PhoneServiceCrudImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> getAllPhone() {
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