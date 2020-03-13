// Class: CSE 1322L
//Section:
//Term: spring 2020
//Instructor: Kevin Markley
//Name: Tyler Williams
//Assignment 5

public class LinkedList {
	private Node first;
	class Node
	{
		//n is used to store the instances of the species appearing in the list
		//sName stores species name. next is automatically null.
		private int n = 1;
		private Node next = null;
		private String sName = "";
	}
	
	public LinkedList()
	{
		first = null;
	}
	
	//adds a new data entry to the front of the list (unused, so incomplete)
	public void addFront(String name)
	{
		Node nNode = new Node();
		nNode.sName = name.toLowerCase();
		nNode.next = first;
		first = nNode;
	}
	
	//adds a new data entry to the back of the list.
	public void addBack(String name)
	{
		//create new node, set name in new node to lower-case version of entered string,
		//and make temp = to first. part of my confusion is figuring out if, after initializing,
		//temp is a clone of first, a reference to the data of first, or if temp literally represents first.
		Node nNode = new Node();
		nNode.sName = name.toLowerCase();
		Node temp = first;
		
		//determine if the list has anything in it. if not, first becomes the value in temp.
		if(temp == null)
		{
			nNode.next = first;
			first = nNode;
			return;
		}
		
		//iterate through the linked list, search for the last node. if it's discovered that
		//there's a node already holding the name being added, simply increase the counter in
		//the node, and terminate.
		while(temp.next != null)
		{
			if(temp.sName.equals(name.toLowerCase()))
			{
				temp.n++;
				return;
			}
			temp = temp.next;
		}
		
		//temp should be a reference to the data in the last node now, so making temp.next = nNode
		//means that temp is pointing to last node's .next value when setting it, instead of temp's
		//independent .next value, meaning temp must be a reference and not a copy.
		//how come in line 61, then, is temp able to = to its own .next value and not 
		//manipulate the data of the node it's referencing?
		temp.next = nNode;
	}
	
	//returns the number of times a species was added to the linked list.
	public int getCount(String name)
	{
		boolean found = false;
		Node temp = first;
		
		if(temp != null)
		{
			while(!temp.sName.equals(name.toLowerCase()) && temp.next != null)
			{
				temp = temp.next;
			}
			if(temp.sName.equals(name.toLowerCase()))
			{
				return temp.n;
			}
		}
		return 0;
	}
	
	//basically a toString() which returns a full inventory of all species entered, and
	//how many times each species was encountered.
	public String GetReport()
	{
		boolean start = true;
		String report = "";
		Node temp = first;
		
		if(temp == null)
		{
			return "There are no species stored in the list!";
		}
		
		if(start)
		{
			report += "Species: " + temp.sName + " Number of birds: " + temp.n;
			start = false;
		}
		
		while(temp.next != null)
		{
			report += " Species: " + temp.sName + " Number of birds: " + temp.n;
		}
		
		return report;
	}
}
