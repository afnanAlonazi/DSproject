package cscproject;
import java.util.Scanner;
public class Phonebook {
	public static void main(String[] args) {
		
		LinkedList<Contact> contact = new LinkedList<Contact>(); ///Static //نعدل الاقتطاع من الاسم
		LinkedList<event> allEventList = new LinkedList<event>();
		LinkedList<Contact> contactSearch;
		Contact contactSearchUniqe ;
		LinkedList<event> seaechEventList;
		Scanner input = new Scanner(System.in ) ; 
		char choice;
		System.out.println("Welcome to the Linked Tree Phonebook");
		do{
			
			System.out.println("Please choose an option:"); 
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact"); 
			System.out.println("3. Delete a contact ");
			System.out.println("4. Schedule an event ");
			System.out.println("5. Print event details ");
			System.out.println("6. Print contacts by first name ");
			System.out.println("7. Print all events alphabetically ");
			System.out.println("8. Print Contacts that shared an event ");
			System.out.println("9. Exit ");
			System.out.println("Enter your choice: ");
			 
			choice =input.next().charAt(0); 
			if(choice=='9')
				break;
			switch( choice ){
			case '1' :	
			Contact c = new Contact();
			c.ReadData();
			if((srearchUniqeInfo(contact,c.getContactName())==null)&&(srearchUniqeInfo(contact,c.getPhoneNumber())==null)) {
			contact.SortedAdd(c);
			System.out.println("Contact added successfully!");
			}//end of else
			else 
				System.out.println("Contact already exists");
			
			break ;//end of case 1
			
			case '2' :
				input.nextLine();
				System.out.println("Enter search criteria:");
				System.out.println("1. Name ");
				System.out.println("2. Phone Number");
				System.out.println("3. Email Address");
				System.out.println("4. Address ");
				System.out.println("5. Birthday");
				System.out.println("Enter your choice: ");
				
				char criteria =input.next().charAt(0) ;
				
				
				switch(criteria) {
				case '1':
					input.nextLine();
					System.out.println("Enter the contact's name:");
					String name= input.nextLine();
					contactSearchUniqe = srearchUniqeInfo(contact,name);
					if(contactSearchUniqe != null) { 
					System.out.println("Contact found!");
					contactSearchUniqe .PrintContactInfo();
					 }//end of if
					else
						System.out.println("Contact Not found!");
						
							
				break;
				case '2':
					input.nextLine();
					System.out.println("Enter the contact's  Phone Number:");
					String number= input.nextLine();
					contactSearchUniqe = srearchUniqeInfo(contact,number);
					if(contactSearchUniqe!= null) { 
					System.out.println("Contact found!");
					contactSearchUniqe .PrintContactInfo();
					 }//end of if
					else
						System.out.println("Contact Not found!");

					
						
				break;
				case '3':
					input.nextLine();
					System.out.println("Enter the contact's Email Address:");
					String Eadress= input.nextLine();
					contactSearchUniqe = srearchUniqeInfo(contact,Eadress);
					if(contactSearchUniqe != null) { 
					System.out.println("Contact found!");
					contactSearchUniqe .PrintContactInfo();
					 }//end of if
					else
						System.out.println("Contact Not found!");

					
						
				break;
				case '4':
					input.nextLine();
					System.out.println("Enter the contact's Address:");
					String adress= input.nextLine();
					contactSearch=srearchNotUniqeInfo(contact ,adress);
				   if(!contactSearch.empty()) {
						System.out.println("Contact found!");
						contactSearch.display();
					 }
					else
						System.out.println("Contact Not found!");
				break;
				case '5':
					input.nextLine();
					System.out.println("Enter the contact's Birthday:");
					String Birthday= input.nextLine();
					contactSearch=srearchNotUniqeInfo(contact,Birthday);
					   if(!contactSearch.empty()) {
							System.out.println("Contact found!");
							contactSearch.display();
						 }
						else
							System.out.println("Contact Not found!");
				break;
				default :
					System.out.println("invalid input ");
					
				}
			
			break ;
			
			case '3' :
				input.nextLine();
				System.out.println("Enter the contact name or phoneNumber:");
				String nameOrphone= input.nextLine();
				if((srearchUniqeInfo(contact,nameOrphone)!=null)){ 
					deleteContact(contact,nameOrphone,allEventList );
					System.out.println("Contact deleted successfully!");
			      }	//end of if
					else 
						System.out.println("Contact Not exists"); 
					
					
				   
			break ;
			
			case '4' :
				
				input.nextLine();
			    event E = new event();
			    E.ReadData();
			    schedulEvent(E,contact,allEventList);
			    
			     break ;
			
			case '5' :
				input.nextLine();	
				System.out.println("Enter search criteria:");
				System.out.println("1. contact name ");
				System.out.println("2. Event tittle");
				System.out.println("Enter your choice: ");
				  criteria =input.next().charAt(0);
					switch(criteria) {
					case '1':
						input.nextLine();
						System.out.println("Enter the contact's name:");
						String name= input.nextLine();	
						seaechEventList = searchEventsByName(contact,name);
						if(!seaechEventList.empty()){
						System.out.println("Event found!");
						seaechEventList.display();
						}//end of if
						else 
						System.out.println("Event Not found!");
				
					break;
					
					case '2':
						input.nextLine();
					   	System.out.println("Enter the Event title");
						String title= input.nextLine();
						seaechEventList=searchTitleEvent (contact,title);
						if(!seaechEventList.empty()){ 
					     System.out.println("event found !");
						 seaechEventList.display();
						}
						else
							System.out.println("Event Not found!");
	
						break;
					
					
					default :
						System.out.println("invalid input ");
						
					} //end of small switch  
		    	
					break;
					
			case '6' :
				input.nextLine();
				System.out.println("Enter the first name");
				String name= input.next();
				printByFirstName(name,contact);
				break;

			
           case '7' :
				
				input.nextLine();
				printEventAllphabetically(allEventList);	
				
				
			break;
			
           case '8':
        	   input.nextLine();
        	 System.out.println("Enter event title:");
       		String eventTitle=input.nextLine();
       		System.out.println("Enter event date and timeeventDate (MM/DD/YYYY HH:MM):");
       		String eventDate=input.next();
       		String eventTime =input.next();
       		System.out.println("Enter event location:");
       		input.nextLine();
       		String eventLocation =input.nextLine();
				event e = new event(eventTitle ,eventDate, eventTime ,eventLocation);
				PrintAllContactSharedEvent(contact,  e);
				
				break;
			default :
				System.out.println("invalid input ");
				
			}// end switch
			
			}while(choice!='9') ;
			System.out.println("Goodbay ");
			
			
			

   }
	
	
	
