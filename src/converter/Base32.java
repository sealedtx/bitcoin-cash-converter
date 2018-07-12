package converter;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2018 Igor Kiulian
 *
 * Distributed under the MIT software license, see the accompanying file LICENSE
 * or http://www.opensource.org/licenses/mit-license.php.
 *
 */
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
