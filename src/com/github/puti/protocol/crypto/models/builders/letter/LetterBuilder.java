package com.github.puti.protocol.crypto.models.builders.letter;

import com.github.puti.protocol.crypto.engine.exception.LetterInvalidToken;
import com.github.puti.protocol.crypto.models.noData.key.Key;
import com.github.puti.protocol.crypto.models.noData.letter.Letter;
import com.github.puti.protocol.crypto.models.noData.lettersSet.LettersSet;
import com.github.puti.protocol.crypto.utils.Util;

public class LetterBuilder {
	private Key key = null;
	private String letter;
	private String utfLetter = "";
	private int index = 2021;

	public LetterBuilder(Key key, String letter, int index) {
		this.key = key;
		this.letter = letter;
		this.utfLetter = Util.createToken(letter.length());
		this.index = index;
	}

	public Letter me() {
		return new Letter() {

			@Override
			public String encode(LettersSet arg) throws LetterInvalidToken {
				String result = key.target().equals(arg) ? utfLetter : null;
				if (result == null)
					throw new LetterInvalidToken();
				else
					return result;
			}

			@Override
			public String decode(LettersSet arg) throws LetterInvalidToken {
				String result = key.target().equals(arg) ? letter : null;
				if (result == null)
					throw new LetterInvalidToken();
				else
					return result;
			}

			@Override
			public int index() {
				return index;
			}
		};
	}

}
