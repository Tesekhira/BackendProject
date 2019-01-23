package uh2.fstm.ilisi.Model.BO;

public class Hello {
	private String greeting;
	private String name;
	public Hello() {
	}

	public Hello(String greeting , String name) {
		this.greeting = greeting;
		this.name = name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getGreeting() {
		return this.greeting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
