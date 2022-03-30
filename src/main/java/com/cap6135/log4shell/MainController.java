package com.cap6135.log4shell;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class MainController {

    private static final Logger logger = LogManager.getLogger(MainController.class.getName());
	
	@GetMapping("/")
    public String index(@RequestHeader(name="X-Api-Version", required=false) String v) {
		
		if (v == null || v.isEmpty()) {
			v = "1.0";
		}
		
		logger.info(v);
		
		return "<h1 style=\"color: #5e9ca0;\">Log4Shell</h1><h4>Vulnerability - Exploitation and Mitigation</h4><p>API Version: " + v + "</p>";
    }
}
