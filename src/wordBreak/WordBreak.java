package wordBreak;

import java.util.*;

public class WordBreak {
  public static void main(String[] args) {
    String dictWords = new String("lr m lrm hcdar wk");
    String[] wordsArr = dictWords.split(" ");
    String src = new String("hcdarlrm");
    String sent = new String("");
    Map<String, String> wordsDict = new HashMap<String, String>();
    for (int i = 0; i < wordsArr.length; ++i) {
      wordsDict.put(wordsArr[i], wordsArr[i]);
    }
    constructSentence(src, wordsDict, sent);
    System.out.println("");
  }
  
  public static void constructSentence(String src,
                                       Map<String, String> dict,
                                       String sent) {
    if (src.equals("")) return;
    String possibleWord = new String("");
    
    // iterate over the current substring src
    for (int i = 0; i < src.length(); ++i) {
      
      // construct a possible word by concatenating a character
      // from src to our possibleWord variable
      possibleWord = possibleWord + src.charAt(i);
      if (dict.containsKey(possibleWord)) {
        // if the possibleWord is a valid word in our dictionary
        // concatenate to our sentence, sentenceContinue
        String sentenceContinue = sent + " " + possibleWord;
        if (i == src.length() - 1) {
          // we found a word and there are no more characters
          // to process, we have a sentence to print.
          System.out.print("(" + sentenceContinue + ")");
        } else {
          // recurse on the rest of the string.
          constructSentence(src.substring(i+1, src.length()),
                            dict, sentenceContinue);
        }
      }
      // it's important to see that we recurse on the substring,
      // but we continue to look at the current string in our loop
      // until it is exhausted.
      // this allows us to catch snakes and ladders & snake sand ladder
      // because we don't stop once we find "snake" in the string "snakesandladder".
      // When "snake" is found, we recurse on "sandladder", but the loop continues
      // so that we also find "snakes" and recurse on "andladder"
    }
  }  
}
