package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	private String topic;
	
	/**
	 * Constructor to create a SubscribeMsg
	 * @param user
	 * @param topic
	 */
	public SubscribeMsg(String user, String topic) {
		super(MessageType.SUBSCRIBE, user);
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
		return "[SubscribeMsg]: Topic: " + topic + super.toString();
	}
		
}