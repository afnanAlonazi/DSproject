package cscproject;

import java.util.Scanner;

public class event {

	private String eventTitle;
	private String eventDate ;
	private String eventTime;
	private String eventLocation;
	private Contact c ;
	
	public event ( ) {
		
	
		}
	
	
	public event(String eventTitle, String eventDate, String eventTime, String eventLocation) {
		super();
		this.eventTitle = eventTitle;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
	}


	public void ReadData() { // 
		Scanner input= new Scanner(System.in);
		System.out.println("Enter event title:");
		eventTitle=input.nextLine();
		System.out.println("Enter contact name:");
		c= new Contact();
		c.setContactName(input.nextLine());
		System.out.println("Enter event date and timeeventDate (MM/DD/YYYY HH:MM):");
		eventDate=input.next();
		eventTime =input.next();
		System.out.println("Enter event location:");
		input.nextLine();
		eventLocation =input.nextLine();
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

	public String getContactname() {
		return c.getContactName();
	}

	public void setContactname(String contactname) {
		c.setContactName(contactname);
	}
    public int compareTo(event e) {
		
		return  eventTitle.compareTo(e.eventTitle);
	}
	public void print() {
		System.out.println("event title: "+eventTitle);
		System.out.println("contact name: "+  c.getContactName()   );
		System.out.println(" event date and time (MM/DD/YYYY HH:MM): " +eventDate +" "+eventTime);
		System.out.println("event location: "+eventLocation);
		
	}
	public boolean isSameEvent(event e) {
		boolean sameEvent= false;
		if(eventTitle.equalsIgnoreCase(e.eventTitle) &&
				eventDate.equalsIgnoreCase(e.eventDate)&&
				eventTime.equalsIgnoreCase(e.eventTime)&&
				eventLocation.equalsIgnoreCase(e.eventLocation)
				)
			sameEvent= true;
		
		return sameEvent;
		
			
			
		
	}

	@Override
	public String toString() {
		return "eventTitle=" + eventTitle + "\n" + "contact name: "+  c.getContactName()+ "\n"
				+ "event date and time (MM/DD/YYYY HH:MM): " +eventDate +" "+eventTime+"\n"
				+"event location:"+eventLocation +"\n";
	}
	
	
	
}
