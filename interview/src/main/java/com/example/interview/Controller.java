package com.example.interview;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/main")
    public String main(@RequestParam(name = "word", required = false, defaultValue = "test")String word, Model model){
        String string = word;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++){
            hashMap.put(chars[i], hashMap.containsKey(chars[i]) ? hashMap.get(chars[i]) + 1 : 1);
        }

        int max = Collections.max(hashMap.values());
        char maxKey = 0;

        for(Map.Entry<Character, Integer> entry : hashMap.entrySet()){
            if(entry.getValue().equals(max))
                maxKey = entry.getKey();
        }
        model.addAttribute("word", maxKey);
        model.addAttribute("quantity", max);
        return "main";
    }
}
