package com.app.poc;

import static akka.pattern.PatternsCS.ask;

import java.util.concurrent.CompletableFuture;

import org.junit.Before;
import org.junit.Test;

import com.app.poc.actor.EmployeeSalaryActor;
import com.app.poc.message.EmployeeSalaryMessage;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Hello world!
 *
 */
public class App {
	ActorSystem system = null;

	@Before
	public void setup() {
		system = ActorSystem.create("system");
	}

	@Test
	public void shouldTellMessageToEmployeeActor() {
		ActorRef empActorRef = system.actorOf(Props.create(EmployeeActor.class), "emp-actor");
		empActorRef.tell("emp-message", null);
	}

	@Test
	public void shouldAskEmployeeSalaryActorToGetSalary()throws Exception {
		ActorRef empActorRef = system.actorOf(Props.create(EmployeeSalaryActor.class), "emp-salary-actor");
		 CompletableFuture<Object> actorResponse =	ask(empActorRef, new EmployeeSalaryMessage("1"), 1000).toCompletableFuture();
		 Object response = actorResponse.get();
		 System.out.println("Got the response from employee salary actor "+response);
		 
	}

}
