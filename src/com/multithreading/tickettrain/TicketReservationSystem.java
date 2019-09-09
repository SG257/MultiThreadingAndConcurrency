package com.multithreading.tickettrain;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TicketReservationSystem {
	private Map<String,Integer> trainInfo;
	ReadWriteLock rwlock = new ReentrantReadWriteLock();
	public TicketReservationSystem(Map<String,Integer> trainInfo) {
		// TODO Auto-generated constructor stub
		this.trainInfo = trainInfo;
	}
	public void SeatsAvailability(String trainName) {
		Lock lock = rwlock.readLock();
		lock.lock();
		try {
			if(!trainInfo.containsKey(trainName))
				System.out.println("No such Train...Please check Train Name");
			else
				System.out.println(trainName + " Train has "+trainInfo.get(trainName)+" seats left... ");
		}
		catch(Exception e) {}
		finally {
			lock.unlock();
		}
				
	}
	public void reserveTickets(String trainName,Integer tickets) {
		Lock lock = rwlock.writeLock();
		SeatsAvailability(trainName);
		lock.lock();
		try {
			//Thread.sleep(25);
			if(!trainInfo.containsKey(trainName))
				System.out.println("No such Train...Please check Train Name");
			else {
				int availableSeats = trainInfo.get(trainName);
				Thread.sleep(10);
				if(tickets<availableSeats){
					availableSeats += -tickets;
					trainInfo.put(trainName,availableSeats);
					System.out.println(tickets + " Seats Booked for train "+ trainName);
				}
				else
					System.out.println("Not enough Seats Available on train "+trainName +"...please check seats Availability");
			}
		}catch(Exception e) {}
		finally {
			lock.unlock();
		}
		//SeatsAvailability(trainName);
	}
	
}
