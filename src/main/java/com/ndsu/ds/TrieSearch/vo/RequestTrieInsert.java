package com.ndsu.ds.TrieSearch.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class RequestTrieInsert {

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @JsonProperty("keyword")
    private String keyWord;
}
