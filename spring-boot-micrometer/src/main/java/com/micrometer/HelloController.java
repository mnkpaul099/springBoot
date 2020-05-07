package com.micrometer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
public class HelloController {
	
	@Timed(
			value = "mainak.promo.request",
			percentiles = {0.95, 0.99},
			histogram = true,
			extraTags = {"version", "1.0"}
			)
	@GetMapping("/promo") 
	public String promo () {
		
		return "Hello Prometheus!";
	}
	
	@Timed(
			value = "mainak.grafa.request",
			percentiles = {0.95, 0.99},
			histogram = true,
			extraTags = {"version", "1.0"}
			)
	@GetMapping("/grafa") 
	public String grafa () {
		
		return "Hello Grafana!";
	}

}
