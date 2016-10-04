package binarySearchTree;

public class Client {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(31);
    BinarySearchTree tree = new BinarySearchTree(root);
    System.out.println("tree root value is: " + tree.getRoot().getVal());
    TreeNode toInsert = new TreeNode(23);
    tree.insertNode(toInsert);
    System.out.println("root's left child: " + root.leftChild().getVal());
    tree.insertNode(new TreeNode(55));
    tree.insertNode(new TreeNode(15));
    tree.insertNode(new TreeNode(44));
    tree.insertNode(new TreeNode(26));
    tree.inOrderTraversal(tree.getRoot());
    System.out.println("");
    System.out.println("***");
    System.out.println("");
    tree.breadthFirstTraversal();
    int toFind = 26;
    TreeNode result = tree.contains(toFind);
    if (result != null) {
      System.out.println("found: " + result.getVal());
    } else {
      System.out.println("no such node exists in tree: " + toFind);
    }
    
    /*System.out.println("***");
    System.out.println("");
    tree.depthFirstTraversal(tree.getRoot());
    System.out.println("");
    */
    System.out.println("***");
    System.out.println("");
    tree.preOrderTraversal(tree.getRoot());
    System.out.println("");
    System.out.println("***");
    System.out.println("");
    tree.postOrderTraversal(tree.getRoot());
    System.out.println("");
    
    TreeNode found = tree.contains(31);
    TreeNode successor = tree.findSuccessor(found);
    if (successor != null) {
      System.out.println("Found successor of " + found.getVal() + ": " + successor.getVal());
    } else {
      System.out.println("no successor for " + found.getVal() + " found");
    }
  }
}
