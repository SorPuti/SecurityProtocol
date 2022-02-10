package com.github.puti.protocol.crypto.models.noData.lettersSet;

import com.github.puti.protocol.crypto.engine.Engine;
import com.github.puti.protocol.crypto.engine.functions.CommuOrden;

public interface LettersSet {

	String compressedSize();

	void reset();

	Engine engine();

	String encode();

	String decode();

	void orden(CommuOrden orden);

	void setLetters(String arg);

	public enum COMPRESSED {
		LOW(0, 10), NORMAL(10, 100), HIGH(100, 500), SUPER_HIGH(500, 1000), VERY_HIGH(1000, 2000),
		Package(2000, 999999999);

		int min = 0;
		int max = 0;

		COMPRESSED(int min, int max) {
			this.min = min;
			this.max = max;
		}

		public static String valueOf(int average) {
			for (COMPRESSED value : COMPRESSED.values())
				if (average <= value.max && average >= value.min)
					return value.name();

			return null;
		}

	}

}
