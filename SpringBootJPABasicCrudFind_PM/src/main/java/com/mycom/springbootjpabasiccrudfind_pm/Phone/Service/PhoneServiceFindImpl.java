package com.mycom.springbootjpabasiccrudfind_pm.Phone.Service;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceFindImpl implements PhoneServiceFind {
    private final PhoneRepository phoneRepository;

    @Override
    public List<Phone> findByModelAndCompany(String model, String company) {
        return phoneRepository.findByModelAndCompany(model, company);
    }

    @Override
    public List<Phone> findByModelOrCompany(String model, String company) {
        return phoneRepository.findByModelOrCompany(model, company);
    }

    @Override
    public List<Phone> findByModelLike(String model) {
        return phoneRepository.findByModelLike("%"+model+"%");
    }

    @Override
    public List<Phone> findByPriceBetween(Integer min, Integer max) {
        return phoneRepository.findByPriceBetween(min, max);
    }
}