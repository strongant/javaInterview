package com.strongant.string;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class WordConvertTest {
	@Test
	public void testReverse() throws Exception {
		WordConvert wordConvert = new WordConvert();
		String originStirng  = "I am a java developer.";
		String expectedString = wordConvert.reverse(originStirng);
		Assert.assertNotNull(expectedString);
		Assert.assertEquals(expectedString, ".repoleved avaj a ma I");
	}

	@Test
	public void testReverseSentence() throws Exception {
		WordConvert wordConvert = new WordConvert();
		String origin = "I am strongant";
		String expected = wordConvert.reverseSentence(origin);
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected,"strongant am I ");
	}
}