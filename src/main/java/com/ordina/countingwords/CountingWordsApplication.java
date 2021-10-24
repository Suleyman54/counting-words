package com.ordina.countingwords;

import com.ordina.countingwords.service.WordFrequencyAnalyzerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountingWordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountingWordsApplication.class, args);

		WordFrequencyAnalyzerService wordFrequencyAnalyzer = new WordFrequencyAnalyzerService();

		//System.out.println(wordFrequencyAnalyzer.calculateHighestFrequency("the sun shines over the lake"));
		System.out.println(wordFrequencyAnalyzer.calculateFrequencyForWord("The sun shines over the lake", "The"));
	}


}
