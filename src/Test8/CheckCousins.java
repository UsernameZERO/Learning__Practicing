package Test8;

import BinaryTree.BinaryTreeNode;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class CheckCousins {
    static class BinaryTreeNode<T>{
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        public BinaryTreeNode(T data){
            this.data = data;
        }
    }
    /*
    Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether
    the two nodes are cousins of each other or not. Two nodes are said to be
    cousins of each other if they are at same level of the Binary Tree and have
    different parents.

    Time Complexity:
            Do it in O(n).

     Sample Input :
        5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
        2
        4
     Sample Output :
        true
     */

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode(5);
        BinaryTreeNode<Integer> b = new BinaryTreeNode(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode(10);
        BinaryTreeNode<Integer> d = new BinaryTreeNode(2);
        BinaryTreeNode<Integer> e = new BinaryTreeNode(3);
        BinaryTreeNode<Integer> f = new BinaryTreeNode(4);
        BinaryTreeNode<Integer> g = new BinaryTreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        e.right = g;

        System.out.println(isCousin(a,2,4));

    }
    static class Pair{
        int parent;
        int level;
        public Pair(int parent,int level){
            this.parent = parent;
            this.level = level;
        }

    }
    public static Pair ToknowParent(BinaryTreeNode<Integer> root,int node,int parent,int level){
        if (root == null) return null;
        if (root.data == node){
            return new Pair(parent,level);
        }
        Pair LeftParent = ToknowParent(root.left,node,root.data,level+1);
        if (LeftParent != null){
            return LeftParent;
        }
        return ToknowParent(root.right,node,root.data,level+1);
    }
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        Pair ParentforP = ToknowParent(root,p,-1,0);
        Pair ParentforQ = ToknowParent(root,q,-1,0);
        if (ParentforP == null || ParentforQ == null)
            return false;
        if (ParentforP.parent != ParentforQ.parent && ParentforP.level == ParentforQ.level){
            return true;
        }
        return false;

    }
}

