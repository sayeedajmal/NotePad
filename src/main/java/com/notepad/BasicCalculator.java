package com.notepad;

import java.util.Scanner;

public class BasicCalculator {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		System.out.println(" 1. Addition \n 2. Subtraction \n 3. Multiplication \n 4. Division");
		System.out.println("Enter Your Choice: ");
		int choice = input.nextInt();
		System.out.println("Enter First Number: ");
		Double FirstNumber = input.nextDouble();
		System.out.println("Enter Second Number: ");
		Double SecondNumber = input.nextDouble();
		double result = 0.0;
		switch (choice) {
			case 1:
				result = FirstNumber + SecondNumber;
				break;
			case 2:
				result = FirstNumber - SecondNumber;
				break;
			case 3:
				result = FirstNumber * SecondNumber;
				break;
			case 4:
				result = FirstNumber / SecondNumber;
				break;
			default:
				break;
		}
		System.out.println("Result is: " + result);
		input.close();
	}
}
