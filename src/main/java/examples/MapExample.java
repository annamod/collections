package examples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
		Map<String, Integer> heroesToFunCount = new HashMap<>();

		heroesToFunCount.put("Batman", 50);
		heroesToFunCount.put("Catwoman", 45);
		heroesToFunCount.put("Joker", 80);
		heroesToFunCount.put(null, 5);							//map can contain one value with null key

		printHeroesFunCount(heroesToFunCount);

		addFans(heroesToFunCount, "Batman", 100);

		Collection<String> heroes = heroesToFunCount.keySet();
		Collection<Integer> funCounts = heroesToFunCount.values();
    }

    private static void printHeroesFunCount(Map<String, Integer> heroesToFunCount) {
    	for (Map.Entry<String, Integer> heroToFunCount : heroesToFunCount.entrySet()) {
    		System.out.println("Hero name: " + heroToFunCount.getKey() + " fun count: " + heroToFunCount.getValue());
		}
	}

	private static void printHeroesFunCountWithStreams(Map<String, Integer> heroesToFunCount) {
		heroesToFunCount.entrySet()
				.stream()
				.forEach(e -> System.out.println("Hero name: " + e.getKey() + " fun count: " + e.getValue()));
	}

	private static void addFans(Map<String, Integer> heroesToFunCount, String hero, int fansToAdd) {
		Integer countForHero = heroesToFunCount.get(hero);
		if (countForHero == null) {
			countForHero = 0;
		}
		heroesToFunCount.put(hero, countForHero + fansToAdd);
	}

	private static void addFansV2(Map<String, Integer> heroesToFunCount, String hero, int fansToAdd) {
		Integer countForHero = heroesToFunCount.computeIfAbsent(hero, key -> 0);
		heroesToFunCount.put(hero, countForHero + fansToAdd);
	}

	private static void addFansV3(Map<String, Integer> heroesToFunCount, String hero, int fansToAdd) {
		heroesToFunCount.merge(hero, fansToAdd, Integer::sum);
	}
}
