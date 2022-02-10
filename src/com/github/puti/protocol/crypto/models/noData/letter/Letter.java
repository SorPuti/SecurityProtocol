package com.github.puti.protocol.crypto.models.noData.letter;

import com.github.puti.protocol.crypto.engine.exception.LetterInvalidToken;
import com.github.puti.protocol.crypto.models.noData.lettersSet.LettersSet;

public interface Letter {
	
	String encode(LettersSet arg) throws LetterInvalidToken;
	
	String decode(LettersSet arg) throws LetterInvalidToken;
	
	int index();
	
}
