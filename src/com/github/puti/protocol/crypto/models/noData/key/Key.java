package com.github.puti.protocol.crypto.models.noData.key;

import com.github.puti.protocol.crypto.engine.exception.LetterInvalidToken;
import com.github.puti.protocol.crypto.models.noData.lettersSet.LettersSet;

public interface Key {

	String a(LettersSet lettersSet) throws LetterInvalidToken;

	LettersSet target();

}
