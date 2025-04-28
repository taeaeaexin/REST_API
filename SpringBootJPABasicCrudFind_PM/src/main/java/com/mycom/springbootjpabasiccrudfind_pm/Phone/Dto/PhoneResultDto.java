package com.mycom.springbootjpabasiccrudfind_pm.Phone.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneResultDto {
    private String result;
    private PhoneDto phoneDto;
    private List<PhoneDto> phoneList;
    private Long count;
}