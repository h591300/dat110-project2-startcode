package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	public void addClientSession(String user, Connection connection) {
		
		//if clients does not exist, we create a new client session 
		if(!clients.containsKey(user)) {
			ClientSession clientSession = new ClientSession(user, connection);
			clients.put(user, clientSession);
			
		}		
	}

	public void removeClientSession(String user) {

		//if the client exists, we delete the client session
		if(clients.containsKey(user)) {
			clients.remove(user);
		}
		
	}

	public void createTopic(String topic) {

		//if the topic does not exist, creates a new set of subscribers, 
		//and maps the topic and subscribers 
		if(!subscriptions.containsKey(topic)) {
			 
			Set<String> subscribers = ConcurrentHashMap.newKeySet();
			subscriptions.put(topic, subscribers);
		}
		
		
	}

	public void deleteTopic(String topic) {

		//deletes a topic if it exists
		if(subscriptions.containsKey(topic)) {
			subscriptions.remove(topic);
		}

		
		
	}

	public void addSubscriber(String user, String topic) {
		
		//gets the current subscribers, ads a new user, 
		//and replace the existing topic with a updated one
		Set<String> currentSubscribers = getSubscribers(topic);
		
		currentSubscribers.add(user);
		
		subscriptions.replace(topic, currentSubscribers);
			
	}

	public void removeSubscriber(String user, String topic) {

		//gets current subscribers, if the user is subscribed we remove it
		//and replace the existing topic with a updated one
		Set<String> currentSubscribers = getSubscribers(topic);
		 
		if(currentSubscribers.contains(user)) {
			currentSubscribers.remove(user);
		}
		
		subscriptions.replace(topic, currentSubscribers);

	}
}