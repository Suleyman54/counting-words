package com.ordina.countingwords.service;

import java.util.List;
import com.ordina.countingwords.model.WordFrequency;

public interface WordFrequencyAnalyzer {

    int calculateHighestFrequency(String text);

    int calculateFrequencyForWord(String text, String word);

    List<WordFrequency> calculateMostFrequentNWords(String text, int limit);

}
