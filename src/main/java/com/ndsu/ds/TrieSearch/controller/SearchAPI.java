package com.ndsu.ds.TrieSearch.controller;

import com.ndsu.ds.TrieSearch.cache.CacheHelper;
import com.ndsu.ds.TrieSearch.helper.TrieHandler;
import com.ndsu.ds.TrieSearch.startup.StartupApplicationListener;
import com.ndsu.ds.TrieSearch.vo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

//@Controller
@RestController
@RequestMapping("/search")
public class SearchAPI {
    private static final Logger LOGGER = LogManager.getLogger(SearchAPI.class);

    @Autowired
    TrieHandler trieHandler;

    //@GetMapping("get")
    @CrossOrigin
    @PostMapping(path = "/get", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchWord(@RequestBody RequestTrieSearch req)
    {
        LOGGER.info("In Search word action keyword "+req.getKeyWord());
        ResponseTrieSearch responseTrieSearch = trieHandler.searchWord(req.getKeyWord());
        return new ResponseEntity<>(responseTrieSearch, HttpStatus.OK);
    }

    @PostMapping(path = "/add", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addWord(@RequestBody RequestTrieInsert req){
        LOGGER.info("In addWord req "+req.getKeyWord());
        ResponseTrieInsert responseTrieInsert = trieHandler.addWord(req.getKeyWord());
        return new ResponseEntity<>(responseTrieInsert, HttpStatus.OK);
    }

    @GetMapping(path = "/count", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity CountOfWords(){
        LOGGER.info("In CountOfWords");
        //ResponseTrieInsert responseTrieInsert = trieHandler.addWord(req.getKeyWord());
        HashMap<String,Long> map = new HashMap<String,Long>();
        map.put("count", CacheHelper.totalWords);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
