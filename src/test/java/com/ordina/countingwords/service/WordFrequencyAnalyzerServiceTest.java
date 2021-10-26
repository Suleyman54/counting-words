package com.ordina.countingwords.service;

import com.ordina.countingwords.model.WordFrequency;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordFrequencyAnalyzerServiceTest {

    WordFrequencyAnalyzer wordFrequencyAnalyzer =
            new WordFrequencyAnalyzerService();

    @Test
    void shouldGiveHighestFrequency(){
        assertEquals(2,
                wordFrequencyAnalyzer.
                        calculateHighestFrequency("The sun shines over the lake"));
    }

    @Test
    void shouldCalculateFrequencyForWord(){
        assertEquals(2,
                wordFrequencyAnalyzer.
                        calculateFrequencyForWord("The sun shines over the lake", "The"));
    }

    @Test
    void shouldCalculateMostFrequentNWords(){
        List<WordFrequency> wordFrequencies = wordFrequencyAnalyzer.calculateMostFrequentNWords("The sun shines over the lake", 3);

        assertEquals(wordFrequencies.size(), 3);
        assertEquals(wordFrequencies.get(0).getWord(), "the");
        assertEquals(wordFrequencies.get(0).getFrequency(), 2);
        assertEquals(wordFrequencies.get(1).getWord(), "lake");
        assertEquals(wordFrequencies.get(1).getFrequency(), 1);
        assertEquals(wordFrequencies.get(2).getWord(), "over");
        assertEquals(wordFrequencies.get(2).getFrequency(), 1);
    }

}