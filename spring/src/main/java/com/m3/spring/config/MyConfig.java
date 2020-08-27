package com.m3.spring.config;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;
import com.m3.spring.Deps.DepS30;
import com.m3.spring.Deps.S30able;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import(MyConfig2.class)
public class MyConfig {

	@Bean
	@Qualifier("A1")
	public DepA createDepA() {
		return new DepA();
	}

	@Bean
	@Primary
	public DepA makeDepA() {
		return new DepA();
	}

	@Bean
	public DepB createDepB() {
		return new DepB();
	}

	@Bean(name="group1")
	public S30able createS30() {
		return new DepS30("Sam", "Dani", "Ann");
	}

	@Bean
	@Qualifier("group2")
	public S30able getS30() {
		return new DepS30("Beshoy", "Hannah", "Ben");
	}
}
