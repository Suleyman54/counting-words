package com.ordina.countingwords.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ordina.countingwords.model.WordFrequency;

@Service
public class WordFrequencyAnalyzerService implements WordFrequencyAnalyzer {

    @Override
    public int calculateHighestFrequency(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Map<String, Integer> words = countWords(text);
        return Collections.max(words.values());
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        if (text == null || text.isEmpty() || word == null || word.isEmpty())
            return 0;

        return countWords(text)
                .getOrDefault(word.toLowerCase(), 0);
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int limit) {
        if (text == null || text.isEmpty() || limit <= 0) {
            return Collections.emptyList();
        }

        Map<String, Integer> words = countWords(text);
        List<WordFrequency> wordFrequencies = new ArrayList<>();

        for (Entry<String, Integer> entry : words.entrySet()){
            wordFrequencies.add(new WordFrequency(entry.getKey(), entry.getValue()));
        }

        wordFrequencies.sort(Comparator.comparing(WordFrequency::getWord));
        wordFrequencies.sort(Comparator.comparingInt(WordFrequency::getFrequency).reversed());

        return wordFrequencies.subList(0, limit);
    }

    private Map<String, Integer> countWords(String text){
        Map<String,Integer> wordsToFrequency = new HashMap<>();

        String[] splittedWords = text.split("\\s");
        for (String splittedWord : splittedWords) {
            if (!splittedWord.matches(".*\\d.*")) {
                String word = splittedWord.toLowerCase();

                if (wordsToFrequency.containsKey(word)) {
                    wordsToFrequency.put(word, wordsToFrequency.get(word) + 1);
                } else {
                    wordsToFrequency.put(word, 1);
                }
            }
        }
        return wordsToFrequency;
    }

}
