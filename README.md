# Data Security - Project 2
## University of Prishtina - Faculty of Electrical and Computer Engineering

### Implementations of cryptographic algorithms: Diagonal Transposition Cipher and Beaufort Cipher.

#### Authors:
Mirgeta Gashi<br>
Natyra Bicaj<br>
Naila Radoncic<br>
Mesud Hoxha<br>

#### Programing language: Java

### 1. Diagonal Transposition Cipher
#### Encryption:
1. Run program
2. Enter plaintext
3. Enter key
4. Display the encrypted text

#### Decryption:
1. Run program
2. Enter ciphertext
3. Enter key
4. Display the plain text

#### Description:
Transposition techniques alter the order of plaintext letters through permutations, enhancing security through obfuscation. Diagonal transposition enhanc the security and efficiency of transposition-based encryption. By arranging plaintext characters diagonally and utilizing variable-length matrices, the algorithm aims to streamline encryption processes and mitigate vulnerabilities.Diagonal transpositional also supports the space between the words. The algorithm which is used to arrange the input string into diagonal is as follows:
1. Write the plain text message in a diagonal form of variable length size:  diagonal, upper triangular, and lower triangular format
2. Generate the key
3. Read the message column by column in random order of columns by using the key positions with the help of wave technique
4. Reads from bottom to top<br>

#### Results:
 Encryption <br>
<img src="https://github.com/mirgetagashi/DataSecurity/assets/154754089/a23457fa-44b5-4a47-9946-dc8b185ac636" width="700" height="250">

Decryption <br>
<img src="https://github.com/mirgetagashi/DataSecurity/assets/154754089/1bbcda03-a836-4a66-9aed-1b8e3426cceb" width="700" height="250">











