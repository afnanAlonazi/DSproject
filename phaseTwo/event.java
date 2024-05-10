package projectCSC212;


	import java.util.Scanner;

	public class event {

		private String eventTitle;
		private String Contactname;
		private String eventDate ;
		private String eventTime;
		private String eventLocation;
		private LinkedList<Contact> ContactInEvent ;
		private boolean EventORappointment;
		
		public event ( ) {
			}
		
		
		public event(String eventTitle, String eventDate, String eventTime, String eventLocation) {
			super();
			this.eventTitle = eventTitle;
			this.eventDate = eventDate;
			this.eventTime = eventTime;
			this.eventLocation = eventLocation;
		}


		public String[] ReadDataEvent() { // and return name of contacts to add event to them
			Scanner input= new Scanner(System.in);
			System.out.println(" event title:");
			eventTitle=input.nextLine();
			System.out.println(" contact name:");
			String contactname=input.nextLine();
			ContactInEvent=new LinkedList();
			System.out.println(" event date and time (MM/DD/YYYY HH:MM):");
			eventDate=input.next();
			eventTime =input.next();
			System.out.println(" event location:");
			input.nextLine();
			eventLocation =input.nextLine();
			EventORappointment=true;
			return contactinEvent(contactname);
			
		}
		public String ReadDataAp() { // and return name of contact to add appointment 
			Scanner input= new Scanner(System.in);
			System.out.println(" appointment title:");
			eventTitle=input.nextLine();
			System.out.println(" contact name:");
			ContactInEvent=new LinkedList();
			String contactname=input.nextLine();
			while( contactname.indexOf(',')!= -1  ){
				System.out.println("you shouldn't assign more than one contact ");
				System.out.println("contact name:");
				 contactname=input.nextLine();
				}
			System.out.println(" appointment date and time  (MM/DD/YYYY HH:MM):");
			eventDate=input.next();
			eventTime =input.next();
			System.out.println(" appointment location:");
			input.nextLine();
			eventLocation =input.nextLine();
			EventORappointment=false;
			return contactname ;
		}

		public String getEventTitle() {
			return eventTitle;
		}

		public void setEventTitle(String eventTitle) {
			this.eventTitle = eventTitle;
		}

		public String getEventDate() {
			return eventDate;
		}

		public void setEventDate(String eventDate) {
			this.eventDate = eventDate;
		}

		public String getEventTime() {
			return eventTime;
		}

		public void setEventTime(String eventTime) {
			this.eventTime = eventTime;
		}

		public String getEventLocation() {
			return eventLocation;
		}

		public void setEventLocation(String eventLocation) {
			this.eventLocation = eventLocation;
		}

		
	    public int compareTo(event e) {
			
			return  eventTitle.compareTo(e.eventTitle);
		}
		public void print() {
			System.out.println("event title: "+eventTitle);
			System.out.print("contact name: " + Contactname);
			System.out.println();
			System.out.println(" event date and time (MM/DD/YYYY HH:MM): " +eventDate +" "+eventTime);
			System.out.println("event location: "+eventLocation);
			
		}
	
        
		public LinkedList<Contact> getContactInEvent() {
			return ContactInEvent;
		}


		public void setContactInEvent(LinkedList<Contact> contactInEvent) {
			ContactInEvent = contactInEvent;
		}


		public String EventORappointment() {
			
			if(EventORappointment)
			    return "Event Detalais:";
			else
				return "appointment Detalais:";
		}


		public void setEventORappointment(boolean eventORappointment) {
			EventORappointment = eventORappointment;
		}


		public String getContactname() {
			
			if(ContactInEvent.empty())
			 Contactname=" ";
			 
		    ContactInEvent.FindFirst();
		    Contactname=ContactInEvent.retrive().getContactName();
		    
			while(!ContactInEvent.last()){
				ContactInEvent.FindNext();
			    Contactname =Contactname+","+ ContactInEvent.retrive().getContactName();
			}
			
			
			return Contactname;
		}


		public void setContactname(String contactname) {
			Contactname = contactname;
		}


		public String[] contactinEvent(String names){
	     String[] namesArray = names.split(",");
	      return namesArray;
		      }


		@Override
		public String toString() {
			return EventORappointment()+"\n"+"Title: " + eventTitle + "\nContactname: " + getContactname() + "\nDate:" + eventDate
					+ "\nTime:" + eventTime + "\nLocation: " + eventLocation ;
		}


		public boolean isEventORappointment() {
			return EventORappointment;
		}
		
		
		

	}
	
	
		
		
		
		
	
		
		
	



