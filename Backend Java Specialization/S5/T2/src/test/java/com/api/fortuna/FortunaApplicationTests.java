package com.api.fortuna;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class FortunaApplicationTests {
	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(context, "Context should not be null.");
	}

}
