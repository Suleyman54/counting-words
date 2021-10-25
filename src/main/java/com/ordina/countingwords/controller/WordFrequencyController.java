package com.ordina.countingwords.controller;

import com.ordina.countingwords.model.WordFrequency;
import com.ordina.countingwords.service.WordFrequencyAnalyzer;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/v1/word-frequency")
public class WordFrequencyController {

    private final WordFrequencyAnalyzer wordFrequencyAnalyzerService;

    @Autowired
    public WordFrequencyController(WordFrequencyAnalyzer wordFrequencyAnalyzerService) {
        this.wordFrequencyAnalyzerService = wordFrequencyAnalyzerService;
    }

    @GET
    @Path("/calculate-highest-frequency")
    @Produces(MediaType.TEXT_PLAIN)
    public Response calculateHighestFrequency(@QueryParam("text") String text) {
        int highestFrequency = wordFrequencyAnalyzerService.calculateHighestFrequency(text);
        return Response.ok(highestFrequency)
                .build();
    }

    @GET
    @Path("/calculate-frequency-for-word")
    @Produces(MediaType.TEXT_PLAIN)
    public Response calculateFrequencyForWord(@QueryParam("text") String text,
                                              @QueryParam("word") String word){
        int frequency = wordFrequencyAnalyzerService.calculateFrequencyForWord(text, word);
        return Response.ok(frequency)
                .build();
    }

    @GET
    @Path("/calculate-most-frequent-n-words")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateMostFrequentNWords(@QueryParam("text") String text,
                                                @QueryParam("limit") int limit){
        List<WordFrequency> wordFrequencies = wordFrequencyAnalyzerService.calculateMostFrequentNWords(text, limit);
        return Response.ok(wordFrequencies)
                .build();
    }

}
