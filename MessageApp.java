import java.util.Arrays;

import java.util.Scanner;

import java.util.Random;

public class MessageApp{
	private Message messages[][] = new Message[16][10];
	private int[] messageCounts = new int[16];

	private static int totalCount = 0;
	private String[] contacts = new String[16];

	public void addContacts(){

	String[] contactsadded = { "John", "Joseph", "Sophia", "Alice", "David", "Alia", "Ali", "Fatima", "Sara", "Hadiya",
					"Minahil", "James", "Sir", "Mam", "Wania", "Zoha"};

	for(int i =0; i<contacts.length; i++){
		contacts[i] = contactsadded[i];
		}

	System.out.println("Contacts you have: " + Arrays.toString(contacts));
	}

	public void sendMessage(String senderNo, String recieverNo, String messageContent, boolean status){
		int index = -1;
		for(int i = 0; i<contacts.length; i++){
			if(contacts[i].equalsIgnoreCase(recieverNo)){
			index = i;
			break;
			}
		}
		if(index != -1){
			if(messageCounts[index]<messages[index].length){
			String messageId = String.format("%03d", totalCount++);
			messages[index][messageCounts[index]] = new Message(senderNo, recieverNo, messageContent, status, messageId);
			messageCounts[index]++;
			System.out.println("Message sent to " + recieverNo + " with Id " + messageId);
			}else{
				System.out.println("Array is full. cannot send more messsges");
				}
			} else{
				System.out.println("This reciever " + recieverNo + "is not in your contact list ");
			}
	}


	public void displayMessages(){
		for(int i = 0; i<contacts.length; i++){
			System.out.println("Messages with: " + contacts[i]);
			for(int j = 0; j<messageCounts[i]; j++){
				if(messages[i][j] != null){
			messages[i][j].displayMessage();
			System.out.println();
				}
			}
		}
	}
	
	public void deleteMessage(String messageId){
		for(int i = 0; i<contacts.length; i++){
			for(int j=0; j<messageCounts[i]; j++){
				if(messages[i][j].getMessageId().equals(messageId)){
				System.out.println("Message with id " + messageId + " has been deleted");
				for(int k = j; k<messageCounts[i]-1; k++){
					messages[i][k] = messages[i][k+1];
				}
					messageCounts[i]--;
					return;
				}
			}
		}
		System.out.println("Message with this id not found");
	}




	public void sendReciever(){

		Scanner s = new Scanner(System.in);
		System.out.println("enter reciever name");
		String recieverNo = s.nextLine();
		System.out.println("enter message content");
		String messageContent = s.nextLine();
		System.out.println("enter current status");
		boolean status = s.nextBoolean();
		s.nextLine();
		sendMessage("3835044", recieverNo, messageContent, status);
	}


	public void search(String recieverNo){
		boolean found = false;
		for(int i = 0; i<contacts.length; i++){
			if(contacts[i].equalsIgnoreCase(recieverNo)){
			System.out.println("message with " + recieverNo);
				if(messageCounts[i] == 0){
					System.out.println("No messages found");
					}else{
		  			for(int j = 0; j<messageCounts[i]; j++){
					messages[i][j].displayMessage();
					System.out.println();
					}
				}		
				found = true;
				break;
			}
		}
	}

	public void seenMessages(){
		boolean seenMessage = false;
		for(int i = 0; i< contacts.length; i++){
			for(int j = 0; j<messageCounts[i]; j++){
				if(messages[i][j].getStatus()){
				System.out.println("message to " + contacts[i]);
				messages[i][j].displayMessage();
				System.out.println();
				seenMessage = true;
				}
			}
		}
	}
	public void unseenMessages(){
		boolean unseenMessage = false;
		for(int i = 0; i<contacts.length; i++){
			for(int j = 0; j<messageCounts[i]; j++){
				if(!messages[i][j].getStatus()){
					System.out.println("messages to " + contacts[i]);
					messages[i][j].displayMessage();
					System.out.println();
					unseenMessage = true;
				}
			}
		}
	}

	public void shuffleMessages(){
		Random random = new Random();
	
		Message[] allmsgs = new Message[totalCount];
		int idx = 0;
	
		for(int i=0; i<contacts.length; i++){
			for(int j = 0; j<messageCounts[i]; j++){
				allmsgs[idx++] = messages[i][j];
			}

		}
		for(int i = allmsgs.length-1; i>0; i--){
			int j = random.nextInt(i+1);
			Message temp = allmsgs[i];
			allmsgs[i] = allmsgs[j];
			allmsgs[j] = temp;
		}
		idx = 0;
		for(int i = 0; i<contacts.length; i++){
			for(int j =0; j<messageCounts[i]; j++){
				messages[i][j] = allmsgs[idx++];
			}
		}
		System.out.println("messages are now shuffled");
	}

}
