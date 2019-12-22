package com.contract.producer.testing;

import com.contract.producer.testing.controller.CalculatorController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
class ContractTestingApplicationTests {

	@Autowired
	private CalculatorController calculatorController;

	@BeforeEach
	public void setup() {
		StandaloneMockMvcBuilder standaloneMockMvcBuilder
				= MockMvcBuilders.standaloneSetup(calculatorController);
		RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
	}
}
