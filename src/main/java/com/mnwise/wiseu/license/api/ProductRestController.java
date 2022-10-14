package com.mnwise.wiseu.license.api;

import com.mnwise.wiseu.license.dto.ProductDTO;
import com.mnwise.wiseu.license.service.ProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProdService prodService;

    @RequestMapping(value = "/api/product", method = RequestMethod.POST)
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        prodService.save(productDTO);
        return productDTO;
    }
}
