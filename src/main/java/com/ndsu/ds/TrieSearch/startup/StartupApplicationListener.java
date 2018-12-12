package com.ndsu.ds.TrieSearch.startup;


import com.ndsu.ds.TrieSearch.cache.CacheHelper;
import com.ndsu.ds.TrieSearch.helper.TrieHandler;
import com.ndsu.ds.TrieSearch.vo.TrieNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LogManager.getLogger(StartupApplicationListener.class);

    @Autowired
    TrieHandler trieHandler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("In onApplicationEvent");
        TrieNode node =  new TrieNode();
        CacheHelper.rootNodeMap.put("root",node);
        LOGGER.info("After getting root Node");

    }
}
