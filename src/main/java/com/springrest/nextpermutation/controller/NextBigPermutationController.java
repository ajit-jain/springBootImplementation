package com.springrest.nextpermutation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.nextpermutation.entities.NextBigNumberResponseFormat;
import com.springrest.nextpermutation.services.NextBigNumberInterface;

@RestController
public class NextBigPermutationController {
	@Autowired
	private NextBigNumberInterface nextBigNumberService;
	
	@GetMapping("/health")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.status(HttpStatus.OK)
				.body("Health Check Successful!");
	}
	
	@GetMapping("/nextBigPermutation/{num}")
	public ResponseEntity<NextBigNumberResponseFormat> getNextBigPermutation(@PathVariable String num) {
		try {
			Long.parseLong(num);
			return ResponseEntity.status(HttpStatus.OK).body(
					nextBigNumberService.getNextBiggerNumberFromSameDigits(num)
				);
		} catch(NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new NextBigNumberResponseFormat(
							"Please pass valid input. It should be in range of [0,9,223,372,036,854,775,807]",
							null
						)		
				  );
		}
	}
}
