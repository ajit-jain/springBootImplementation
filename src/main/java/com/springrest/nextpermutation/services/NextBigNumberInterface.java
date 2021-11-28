package com.springrest.nextpermutation.services;

import com.springrest.nextpermutation.entities.NextBigNumberResponseFormat;


public interface NextBigNumberInterface {
	public NextBigNumberResponseFormat getNextBiggerNumberFromSameDigits(String str);
}
