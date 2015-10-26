package caesar;

public class CaesarCipher {

    public static final int LENGTH_OF_ALPHABET = 26;

    public char encryptChar(char toEncrypt, int key) {
        int encrypted = toEncrypt + key;
        if (encrypted > 'z')
            encrypted = encrypted - LENGTH_OF_ALPHABET;
        return (char) encrypted;
    }
}
