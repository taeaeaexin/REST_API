package com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceFind;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PhoneControllerFind {
    private final PhoneServiceFind phoneServiceFind;

    @GetMapping("/By-Model-And-Company")
    public List<Phone> findByModelAndCompany(
            @RequestParam("model") String model,
            @RequestParam("company") String company){
        return phoneServiceFind.findByModelAndCompany(model, company);
    }

    @GetMapping("/By-Model-Or-Company")
    public List<Phone> findByOrAndCompany(
            @RequestParam("model") String model,
            @RequestParam("company") String company){
        return phoneServiceFind.findByModelOrCompany(model, company);
    }

    @GetMapping("/By-Model-Like")
    public List<Phone> findByModelLike(
            @RequestParam("model") String model){
        return phoneServiceFind.findByModelLike(model);
    }

    @GetMapping("/By-Price-Between")
    public List<Phone> findByPriceBetween(
            @RequestParam("min") Integer min,
            @RequestParam("max") Integer max){
        return phoneServiceFind.findByPriceBetween(min, max);
    }
}
