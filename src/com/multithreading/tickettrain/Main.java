package com.multithreading.tickettrain;

import java.util.HashMap;
import java.util.Map;

class Passenger extends Thread{
	
	TicketReservationSystem trs;
	String trainName;
	Integer tickets;

	public Passenger(TicketReservationSystem obj,String trainName,Integer tickets) {
		this.trs = obj;
		this.trainName = trainName;
		this.tickets = tickets;
	}
	
	@Override
	public void run() {
		trs.reserveTickets(trainName, tickets);	
	}
	
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> trainInfo = new HashMap();
		trainInfo.put("Rajdhani",330);
		trainInfo.put("Shatabdi",120);
		trainInfo.put("VandeBharatExpress",90);
		trainInfo.put("TejasExpress",123);
		TicketReservationSystem trs = new TicketReservationSystem(trainInfo);
		new Passenger(trs,"Rajdhani",200).start();
		new Passenger(trs, "Rajdhani", 140).start();
		new Passenger(trs,"Shatabdi",100).start();
		new Passenger(trs,"Shatabdi",25).start();
	}

}
