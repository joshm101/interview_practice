package subsetsOfSet;
import java.util.*;

public class SubsetsOfSet {
  public static void main(String[] args) {
    ArrayList<Integer> set = new ArrayList<Integer>();
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);
    set.add(5);
    set.add(6);
    int originalSize = set.size();
    ArrayList<ArrayList<Integer>> allSubsets;
    allSubsets = subsetsOfSet(set, originalSize);
    for (int i = 0; i < allSubsets.size(); ++i) {
      for (int j = 0; j < allSubsets.get(i).size(); ++j) {
        System.out.print(allSubsets.get(i).get(j) + " ");
      }
      System.out.println("");
    }
  }
  
  public static ArrayList<ArrayList<Integer>> subsetsOfSet(ArrayList<Integer> set, int size) {
    if (size > 1) {
      // not yet bottomed out, recurse on smaller sized sets.
      ArrayList<ArrayList<Integer>> allSets = subsetsOfSet(set, size - 1);
      
      // obtain a copy of the currently computed subsets
      ArrayList<ArrayList<Integer>> currentSets = new ArrayList<ArrayList<Integer>>(allSets);
      
      // get newest digit to construct new subsets with
      int currentItem = set.get(size - 1);
      
      // iterate over the subsets we have already constructed
      for (int i = 0; i < currentSets.size(); ++i) {
        // each subset we come across, add our current digit to the subset and
        // save that new resulting subset to allSets.
        ArrayList<Integer> newSet = new ArrayList<Integer>(currentSets.get(i));
        newSet.add(currentItem);
        allSets.add(newSet);
      }
      // single element set of the current item from the set that was just processed.
      ArrayList<Integer> currentSetItem = new ArrayList<Integer>();
      currentSetItem.add(currentItem);
      allSets.add(currentSetItem);
      return allSets;
    } else {
      // bottom out base case.
      ArrayList<Integer> singleItem = new ArrayList<Integer>();
      
      // create a single element subset of the first item in our set.
      singleItem.add(set.get(0));
      
      // create the allSets ArrayList starting with a single, 1-element subset
      ArrayList<ArrayList<Integer>> allSets = new ArrayList<ArrayList<Integer>>();
      allSets.add(singleItem);
      return allSets;
    }
  }
}
