import com.sun.jdi.connect.Connector;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] givenFirst = {"papa", "happy", "4cro4cor4", "birthday", "coco", "uuoonn", "me!"};
        Set<Character> uniqueCharacterSet = findWordsWithDoublingLetters(givenFirst);

        System.out.println("Given array contains 2 words with the even number of charecters, where " + uniqueCharacterSet.size() +
                " unique characters as " + String.valueOf(uniqueCharacterSet));
    }

    public static Set<Character> findWordsWithDoublingLetters(String[] array) throws Exception {
        if (array.length < 2){
            throw new Exception("Given array length should be 2 or more.");
        }
        Set<String> checkedWords = new HashSet();
        for(int i= 0; i < array.length; i++){
            if(checkedWords.size() < 2 && CheckWordWithEvenNumbersOfChar(array[i])){
                checkedWords.add(array[i]);
            }
        }
        if (checkedWords.size() < 2){
            throw new Exception("Task cann't be finished because there were found less than 2 words.");
        }
        return FindUniqueCharacter(checkedWords);
    }

    public static boolean CheckWordWithEvenNumbersOfChar(String word)
    {
        Map<Character, Integer> charsSet = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            if (charsSet.containsKey(word.charAt(i))){
                charsSet.put(word.charAt(i), charsSet.get(word.charAt(i)) + 1);
            } else {
                charsSet.put(word.charAt(i), 1);
            }
        }
        for(Integer value : charsSet.values()){
            if(value % 2 != 0){
                return false;
            }
        }
        return true;
    }

    public static Set<Character> FindUniqueCharacter(Set<String> words){
        Set<Character> uniqueCharacters = new HashSet<>();
        for(String word : words){
            for(Character character : word.toCharArray()){
                uniqueCharacters.add(character);
            }
        }
        return uniqueCharacters;
    }
}