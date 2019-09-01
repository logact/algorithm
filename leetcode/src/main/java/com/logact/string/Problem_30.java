package com.logact.string;

import java.util.*;

/**
 * @author: logact
 * @date: Created in 2019/9/1 16:16
 * @description:
 * difficult
 */

public class Problem_30 {
    /**
     * 这种方法太粗糙了。造成超时。
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<Integer>();
        if(s==null||words.length==0)return res;
        Set<String> set=getSet(words);
        for(String e:set){
            System.out.println("e "+e);
        }
        //   System.out.println(set.contains("barfoo"));
        int len=words.length*words[0].length();
        for(int i=0;i<=s.length()-len;i++){
            String ss=s.substring(i,i+len);

            if(set.contains(ss)){

                res.add(i);
            }
        }
        return res;

    }
    private Set<String> getSet(String[]words){
        Set<String> res=new HashSet<String>();
        Set<Integer> set =new HashSet<Integer>();
        getHelp(words,"",0,res,set);
        return res;
    }
    private void getHelp(String[]words,String aString,int l,Set<String> res,Set<Integer> set)     {
        if(l==words.length){
            System.out.println(aString);
            res.add(aString);
            return;
        }
        for(int i=0;i<words.length;i++){
            if(!set.contains(i)){
                String bString =aString+words[i];
                Set<Integer> copy=new HashSet<Integer>(set);
                copy.add(i);
                getHelp(words,bString,l+1,res,copy);
            }
        }
    }


    /**
     *使用两个hashMap
     * 依然超时：
     * 对hashMap的操作函数
     * getOrDefault()函数。
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res=new ArrayList<Integer>();
        if(s==null||words.length==0)return res;
        Map<String,Integer> allWords=new HashMap<String,Integer>();

        for(int i=0;i<words.length;i++){
            int value = allWords.getOrDefault(words[i], 0);
            allWords.put(words[i], value + 1);
        }
        int len = words.length*words[0].length();
        for(int i=0;i<=s.length()-len;i++){
            String candidate = s.substring(i,i+len);
            System.out.println("candidate:"+candidate);
            Map<String,Integer> tempWords=new HashMap<String,Integer>();
            boolean flag=false;
            for(int j=0;j<=candidate.length()-words[0].length();j+=words[0].length()){
                String word=candidate.substring(j,j+words[0].length());
                System.out.println("      word:"+word);
                if(allWords.containsKey(word)){
                    System.out.println("1");
                    int value = tempWords.getOrDefault(word,0);
                    tempWords.put(word, value + 1);
                    if(allWords.get(word)<tempWords.get(word)){
                        flag=false;
                        break;
                    }else{
                        flag=true;
                    }
                }else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                res.add(i);
            }


        }
        return res;
    }

    /**
     * 滑动窗口法。
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        if (s == null || words == null || words.length == 0)
            return new ArrayList<>();
        int wordLen = words[0].length();
        int len = words.length;
        int totalLen = wordLen * len;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        //把数组处理为Map提高检索速度
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer value = map.get(word);
                value++;
                map.put(word, value);
            } else {
                map.put(word, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < wordLen; i++) {
            int index = i;
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);
                if (!map.containsKey(word)) {
                    //遇到不匹配的单词，清空map2,重新开始匹配
                    map2.clear();
                    index = j + wordLen;
                } else {
                    Integer value2 = map2.get(word);
                    if (value2 == null) {
                        map2.put(word, 1);
                    } else if (value2.equals(map.get(word))) {
                        //遇到重复次数过多的单词，index右移到第一次重复的位置，map2删除右移的单词
                        String temp;
                        while (!(temp = s.substring(index, index + wordLen)).equals(word)) {
                            map2.put(temp, map2.get(temp) - 1);
                            index += wordLen;
                        }
                        //删除第一个重复的单词，当前单词次数不变
                        index += wordLen;
                    } else {
                        map2.put(word, value2 + 1);
                    }
                    //判断子串长度是否匹配，匹配则说明遇到了一个匹配的下标
                    //下标右移一个单词的位置，map2去掉第一个单词
                    if (j + wordLen - index == totalLen) {
                        res.add(index);
                        String firstWord = s.substring(index, index + wordLen);
                        map2.put(firstWord, map2.get(firstWord) - 1);
                        index += wordLen;
                    }
                }
            }
            map2.clear();
        }
        return res;
    }
}

