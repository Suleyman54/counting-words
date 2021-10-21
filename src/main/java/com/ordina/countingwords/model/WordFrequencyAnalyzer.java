package com.ordina.countingwords.model;

import java.util.List;

public class WordFrequencyAnalyzer {
    public String text;
    public WordFrequency wordFrequency;
    List<WordFrequency> calculateMostFrequentNWords;

    public WordFrequencyAnalyzer(String text, WordFrequency wordFrequency, List<WordFrequency> calculateMostFrequentNWords) {
        this.text = text;
        this.wordFrequency = wordFrequency;
        this.calculateMostFrequentNWords = calculateMostFrequentNWords;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public WordFrequency getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(WordFrequency wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    public List<WordFrequency> getCalculateMostFrequentNWords() {
        return calculateMostFrequentNWords;
    }

    public void setCalculateMostFrequentNWords(List<WordFrequency> calculateMostFrequentNWords) {
        this.calculateMostFrequentNWords = calculateMostFrequentNWords;
    }

    public int calculateHighestFrequency(String text){
        return 1;
    }
    public String calculateFrequencyForWord (String text, String word) {
        return "print something";
    }


}
