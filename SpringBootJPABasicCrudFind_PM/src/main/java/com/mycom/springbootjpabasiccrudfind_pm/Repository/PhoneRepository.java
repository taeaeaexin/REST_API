package com.mycom.springbootjpabasiccrudfind_pm.Repository;

import com.mycom.springbootjpabasiccrudfind_pm.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}