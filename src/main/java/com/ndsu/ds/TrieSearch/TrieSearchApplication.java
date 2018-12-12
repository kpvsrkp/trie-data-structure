package com.ndsu.ds.TrieSearch;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages={"com.ndsu.ds.TrieSearch.controller"})
//@ComponentScan("com.ndsu.ds.TrieSearch.controller")
//@ComponentScan(basePackageClasses = SearchAPI.class)
//@ComponentScan(basePackages="com.ndsu.ds.TrieSearch.controller")
//@ComponentScan(basePackages={"com.ndsu.ds.TrieSearch.controller"})
public class TrieSearchApplication {
	private static final Logger LOGGER = LogManager.getLogger(TrieSearchApplication.class);


	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(TrieSearchApplication.class, args);
		LOGGER.info("Info level log message");
	}
}
