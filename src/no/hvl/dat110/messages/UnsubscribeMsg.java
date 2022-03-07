package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {
	
	private String topic;
	
	/**
	 * Constructor to create a UnsubscribeMsg
	 * @param user
	 * @param topic
	 */
	public UnsubscribeMsg(String user, String topic) {
		super(MessageType.UNSUBSCRIBE, user);
		this.topic = topic; 
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
		return "[UnsubscribeMsg]: Topic: " + topic + super.toString();
	}
	
}