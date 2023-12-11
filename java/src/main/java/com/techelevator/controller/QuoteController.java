package com.techelevator.controller;


import com.techelevator.model.Quote;
import com.techelevator.services.RestQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class QuoteController {

@Autowired
    private RestQuoteService restQuoteService;

    @GetMapping("/api/quote/random")
    public ResponseEntity<Quote> getRandomQuote() {
        Quote randomQuote = restQuoteService.getQuote();
        return new ResponseEntity<>(randomQuote, HttpStatus.OK);
    }
}

