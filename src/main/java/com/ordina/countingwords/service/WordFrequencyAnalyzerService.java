package com.ordina.countingwords.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.ordina.countingwords.model.WordFrequency;

@Service
public class WordFrequencyAnalyzerService implements WordFrequencyAnalyzer {

    //CalculateHighestFrequency should return the highest frequency in the text (several
    //words might have this frequency)
    @Override
    public int calculateHighestFrequency(String text) {
        if (text == null || text.isEmpty())
            return 0;

        String[] words = text.split("\\s+[a-zA-Z]");

        int finalCount = 0;
        int tempCount = 0;

        String highestFrequency = null;

        for (String word : words) {
            tempCount = 0;
            for (String w : words) {
                if (word.equalsIgnoreCase(w)) {
                    tempCount++;
                }
            }
            if (tempCount >= finalCount) {
                finalCount = tempCount;
                highestFrequency = word;
            }
        }

        return finalCount;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        String[] splittedWords = text.split("\\s+");

        int count = 0;
        for (int i = 0; i < splittedWords.length; i++) {
            String splittedWord = splittedWords[i];

            if (!splittedWord.matches(".*\\d.*")) {

                if (word.equalsIgnoreCase(splittedWord)) {
                    count++;
                }

            }
        }
        return count;
    }

    // something like this but then in Java
    //def count_occurrences(word, sentence):
    //return sentence.lower().split().count(word)
    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int limit) {
        Map<String, Integer> myMap = new HashMap<String, Integer>();

        List<WordFrequency> wordFrequencies = new ArrayList<>();
        wordFrequencies.add(new WordFrequency("hello", 1));

        return wordFrequencies;
    }
}
