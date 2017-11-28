package examples;

import java.util.HashSet;
import java.util.Set;

/**
 * @author annamod
 */
public class SetExample {

    public static void main(String[] args) {
        Set<String> usernames = new HashSet<>();
        usernames.add("batman");
        usernames.add("catwoman");
        usernames.add("superman");

        validateUsername(usernames, "joker");
        validateUsername(usernames, "catwoman");

    }

    private static void validateUsername(Set<String> existingUserNames, String newUserName) {
        if (existingUserNames.contains(newUserName)) {
            System.out.print(newUserName + " user already exists! Please use different username.");
        } else {
            System.out.println(newUserName + " is a valid user name.");
        }
    }

}
