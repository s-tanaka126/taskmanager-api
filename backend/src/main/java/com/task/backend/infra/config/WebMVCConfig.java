package com.task.backend.infra.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class WebMVCConfig {

    @Bean
    ModelMapper modelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      return modelMapper;
    }
}
