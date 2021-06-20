package BinaryTree;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> TakeInputBest(boolean isroot,int parentData,boolean isleft){
		if(isroot) {
			System.out.println("Enter Root data");
		}else {
			if(isleft) {
				System.out.println("Enter Left Child " + parentData);
			}else {
				System.out.println("Enter Right Child " + parentData);
			}
		}
		Scanner s = new Scanner(System.in);
		int rootdata = s.nextInt();
		if(rootdata == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		root.left = TakeInputBest(false,rootdata,true);
		root.right = TakeInputBest(false,rootdata,false);
	
		return root;
	}
	
	public static BinaryTreeNode<Integer> TakeInput(){
		Scanner s = new Scanner(System.in);
		int rootdata = s.nextInt();
		if(rootdata == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		BinaryTreeNode<Integer> leftChild = TakeInput();
		BinaryTreeNode<Integer> rightChild= TakeInput();
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " : ");
		if(root.left!=null) {
			System.out.print("L" + root.left.data+", ");
		}
		if(root.right!=null) {
			System.out.print("R" + root.right.data+", ");
		}
		System.out.println();
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
		
	}
	
	public static int sumNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		return (root.data + sumNode(root.left)+sumNode(root.right));
	}
	
	public static int numNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftcount = numNode(root.left);
		int rightcount = numNode(root.right);
		return 1 + leftcount+rightcount;
	}
	
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		if(root == null) {
			return 0;
		}
		int count =0;
		 if(root.data>x) {
				count++;
			}
			int l = countNodesGreaterThanX(root.left, x);
			int r = countNodesGreaterThanX(root.right,x);
			return count + l + r ;
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        int cl = 1+l;
        int cr = 1+r;
        if(cl>cr){
            return cl;
        }
        return cr;
	}
	
	public static int height1(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int l = height1(root.left);
		int r = height1(root.right);
		return 1 + Math.max(l,r);
	}
	
	public static int numLeaves(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		return numLeaves(root.left)+numLeaves(root.right);
	}

	public static void DepthOfK(BinaryTreeNode<Integer> root,int k) {
		if(root == null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
			return;
		}
		DepthOfK(root.left,k-1);
		DepthOfK(root.right, k-1);
	}
	
	public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		if(root.left == null && root.right == null) {
			return null;
		}
		removeLeaf(root.left);
		removeLeaf(root.right);
		return root;
	}

	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		if(root == null) {
			return;
		}
		mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
      	BinaryTreeNode<Integer>  temp = root.left;
        root.left = root.right;
        root.right = temp;
//		Queue<BinaryTreeNode<Integer>> qu = new LinkedList<>();
//		qu.add(root);
//		while(qu.size()>0) {
//			BinaryTreeNode<Integer> cur = qu.peek();
//			qu.remove();
//			
//			BinaryTreeNode<Integer> temp = cur.left;
//			cur.left = cur.right;
//			cur.right = temp;
//			if(cur.left!=null) {
//				qu.add(cur.left);
//			}
//			if(cur.right != null) {
//				qu.add(cur.right);
//			}
//		}
		
	}
	
	public static boolean BalancedTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int l = height1(root.left);
		int r = height(root.right);
		if(Math.abs(l-r) > 1) {
			return false;
		}
		boolean left = BalancedTree(root.left);
		boolean right = BalancedTree(root.right);
		return left && right;
	}
	
	public static TreeBalanced isBalanced(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			int height =0;
			boolean isbals = true;
			TreeBalanced ans = new TreeBalanced();
			ans.height = height;
			ans.balanced = isbals;
		}
		TreeBalanced left = isBalanced(root.left);
		TreeBalanced right = isBalanced(root.right);
		boolean isbals = true;
		int height = 1+ Math.max(left.height, right.height);
		if(Math.abs(left.height - right.height) > 1) {
			isbals = false;
		}
		if(!left.balanced || !right.balanced) {
			isbals = false;
		}
		TreeBalanced res = new TreeBalanced();
		res.height = height;
		res.balanced = isbals;
		return res;
		
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> b = TakeInputBest(true,0,true);
		
//		printTreeDetailed(b);
//		preOrder(b);
//		postOrder(b);
		System.out.println(countNodesGreaterThanX(b, 2));
	//	System.out.println(numNode(b));
//		System.out.println(sumNode(b));

	}

}
