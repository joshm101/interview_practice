package isRotation;

public class IsRotation {
  public static void main(String[] args) {
    String s1 = new String("waterbottle");
    String s2 = new String("erbottlewat");
    boolean result = isRotation(s2, s1);
    System.out.println(s2 + " is a rotation of " + s1 + ": " + result);
  }
  
  public static boolean isRotation(String s2, String s1) {
    if (s1.length() != s2.length()) return false;
    
    // boolean flag to determine whether a substring
    // check is necessary
    boolean useSubstring = false;
    
    // s1Pos tells us the current
    // iteration position of string s1
    int s1Pos = 0;
    
    // substringEndIndex tells us where to take a
    // substring from on s2 in the range [0...substringEndIndex]
    int substringEndIndex = 0;
    for (int i = 0; i < s2.length(); ++i) {
      // iterate over string s2
      
      if (s1.charAt(s1Pos) == s2.charAt(i)) {
        // characters match from both strings
        
        // move s1 index 1 position over
        ++s1Pos;
        
        // if this is the first character we have found
        // or if we just found the first character
        // of s1 in s2 (again), we set the end index
        // to the current index of s2.
        if (useSubstring == false) substringEndIndex = i;
        useSubstring = true;
      } else {
        // no match        
        useSubstring = false;
        
        // reset s1Pos to 0 so that we can see if the
        // start of s1 occurs further down the string s2.
        s1Pos = 0; 
      }
    }
    if (useSubstring == true) {
      
      // if s2[0, substringEndIndex] is a substring of s1, we have a rotation
      if (s1.contains(s2.substring(0, substringEndIndex)) == true) return true;
    }
    return false;
  }
}
