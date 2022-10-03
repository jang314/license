package com.mnwise.wiseu.license.api;


import com.mnwise.wiseu.license.service.ServerService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ServerRestController {
    private final ServerService serverService;

    public ServerDto save(@RequestBody ServerDto serverDto) {

        return serverDto;
    }

    @Data
    static class ServerDto{
        private String custId;
        private String product;
        private String ip;
    }

}
