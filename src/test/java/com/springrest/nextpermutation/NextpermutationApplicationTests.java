package com.springrest.nextpermutation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springrest.nextpermutation.entities.NextBigNumberResponseFormat;
import com.springrest.nextpermutation.services.NextBigNumberInterface;

@SpringBootTest
class NextpermutationApplicationTests {
	
	@Autowired
	private NextBigNumberInterface nextBigPermutationService;
	
	@Test
	void getNextBigNumberWithProcessableInputs() {
		NextBigNumberResponseFormat responseForNum13 = nextBigPermutationService.getNextBiggerNumberFromSameDigits("13");
		NextBigNumberResponseFormat responseForNum144 = nextBigPermutationService.getNextBiggerNumberFromSameDigits("144");
		NextBigNumberResponseFormat responseForNum3015 = nextBigPermutationService.getNextBiggerNumberFromSameDigits("3015");
		
		assertEquals("31",responseForNum13.getValue());
		assertEquals("414",responseForNum144.getValue());
		assertEquals("3051",responseForNum3015.getValue());
	}
	
	@Test
	void getNextBigNumberWithNonProcessableInputs() {
		NextBigNumberResponseFormat responseForNum6 = nextBigPermutationService.getNextBiggerNumberFromSameDigits("6");
		NextBigNumberResponseFormat responseForNum777 = nextBigPermutationService.getNextBiggerNumberFromSameDigits("777");
		
		assertEquals("No answer",responseForNum6.getValue());
		assertEquals("No answer",responseForNum777.getValue());
	}
	
	@Test
	void getNextBigNumberWithValueThatExceedsTheDatatypeLimit() {
		NextBigNumberResponseFormat response = nextBigPermutationService.getNextBiggerNumberFromSameDigits("9223372036854775807");
		
		assertEquals("Value would exceed long datatype limit.",response.getMessage());
	}
}
