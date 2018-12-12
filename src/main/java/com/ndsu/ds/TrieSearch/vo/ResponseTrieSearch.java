package com.ndsu.ds.TrieSearch.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResponseTrieSearch {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("message")
    private String message;
    @JsonProperty("matchedWords")
    private ArrayList<String> matchedWords;

    public ArrayList<String> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(ArrayList<String> matchedWords) {
        this.matchedWords = matchedWords;
    }
}
