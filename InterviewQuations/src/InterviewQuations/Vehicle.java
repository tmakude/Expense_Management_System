package InterviewQuations;

public abstract class Vehicle {

	int speed = 0; // Instance variable
	static int maxSpeed = 120; // Static variable
	private String type = "Car"; // Private variable

	void accelerate() {
		speed += 10;
		System.out.println("Speed: " + speed);
	}

}
