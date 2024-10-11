import java.time.LocalDateTime;

public class Message{
	private String senderNo;
	private String recieverNo;
	private String messageContent;
	private boolean status;
	LocalDateTime timestamp;
	private String messageId;

	public Message(String senderNo, String recieverNo, String messageContent, boolean status, String messageId){
		this.senderNo = senderNo;
		this.recieverNo = recieverNo;
		this.status = status;
		this.messageContent = messageContent;
		this.timestamp = LocalDateTime.now();
		this.messageId = messageId;
	}

	public String getSenderNo(){
		return senderNo;
	}
	public String getRecieverNo(){
		return recieverNo;
	}
	public boolean getStatus(){
		return status;
	}
	public String getMessageContent(){
		return messageContent;
	}
	public LocalDateTime getTimestamp(){
		return timestamp;
	}
	public String getMessageId(){
		return messageId;
	}
	
	public void displayMessage(){
		System.out.println("Message Id: " + messageId);
		System.out.println("To: " + recieverNo);
		System.out.println("Content: " + messageContent);
		System.out.println("Delivered: " + (status ? "seen" : "unseen"));
		System.out.println("Timestamp: " + timestamp);
	}
}



