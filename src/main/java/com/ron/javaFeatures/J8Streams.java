package com.ron.javaFeatures;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class J8Streams {

	public static void main(String[] args) {
		Utils.print("Features Introduced in Java 8: Streams");
		J8Streams j8 = new J8Streams();
		j8.quickIntroToStreams();
		j8.whyDoWeNeedStreams();
		j8.creatingStreams();
		j8.convertingStreams();
		j8.intermediateOperations();
		j8.terminalOperations();
		j8.optionals();
	}


	private void quickIntroToStreams() {
		Utils.newMethod("quickIntroToStreams");

		final int MAX = 950;
		List<Integer> myList = Utils.getRandomList(100, 500, 1000);


		// get a sequential stream
		Stream<Integer> stream = myList.stream();

		// filter the stream (using a lambda)
		Stream<Integer> filteredStream = stream.filter(p -> p > MAX);

		// sort the stream
		Stream<Integer> sortedStream = filteredStream.sorted();

		// print out the values (using a lambda)
		sortedStream.forEach(p -> Utils.print("High Numbers A: sequential =", p));
		Utils.print();


		// all in one line
		myList.stream().filter(p -> p > MAX).sorted().forEach(p -> Utils.print("High Numbers B: sequential =", p));
		Utils.print();
	}


	private void whyDoWeNeedStreams() {
		Utils.newMethod("whyDoWeNeedStreams");

		// Solve this problem: get the sum of all positive values in a list

		List<Integer> myList = Utils.getRandomList(1000, -500, 500);

		// prior to Java 8
		int sum = 0;
		for (Integer i : myList) {
			if (i > 0) {
				sum += i;
			}
		}
		Utils.print("(loop) sum =", sum);


		// The Java 8+ way:
		int streamSum = myList.stream().filter(p -> p > 0).mapToInt(i -> i).sum();
		Utils.print("streamSum =", streamSum);


		// This can be parallelized very easily:
		int parallelStreamSum = myList.parallelStream().filter(p -> p > 0).mapToInt(i -> i).sum();
		Utils.print("parallelStreamSum =", parallelStreamSum);
	}


	// Collections vs Streams


	private void creatingStreams() {
		Utils.newMethod("creatingStreams");

		// use static of() method in interface Stream
		Stream<Integer> stream = Stream.of(1, 2, 3, 1, 2, 3);

		// creating Sequential and Parallel streams from collections
		List<Integer> myList = Utils.getRandomList(10, -10, 10);
		Stream<Integer> sequentialStream = myList.stream();
		Stream<Integer> parallelStream = myList.parallelStream();

		// creating streams from Strings
		IntStream intStreamFromString = "abc".chars();  // Java 9

		// creating streams from Arrays
		IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4});
		Stream<Integer> integerStream = Arrays.stream(new Integer[]{1, 2, 3, 4});
		Stream<J8Streams> j8Stream = Arrays.stream(new J8Streams[]{});

		// Stream.iterate()
		IntStream stream1 = IntStream.iterate(0, i -> i + 1);
		IntStream stream2 = IntStream.iterate(0, i -> i < 10, i -> i + 1);   // Java 9
		Stream<Integer> strStream3 = Stream.iterate(123, i -> i + 1);
		Stream<String> strStream4 = Stream.iterate("123", p -> Integer.valueOf(p) < 100, i -> String.valueOf(Integer.parseInt(i) + 1));

		// Stream.generate()
		Stream<String> endlessStream = Stream.generate(() -> "abc");
	}


	private void convertingStreams() {
		Utils.newMethod("convertingStreams");

		// use collect() to convert a stream to a collection (Set, List or Map)

		Stream<Integer> integerStream = Stream.of(4, 3, 2, 1, 2, 3, 4, 1, 2, 3, 1);
		Set<Integer> integerSet = integerStream.collect(Collectors.toSet());
		Utils.print("integerStream: set =", integerSet.toString());

		integerStream = Stream.of(4, 3, 2, 1, 2, 3, 4, 1, 2, 3, 1); // stream was closed - have to create a new one
		Utils.print("integerStream: list =", integerStream.collect(Collectors.toList()));

		integerStream = Stream.of(9, 3, 5, 1, 13, 2);
		Map<Integer, Integer> intMap = integerStream.collect(Collectors.toMap(k -> k, v -> v * v));
		Utils.print("integerStream: map =", intMap);

		// Convert Stream to an Array
		integerStream = Stream.of(1, 2, 3, 4);
		Integer[] intArray = integerStream.toArray(Integer[]::new);
		Utils.print("intStream1: array =", Arrays.toString(intArray));
	}


	private void intermediateOperations() {
		Utils.newMethod("intermediateOperations");
		List<Integer> list = Utils.getRandomList(20, -100, 100);
		Utils.print("list =", list, "; size =", list.size());

		// filter()
		Stream<Integer> positives = list.stream().filter(p -> p > 0);    // keep only positive numbers
		Utils.printStream("filter: positives", positives);

		// limit()
		Stream<Integer> limit = list.stream().limit(3);   // "short-circuiting" intermediate operation
		Utils.printStream("limit", limit);

		// map()
		Stream<String> words = Stream.of("m3", "Finest", "Bestest", "Awesomest", "training");
		Stream<String> upperCaseStream = words.map(String::toUpperCase);       // s -> s.toUpperCase()
		Utils.printStream("map: upperCase", upperCaseStream);

		// sorted()
		Stream<Integer> stream2 = list.stream();
		Stream<Integer> sortedInts = stream2.sorted();
		Utils.printStream("sorted", sortedInts);

		// sorted() using Comparator argument
		Stream<Integer> reverseSortedInts = list.stream().sorted(Comparator.reverseOrder());
		Utils.printStream("reverse sorted", reverseSortedInts);

		// flatMap() - 'flatten' a stream of collections to a simple, flat stream of objects
		Stream<List<String>> wordListsStream = Stream.of(
				Arrays.asList("The", "quick", "brown", "fox"),
				Arrays.asList("jumps", "over"),
				Arrays.asList("the", "lazy", "dog"));
		// Utils.printStream("wordListsStream", wordListsStream);
		Stream<String> wordStream = wordListsStream.flatMap(Collection::stream);
		Utils.printStream("flatMap", wordStream);
	}

	private void terminalOperations() {
		terminalOperations("shortList", Arrays.asList(2, 10, 5, 3, 7, 4));
		terminalOperations("randomList", Utils.getRandomList(20, -200, 400));
	}

	private /*static*/ int myCompare(int a, int b) {
		return 0;
	}

	private void terminalOperations(String listName, List<Integer> integerList) {

		Utils.newMethod("terminalOperations");
		Utils.print("listName    =", listName);
		Utils.print("integerList =", integerList);
		Utils.print();

		// count(), sum()
		Utils.print("count   =", integerList.stream().count());
		Utils.print("sum     =", integerList.stream().mapToInt(p -> p).sum());
		Utils.print();

		// average(), min(), max()
		Utils.print("average =", integerList.stream().mapToDouble(p -> p).average());
		Utils.print("min     =", integerList.stream().mapToInt(p -> p).min());
		Utils.print("max     =", integerList.stream().mapToLong(p -> p).max());
		Utils.print();

		Utils.print("min     =", integerList.stream().min((a, b) -> a.compareTo(b)));
		Utils.print("min     =", integerList.stream().min(Integer::compareTo));
		Utils.print("min     =", integerList.stream().min(Integer::compare));
		Utils.print("min     =", integerList.stream().min(this::myCompare));
		Utils.print("min     =", integerList.stream().min(Comparator.naturalOrder()));
		Utils.print("min     =", integerList.stream().min(Comparator.comparingInt(a -> a)));
		Utils.print();


		// Optional
		OptionalDouble optionalAverageValue = integerList.stream().mapToInt(p -> p).average();
		if (optionalAverageValue.isPresent()) {
			Utils.print("(optional) avg =", optionalAverageValue.getAsDouble());
		}

		Optional<Integer> optionalMinValue = integerList.stream().min(Integer::compare);
		optionalMinValue.ifPresent(i -> Utils.print("(optional) min =", i));

		integerList.stream().max(Integer::compareTo).ifPresentOrElse(i -> Utils.print("(optional) max =", i), () -> Utils.print("empty stream"));

		Utils.print("min =", integerList.stream().min(Integer::compare).orElse(Integer.MIN_VALUE));
		Utils.print();


		// reduce() - use an associative accumulation function
		integerList.stream().reduce(Integer::sum).ifPresent(s -> Utils.print("reduce: sum     =", s));
		integerList.stream().reduce((i, j) -> i * j).ifPresent(p -> Utils.print("reduce: product =", p));


		// forEach() - print out odd numbers
		Stream<Integer> intStream = integerList.stream();
		intStream.forEach(i -> {
			if (i % 2 == 1) Utils.print("forEach: odd =", i);
		});


		// short-circuiting operations

		// match - match any, none or all items in the stream
		Utils.print("match: does the stream contain 10?    ", integerList.stream().anyMatch(i -> i == 10));
		Utils.print("match: does the stream not contain 10?", integerList.stream().noneMatch(i -> i == 10));
		Utils.print("match: are all elements positive?     ", integerList.stream().allMatch(i -> i > 0));

		// findFirst
		Optional<Integer> optionalFirstOdd = integerList.stream().filter(i -> i % 2 == 1).findFirst();
		optionalFirstOdd.ifPresent(integer -> Utils.print("findFirst: first odd number =", integer));

		// findAny
		Optional<Integer> optionalFirstAny = integerList.stream().filter(i -> i % 2 == 1).findAny();
		optionalFirstAny.ifPresent(integer -> Utils.print("findAny: an odd number      =", integer));
	}


	private void optionals() {
		Utils.newMethod("optionals");

		Optional<String> o1 = Optional.of("");
		// Optional<String> o2 = Optional.of(null);

		Optional<String> o3 = Optional.ofNullable(null);
		Optional<String> o4 = Optional.ofNullable("");

		Optional<String> o5 = Optional.empty();
	}
}
