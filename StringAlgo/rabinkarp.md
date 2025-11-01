


```` java 
 public class KarpRabin {
    private final int PRIME = 101;
    // Calculate hash for a string
    private long calculateHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = hash + str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    // Update hash for next substring window
    private long updateHash(long prevHash, char oldChar, char newChar, int patternLength) {
        long newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    // Search for pattern in text
    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) {

            // Check if hash matches, then compare substring
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            
             
            // Update hash for next window
            if (i < text.length() - patternLength) {
                textHash = updateHash(
                    textHash,
                    text.charAt(i),                          // old character leaving the window
                    text.charAt(i + patternLength),          // new character entering the window
                    patternLength
                );
            }
        }
    }

    // Main function to test
    public static void main(String[] args) {
        KarpRabin rk = new KarpRabin();
        rk.search("ABCCDDAEFG", "CDD");
    }
}
````