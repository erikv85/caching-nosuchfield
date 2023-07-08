package com.example.cachingnosuchfield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@EnableCaching
@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@Service
class MyService {
    int x = 1;

    @Cacheable("numbers")
    public List<Integer> somethingSlow() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        return List.of(1,2,3);
    }
}
