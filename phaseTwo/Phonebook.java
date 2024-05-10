package projectCSC212;


	import java.util.Scanner;
	public class Phonebook {
		public static void main(String[] args) {
			
			ContactBST<Contact> contact = new ContactBST<Contact>();//Contact tree
			LinkedList<event> allEventList = new LinkedList<event>();
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
				System.out.println("8. Exit ");
				System.out.println("Enter your choice: ");
				 
				choice =input.next().charAt(0); 
				if(choice=='8')
					break;
				switch( choice ){
				case '1' :	
				Contact c = new Contact();
				c.ReadData();
				if((contact.srearchUniqeInfo(c.getContactName())== null)&&(contact.srearchUniqeInfo(c.getPhoneNumber())==null)) {
				contact.insert(c.getContactName(),c);
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
						if((contact.srearchUniqeInfo(name)) != null) { 
						System.out.println("Contact found!");
						contact.srearchUniqeInfo(name).PrintContactInfo();
						 }//end of if
						else
							System.out.println("Contact Not found!");
							
								
					break;
					case '2':
						input.nextLine();
						System.out.println("Enter the contact's  Phone Number:");
						String number= input.nextLine();
						if(contact.srearchUniqeInfo(number)!= null) { 
						System.out.println("Contact found!");
						contact.srearchUniqeInfo(number) .PrintContactInfo();
						 }//end of if
						else
							System.out.println("Contact Not found!");

						
							
					break;
					case '3':
						input.nextLine();
						System.out.println("Enter the contact's Email Address:");
						String Eadress= input.nextLine();
						if(contact.srearchUniqeInfo(Eadress) != null) { 
						System.out.println("Contact found!");
						contact.srearchUniqeInfo(Eadress).PrintContactInfo();
						 }//end of if
						else
							System.out.println("Contact Not found!");

						
							
					break;
					case '4':
						input.nextLine();
						System.out.println("Enter the contact's Address:");
						String adress= input.nextLine();
					   if(!contact.srearchNotUniqeInfo(adress).empty()) {
							System.out.println("Contact found!");
							contact.srearchNotUniqeInfo(adress).display();
						 }
						else
							System.out.println("Contact Not found!");
					break;
					case '5':
						input.nextLine();
						System.out.println("Enter the contact's Birthday:");
						String Birthday= input.nextLine();
						   if(!contact.srearchNotUniqeInfo(Birthday).empty()) {
								System.out.println("Contact found!");
								contact.srearchNotUniqeInfo(Birthday).display();
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
					Contact removed;
					System.out.println("Enter the contact name or phoneNumber:");
					String nameOrphone= input.nextLine();
					removed=contact.srearchUniqeInfo(nameOrphone);
					if((removed!=null)){ 
						deleteContact(contact,nameOrphone,allEventList );
						System.out.println("Contact deleted successfully!");
				      }	//end of if
						else 
							System.out.println("Contact Not exists"); 
						break;
					  
				
				case '4' :
					
					input.nextLine();
					System.out.println("Enter Type ");
					System.out.println("1.Event ");
					System.out.println("2.Appointment");
					  criteria =input.next().charAt(0);
						switch(criteria) {
						case '1':
							  event E = new event();
							  String[]nameofContacts= E.ReadDataEvent();
							  if(!checkContactinBST(nameofContacts,contact))
								  System.out.println("contact not found!");   
							  else if(checkConflict(E.getEventTime(),E.getEventDate(),allEventList))
								  System.out.println("conflict with other Event/Appointment"); 
							  
							  else 
								  { 
								    for(int i=0;nameofContacts.length>i;i++)
							        schedulEvent(nameofContacts[i],E,contact);
								    allEventList.SortedAdd(E); 
								    System.out.println("Event scheduled successfully ! ");	  
								  }
						break;
						
						case '2':
							 event e = new event();
							 String nameofContact= e.ReadDataAp();
							 if (contact.srearchUniqeInfo(nameofContact)==null)
								  System.out.println("contact not found!");
							
							  else   if(checkConflict(e.getEventTime(),e.getEventDate(),allEventList))
								  System.out.println("conflict with other Event/Appointment");
							  else
							     {
								  if (e.isEventORappointment()==false) 
										 if(!e.getContactInEvent().empty())
											 System.out.println("the Appointment has been scheduled to a contact berfore");
										 else {
								  schedulEvent(nameofContact,e,contact);  
							       allEventList.SortedAdd(e);
							       System.out.println("Appointment scheduled successfully ! ");
							       }
										 
								  }
							 
							break;
						
						
						default :
							System.out.println("invalid input ");
							
						} //end of small switch  
				     break ;
				
				case '5' :
					input.nextLine();	
					System.out.println("Enter search criteria:");
					System.out.println("1.contact name ");
					System.out.println("2.Event tittle");
					System.out.println("Enter your choice: ");
					  criteria =input.next().charAt(0);
						switch(criteria) {
						case '1':
							input.nextLine();
							System.out.println("Enter the contact's name:");
							String name= input.nextLine();	
							printEventShareContact(contact,name);
					
						break;
						
						case '2':
							input.nextLine();
						   	System.out.println("Enter the Event title");
							String title= input.nextLine();
							seaechEventList=searchEventShareTitle (title,allEventList);
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
					printContactByfirstname(contact,name);
					break;

				
	           case '7' :
					
					input.nextLine();
					printEventAllphabetically(allEventList);	
					
					
				break;
				
	           
				default :
					System.out.println("invalid input ");
					
				}// end switch
				
				}while(choice!='8') ;
				System.out.println("Goodbay ");
				
				
				

	   }
		
		
		
		public static boolean checkConflict (String time ,String date , LinkedList<event> allEventList ) {
			
			if(allEventList.empty())
				return false;
			
			else {
				allEventList.FindFirst();
			    while(!allEventList.last()) {
				  if(allEventList.retrive().getEventTime().equals(time)&&allEventList.retrive().getEventDate().equals(date) )
				   return true;
				  allEventList.FindNext();
				}//end while

			if(allEventList.retrive().getEventTime().equals(time)&&allEventList.retrive().getEventDate().equals(date) )
			{
				return true;
			}
			return false;
	      }
			}//end of method checkConflict
		
		public static void schedulEvent(String name,event E , ContactBST<Contact> contact ){ 
	 
				    contact.srearchUniqeInfo(name).getEventList().insert(E); 
				    E.getContactInEvent().insert(contact.srearchUniqeInfo(name)); 
		}//end of schedulEvent method 
	

			
			public static void printEventAllphabetically(LinkedList<event> allEventList) {
				if(allEventList.empty()) {
					System.out.println("No event have been added!");
					return ;
				}
				allEventList.FindFirst();
				while(!allEventList.last()) {
					System.out.println(allEventList.retrive());
				    allEventList.FindNext();
				}
				System.out.println(allEventList.retrive());	
				System.out.println("");
			}
			
			public static LinkedList<event> searchEventShareTitle(String title ,LinkedList<event> allEventList){
				LinkedList<event> EventShareTitle =new LinkedList<event>();
				if(allEventList.empty()) {
					return EventShareTitle ;
				}
				allEventList.FindFirst();
				while(!allEventList.last()) {
					if(allEventList.retrive().getEventTitle().equals(title))
						EventShareTitle.insert(allEventList.retrive());
				allEventList.FindNext();
				}//end of while
				if(allEventList.retrive().getEventTitle().equals(title))
					EventShareTitle.insert(allEventList.retrive());
				return EventShareTitle ;
					
			}
			
public static void deleteContact(ContactBST  <Contact> con ,String NameOrPhone ,LinkedList <event> Allevent ) {
				
				Contact removedCon = con.srearchUniqeInfo(NameOrPhone);
				
				if (removedCon!=null) {
					con.removeKey(removedCon.getContactName());
						deleteEvent(Allevent,removedCon);
				}
				}
			
				public static void deleteEvent(LinkedList <event> Allevent ,Contact removedCon ) {
					
					if(Allevent.empty()) {
						 return;
						    }
					Allevent.FindFirst();
							while(!Allevent.last()) {
								Allevent.retrive().getContactInEvent().FindFirst();
								while(!Allevent.retrive().getContactInEvent().last()) {
								if(removedCon.getContactName().equalsIgnoreCase(Allevent.retrive().getContactInEvent().retrive().getContactName() ))  {
									Allevent.retrive().getContactInEvent().remove();
								
								if(Allevent.retrive().getContactInEvent().empty())
									Allevent.remove();
									}
							   else
									Allevent.retrive().getContactInEvent().FindNext();
								
								}
								
								if(removedCon.getContactName().equalsIgnoreCase(Allevent.retrive().getContactInEvent().retrive().getContactName() ))  {
									Allevent.retrive().getContactInEvent().remove();
								
								if(Allevent.retrive().getContactInEvent().empty())
									Allevent.remove();
									}
								
								
								
									
									Allevent.FindNext();
							}
							while(!Allevent.retrive().getContactInEvent().last()) {
								if(removedCon.getContactName().equalsIgnoreCase(Allevent.retrive().getContactInEvent().retrive().getContactName() ))  {
									Allevent.retrive().getContactInEvent().remove();
								
								if(Allevent.retrive().getContactInEvent().empty())
									Allevent.remove();
									}
							   else
									Allevent.retrive().getContactInEvent().FindNext();
								
								}
								
								if(removedCon.getContactName().equalsIgnoreCase(Allevent.retrive().getContactInEvent().retrive().getContactName() ))  {
									Allevent.retrive().getContactInEvent().remove();
								
								if(Allevent.retrive().getContactInEvent().empty())
									Allevent.remove();
									}					
					
				}
			public static void printContactByfirstname(ContactBST contact,String input) {
				LinkedList<Contact> contactname = contact.searchFirstName(input);
				if(contactname.empty()) {
					System.out.println("no Contact with this name");
					return;}
				contactname.FindFirst();	
				System.out.println(" Contact found");
				while(!contactname.last()){
					 System.out.println(contactname.retrive()) ;
					 contactname.FindNext();
					 }
				System.out.println(contactname.retrive()) ;
				
				}
				
				public static void printEventShareContact(ContactBST contact,String input) {
					
					Contact contactObj = contact.srearchUniqeInfo(input);
					if(contactObj!=null&& !contactObj.getEventList().empty()){
					System.out.println("Event found!");
					contactObj.getEventList().display();
					}//end of if
					else 
					System.out.println("Event Not found!");	
			 }
				
				public static boolean checkContactinBST(String [] nameofContacts ,ContactBST contact) {
					for(int i=0;nameofContacts.length>i;i++) {
						if(contact.srearchUniqeInfo(nameofContacts[i])==null)
							return false;
					}
					return true;
			}//end of method
			
			
					
					
					
			}
			
			
				
				
			
			
			
			
			 
			
			 
			
	     
	      
	     
	      
	     
	     
	     
	     
	      
	      
	      
	      
	   
	      
	     

				
		
	     
				
				
			

	













