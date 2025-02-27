package com.in28minutes.learnspringframework.hellowworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name,int age, Address address) {};

record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	
	@Bean
	public String name() {
		return "Chris";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Jack",20,new Address("Main Street","Utrecht"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(),age(), address());
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {//name, age
		return new Person(name,age,address3);
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) {//name, age
		return new Person(name,age,address);
	}
	
	@Bean
	
	public Person person5Qualifier(String name, int age, @Qualifier("address2qualifier") Address address) {//name, age
		return new Person(name,age,address);
	}
	
	@Bean(name = "address2")
	@Qualifier("address2qualifier")
	public Address address() {
		return new Address("Baker Street","London");
	}
	
	@Bean(name = "address3")
	@Primary
	public Address address3() {
		return new Address("Papandreou","Thessaloniki");
	}
}
