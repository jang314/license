package com.mnwise.wiseu.license.api;

import com.mnwise.wiseu.license.dto.CustDTO;
import com.mnwise.wiseu.license.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustRestController {
    private final CustService custService;

    @RequestMapping(value="/api/cust", method = RequestMethod.POST)
    public CustDTO save(@RequestBody CustDTO custDTO) {
        System.out.println("cust : " +custDTO.toString());
        custService.save(custDTO);
        return custDTO;
    }
}
