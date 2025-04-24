package com.mycom.springbootjpabasiccrudfind_pm.Service;

import com.mycom.springbootjpabasiccrudfind_pm.Entity.Phone;

import java.util.List;

public interface PhoneServiceFind {
    List<Phone> findByModelAndCompany(String model, String company);

    List<Phone> findByModelOrCompany(String model, String company);

    List<Phone> findByModelLike(String model);

    List<Phone> findByPriceBetween(Integer min, Integer max);
}
