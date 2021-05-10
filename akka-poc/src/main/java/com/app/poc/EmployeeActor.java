package com.app.poc;

import akka.actor.AbstractActor;

public class EmployeeActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		System.out.println("Inside createReceive method of emplyoee actor");

		return receiveBuilder().matchEquals("emp-message", msg -> {
			System.out.println("Got message " + msg);
			 System.out.println("The address of this actor is: " + getSelf());
             getSender().tell("Hey sender I got your message ", getSelf());
		}

		).build();
	}

}
