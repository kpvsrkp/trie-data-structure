package com.ndsu.ds.TrieSearch.vo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TrieNode {
    private static final Logger LOGGER = LogManager.getLogger(TrieNode.class);

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public HashMap<Character, TrieNode> getChild() {
        return child;
    }

    public void setChild(HashMap<Character, TrieNode> child) {
        this.child = child;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    char character;
    HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    //private static TrieNode instance;
    public TrieNode() {}
    public TrieNode(char character){
        this.character = character;
    }

    /*public static TrieNode getInstance(){
        LOGGER.info("getting instance");

        //if(instance==null){
            LOGGER.info("getting instance");
            instance = new TrieNode();
        //}
        return instance;

    }*/
}