	public static boolean checkConflict (String time ,String date , LinkedList<event> eventlist ) {
		
		if(eventlist.empty())
			return false;
		
		else {
			eventlist.FindFirst();
		    while(!eventlist.last()) {
			  if(eventlist.retrive().getEventTime().equals(time)&&eventlist.retrive().getEventDate().equals(date) )
			   return true;
			  eventlist.FindNext();
			}//end while

		if(eventlist.retrive().getEventTime().equals(time)&&eventlist.retrive().getEventDate().equals(date) )
		{
			return true;
		}
		return false;
      }
		}
	
	public static void schedulEvent(event E , LinkedList<Contact> contact , LinkedList<event> allEventList ){ 
		 if( srearchUniqeInfo(contact, E.getContactname())!=null) { 
			  
					      if (checkConflict(E.getEventTime(),E.getEventDate(),(srearchUniqeInfo(contact,E.getContactname()).getEventList()))) {
						    System.out.println("conflict with other event"); 
						    return;
						   }//end of if
						  else{
							  srearchUniqeInfo(contact,E.getContactname()).getEventList().insert(E); 
							 if(isUnigueEvent(E,allEventList))
							allEventList.SortedAdd(E);
							 
							System.out.println("Event scheduled successfully!")	;//end of else
							 } //end of if
					}// end of if
					 
		      
				 else
					 System.out.println("contact not found!"); 
		
		}//end of schedulEvent method 
	
