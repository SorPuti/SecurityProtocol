package com.github.puti.protocol.crypto.models.builders.key;

import com.github.puti.protocol.crypto.engine.exception.LetterInvalidToken;
import com.github.puti.protocol.crypto.models.noData.key.Key;
import com.github.puti.protocol.crypto.models.noData.lettersSet.LettersSet;
import com.github.puti.protocol.crypto.utils.Util;

public class KeyBuilder {

	private LettersSet lettersSet;
	private String key = "";

	public KeyBuilder(LettersSet lettersSet) {
		this.lettersSet = lettersSet;
		this.key = Util.createToken(36);
	}

	public Key me() {
		return new Key() {

			@Override
			public String a(LettersSet target) throws LetterInvalidToken {
				return lettersSet.equals(target) ? key : null;
			}

			@Override
			public LettersSet target() {
				return lettersSet;
			}

		};
	}

}
