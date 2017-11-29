package examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
		List<String> heroes = new ArrayList<>();

		heroes.add("Wolverine");
		heroes.add("Iron Man");
		heroes.add("Spider-Man");
		heroes.add("Wolverine");							//list allows for duplicates

		heroes.add(0, "Captain America");		//we can insert element at selected index within the list

		heroes.add(null);									//null is proper value
		print(heroes);

		//sort(heroes);
		//print(heroes);

    }

    private static void print(List<String> heroes) {
    	for (String hero : heroes) {
    		System.out.println(hero);
		}
	}

	private static void printWithStreams(List<String> heroes) {
		heroes.stream()
				.forEach(h -> System.out.println(h));
	}

	private static void printWithIterator(List<String> heroes) {
		Iterator<String> it = heroes.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}


	private static void sort(List<String> heroes) {
    	heroes.sort(Comparator.nullsLast(String::compareTo));
	}
}