   public static void deleteContact(LinkedList <Contact> con ,String NameOrPhone ,LinkedList <event> Allevent ) {
		
		Contact removedCon =new Contact();
		
		
				con.FindFirst();
				while(!con.last()) {
					if(con.retrive().getContactName().equalsIgnoreCase(NameOrPhone) || con.retrive().getPhoneNumber().equalsIgnoreCase(NameOrPhone)) {
						 removedCon = con.retrive();
						con.remove();
						
					
					}
					else
						con.FindNext();
				}
				if(con.retrive().getContactName().equalsIgnoreCase(NameOrPhone) || con.retrive().getPhoneNumber().equalsIgnoreCase(NameOrPhone)){
					 removedCon = con.retrive();
				con.remove();
				
				}
				deleteEvent(Allevent,removedCon);
		}

		public static void deleteEvent(LinkedList <event> Allevent ,Contact removedCon ) {
			
			if(Allevent.empty()) {
				 return;
				    }
			Allevent.FindFirst();
					while(!Allevent.last()) {
						if(removedCon.getContactName().equalsIgnoreCase(Allevent.retrive().getContactname()))  
							Allevent.remove();
						else
							Allevent.FindNext();
					}
					if(removedCon.getContactName().equalsIgnoreCase(Allevent.retrive().getContactname()))  
						Allevent.remove();
					
			
			
			
		}
		public static boolean isUnigueEvent(event E,LinkedList<event> allEventList ) {
			
			if(allEventList.empty())
				return true;
			else {
				allEventList.FindFirst();
			while(!allEventList.last()) {
				if(allEventList.retrive().getEventTitle().equalsIgnoreCase(E.getEventTitle()) )
				 return false;
				allEventList.FindNext();
				}//end while

			if(allEventList.retrive().getEventTitle().equalsIgnoreCase(E.getEventTitle()) )
				
			{
				return false;
			}
			return true;	
		}
		}
		
		public static void printEventAllphabetically(LinkedList<event> allEventList) {
			if(allEventList.empty()) {
				System.out.println("No event have been added!");
				return ;
			}
			allEventList.FindFirst();
			while(!allEventList.last()) {
				System.out.println("event title:  "+ allEventList.retrive().getEventTitle());	
			allEventList.FindNext();}
			System.out.println("event title:  "+ allEventList.retrive().getEventTitle());	
		}
		
		
		public static void printByFirstName(String name ,LinkedList<Contact> contact ) {
			int count=0;
			if(contact.empty()) {
				System.out.println("no contacts ");
				return;
				}
			contact.FindFirst();
			while(!contact.last()) {
				if(   name.equalsIgnoreCase(contact.retrive().getContact1STname())     ) {
						contact.retrive().PrintContactInfo();
				count++;
				}
				contact.FindNext();
			}//end of while
			if(   name.equalsIgnoreCase(contact.retrive().getContact1STname())     ) {
				contact.retrive().PrintContactInfo();
				count++;}
			if (count==0)
				System.out.println("no contacts with this name!");
					
	}
		
		
		  public static Contact srearchUniqeInfo ( LinkedList<Contact> contactlist ,String input){
	           if(contactlist.empty())
	        	   return null;
	        	   
			  contactlist.FindFirst();
	 		   while (!contactlist.last()){
			      
	 			   if( (contactlist.retrive().getContactName().equalsIgnoreCase(input ) )||(contactlist.retrive().getPhoneNumber().equalsIgnoreCase(input))
	 					   ||(contactlist.retrive().getEmailAddress().equalsIgnoreCase(input)))
					     return contactlist.retrive() ;
	 			   contactlist.FindNext();
	 		  }//end of while	

 			   if( (contactlist.retrive().getContactName().equalsIgnoreCase(input ) )||(contactlist.retrive().getPhoneNumber().equalsIgnoreCase(input))
 					   ||(contactlist.retrive().getEmailAddress().equalsIgnoreCase(input)))
				     return contactlist.retrive() ;
	       
	 		  return null;
	 		  }//end of srearchUniqeInfo
	      
		
		
		 
		
