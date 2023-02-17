package com.sumit0733.spring.firstproject;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency")
@Component
public class CurrencyServiceConfiguration {
	private String URL;
	private String name;
	private String password;
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
