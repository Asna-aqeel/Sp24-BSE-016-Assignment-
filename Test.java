import java.util.Scanner;
public class Test{
	public static void main(String [] args){
		
		MessageApp m = new MessageApp();
		Scanner sc = new Scanner(System.in);

		
		
		boolean cond = true;
		while(cond){
		System.out.println("Menu:");
		System.out.println("enter 1 to see your contact list: ");
		System.out.println("enter 2 to send a msg: ");
		System.out.println("enter 3 to display msg: ");	
		System.out.println("enter 4 to delete a message: ");
		System.out.println("enter 5 to send message to a particular receiver: ");
		System.out.println("enter 6 to search a message: ");
		System.out.println("enter 7 to see all seen message: ");
		System.out.println("enter 8 to see all unseen messages: ");
		System.out.println("enter 9 to shuffle all messages: ");
		System.out.println("enter 10 to exit ");
		
		System.out.println();
		int choice = sc.nextInt();

		sc.nextLine();

		switch(choice){
		case 1:
		m.addContacts();
		break;
		
		case 2:
		m.sendMessage("3835044", "john", "Hello", true);	

		m.sendMessage("3835044", "joseph", "How are you", false);

		m.sendMessage("3835044", "sophia", "im right here", true);
		
		m.sendMessage("3835044", "alice", "not available", true);

		m.sendMessage("3835044", "david", "im going", true);

		m.sendMessage("3835044", "alia", "where are you", true);

		m.sendMessage("3835044", "ali", "where are you", true);

		m.sendMessage("3835044", "fatima", "where are you", false);

		m.sendMessage("3835044", "sara", "where are you", true);
		
		m.sendMessage("3835044", "hadiya", "where are you", false);	

		m.sendMessage("3835044", "minahil", "where are you", true);

		m.sendMessage("3835044", "james", "where are you", false);
		
		m.sendMessage("3835044", "sir", "where are you", true);

		m.sendMessage("3835044", "mam", "where are you", true);

		m.sendMessage("3835044", "wania", "where are you", false);	
		break;

		case 3:
		System.out.println("displaying messages you sent: ");
		m.displayMessages();
		break;
		
		case 4:
		System.out.println("enter message id you want to delete");
		String messageId = sc.nextLine();
		m.deleteMessage(messageId);
		break;
		
		case 5:
		m.sendReciever();
		break;

		case 6:
		System.out.println("enter reciever name to search:");
		String recieverNo = sc.nextLine();
		m.search(recieverNo);
		break;

		case 7:
		m.seenMessages();
		break;

		case 8:
		m.unseenMessages();
		break;

		case 9:
		m.shuffleMessages();
		break;
		
		case 10:
		cond = false;
		System.out.println("exit");
		break;

		default:
		System.out.println("Invalid choice");
		break;

			}
		}
	}
}
