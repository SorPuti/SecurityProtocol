package com.github.puti.protocol.crypto.engine;

import com.github.puti.protocol.crypto.engine.exception.LetterInvalidToken;
import com.github.puti.protocol.crypto.models.noData.lettersSet.LettersSet;
import com.github.puti.protocol.crypto.utils.Util;

public class Engine {

	private LettersSet lettersSet;

	public Engine(LettersSet lettersSet) {
		this.lettersSet = lettersSet;
	}

	public boolean isValid() {
		if (lettersSet == null)
			return false;
		if (lettersSet.compressedSize().equals("LOW"))
			return false;
		return true;
	}

	public String decode() {
		StringBuilder builder = new StringBuilder();

		lettersSet.orden((index, letter) -> {
			try {
				builder.append(letter.decode(lettersSet));
			} catch (LetterInvalidToken e) {
				Util.print("Oops! ouvi falhas ao executar o protocolo.");
				e.printStackTrace();
			}

		});
		return builder.toString();
	}

	public String encode() {
		StringBuilder builder = new StringBuilder();
		lettersSet.orden((index, letter) -> {
			try {
				builder.append(letter.encode(lettersSet));
			} catch (LetterInvalidToken e) {
				Util.print("Oops! ouvi falhas ao executar o protocolo.");
				e.printStackTrace();
			}

		});
		return builder.toString();
	}
}
