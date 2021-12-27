package com;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IplManagementSystemApplicationTests {

	@Test
		/* default */void contextLoads() {
		Assert.assertEquals("RCB",IplManagementSystemApplicationTests.class.desiredAssertionStatus());
	}

}
