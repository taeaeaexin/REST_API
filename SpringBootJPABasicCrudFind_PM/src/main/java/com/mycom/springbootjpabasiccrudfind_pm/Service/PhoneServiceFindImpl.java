package com.mycom.springbootjpabasiccrudfind_pm.Service;

import com.mycom.springbootjpabasiccrudfind_pm.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Repository.PhoneRepository;
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