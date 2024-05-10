package projectCSC212;

public class ContactBST<T> {
	BSTNode<T> root , current;

	public ContactBST() {
		root=current = null;
	}
	
	public boolean empty() {
		return root==null;
	}
	
	public T retrieve() {
		return current.data;
	}

	public boolean full() {     
		return false;
	}
	public void update(T val) {
		current.data=val;
	}
	
	public boolean findKey(String tkey) {
	   
		BSTNode<T> p = root , q=root;
		if(root==null)
			return false;
		
		while (p!= null) {
		    	q=p;
			if (tkey.compareTo(p.key)==0) {
				current=p;
				return true;
				}//end of if
			
			else if (tkey.compareTo(p.key)<0)
			   p=  p.left;
			else
				p =p.right;	
			
		}//end of while
		
		current=q;
		return false;
	}
	public boolean insert(String k, T val) {
		BSTNode<T> p, q = current;
		
		if(findKey(k)) {
		current = q; // findkey() modified current
		return false; // key already in the BST
		}
		
		p = new BSTNode<T>(k, val);
		if (empty()) {
		root = current = p;
		return true;
		}
		
		else {
		// current is pointing to parent of the new key
		if (k.compareTo(current.key) < 0)
		current.left = p;
		else
		current.right = p;
		current = p;
		return true;
		}
		}

 public Contact srearchUniqeInfo(String input) {
	 srearchUniqeInfo((BSTNode<Contact>) root, input);
	  return srearchUniqeInfo((BSTNode<Contact>) root, input);
}

private Contact srearchUniqeInfo (BSTNode<Contact> p , String input) {
	
	if(p==null)
	return null;
	 
	 Contact result = srearchUniqeInfo(p.left, input);
	    if (result != null) 
	        return result; 
     if( p.data.getContactName().equals(input)||
    		 p.data.getPhoneNumber().equals(input)||p.data.getEmailAddress().equals(input))
    	return p.data;
     
     
    return srearchUniqeInfo(p.right,input);
    	 
 }//end of method rearchUniqeInfo


public LinkedList<Contact> srearchNotUniqeInfo(String input){
	LinkedList<Contact> contactSearchList= new LinkedList<Contact>();
	srearchNotUniqeInfo((BSTNode<Contact>) root, input,contactSearchList);
	return contactSearchList;
}   

private void srearchNotUniqeInfo (BSTNode<Contact> p,String input,LinkedList<Contact> contactSearchList ) {
	if(p==null)
		return ;
	 
	srearchNotUniqeInfo(p.left,input,contactSearchList);
	  if( p.data.getAddress().equals(input)||p.data.getBirthday().equals(input))
	    	 contactSearchList.insert(p.data);
	     
	 srearchNotUniqeInfo(p.right,input,contactSearchList);
	}//end of method rearchUniqeInfo

public LinkedList<Contact> searchFirstName(String name ){
	LinkedList<Contact> shareFirstnamelist= new LinkedList<Contact>(); 
	searchFirstName((BSTNode<Contact>) root,name,shareFirstnamelist );
	 return shareFirstnamelist;
}

private void searchFirstName(BSTNode<Contact> p,String name,LinkedList<Contact> shareFirstnamelist ) {
	if(p==null)
		return;
	
	   searchFirstName(p.left,name ,shareFirstnamelist);
		
		if(p.data.getContact1STname().equalsIgnoreCase(name))
			shareFirstnamelist.insert(p.data);
		
		searchFirstName(p.right,name,shareFirstnamelist);
		
	}//end of method printByFirstName

public boolean removeKey(String key) {
	// Search for k
	String k1 = key;
	BSTNode<T> p = root;
	BSTNode<T> q = null; // Parent of p
	while (p != null) {

		if (k1.compareTo(p.key) < 0) {
			q = p;
			p = p.left;
		} else if (k1.compareTo(p.key) > 0) {
			q = p;
			p = p.right;
		} else { //  key is exist
			if ((p.left != null) && (p.right != null)) { // 2 children

				// Search for the min in the right subtree
				BSTNode<T> min = p.right;
				q = p;
				while (min.left != null) {
					q = min;
					min = min.left;
				}
				p.key = min.key;
				p.data = min.data;
				k1 = min.key;
				p = min;
				// Now fall back to either case 1 or 2
			}

			// The subtree rooted at p will change here
			if (p.left != null) { // One child
				p = p.left;
			} else { // One or no children
				p = p.right;
			}

			if (q == null) { // No parent for p, root must change
				root = p;
			} else {
				if (k1.compareTo(q.key) < 0) {
					q.left = p;
				} else {
					q.right = p;
				}
			}
			current = root;
			return true;

		}
		
	}

	return false; // key not exist
}

public void displayInOreder () {
	 displayInOreder (root);
} 

private void displayInOreder (BSTNode<T> p) {
	if(p!=null) {
		displayInOreder(p.left);
		System.out.println(p.data);
		displayInOreder(p.right);
	}
	
}





}


