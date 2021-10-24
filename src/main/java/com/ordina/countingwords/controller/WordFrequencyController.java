package com.ordina.countingwords.controller;

import com.ordina.countingwords.model.WordFrequency;
import com.ordina.countingwords.service.WordFrequencyAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/word-frequency")
public class WordFrequencyController {

    private final WordFrequencyAnalyzer wordFrequencyAnalyzerService;

    @Autowired
    public WordFrequencyController(WordFrequencyAnalyzer wordFrequencyAnalyzerService) {
        this.wordFrequencyAnalyzerService = wordFrequencyAnalyzerService;
    }

    @GetMapping("/calculate-highest-frequency")
    public int calculateHighestFrequency(@RequestParam(required = false) String text) {
        return wordFrequencyAnalyzerService.calculateHighestFrequency(text);
    }

    @GetMapping("/calculate-frequency-for-word")
    public int calculateFrequencyForWord(@RequestParam (required = false) String text,
                                         @RequestParam String word){

        return wordFrequencyAnalyzerService.calculateFrequencyForWord(text, word);
    }

    @GetMapping("/calculate-most-frequent-n-words")
    public List<WordFrequency> calculateMostFrequentNWords(@RequestParam (required = false) String text,
                                                           @RequestParam int limit){

        return wordFrequencyAnalyzerService.calculateMostFrequentNWords(text, limit);
    }

}
