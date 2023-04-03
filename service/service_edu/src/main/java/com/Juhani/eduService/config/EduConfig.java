package com.Juhani.eduService.config;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.Juhani.eduService.mapper")
public class EduConfig {

}
