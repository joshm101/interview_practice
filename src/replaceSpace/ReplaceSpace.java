package replaceSpace;

public class ReplaceSpace {
  public static void main (String[] args) {
    String str = new String("this is my string with normal spaces");
    String spacesReplaced = replaceSpace(str);
    System.out.print("new string: ");
    System.out.println(spacesReplaced);
  }
  
  public static String replaceSpace(String s1) {
    String spaceStr = new String("%20");
    for (int i = 0; i < s1.length(); ++i) {
      if (s1.charAt(i) == ' ') {
        String prefix = s1.substring(0, i);
        String suffix = s1.substring(i+1, s1.length());
        prefix = prefix.concat(spaceStr);
        s1 = prefix.concat(suffix);
      }
    }
    return s1;
  }
}
