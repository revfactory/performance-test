package com.kakao.tech.performancetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
@RestController
public class PerformanceTestApplication {

	@GetMapping("/ping")
	public Mono<String> ping() {
		return Mono.just("pong")
				.publishOn(Schedulers.boundedElastic());
	}

	public static void main(String[] args) {
		System.setProperty("spring.webflux.virtual-threads.enabled", "true");
		System.setProperty("reactor.schedulers.defaultBoundedElasticSize", "10000");
		SpringApplication.run(PerformanceTestApplication.class, args);
	}

}
