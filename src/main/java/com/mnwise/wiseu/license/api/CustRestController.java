package com.mnwise.wiseu.license.api;

import com.mnwise.wiseu.license.dto.*;
import com.mnwise.wiseu.license.dto.condition.CustSearchCond;
import com.mnwise.wiseu.license.dto.query.CustQueryDTO;
import com.mnwise.wiseu.license.service.CustService;
import com.mnwise.wiseu.license.validator.CustValidator;
import com.mnwise.wiseu.license.validator.Message;
import com.mnwise.wiseu.license.validator.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustRestController {
    private final CustService custService;
    private final CustValidator validator;

    @PostConstruct
    public void init() {

    }

    @RequestMapping(value = "/api/cust", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Message> save(@RequestBody @Valid CustDTO custDTO, BindingResult result) {
        Message.MessageBuilder builder = Message.builder();
        try {
            this.validator.validate(custDTO, result);
            if(result.hasErrors()) {
                builder = builder
                        .message(result.getFieldError().getDefaultMessage())
                        .code(Status.BAD_REQUEST);
            } else {
                String id = custService.save(custDTO);
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

    @GetMapping("/api/cust")
    public ResponseEntity<Page<CustQueryDTO>> findList(Pageable pageable, @RequestBody CustSearchCond condition) {
        return new ResponseEntity<>(custService.findList(pageable, condition), HttpStatus.OK);
    }


}
