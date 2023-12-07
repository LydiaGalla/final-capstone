package com.techelevator.services;


import com.techelevator.model.Quote;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestQuoteService implements QuoteService {
    String API_BASE_URL = "https://zenquotes.io/api/random/";

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Quote getQuote() {
        String url = API_BASE_URL + "/api/random";
        return restTemplate.getForObject(url, Quote.class);


    }
}
