package com.example.cachingnosuchfield;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CachingNosuchfieldApplicationTests {
    @Autowired
    MyService myService;

    @BeforeAll
    void setup() throws Exception {
        myService.getClass().getDeclaredField("x");
    }

    @Test void someTest() {
        var l = myService.somethingSlow();

        var start = System.currentTimeMillis();
        l = myService.somethingSlow();
        var stop = System.currentTimeMillis();
        assertTrue(stop - start < 100);
    }
}
