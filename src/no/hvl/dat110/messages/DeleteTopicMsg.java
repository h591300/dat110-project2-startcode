package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	private String topic;

	/**
	 * Constructor to create a SubscribeMsg
	 * @param user
	 * @param topic
	 */
	public DeleteTopicMsg(String user, String topic) {
		super(MessageType.DELETETOPIC, user);
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
		return "[DeleteTopicMsg]: Topic: " + topic + super.toString();
	}


}