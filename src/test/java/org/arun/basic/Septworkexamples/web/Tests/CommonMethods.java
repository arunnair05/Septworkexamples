package org.arun.basic.Septworkexamples.web.Tests;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class CommonMethods {

	public static int valueBetweenRange(int r1, int r2) {

		return new Random().nextInt(r2 - r1) + r1;
	}

	public static String getRandomString(int length, boolean useLetters, boolean useNumbers) {
		return RandomStringUtils.random(length, useLetters, useNumbers);
	}

}
