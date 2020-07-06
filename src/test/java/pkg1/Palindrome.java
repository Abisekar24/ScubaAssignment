package pkg1;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sampleStr;
		String reverseStr = "";
		int length;
		sampleStr = "HiH";
		length = sampleStr.length();

		for (int i = length - 1; i >= 0; i--)
			reverseStr = reverseStr + sampleStr.charAt(i);
		if (sampleStr.equals(reverseStr))
			System.out.println("Entered string/number is a palindrome.");
		else
			System.out.println("Entered string/number is not a palindrome.");

	}

}
