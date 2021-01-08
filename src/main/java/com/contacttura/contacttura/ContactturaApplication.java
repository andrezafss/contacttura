package com.contacttura.contacttura;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.contacttura.contacttura.model.Contacttura;
import com.contacttura.contacttura.model.ContactturaUser;
import com.contacttura.contacttura.repository.ContactturaRepository;
import com.contacttura.contacttura.repository.ContactturaRepositoryUser;

@SpringBootApplication
public class ContactturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactturaApplication.class, args);
		
	}
//	@Bean
//	CommandLineRunner init(ContactturaRepository repository) {
//		return args -> {
//			repository.deleteAll();
//			LongStream.range(1,11)
//			.mapToObj(i ->{
//				Contacttura c = new Contacttura();
//				c.setName("Contacttura User" + i);
//				c.setEmail("Contacttuta" + i + "@gmail");
//				c.setPhone("(081) 9" + i + i + i + i + "-" + i +  i + i + i);
//				return c;
//			})
//			.map(m -> repository.save(m))
//			.forEach(System.out::println);
//		};
//		
//	}
	/*@Bean
	CommandLineRunner init(ContactturaRepositoryUser repository){
		return args -> {
			repository.deleteAll();
			LongStream.range(1,3)
			.mapToObj(i -> {
				ContactturaUser c = new ContactturaUser();
				c.setName("Contactura User" + i);
				c.setUsername("contacturaUser" + i + "@gmail.com");
				c.setPassword("123");
				c.setAdmin(true);
				return c;
			})//pera que to vendo no meu codigo
			.map(m -> repository.save(m))
			.forEach(System.out::println);
		};
	
	}*/
		
	

}
