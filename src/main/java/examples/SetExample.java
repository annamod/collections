package examples;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<String> usernames = new HashSet<>();
        usernames.add("Batman");
        usernames.add("Catwoman");
        usernames.add("Superman");

		usernames.add("Superman");					//duplicated element won't be added
		//usernames.add(null)						//null will cause NullPointerException

		printUsernames(usernames);

        validateUsername(usernames, "Joker");
        validateUsername(usernames, "Catwoman");
    }

    private static void printUsernames(Set<String> usernames) {
		for (String username : usernames) {
			System.out.println(username);
		}
	}

	private static void printUsernamesWithStreams(Set<String> usernames) {
		usernames.stream()
				.forEach( username -> System.out.println(username));
	}

    private static void validateUsername(Set<String> existingUserNames, String newUserName) {
        if (existingUserNames.contains(newUserName)) {
            System.out.print(newUserName + " user already exists! Please use different username.");
        } else {
            System.out.println(newUserName + " is a valid user name.");
        }
    }
}
