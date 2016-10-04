package binarySearchTree;

import java.util.*;

public class BinarySearchTree {
  private TreeNode root;
  
  public BinarySearchTree(TreeNode root) {
    this.root = root;
  }
  
  /**
   * returns the tree's root.
   * @return
   */
  public TreeNode getRoot() {
    return this.root;
  }
  
  /**
   * This function will check to see
   * if the tree contains a node
   * with the passed in value.
   * If the node exists, it will
   * be returned. Otherwise,
   * null will be returned.
   * @param val - find node with this value
   * @return
   */
  public TreeNode contains(int val) {
    TreeNode current = this.root;
    while (current != null) {
      if (val < current.getVal()) {
        // node we are looking for
        // should be in left subtree
        // because passed in value
        // is less than current node's
        // value.
        current = current.leftChild();
      } else {
        if (val > current.getVal()) {
          // node we are looking for
          // should be in right subtree
          // because passed in value
          // is greater than current node's
          // value.
          current = current.rightChild();
        } else {
          if (val == current.getVal()) {
            // node we are after exists in tree.
            break;
          }
        }
      }
    }
    // return the result of our search.
    // null if node not found, valid node if
    // found.
    return current;
  }
  
  /**
   * Function to find the in-order successor
   * of the passed in TreeNode, current.
   * The function will return the TreeNode
   * of the successor if it is found.
   * If there is no successor, null is
   * returned.
   * @param current
   * @return
   */
  public TreeNode findSuccessor(TreeNode current) {
    if (current.getParent() == null) {
      // we want to find the successor of the root node.
      
      if (current.rightChild() != null) {
        // return left child of current node's 
        // right child if it exists. 
        // return right child otherwise.
        if (current.rightChild().leftChild() != null) {
          return current.rightChild().leftChild();
        } else {
          return current.rightChild();
        }
      }
    }
    if (current.rightChild() != null) {
      if (current.rightChild().leftChild() != null) {
        // if the right child exists and the right
        // child has a left child, that is our successor
        return current.rightChild().leftChild();
      } else {
        // if not left child exists for the right child,
        // the right child is the successor
        return current.rightChild();
      }
    } else {
      // no right child, must move up tree
      // to find successor.
      TreeNode tmp = current;
      while (true) {
        if (tmp == null) return null; // root's parent reached, no successor.
        if (tmp == tmp.getParent().leftChild()) {
          // if we have found a node who's the left
          // child of its parent, the parent
          // is our current node's successor.
          return tmp.getParent();
        } else {
          // continue moving up tree.
          tmp = tmp.getParent();
        }
      }
    }
  }
  
  /**
   * Recursive function to print out the nodes
   * in-order. Visit the left child to print,
   * print current node, visit right child to print.
   * @param current
   */
  public void inOrderTraversal(TreeNode current) {
    if (current == null) return;
    inOrderTraversal(current.leftChild());
    System.out.print(current.getVal() + " ");
    inOrderTraversal(current.rightChild()); 
  }
  
  /**
   * Recursive function to print out the nodes
   * pre-order. Visit/print the current node,
   * visit/print the left child, and then
   * visit/print the right child.
   * @param current
   */
  public void preOrderTraversal(TreeNode current) {
    if (current == null) return;
    System.out.print(current.getVal() + " ");
    preOrderTraversal(current.leftChild());
    preOrderTraversal(current.rightChild());
  }
  
  /**
   * Recursive function to print out the nodes
   * post-order. Visit/print the left child,
   * visit/print the right child, and then
   * visit/print the current node.
   * @param current
   */
  public void postOrderTraversal(TreeNode current) {
    if (current == null) return;
    postOrderTraversal(current.leftChild());
    postOrderTraversal(current.rightChild());
    System.out.print(current.getVal() + " ");
  }
  
  /**
   * Prints out the nodes in the tree
   * via a breadth-first traversal
   */
  public void breadthFirstTraversal() {
    
    // this list will be used as a queue
    // to keep track of nodes in breadth
    // first order.
    List<TreeNode> breadthList = new ArrayList<TreeNode>();
    breadthList.add(this.root);
    
    while (!breadthList.isEmpty()) {
      // loop until there are no more nodes
      // in the tree
      
      // get node at front of queue
      TreeNode currentNode = breadthList.get(0);
      System.out.print(currentNode.getVal() + " ");
      
      // remove the processed node from the front of the queue
      breadthList.remove(0);
      
      // add next breadth level of nodes to the queue.
      if (currentNode.leftChild() != null) {
        breadthList.add(currentNode.leftChild());
      }
      if (currentNode.rightChild() != null) {
        breadthList.add(currentNode.rightChild());
      }
    }
    System.out.println();
  }
  
  /**
   * Recursive function that prints out the 
   * nodes in the tree via a depth-first 
   * traversal.
   */
  public void depthFirstTraversal(TreeNode current) {
    if (current == null) return;
    
    if (current.leftChild() == null && current.rightChild() == null) {
      // We have a leaf node, print and return (bottomed out)
      System.out.print(current.getVal() + " ");
      return;
    }
    
    // visit/print left child, visit/print right
    // child, and then print current node.
    depthFirstTraversal(current.leftChild());
    depthFirstTraversal(current.rightChild());
    System.out.print(current.getVal() + " ");
    return;
  }
  
  /**
   * This function will insert a node into
   * the proper location in the tree
   * using a binary search
   * 
   * @param toInsert - node to insert.
   */
  public void insertNode(TreeNode toInsert) {
    TreeNode current = this.root;
    
    if (current == null) {
      // our tree is empty, create the root.
      this.root = toInsert;
      return;
    }
    while (true) {
      if (toInsert.getVal() > current.getVal()) {
        // if value of node to insert is greater
        // than the current node in the tree
        
        if (current.rightChild() != null) {
          // if the right child exists, move to right child
          current = current.rightChild();
        } else {
          // if the right child does not exist, then the node
          // we want to insert will become the current node's
          // right child.
          current.setChild("right", toInsert);
          toInsert.setParent(current);
          break;
        }
      } else {
        // value of node to insert is <= current node
        // in the tree.
        
        if (toInsert.getVal() == current.getVal()) {
          // to keep things simple, no duplicates for now.
          System.out.println("Node not inserted, duplicate node exists.");
          return;
        }
        
        if (current.leftChild() != null) {
          // if the left child exists, move to left child.
          current = current.leftChild();
        } else {
          // if the left child does not exist, then the
          // node we want to insert will become the current node's
          // left child.
          current.setChild("left", toInsert);
          toInsert.setParent(current);
          break;
        }
      }
    }
  }
  
}
