package com.spiceJet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Extra {

	@BeforeMethod

	private void syso() {

		System.out.println("Navigate to url");
	}

	@Test

	private void syso1() {
		System.out.println("Login With Userame");

	}

	@Test
	private void syso3() {

		System.out.println("Login With Email");
	}

	@Test
	private void syso5() {

		System.out.println("login with phnoeNo");
	}

	@AfterMethod
	private void syso6() {

		System.out.println("close app phn");
	}

}
