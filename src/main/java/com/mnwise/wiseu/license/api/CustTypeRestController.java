package com.mnwise.wiseu.license.api;

import com.mnwise.wiseu.license.dto.CustTypeDTO;
import com.mnwise.wiseu.license.service.CustTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CustTypeRestController {
    private final CustTypeService custTypeService;

    @RequestMapping(value = "/api/cust_type", method = {RequestMethod.POST, RequestMethod.PUT})
    public int save(@RequestBody @Valid CustTypeDTO custTypeDTO) {
        try{
            custTypeService.save(Optional.ofNullable(custTypeDTO.getId()).orElse(null),
                    Arrays.asList(custTypeDTO.getName().split("/")));
            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @GetMapping("/api/cust_type")
    public CustTypeDTO findOne(Long id) {
        return custTypeService.findOne(id);
    }


}
