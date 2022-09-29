package com.abotnaru.problems.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class EncodeDecodeStringTest {

	@Test
	void testEncodeDecodeListOfTwo() {
		List<String> expectedList = List.of("neet", "code");
		EncodeDecodeString encoderDecoder = new EncodeDecodeString();
		String encoded = encoderDecoder.encode(expectedList);
		assertEquals("4#neet4#code", encoded);
		List<String> actualList = encoderDecoder.decode(encoded);
		assertEquals(expectedList.size(), actualList.size());
		assertEquals(expectedList.get(0), actualList.get(0));
		assertEquals(expectedList.get(1), actualList.get(1));
	}

	@Test
	void testEncodeDecodeListOfFour() {
		List<String> expectedList = List.of("lint", "code", "love", "you");
		EncodeDecodeString encoderDecoder = new EncodeDecodeString();
		String encoded = encoderDecoder.encode(expectedList);
		assertEquals("4#lint4#code4#love3#you", encoded);
		List<String> actualList = encoderDecoder.decode(encoded);
		assertEquals(expectedList.size(), actualList.size());
		assertEquals(expectedList.get(0), actualList.get(0));
		assertEquals(expectedList.get(1), actualList.get(1));
		assertEquals(expectedList.get(2), actualList.get(2));
		assertEquals(expectedList.get(3), actualList.get(3));
	}

	@Test
	void testEncodeDecodeListOfOne() {
		List<String> expectedList = List.of("neet");
		EncodeDecodeString encoderDecoder = new EncodeDecodeString();
		String encoded = encoderDecoder.encode(expectedList);
		assertEquals("4#neet", encoded);
		List<String> actualList = encoderDecoder.decode(encoded);
		assertEquals(expectedList.size(), actualList.size());
		assertEquals(expectedList.get(0), actualList.get(0));
	}

	@Test
	void testEncodeDecodeListOfThreeLongWords() {
		List<String> expectedList = List.of("verylongstringWith@llTypesOfChars234#deid#43@!dd",
				"bkkdo3945kral45#30sldkwlkdjf093ifja#%^#@aldfkjelw");
		EncodeDecodeString encoderDecoder = new EncodeDecodeString();
		String encoded = encoderDecoder.encode(expectedList);
		assertEquals(
				"48#verylongstringWith@llTypesOfChars234#deid#43@!dd49#bkkdo3945kral45#30sldkwlkdjf093ifja#%^#@aldfkjelw",
				encoded);
		List<String> actualList = encoderDecoder.decode(encoded);
		assertEquals(expectedList.size(), actualList.size());
		assertEquals(expectedList.get(0), actualList.get(0));
		assertEquals(expectedList.get(1), actualList.get(1));
	}

}
