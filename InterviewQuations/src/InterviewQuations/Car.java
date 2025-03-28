package InterviewQuations;

public class Car extends Vehicle {
	
	void display() {
        System.out.println("Max Speed: " + maxSpeed); // Accessing static variable
        System.out.println("Speed: " + speed); // Accessing instance variable
    }

}
