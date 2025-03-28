package InterviewQuations;

import javax.sql.rowset.serial.SQLOutputImpl;

public class ReverseString {

	public static void main(String[] args) {
		String str = "Tushar";
		String reversed = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reversed += str.charAt(i);
		}

		System.out.println("Reversed String: " + reversed);
	}

}
