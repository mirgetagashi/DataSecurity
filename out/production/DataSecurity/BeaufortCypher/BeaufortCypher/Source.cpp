#include <iostream>
#include <string>

using namespace std;

string beaufortEncrypt(string plainText, string key) {
    string cipherText = "";
    int keyIndex = 0;

    for (char plainChar : plainText) {
        if (isalpha(plainChar)) {
            char keyChar = key[keyIndex];
            int shift = toupper(keyChar) - 'A';
            char encryptedChar = ((shift + toupper(plainChar) - 'A') % 26) + 'A';

            if (islower(plainChar)) {
                cipherText += tolower(encryptedChar);
            }
            else {
                cipherText += encryptedChar;
            }

            keyIndex = (keyIndex + 1) % key.length();
        }
        else {
            cipherText += plainChar;
        }
    }

    return cipherText;
}

string beaufortDecrypt(string cipherText, string key) {
    string plainText = "";
    int keyIndex = 0;

    for (char cipherChar : cipherText) {
        if (isalpha(cipherChar)) {
            char keyChar = key[keyIndex];
            int shift = toupper(keyChar) - 'A';
            char decryptedChar = ((26 + toupper(cipherChar) - 'A' - shift) % 26) + 'A';

            if (islower(cipherChar)) {
                plainText += tolower(decryptedChar);
            }
            else {
                plainText += decryptedChar;
            }

            keyIndex = (keyIndex + 1) % key.length();
        }
        else {
            plainText += cipherChar;
        }
    }

    return plainText;
}

int main() {
    string plaintext, key;

    cout << "Shkruani tekstin: ";
    getline(cin, plaintext);

    cout << "Shkruani celesin: ";
    getline(cin, key);

    string ciphertext = beaufortEncrypt(plaintext, key);
    cout << "Teksti i enkriptuar: " << ciphertext << endl;

    string decryptedText = beaufortDecrypt(ciphertext, key);
    cout << "Teksti i dektriptuar: " << decryptedText << endl;

    return 0;
}
