package com.app.poc.actor;

import java.util.HashMap;
import java.util.Map;

import com.app.poc.message.EmployeeSalaryMessage;

import akka.actor.AbstractActor;

public class EmployeeSalaryActor extends AbstractActor {

	private Map<String, String> empSalaryDetails = null;

	public EmployeeSalaryActor() {
		empSalaryDetails = createEmpSalaryDetails();
	}

	@Override
	public Receive createReceive() {

		return receiveBuilder().match(EmployeeSalaryMessage.class, msg -> {
			System.out.println("Received message by Employee salary Actor and emp id is " + msg.getSalary());
			
			//sending the response
			getSender().tell("emp salary " + getEmpSalaryById(msg.getSalary()), getSelf());

		}).build();
	}

	Map<String, String> createEmpSalaryDetails() {
		Map<String, String> empSalaryDetails = new HashMap<String, String>();
		empSalaryDetails.put("1", "1000");
		empSalaryDetails.put("2", "2000");
		empSalaryDetails.put("3", "3000");
		empSalaryDetails.put("4", "4000");
		empSalaryDetails.put("5", "5000");

		return empSalaryDetails;

	}

	private String getEmpSalaryById(String empId) {
		return empSalaryDetails.getOrDefault(empId, "Emp Not Foud");
	}

}