      public static LinkedList<Contact> srearchNotUniqeInfo ( LinkedList<Contact> contactlist  ,String input){
        	LinkedList<Contact> list = new LinkedList<Contact>();
        	if(contactlist.empty())
        	 return new LinkedList<Contact>();
           contactlist.FindFirst();
 		   while (!contactlist.last()){
		      
 			 if((contactlist.retrive().getAddress().equalsIgnoreCase(input))||(contactlist.retrive().getBirthday().equalsIgnoreCase(input))) 
			   list.insert(contactlist.retrive()); 
		  
		      contactlist.FindNext();
		    }//end of while		 		 
 		     if((contactlist.retrive().getAddress().equalsIgnoreCase(input))||(contactlist.retrive().getBirthday().equalsIgnoreCase(input))) 
			   list.insert(contactlist.retrive()); 
		 
		      
		     return list;
	 }//end of srearchNotUniqeInfo
      
      public static LinkedList<event> searchEventsByName(LinkedList<Contact> contact, String input) {
			if (contact.empty())
				return new LinkedList<event>();
			contact.FindFirst();
			while (!contact.last()) {
				if (contact.retrive().getContactName().equalsIgnoreCase(input))
					return contact.retrive().getEventList();
		        contact.FindNext();
		    }//end of while
			if (contact.retrive().getContactName().equalsIgnoreCase(input))
				return contact.retrive().getEventList();
           return new LinkedList<event>();
           } //end of method search event  by contact name
      
     public static LinkedList<event> searchTitleEvent(LinkedList<Contact> contacts, String input) {
  		if(contacts.empty())
  			return new LinkedList<event>() ;	
  		LinkedList<event> events;
  		LinkedList<event> eventlist=new LinkedList<event>();
  		contacts.FindFirst();
  		while(!contacts.last()){ 
  		  events=contacts.retrive().getEventList(); 
  		  events.FindFirst();
  		   while( !events.empty()&&!events.last()) {
  			  if (events.retrive().getEventTitle().equalsIgnoreCase(input))
  				eventlist.insert(events.retrive());
  			  events.FindNext();
  		   }// end while 
  		   if (events.retrive().getEventTitle().equalsIgnoreCase(input))
  				eventlist.insert(events.retrive());
  		        contacts.FindNext();
  		}//end of while
  		events=contacts.retrive().getEventList(); 
  		 events.FindFirst();
  		  while( !events.empty()&&!events.last()) {
  			  if (events.retrive().getEventTitle().equalsIgnoreCase(input))
  				eventlist.insert(events.retrive());
  			    events.FindNext();
  			    }
  		  if (events.retrive().getEventTitle().equalsIgnoreCase(input))
  				eventlist.insert(events.retrive());
  			 return eventlist ;
  		
  	  }//end of method searchTitleEvent
      
      
      
      
   
      
      public static void PrintAllContactSharedEvent(LinkedList<Contact> contacts, event e) {
			LinkedList<event> events ;
			int count=0;
			if(contacts.empty()) {
				System.out.println("no contacts ");
				return;
				}
			contacts.FindFirst();
	  		while(!contacts.last()){ 
	  		  events=contacts.retrive().getEventList(); 
	  		  events.FindFirst();
	  		   while( !events.empty()&&!events.last()) {
	  			 if(events.retrive().isSameEvent(e)) {
	  				  contacts.retrive().PrintContactInfo();
	  				  count++;}
	  			  events.FindNext();
	  		   }// end while 
	  		 if(events.retrive().isSameEvent(e)) {
	  			contacts.retrive().PrintContactInfo();
	  		 count++;}
	  		        contacts.FindNext();
	  		}//end of while
	  		events=contacts.retrive().getEventList(); 
	  		 events.FindFirst();
	  		  while( !events.empty()&&!events.last()) {
	  			  if(events.retrive().isSameEvent(e)) {
	  				contacts.retrive().PrintContactInfo();
	  			    events.FindNext();
	  			  count++;}
	  			    }
	  		   if(events.retrive().isSameEvent(e)) {
	  			 contacts.retrive().PrintContactInfo();
	  			 count++;}
	  		   if( count==0)
	  			   System.out.println("there're no Contacts shered this event");
		
	}

			
	}
     
			
			
		

		










