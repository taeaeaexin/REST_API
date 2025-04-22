package com.mycom.springbootjpabasiccrudfind_pm.Service;

import com.mycom.springbootjpabasiccrudfind_pm.Entity.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneServiceCrud {
    // C: 만들기
    Phone savePhone(Phone phone);

    // R: 전체 휴대폰 리스트
    List<Phone> getAllPhone();

    // R: ID로 find
    Optional<Phone> getPhoneById(int id);

    // U: 수정 하기
    Phone updatePhone(Phone phone);

    // D: 삭제 하기
    void deletePhone(int id);
}