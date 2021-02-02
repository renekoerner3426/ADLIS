package timeslottest;

import java.time.LocalDateTime;

public class asdsadad {

	public static void main(String[] args) {
		String test = "" + LocalDateTime.now();
		System.out.println(test);

		String[] splitted = test.split("-");
		for (String string : splitted) {
			System.out.println(string);
		}

		String[] splittedAgain = splitted[2].split(":");
		for (String string : splittedAgain) {
			System.out.println(string);
		}

		System.out.println("das will ich:");

		System.out.println("jahr: " + splitted[0]);
		System.out.println("monat: " + splitted[1]);
		System.out.println("tag+stunde: " + splittedAgain[0]);
		System.out.println("minute: " + splittedAgain[1]);

	}

}
