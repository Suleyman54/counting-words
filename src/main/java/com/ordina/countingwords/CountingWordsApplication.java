package com.ordina.countingwords;

import com.ordina.countingwords.controller.WordFrequencyController;
import com.ordina.countingwords.service.WordFrequencyAnalyzerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CountingWordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountingWordsApplication.class, args);

		WordFrequencyAnalyzerService wordFrequencyAnalyzer = new WordFrequencyAnalyzerService();
//		WordFrequencyController wordFrequencyController = new WordFrequencyController(wordFrequencyAnalyzer);


		//System.out.println(wordFrequencyAnalyzer.calculateHighestFrequency("the sun shines over the lake"));
//		System.out.println(wordFrequencyAnalyzer.calculateFrequencyForWord("The sun shines over the lake", "the"));
//		System.out.println(wordFrequencyAnalyzer.calculateHighestFrequency("The sun shines over the lake"));
		System.out.println(wordFrequencyAnalyzer.calculateMostFrequentNWords("The sun shines over the lake", 3));


	}


}
