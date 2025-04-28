package com.mycom.springbootjpabasiccrudfind_pm.Phone.Service;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneDto;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto.PhoneResultDto;

public interface PhoneServiceCrud {
    // C: 만들기
    PhoneResultDto savePhone(PhoneDto phoneDto);

    // R: 전체 휴대폰 리스트
    PhoneResultDto getAllPhone();

    // U: 수정 하기
    PhoneResultDto updatePhone(PhoneDto phoneDto);

    // D: 삭제 하기
    PhoneResultDto deletePhone(int id);

    PhoneResultDto getPhoneById(Integer id);
}