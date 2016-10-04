package binarySearchTree;

public class TreeNode {
  private int val;
  private TreeNode left;
  private TreeNode right;
  private TreeNode parent;
  
  public TreeNode(int val) {
    this.val = val;
  }
  
  /**
   * Get the current node's value.
   * @return
   */
  public int getVal() {
    return this.val;
  }
  
  /**
   * Get the current node's left child.
   * If left child does not exist,
   * null will be returned.
   * @return
   */
  public TreeNode leftChild() {
    return this.left;
  }
  
  /**
   * Get the current node's right child.
   * If right child does not exist,
   * null will be returned.
   * @return
   */
  public TreeNode rightChild() {
    return this.right;
  }
  
  /**
   * Get the current node's parent.
   * If the parent does not exist,
   * null will be returned.
   * In a binary search tree, this would
   * mean we are currently at the root node.
   * @return
   */
  public TreeNode getParent() {
    return this.parent;
  }
  
  public void setParent(TreeNode parent) {
    this.parent = parent;
  }
  
  /**
   * Set value of current node.
   * @param value - update node with this value
   */
  public void setVal(int value) {
    this.val = value;
  }
  
  /**
   * Sets one of current node's children.
   * @param leftOrRight - string indicating which
   *                      child we are setting
   * @param child - one of current node's children will
   *                be set to this node.
   */
  public void setChild(String leftOrRight, TreeNode child) {
    switch (leftOrRight) {
    case "left":
      this.left = child;
      break;
    case "right":
      this.right = child;
      break;
    }
  }
}
