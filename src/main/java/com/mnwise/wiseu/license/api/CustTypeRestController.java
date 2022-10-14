package com.mnwise.wiseu.license.api;

import com.mnwise.wiseu.license.domain.CustType;
import com.mnwise.wiseu.license.dto.CustTypeDTO;
import com.mnwise.wiseu.license.validator.Message;
import com.mnwise.wiseu.license.service.CustTypeService;
import com.mnwise.wiseu.license.validator.CustTypeValidator;
import com.mnwise.wiseu.license.validator.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustTypeRestController {
    private final CustTypeService custTypeService;
    private final CustTypeValidator validator;

    @RequestMapping(value = "/api/cust_type", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Message> save(@RequestBody @Valid CustTypeDTO custTypeDTO, BindingResult result) {
        Message.MessageBuilder builder = Message.builder();
        try {
            this.validator.validate(custTypeDTO, result);
            if(result.hasErrors()) {
                builder = builder
                        .message(result.getFieldError().getDefaultMessage())
                        .code(Status.BAD_REQUEST);
            } else {
                Long id = custTypeService.save(CustType.builder().id(custTypeDTO.getId())
                        .name(custTypeDTO.getName()).build());
                builder = builder.message("정상적으로 처리되었습니다.")
                        .code(Status.OK)
                        .data(id);
            }
        } catch (Exception e) {
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

    @GetMapping("/api/cust_type/{id}")
    public CustTypeDTO findOne(@PathVariable Long id) {
        return custTypeService.findOne(id);
    }

//    @GetMapping("/api/cust_type")
//    public Page<CustTypeDTO> selectCustType(@RequestBody CustTypeDTO custTypeDTO) {
//
//    }

}
