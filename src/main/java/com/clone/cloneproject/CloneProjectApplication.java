package com.clone.cloneproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


@EnableScheduling
@EnableJpaAuditing // 생성 시간/수정 시간 자동 업데이트
@SpringBootApplication
public class CloneProjectApplication {

    // 타임스탬프시간 맞추기
    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
//
    public static void main(String[] args) {
        SpringApplication.run(CloneProjectApplication.class, args);
    }

}
