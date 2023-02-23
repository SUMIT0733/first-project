package com.sumit0733.spring.firstproject.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameVersion {
	
	@GetMapping("/person/v1")
	public PersonV1 personversion1() {
			return new PersonV1("Alex James");
	} 
	
	@GetMapping("/person/v2")
	public PersonV2 personversion2() {
			return new PersonV2(new Name("Alex","James"));
	} 
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 personversion1RP() {
			return new PersonV1("Alex James");
	} 
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 personversion2RP() {
			return new PersonV2(new Name("Alex","James"));
	} 
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 personversion1Header() {
		return new PersonV1("Alex James");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 personversion2Header() {
			return new PersonV2(new Name("Alex","James"));
	} 
}