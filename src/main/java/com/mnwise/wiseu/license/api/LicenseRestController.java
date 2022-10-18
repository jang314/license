package com.mnwise.wiseu.license.api;


import com.mnwise.wiseu.license.dto.LicenseDTO;
import com.mnwise.wiseu.license.dto.condition.LicenseSearchCond;
import com.mnwise.wiseu.license.dto.query.LicenseQueryDTO;
import com.mnwise.wiseu.license.service.LicenseService;
import com.mnwise.wiseu.license.validator.LicenseValidator;
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

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LicenseRestController {
    private final LicenseService licenseService;
    private final LicenseValidator validator;

    /*
    * 라이센스 등록 시 고객사와 제품은 필수 선택하고,
    * 서버 정보와 프로세스 엔진명은 입력받아 같이 저장되게 한다.
    * */
    @RequestMapping(value = "/api/license", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Message> save(@RequestBody @Valid LicenseDTO licenseDTO, BindingResult result) {
        Message.MessageBuilder builder = Message.builder();
        try {
            this.validator.validate(licenseDTO, result);
            if(result.hasErrors()) {
                builder = builder
                        .message(result.getFieldError().getDefaultMessage())
                        .code(Status.BAD_REQUEST);
            } else {
                String id = licenseService.save(licenseDTO);
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

    @GetMapping(value = "/api/license")
    public ResponseEntity<Page<LicenseQueryDTO>> findList(Pageable pageable, @RequestBody LicenseSearchCond condition) {
        return new ResponseEntity<>(licenseService.findList(pageable, condition), HttpStatus.OK);
    }
}
