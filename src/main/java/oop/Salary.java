package oop;


public class Salary extends Employee {

	private double salary;
	public Salary(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double newSalary) {
		this.salary = newSalary;
	}
	
	public static void test() {
		System.out.println("salary's test");
	}
	
	@Override
	public void work() {
		System.out.println("salary's work");
		
	}
}
