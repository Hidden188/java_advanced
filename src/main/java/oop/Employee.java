package oop;

public abstract class Employee {
	public String name = "employee";
	public Employee(String name, int id) {
		this.name = name;
		System.out.print("constructing an Employee  ");
		System.out.println(name + id);
	}
	
	public double computePay() {
		System.out.println("employ's computePay");
		return 0.0;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}
	
	public static void test() {
		System.out.println("employee's test");
	}
	public abstract void work();
	
}
