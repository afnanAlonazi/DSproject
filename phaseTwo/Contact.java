package projectCSC212;

import java.util.*;


public class Contact implements Comparable<String> {
	
	
		
		
		private String ContactName;
		private String Contact1STname; // Used leter when want to print contact by first name
		private String PhoneNumber;
		private String EmailAddress;
		private String Address;
		private String Birthday;
		private String Notes;
		private LinkedList<event> eventList ;
		
		
		
		
		
		
		public Contact() {
			eventList = new LinkedList<event>();
		}

		public Contact(String contactName, String phoneNumber, String emailAddress, String address, String birthday,
				String notes) {
			super();
			ContactName = contactName;
			Contact1STname=contactName.substring(0,contactName.indexOf(' '));
			PhoneNumber = phoneNumber;
			EmailAddress = emailAddress;
			Address = address;
			Birthday = birthday;
			Notes = notes;
		}
		
		public void ReadData() { // 
			Scanner key = new Scanner(System.in);
			
			System.out.println("Enter the contact's name:");
			ContactName= key.nextLine();
			while( ContactName.indexOf(" ")==-1 ){
				System.out.print("you should enter full name ");
				System.out.println("Enter the contact's name:");
				ContactName= key.nextLine();
				}
			Contact1STname=ContactName.substring(0,ContactName.indexOf(" "));
			System.out.println("Enter the contact's phone number:");
			PhoneNumber= key.nextLine();
			
			while(!validnum(PhoneNumber) ) {
				System.out.println("invalid phone number! ");
				System.out.println("Enter the contact's phone number:");
				PhoneNumber= key.nextLine();
				}
			System.out.println("Enter the contact's email address:");
			EmailAddress= key.nextLine();
			while( EmailAddress.indexOf('@')==-1  ){
				System.out.print("invalid email Adress! try again ");
				System.out.println("Enter the contact's email address:");
				EmailAddress= key.nextLine();
				}
			
			System.out.println("Enter the contact's address:");
			Address= key.nextLine();
			
			System.out.println("Enter the contact's birthday:");
			Birthday= key.nextLine();
			
			
			System.out.println("Enter any notes for the contact: ");
			Notes=key.nextLine();
			
			
		}
		
		
		public int compareTo(String name) {
			
			return  ContactName.compareTo(name);
		}
		public void PrintContactInfo() {
			System.out.println("Name: " +ContactName);
			System.out.println("Phone Number:"+ PhoneNumber);
			System.out.println("Email Address:" + EmailAddress );
			System.out.println("Address: " + Address);
			System.out.println("Birthday:" + Birthday );
			System.out.println("Notes:" + Notes);
		}

		public String getContactName() {
			return ContactName;
		}

		public void setContactName(String contactName) {
			ContactName = contactName;
		}

		public String getContact1STname() {
			return Contact1STname;
		}

		public void setContact1STname(String contact1sTname) {
			Contact1STname = contact1sTname;
		}

		public String getPhoneNumber() {
			return PhoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			PhoneNumber = phoneNumber;
		}

		public String getEmailAddress() {
			return EmailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			EmailAddress = emailAddress;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String getBirthday() {
			return Birthday;
		}

		public void setBirthday(String birthday) {
			Birthday = birthday;
		}

		public String getNotes() {
			return Notes;
		}

		public void setNotes(String notes) {
			Notes = notes;
		}

		public LinkedList<event> getEventList() {
			return eventList;
		}
		
			
		
	

		@Override
		public String toString() {
			return "Name: " +ContactName+"\n"+ "Phone Number:"+ PhoneNumber +"\n"+ "Email Address:" + EmailAddress+"\n"+"Address: " + Address+"\n"
					+"Birthday:" + Birthday+"\n"+"Notes:" + Notes+"\n";
			
		}
		
		public boolean Allnum(String num) {
			
			try {
				Integer.parseInt(num);
				
			}catch(NumberFormatException e) {
				return false;
			}
		         return true;
		}
		
		public boolean validnum(String num) {
			if (  num.length()==10 &&  Allnum(num)  )
				return true;
			return false;
						
			
		}
		
		
	}


