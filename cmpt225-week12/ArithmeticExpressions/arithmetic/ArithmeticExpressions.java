package arithmetic;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import binarytree.BTNode;

public class ArithmeticExpressions {

	final public static int PLUS = 0;
	final public static int MINUS = 1;
	final public static int MULT = 2;
	final public static int DIV = 3;
	static final List<String> opsStr = Arrays.asList("+", "-", "*", "/");

	public static BTNode<Double> createTree() {
		// creating the tree
		//       /
		//      / \
		//     *   6
		//    / \   
		//   5   -   
		//      / \   
		//     +   1
		//    9 4
		BTNode<Double> node1 = new BTNode<Double>(1.0);
		BTNode<Double> node4 = new BTNode<Double>(4.0);
		BTNode<Double> node5 = new BTNode<Double>(5.0);
		BTNode<Double> node6 = new BTNode<Double>(6.0);
		BTNode<Double> node9 = new BTNode<Double>(9.0);

		BTNode<Double> nodePlus = new BTNode<Double>(Double.valueOf(PLUS), node9, node4, null);
		BTNode<Double> nodeMinus = new BTNode<Double>(Double.valueOf(MINUS), nodePlus, node1, null);
		BTNode<Double> nodeMult = new BTNode<Double>(Double.valueOf(MULT), node5, nodeMinus, null);
		BTNode<Double> nodeDiv = new BTNode<Double>(Double.valueOf(DIV), nodeMult, node6, null);
		return nodeDiv;
	}


	public static boolean isOperation(String str) {
		return opsStr.contains(str);
	}

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static double applyOperator(double term1, double term2, String operator) {
		switch (operator) {
		case "+": {
			return term1 + term2;
		}
		case "-": {
			return term1 - term2;
		}
		case "*": {
			return term1 * term2;
		}
		case "/": {
			return term1 / term2;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operator);
		}
	}
	public static double evaluateTree(BTNode<Double> root) {
		if (root == null)
			throw new NullPointerException("root is null");
		else if (root.isLeaf())
			return root.getData();
		else {
			double term1 = evaluateTree(root.getLeftChild()); 
			double term2 = evaluateTree(root.getRightChild());
			return applyOperator(term1, term2, opsStr.get(root.getData().intValue()));
		}
	}

	/**
	 * similar to postOrder, except that inner nodes are converted to chars
	 * @param root
	 * @return the expression inn the postfix notation 
	 */
	public static String treeToPostfix(BTNode<Double> root) {
		if (root == null)
			throw new NullPointerException();
		else if (root.isLeaf())
			return root.getData().toString();
		else { // an inner node
			String term1 = treeToPostfix(root.getLeftChild()); 
			String term2 = treeToPostfix(root.getRightChild());
			return term1 + " " + term2 + " " + opsStr.get(root.getData().intValue());
		}

	}

	public static double evaluatePostfix(String expression) {
		StringTokenizer tokens = new StringTokenizer(expression);

		Stack<Double> stack = new Stack<Double>();

		String nextToken;
		double term1, term2;

		while (tokens.hasMoreTokens()) {
			nextToken = tokens.nextToken();
			if (isNumber(nextToken)) {
				// this is slightly inefficient
				// since Double.parseDouble is also called inside isNumber()
				stack.push(Double.parseDouble(nextToken));
			}
			else if (isOperation(nextToken)) {
				term2 = stack.pop();
				term1 = stack.pop();
				stack.push(applyOperator(term1, term2, nextToken));
			}
			else
				throw new IllegalArgumentException(expression);
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		BTNode<Double> tree = createTree();
		// ( 5 * ( ( 9 + 4 ) - 1 ) ) / 6 = 10

		System.out.println("evaluateTree: " + evaluateTree(tree));

		String postfixExpr = treeToPostfix(tree);
		System.out.println("postfix: " + postfixExpr);

		// postfixExpr = "5.0 9.0 4.0 + 1.0 - * 6.0 /";
		System.out.println("evaluatePostfix: " + evaluatePostfix(postfixExpr));

	}


}
