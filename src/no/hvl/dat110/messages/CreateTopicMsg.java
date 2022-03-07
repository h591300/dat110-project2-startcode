package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	// message sent from client to create topic on the broker
		
		private String topic;
		
		/**
		 * Constructor to create a CreateTopicMsg
		 * @param user
		 * @param topic
		 */
		public CreateTopicMsg(String user, String topic) {
			super(MessageType.CREATETOPIC, user);
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
			return "[CreateTopicMsg]: Topic: " + topic + super.toString();
		}
}
