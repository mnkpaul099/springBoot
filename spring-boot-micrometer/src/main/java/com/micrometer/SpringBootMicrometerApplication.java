package com.micrometer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;

@SpringBootApplication
@RestController
public class SpringBootMicrometerApplication {
	
	public final Counter requestCount;
	
	public SpringBootMicrometerApplication(CollectorRegistry collectorRegistry) {
		requestCount = Counter.build()
				.name("request_count")
				.help("Number of hello request")
				.register(collectorRegistry);
	}
	
	@GetMapping("/hello1") 
	public String hello1 () {
		requestCount.inc();
		requestCount.inc(0.5);
		
		return "Hi!";
	}
	
	@GetMapping("/message")
	public String getMessage() {
		return "working..!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicrometerApplication.class, args);
	}

}
