package com.github.puti.protocol.crypto.models.builders.letterSet;

import java.util.HashSet;
import java.util.Set;

import com.github.puti.protocol.crypto.engine.Engine;
import com.github.puti.protocol.crypto.engine.functions.CommuOrden;
import com.github.puti.protocol.crypto.models.builders.key.KeyBuilder;
import com.github.puti.protocol.crypto.models.builders.letter.LetterBuilder;
import com.github.puti.protocol.crypto.models.noData.key.Key;
import com.github.puti.protocol.crypto.models.noData.letter.Letter;
import com.github.puti.protocol.crypto.models.noData.lettersSet.LettersSet;
import com.github.puti.protocol.crypto.utils.Util;

public class LettersSetBuilder {

	private Set<Letter> letters;

	public LettersSetBuilder() {
		this.letters = new HashSet<>();
	}

	public Key generateKey(LettersSet arg) {
		return new KeyBuilder(arg).me();
	}

	public LettersSet me() {
		return new LettersSet() {

			private Key key = null;

			private Key check() {
				if (key == null)
					this.key = generateKey(this);

				return key;
			}

			@Override
			public void setLetters(String arg) {
				for (int i = 0; i < arg.length(); i++) {
					String letter = String.valueOf(arg.charAt(i));
					letters.add(new LetterBuilder(this.check(), letter, i).me());
				}
			}

			@Override
			public void reset() {
				letters = new HashSet<>();
			}

			@Override
			public String compressedSize() {
				return COMPRESSED.valueOf(letters.size());
			}
			@Override
			public void orden(CommuOrden orden) {
				this.check();
				for (int i = 0; i <= letters.size(); i++) {
					Letter letter = get(i);
					if (letter != null)
						orden.orden(i, letter);
					else
						Util.print("Letter index "+i+" is null!");
				}
			}

			private Letter get(int index) {
				for (Letter l : letters)
					if (l.index() == index)
						return l;

				return null;
			}

			@Override
			public Engine engine() {
				return new Engine(this);
			}

			@Override
			public String encode() {
				return this.engine().encode();
			}

			@Override
			public String decode() {
				return this.engine().decode();
			}
		};
	}

}
