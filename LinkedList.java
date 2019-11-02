package Game;
import java.util.*;
import stdlib.StdOut;

public class LinkedList {
	
	/* 1) Count number of nodes by traversing the list.
	 * 2) Traverse the list again and select every node with probability 1/N. The selection can be done 
	 * by generating a random number from 0 to N-i for i’th node, and selecting the i’th node node only 
	 * if generated number is equal to 0 (or any other fixed number from 0 to N-i).
	 */
	static Node head;	// head of list
	
	/* Node class */
	static class Node {
		int data;
		Node next;
		
		// Constructor to create new node
		Node(int d) {	
			data = d;
			next = null;
		}
	}
	
	// A reservoir sampling sampling based function to print a
	// random node from a linked list
	void printRandom(Node node) {
		// If list is empty
		if(node == null) {
			return;
		}
		
		// Use a different seed value so that we don't get
		// same result each time we run this program
		Math.abs(UUID.randomUUID().getMostSignificantBits());
		
		// Initialize result as first node
		int result = node.data;
		
		// Iterate from the (k+1)th element to nth element
		Node curr = node;
		int n;
		for(n = 2; curr != null; n++) {
			// change result with probability 1/n
			if(Math.random() % n == 0) {
				result = curr.data;
			}			
			// Move to next node
			curr = curr.next;
		}
			StdOut.println("Randomly selected key is " + result);
	}
	// Driver program to test above functions
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
	    list.head = new Node(1); 
	    list.head.next = new Node(2); 
	    list.head.next.next = new Node(3); 
	    list.head.next.next.next = new Node(4); 
	    list.head.next.next.next.next = new Node(5); 

	    for(int i = 0; i < 5; i++)
	    	list.printRandom(head);
		
	}

}
