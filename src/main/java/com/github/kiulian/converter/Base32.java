package com.github.kiulian.converter;

/*-
 * -----------------------LICENSE_START-----------------------
 * Bitcoincash address converter
 * %%
 * Copyright (C) 2018 Igor Kiulian
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -----------------------LICENSE_END-----------------------
 */




import java.util.HashMap;
import java.util.Map;

public class Base32 {

	private static final String CHARSET = "qpzry9x8gf2tvdw0s3jn54khce6mua7l";
	private static final char[] CHARS = CHARSET.toCharArray();

	private static Map<Character, Integer> charPositionMap;
	static {
		charPositionMap = new HashMap<>();
		for (int i = 0; i < CHARS.length; i++) {
			charPositionMap.put(CHARS[i], i);
		}

	}

	public static String encode(int[] byteArray) {
		StringBuilder sb = new StringBuilder();

		for (int val : byteArray) {
			if (val < 0 || val > 31) {
				throw new RuntimeException("This method assumes that all bytes are only from 0-31. Was: " + val);
			}

			sb.append(CHARS[val]);
		}

		return sb.toString();
	}

	public static int[] decode(String base32String) {
		int[] bytes = new int[base32String.length()];

		char[] charArray = base32String.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			Integer position = charPositionMap.get(charArray[i]);
			if (position == null) {
				throw new RuntimeException("There seems to be an invalid char: " + charArray[i]);
			}
			bytes[i] = (byte) ((int) position);
		}

		return bytes;
	}


}
