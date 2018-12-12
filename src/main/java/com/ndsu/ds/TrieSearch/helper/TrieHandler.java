package com.ndsu.ds.TrieSearch.helper;

import com.ndsu.ds.TrieSearch.cache.CacheHelper;
import com.ndsu.ds.TrieSearch.vo.ResponseTrieInsert;
import com.ndsu.ds.TrieSearch.vo.ResponseTrieSearch;
import com.ndsu.ds.TrieSearch.vo.TrieNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope("singleton")
public class TrieHandler {
    private static final Logger LOGGER = LogManager.getLogger(TrieHandler.class);
    private static ArrayList<String> suggestions = new ArrayList<String>();
    @Autowired
    public TrieNode getRootNode(){
        LOGGER.info("getting root node");
        TrieNode root = CacheHelper.rootNodeMap.get("root");
        LOGGER.info("returning the instance");
        return root;
    }

    public ResponseTrieSearch searchWord(String keyWord) {
        suggestions.clear();
        LOGGER.info("In searchword "+keyWord);
        ResponseTrieSearch responseTrieSearch = null;
        TrieNode prefixNode = this.searchNode(keyWord);
        if(prefixNode!=null){
            LOGGER.info("getting suggestions");
            this.getSuggestions(prefixNode,keyWord);
            responseTrieSearch = new ResponseTrieSearch();
            responseTrieSearch.setMatchedWords(suggestions);
            responseTrieSearch.setMessage("Retrived all matches");
        }
        else{
            LOGGER.info("no further suggestions");
            responseTrieSearch = new ResponseTrieSearch();
            responseTrieSearch.setMessage("No matching words found");
        }
        return responseTrieSearch;
    }

    private void getSuggestions(TrieNode prefixNode, String keyWord) {

        LOGGER.info("Getting suggestions for "+keyWord);

        if(prefixNode.isLeaf()){
            LOGGER.info("suggestion "+keyWord);
            suggestions.add(keyWord);
        }

        if (isLastNode(prefixNode)){
            LOGGER.info("This is isLastNode");
            return;
        }

        for (Map.Entry<Character, TrieNode> entry : prefixNode.getChild().entrySet() )
        {
            LOGGER.info("key value "+entry.getKey());
            //keyWord = keyWord + prefixNode.getChild().get(entry.getKey()).getCharacter();
            //getSuggestions(prefixNode.getChild().get(entry.getKey()),keyWord);
            getSuggestions(prefixNode.getChild().get(entry.getKey()),keyWord + prefixNode.getChild().get(entry.getKey()).getCharacter());
        }
    }

    private boolean isLastNode(TrieNode prefixNode) {
        if(prefixNode.getChild().size() == 0){

            return true;
        }
        else
            return false;
    }


    public TrieNode searchNode(String str){
        LOGGER.info("searching keyWord "+str);
        TrieNode root = this.getRootNode();
        LOGGER.info("got root");
        Map<Character, TrieNode> children = root.getChild();
        TrieNode node = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                LOGGER.info("in if for "+c);
                node = children.get(c);
                children = node.getChild();

            }else{
                LOGGER.info("in else ");
                return null;
            }
        }

        return node;
    }

    public ResponseTrieInsert addWord(String keyWord){
        LOGGER.info("Adding keyWord "+keyWord);
        TrieNode rootNode = this.getRootNode();
        HashMap<Character, TrieNode> children = rootNode.getChild();
        TrieNode t;
        for(int i=0; i<keyWord.length(); i++){
            char c = keyWord.charAt(i);
            LOGGER.info("char value "+c);
            //TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
                LOGGER.info("charecter "+c+" exist in node");
            }
            else
            {
                t = new TrieNode(c);
                LOGGER.info("created new node");
                children.put(c,t);
            }

            LOGGER.info("Going down next level");
            children = t.getChild();

            if( i == keyWord.length()-1){
                t.setLeaf(true);
            }


        }
        LOGGER.info("Added keyWord "+keyWord);
        this.updateCacheCount();
        ResponseTrieInsert responseTrieInsert = new ResponseTrieInsert();
        responseTrieInsert.setMessage("Added succesfully");
        return responseTrieInsert;
    }

    private void updateCacheCount() {

        LOGGER.info("Current count "+CacheHelper.totalWords);
        Long temp = CacheHelper.totalWords;
        temp++;
        CacheHelper.totalWords = temp;
    }
}
