package com.mycom.springbootjpabasiccrudfind_pm.Phone.Repository;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    List<Phone> findByModelAndCompany(String model, String company);
    List<Phone> findByModelOrCompany(String model, String company);
    List<Phone> findByModelLike(String model);
    List<Phone> findByPriceBetween(Integer min, Integer max);
}