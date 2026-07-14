package com.treebfs;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Step 1: Put all dictionary words into a HashSet for lightning-fast O(1) lookups
        Set<String> wordSet = new HashSet<>(wordList);
        
        // Edge Case: If the target word isn't even in the dictionary, it's impossible to reach
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Initialize our queue and push the starting word into the line
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // We count the number of words in the sequence. The start word itself counts as level 1.
        int levels = 1;

        // Step 2: The Trusted BFS Skeleton Loop
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Clear out the current mutation level wave completely
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();

                // MAGIC MOMENT: If we pulled our target word out of line, we are finished!
                if (currentWord.equals(endWord)) {
                    return levels;
                }

                // Generate all possible 1-letter mutation neighbors
                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char originalChar = charArray[j]; // Save the original letter to restore it later

                    // Try replacing the character at slot j with every letter from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue; // Skip swapping to the exact same letter

                        charArray[j] = c;
                        String mutatedWord = String.valueOf(charArray);

                        // If the mutated word is a valid destination in our dictionary
                        if (wordSet.contains(mutatedWord)) {
                            queue.add(mutatedWord); // Line it up for the next wave
                            wordSet.remove(mutatedWord); // Visited check: remove it so we never process it again!
                        }
                    }

                    charArray[j] = originalChar; // Restore the letter before moving to the next position
                }
            }
            
            // Increment our sequence step count as we move to the next layer of mutations
            levels++;
        }

        return 0; // If the queue runs dry and we never hit the endWord, no path exists
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println("Shortest chain length: " + ladderLength(beginWord, endWord, wordList));
        // Expected Output: 5
        // The chain is: hit -> hot -> dot -> dog -> cog (5 words total)
    }
}