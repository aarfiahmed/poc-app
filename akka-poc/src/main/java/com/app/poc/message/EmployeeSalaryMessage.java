package com.app.poc.message;

public final class EmployeeSalaryMessage {
private final String salary;

public EmployeeSalaryMessage(final String salary) {
	this.salary=salary;
}

public String getSalary() {
	return salary;
}

@Override
public String toString() {
	return "EmployeeSalaryMessage [salary=" + salary + "]";
}

}
