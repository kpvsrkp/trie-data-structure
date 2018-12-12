package com.ndsu.ds.TrieSearch.cache;

import com.ndsu.ds.TrieSearch.vo.TrieNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Scope("singleton")
public class CacheHelper {
    public static HashMap<String, TrieNode>  rootNodeMap= new HashMap<String, TrieNode>();
    public static Long totalWords = 0L;
    //public static TrieNode rootNode  = new TrieNode();
}
