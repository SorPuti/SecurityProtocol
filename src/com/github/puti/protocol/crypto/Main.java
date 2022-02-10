package com.github.puti.protocol.crypto;

import com.github.puti.protocol.crypto.models.builders.letterSet.LettersSetBuilder;
import com.github.puti.protocol.crypto.models.noData.lettersSet.LettersSet;
import com.github.puti.protocol.crypto.utils.Util;

public class Main {

	public static void main(String[] args) {
		LettersSet protocol = new LettersSetBuilder().me();
		protocol.setLetters("Sistema de criptografia, aceita todos os sinais.Exemplo: !@#$%¨&*");
		Util.print(protocol.encode());
		System.out.println("Protocol valid ? " + protocol.engine().isValid());
		System.out.println("Compressed Size: " + protocol.compressedSize());
		Util.print(protocol.decode());
	}

}
