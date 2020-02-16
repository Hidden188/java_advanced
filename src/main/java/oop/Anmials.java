package oop;

public class Anmials {
	private int id;
	private String name;
	public Anmials(int thisId) {
		//System.out.println("my id is " + thisId);
	}
	String eat(String food) {
		System.out.println("eating");
		return "animals Eating";
	}
	static void sleep() {
		System.out.println("sleeping");
	}
	final void myowner() {
		System.out.println("can not extends");
	}
}
