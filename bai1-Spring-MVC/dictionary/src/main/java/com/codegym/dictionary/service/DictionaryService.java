package com.codegym.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    private final Map<String, String> dictionary;

    public DictionaryService() {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("love", "yêu");
        dictionary.put("house", "nhà");
    }

    public String translate(String word) {
        return dictionary.getOrDefault(word.toLowerCase(), null);
    }
}
