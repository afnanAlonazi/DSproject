package projectCSC212;

public class LinkedList<T> {
	
	private Node<T> head;
	private Node<T> current;
	public LinkedList() {
		head = current=null;
	}
	public boolean empty() {
		return head==null;
	}
	public boolean last() {
		return current.next==null;
	}
	public boolean full() {
		return false;
	}
	public void FindFirst() {
		current=head;
	}
	public void FindNext() {
		current=current.next;
	}
	public T retrive() {
		return current.data;
	}
	public void udpate(T data) {
		current.data = data;
		}
	public void remove() {
		if (current == head) {
			head = head.next;
			}
			else {
			Node<T> tmp = head;
			while (tmp.next != current)
			tmp = tmp.next;
			tmp.next = current.next;
			
		if(current.next==null)	
			current=head;
		else
			current=current.next;
			}
		
	}

	public void insert(T val ) { 
		Node<T> tmp;
		if(head==null)
			head=current=new Node<T> (val);
		else
		{
			tmp=current.next;
			current.next=new Node<T> (val);
			current=current.next;
			current.next=tmp;
		}
		
	}

public void SortedAdd(T obj) { 
		
		Node<T> c ;
		
		if(obj instanceof Contact) {
			 c =new Node<T>(obj);
		
		if(head==null ||((Contact)obj).getContactName().compareTo( (((Contact) head.data)).getContactName() ) < 0) {
				c.next=head;
				head=c;	
}
		else {
		Node <T> cheacker = head;
		Node <T> tracker = null;
		while(cheacker!=null && ((Contact)obj).getContactName().compareTo( (((Contact) cheacker.data)).getContactName() )>0 ) 
		 {
					
			tracker=cheacker;
			cheacker=cheacker.next;
			
	}
				c.next=cheacker;
				tracker.next=c;
		}	
		}else if(obj instanceof event) {
			 c =new Node<T>(obj);	
		
		if(head==null ||(((event)obj).getEventTitle()).compareTo( ((event) head.data).getEventTitle() ) <= 0) {
				c.next=head;
				head=c;	
}
		else {
		Node <T> cheacker = head;
		Node <T> tracker = null;
		while(cheacker!=null && (((event)obj).getEventTitle()).compareTo( ((event) cheacker.data).getEventTitle() )>=0 ) 
		 {
					
			tracker=cheacker;
			cheacker=cheacker.next;
			
	}
				c.next=cheacker;
				tracker.next=c;
		}	
		}
				
	
}
	




public void display() {
	Node<T> temp=head;
	 while (temp!=null) {
	   T x =temp.data;
	   System.out.println((x));	 
       System.out.println("");
	   temp=temp.next;
	 }
} 
public void displayName() {
	Node<T> temp=head;
    while (temp!=null) {
		 String x = ((Contact)temp.data).getContactName();
         System.out.print((x));
         if(temp.next!=null)
         System.out.print(",");
	     temp=temp.next;
	     }
} 


}
		
		



