package com.nsergey.generator.controller;

import com.nsergey.generator.dto.IdResponse;
import com.nsergey.generator.service.GeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/generator")
public class GeneratorController {

    private final GeneratorService generatorService;

    public GeneratorController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @GetMapping("/uid")
    public IdResponse getTimeBasedUniqueId() {
        return new IdResponse(generatorService.getTimeBasedUniqueId());
    }

    @GetMapping("/seq-id")
    public IdResponse getGloballySequentialId() {
        return new IdResponse(generatorService.getGloballySequentialId());
    }

}
