package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();
		
		Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();
		
		for(int i = 0; i < COUNT; i++) {
			int tempInt = sn.read();
			String tempString = Integer.toString(tempInt);
			
			System.out.println("Reading ... : " + tempString);
			
			client.publish(Common.TEMPTOPIC, tempString);
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}

		System.out.println("Temperature device stopping ... ");


	}
}