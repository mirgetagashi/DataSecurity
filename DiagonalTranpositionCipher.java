import java.util.Scanner;
import java.util.Arrays;

class DiagonalTranspositionCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jepni tekstin te cilin duhet ta enkriptojme");
        String plainText = scanner.nextLine();

        System.out.println("Jepni celesin per enkriptim :");
        String key = scanner.nextLine();

        String cipherText = encrypt(plainText, key);
        System.out.println("Teksti i enkriptuar eshte: " + cipherText);


        String decryptedText=decrypt(cipherText,key);
        System.out.println("Teksti i dekriptuar: "+decryptedText);

    }

    public static String encrypt(String plainText, String key) {
        int col = key.length();
        int row = (plainText.length() + key.length() - 1) / key.length();

        char[][] cipherMatrix = new char[row][col];

        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (k < plainText.length() && i == j) {
                    cipherMatrix[i][j] = plainText.charAt(k++);
                } else {
                    cipherMatrix[i][j] = 'x';
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = i; j < col; j++) {
                if((j-i)<row && j<col){
                if (k < plainText.length()) {
                    cipherMatrix[j - i][j] = plainText.charAt(k++);
                } else {
                    cipherMatrix[j - i][j] = 'x';
                }
            }}
        }
        for (int i = 1; i < row; i++) {
            for (int j = i; j < row; j++) {
                if ((j - i )< col && j<row) {
                if (k < plainText.length()) {
                        cipherMatrix[j][j - i] = plainText.charAt(k++);
                    } else {
                        cipherMatrix[j][j - i] = 'x';
                    }
                }
            }
        }

        char[] keySort = key.toCharArray();
        Arrays.sort(keySort);
        int[] indexSort = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            indexSort[i] = key.indexOf(keySort[i]);
        }

        StringBuilder ciphertext = new StringBuilder();
        int direction = 0;
        for (int c = 0; c < key.length(); c++) {
            int colum = indexSort[c];
            int rowCount = Math.min(plainText.length() - colum, row);
            if (direction % 2 == 1) {
                for (int r = rowCount - 1; r >= 0; r--) {
                    ciphertext.append(cipherMatrix[r][colum]);
                }
            } else {
                for (int r = 0; r < rowCount; r++) {
                    ciphertext.append(cipherMatrix[r][colum]);
                }
            }
            direction++;
        }
        return ciphertext.toString();
    }

    public static String decrypt(String cipherText, String key) {
        int col = key.length();
        int row = (cipherText.length() + key.length() - 1) / key.length();
        char[][] cipherMatrix = new char[row][col];


        char[] keySort = key.toCharArray();
        Arrays.sort(keySort);
        int[] indexSort = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            indexSort[i] = key.indexOf(keySort[i]);
        }

        StringBuilder decryptedText = new StringBuilder();
        int index=0;
        int direction = 0;
        for (int c = 0; c < key.length(); c++) {
            int column = indexSort[c];
            int rowCount = Math.min(cipherText.length() - column, row);
            if (direction % 2 == 1) {
                for (int r = rowCount - 1; r >= 0; r--) {
                    cipherMatrix[r][column]=cipherText.charAt(index++);
                }
            } else {
                for (int r = 0; r < rowCount; r++) {
                    cipherMatrix[r][column]=cipherText.charAt(index++);
                }
            }
            direction++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i==j) {
                    decryptedText.append(cipherMatrix[i][j]);
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = i; j < col; j++) {
                if((j-i)<row && j<col){
                decryptedText.append(cipherMatrix[j - i][j]);
            }}
        }

        for (int i = 1; i < row; i++) {
            for (int j = i; j < row; j++) {
                if((j-i)<col && j<row){
                decryptedText.append(cipherMatrix[j][j - i]);
            }}
        }


        return decryptedText.toString();
    }
}
