package com.mnwise.wiseu.license.api;

import com.mnwise.wiseu.license.dto.ProductDTO;
import com.mnwise.wiseu.license.service.ProdService;
import com.mnwise.wiseu.license.validator.Message;
import com.mnwise.wiseu.license.validator.ProductValidator;
import com.mnwise.wiseu.license.validator.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ProductRestController {
    private final ProdService prodService;
    private final ProductValidator validator;

    @RequestMapping(value = "/api/product", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Message> save(@RequestBody @Valid ProductDTO productDTO, BindingResult result) {
        Message.MessageBuilder builder = Message.builder();
        try {
            this.validator.validate(productDTO, result);
            if(result.hasErrors()) {
                builder = builder
                        .message(result.getFieldError().getDefaultMessage())
                        .code(Status.BAD_REQUEST);
            } else {
                String id = prodService.save(productDTO);
                builder = builder.message("정상적으로 처리되었습니다.")
                        .code(Status.OK)
                        .data(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            builder = Message.builder()
                    .code(Status.SERVER_ERROR)
                    .message("서버에러 => " + e.toString());
            log.error(e.toString());
        } finally {
            return new ResponseEntity<>(builder.build(),
                    builder.build().getCode().equals("200") ?
                            HttpStatus.OK : HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findList(Pageable pageable, ProductDTO condition) {
        return new ResponseEntity<>(prodService.findList(pageable, condition), HttpStatus.OK);
    }
}
