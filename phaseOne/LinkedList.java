package cscproject;

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
				}
				if (current.next == null)
				current = head;
				else
				current = current.next;
			
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
			
			if(head==null ||((Contact)obj).compareTo( ((Contact) head.data) ) < 0) {
					c.next=head;
					head=c;	
	}
			else {
			Node <T> cheacker = head;
			Node <T> tracker = null;
			while(cheacker!=null && ((Contact)obj).compareTo( ((Contact) cheacker.data) )>0 ) 
			 {
						
				tracker=cheacker;
				cheacker=cheacker.next;
				
		}
					c.next=cheacker;
					tracker.next=c;
			}	
			}else if(obj instanceof event) {
				 c =new Node<T>(obj);	
			
			if(head==null ||((event)obj).compareTo( ((event) head.data) ) < 0) {
					c.next=head;
					head=c;	
	}
			else {
			Node <T> cheacker = head;
			Node <T> tracker = null;
			while(cheacker!=null && ((event)obj).compareTo( ((event) cheacker.data) )>0 ) 
			 {
						
				tracker=cheacker;
				cheacker=cheacker.next;
				
		}
					c.next=cheacker;
					tracker.next=c;
			}	
			}
					
		
	}
		
	/*	
public void SortedAddEvent(T event) {

		
		Node<T> E =new Node<T>(event);	
		
		if(head==null ||((event)event).compareTo( ((event) head.data) ) < 0) {
				E.next=head;
				head=E;	
}
		else {
		Node <T> cheacker = head;
		Node <T> tracker = null;
		while(cheacker!=null && ((event)event).compareTo( ((event) cheacker.data) )>0 ) 
		 {
					
			tracker=cheacker;
			cheacker=cheacker.next;
			
	}
				E.next=cheacker;
				tracker.next=E;
		}		
				
	
}
	*/	
/*
	
	public void searchTitle(String taitle) {
		Node<T> tmpContact =head;
		Node<event> tmpEvent =((Contact)tmpContact.data).getEventList().head;
		if (head == null)
			return ;
		
		while(tmpContact!=null) {
		 while (tmpEvent!=null) {
			 if(tmpEvent.data.getEventTitle().equalsIgnoreCase(taitle))
				 tmpEvent.data.print();
			 tmpEvent= tmpEvent.next;
			  }//end of while for event list
		 tmpContact=tmpContact.next;
			 }//end of while of contact list
	}//end of searchTitle
	*/
	
	public void display() {
		Node<T> temp=head;
		 while (temp!=null) {
			 T x = temp.data;
	System.out.println((x));
	System.out.println("");
		temp=temp.next;}
	} 
	

}
			
			





