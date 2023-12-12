package com.exemple.aksiomatik.controller;

import com.exemple.aksiomatik.dto.XDto;
import com.exemple.aksiomatik.model.Parameter;
import com.exemple.aksiomatik.service.ParameterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final ParameterService service;

    @PostMapping("/")
    public ResponseEntity<XDto> solve(@RequestBody Parameter parameter) {
        return ResponseEntity.ok(service.solve(parameter));
    }
}
