package no.hvl.dat110.messages;

public class PublishMsg extends Message {
	
	// message sent from client to create publish a message on a topic 
	
	private String topic;
	private String message;
	
	/**
	 *  Constructor to create a PublishMsg
	 * @param user
	 * @param topic
	 * @param message
	 */
	public PublishMsg(String user, String topic, String message) {
		super(MessageType.PUBLISH, user);
		this.topic = topic; 
		this.message = message;
	}
	
	/**
	 * Returns topic
	 * @return
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Sets topic as String given as input parameter
	 * @param topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	} 
	
	@Override
	public String toString() {
		return "[PublishMsg]: Topic: " + topic + super.toString();
	}
	
	public String getMessage() {
		return message;
	}
}