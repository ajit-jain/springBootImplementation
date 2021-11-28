package com.springrest.nextpermutation.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.springrest.nextpermutation.entities.NextBigNumberResponseFormat;

@Service
public class NextBigPermutationService implements NextBigNumberInterface {

	@Override
	public NextBigNumberResponseFormat getNextBiggerNumberFromSameDigits(String str) {
		
		char[] chars = str.toCharArray();
		
		return findNext(chars, chars.length);
	}
	private NextBigNumberResponseFormat findNext(char chars[], int n) {
		int i;
        
		//find the position of the smallest number from rightmost position
        for (i = n - 1; i > 0; i--) {
	        if (chars[i] > chars[i - 1]) {
	            break;
	        }
        }
        
        // if all number are sorted in descending order or numbers are same or number is a single digit.
        if (i == 0) {
           return new NextBigNumberResponseFormat("No permatuation available!","No answer");
        }
        
        // Processing would start to find next big permutation
        String result = "";
        
        int x = chars[i - 1], secondMin = i;
             
        for (int j = i + 1; j < n; j++) {
            if (chars[j] > x && chars[j] < chars[secondMin])
            {
            	secondMin = j;
            }
        }
        
        // i-1 represents the smallest element from the right
        swap(chars, i - 1, secondMin);
 
        Arrays.sort(chars, i, n);
	    
        for (i = 0; i < n; i++)
	        result += chars[i];
        
	    try {
	    	// check the Permutated number is exceeding the long datatype limit or not
	    	Long.parseLong(result);
	    	return new NextBigNumberResponseFormat("permutation applied!",result);
	    } catch (NumberFormatException e) {
	    	return new NextBigNumberResponseFormat(
	    			"Value would exceed long datatype limit.",
	    			null
	    		);
	    }
       
        

	}
	
	private void swap(char ar[], int i, int j)
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
