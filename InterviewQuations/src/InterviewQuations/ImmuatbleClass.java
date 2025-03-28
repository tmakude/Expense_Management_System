package InterviewQuations;

public final class ImmuatbleClass {
	
	private final String name;
	private final int age;
	private final Address address;
	
	public ImmuatbleClass(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() {
		return new Address(address.getCity(), address.getState());
	}

	@Override
	public String toString() {
		return "ImmuatbleClass [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
	

}
