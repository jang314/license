package com.mnwise.wiseu.license.api;

import com.mnwise.wiseu.license.domain.Member;
import com.mnwise.wiseu.license.dto.CustTypeDTO;
import com.mnwise.wiseu.license.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {
    @RequestMapping(value = "/api/member", method = {RequestMethod.POST})
    public void save(@RequestBody MemberDTO member) {
        try{
            System.out.println("Test :" + member);
        }catch (Exception e) {
        }
    }
}
