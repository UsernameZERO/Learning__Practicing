package BinaryTree1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse1 {

	public static BinaryTreeNode1<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		 int data = s.nextInt();
		 BinaryTreeNode1<Integer> root = new BinaryTreeNode1<Integer>(data);
		 Queue<BinaryTreeNode1<Integer>> PendingChild = new LinkedList<BinaryTreeNode1<Integer>>();
		 PendingChild.add(root);
		 while(!PendingChild.isEmpty()) {
			 BinaryTreeNode1<Integer> front = PendingChild.poll();
			 System.out.println("Enter Left Child :" );
			 int left = s.nextInt();
			 if(left!=-1) {
				 BinaryTreeNode1<Integer> Lchild = new BinaryTreeNode1<>(left);
				 front.left = Lchild;
				 PendingChild.add(Lchild);
			 }
			 System.out.println("Enter Right Child :");
			 int right= s.nextInt();
			 if(right!=-1) {
				 BinaryTreeNode1<Integer> Rchild = new BinaryTreeNode1<Integer>(right);
				 front.right = Rchild;
				 PendingChild.add(Rchild);
			 }
		 }
		 return root;
	}
	public static void print(BinaryTreeNode1<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " : ");
		if(root.left!=null) {
			System.out.print("L " + root.left.data + "," );
		}
		if(root.right!=null) {
			System.out.print("R "+ root.right.data + ",");
		}
		System.out.println();
		print(root.left);
		print(root.right);
	}
	
	public static void printLevelWise(BinaryTreeNode1<Integer> root) {
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode1<Integer>> pc = new LinkedList<BinaryTreeNode1<Integer>>();
		pc.add(root);
		while(!pc.isEmpty()) {
			BinaryTreeNode1<Integer> front = pc.peek();
			System.out.print(front.data +":");
			pc.remove();
			if(front.left!=null) {
				pc.add(front.left);
				System.out.print("L:"+front.left.data+",");
			}else {
				System.out.print("L:-1" + ",");
			}
			if(front.right !=null) {
				pc.add(front.right);
				System.out.print("R:"+front.right.data);
			}else {
				System.out.print("R:-1");
			}
			System.out.println();
		}
	}
	public static void printLevelWisee(BinaryTreeNode1<Integer> root) {
		//Your code goes here
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode1<Integer>> pc = new LinkedList<BinaryTreeNode1<Integer>>();
		pc.add(root);
		while(true) {
			int count = pc.size();
			if(count ==0) {
				break;
			}
			while(count>0) {
				BinaryTreeNode1<Integer> front = pc.peek();
				System.out.print(front.data+" ");
				pc.remove();
				if(front.left!=null) {
					pc.add(front.left);
				}
				if(front.right !=null) {
					pc.add(front.right);
				}
				count--;
			}
			System.out.println();
		}
	}
	
	public static void insertDuplicateNode(BinaryTreeNode1<Integer> root) {
		BinaryTreeNode1<Integer> L;
		if(root == null) {
			return;
		}
		insertDuplicateNode(root.left);
		insertDuplicateNode(root.right);
		L = root.left;
		root.left = new BinaryTreeNode1<Integer>(root.data);
		root.left.left = L;
		
	}
	 public static void inOrder(BinaryTreeNode1<Integer> root) {
         if(root == null){
             return;
         }
          BinaryTreeNode1<Integer> curr,pre;
          curr = root;
          while(curr!=null){
              if(curr.left == null){
                  System.out.print(curr.data+" ");
                  curr = curr.right;
              }else{
                  pre = curr.left;
                  while(pre.right!=null && pre.right != curr){
                      pre = pre.right;
                  }
                  if(pre.right == null){
                      pre.right = curr;
                   curr = curr.left;
                  }else{
                       pre.right = null;
                  System.out.print(curr.data + " ");
                  curr = curr.right;
                  }
              }
          }
      }
	
	public static void main(String[] args) {
		BinaryTreeNode1<Integer> root = takeInputLevelWise();
	//	insertDuplicateNode(root);
		inOrder(root);
//		Pair<Integer, Integer> pair = getMinAndMax(root);
//		System.out.println(pair.minimum + " " + pair.maximum);

	}
	
     public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode1<Integer> root) {
		if(root == null) {
			return null;
		}
		BinaryTreeNode1<Integer> cur = root;
		BinaryTreeNode1<Integer> pre;
		int max= Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Pair<Integer,Integer> p = new Pair<>(min,max);
		while(cur!=null) {
			if(cur.left!=null) {
				p.maximum = Math.max(p.maximum, cur.data);
				p.minimum = Math.min(p.minimum, cur.data);
				cur = cur.right;
			}else {
				pre = cur.left;
				while(pre.right!=null && pre.right!=cur) {
					pre = pre.right;
				}
				if(pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				}else {
					pre.right = null;
					p.maximum = Math.max(p.maximum, cur.data);
					p.minimum = Math.min(p.minimum, cur.data);
					cur = cur.right;
				}
			}
			
		}
		
		return p;
		
		
		
	}

}
class Pair<T, U> {
	T minimum;
	U maximum;

	public Pair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}
