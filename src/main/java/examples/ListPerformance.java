package examples;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListPerformance {

	public static void main(String[] args) {
		testPerformance(new ArrayList<>());
		testPerformance(new LinkedList<>());
	}

	private static void testPerformance(List<Integer> list) {
		int testedSize = 200000;

		//add performance
		for (int i=0; i <= testedSize; i++) {
			list.add(i);
		}

		Instant start = Instant.now();
		for (int i=0; i <= testedSize; i++) {
			list.get(i);
		}
		Instant end = Instant.now();
		System.out.println("Get duration: " + Duration.between(start, end));

		//remove with iterator performance
		start = Instant.now();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			it.remove();
		}
		end = Instant.now();
		System.out.println("Iterator remove duration: " + Duration.between(start, end));
	}
}
