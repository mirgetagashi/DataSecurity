import java.util.Scanner;

public class BeaufortCipher {

    public static String beaufortEncrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();
        int keyIndex = 0;

        for (char plainChar : plainText.toCharArray()) {
            if (Character.isLetter(plainChar)) {
                char keyChar = Character.toUpperCase(key.charAt(keyIndex));
                char plainCharUpper = Character.toUpperCase(plainChar);

                int shift = (keyChar - plainCharUpper + 26) % 26;
                char encryptedChar = (char) ('A' + shift);

                if (Character.isLowerCase(plainChar)) {
                    cipherText.append(Character.toLowerCase(encryptedChar));
                } else {
                    cipherText.append(encryptedChar);
                }

                keyIndex = (keyIndex + 1) % key.length();
            } else {
                cipherText.append(plainChar);
            }
        }

        return cipherText.toString();
    }

    public static String beaufortDecrypt(String cipherText, String key) {
        return beaufortEncrypt(cipherText, key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter plain text: ");
        String plainText = scanner.nextLine();

        System.out.print("Enter secret key: ");
        String key = scanner.nextLine();

        // Encryption
        String cipherText = beaufortEncrypt(plainText, key);
        System.out.println("Encrypted text: " + cipherText);

        // Decryption
        String decryptedText = beaufortDecrypt(cipherText, key);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}