package testPractise;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList<String>();
		names.add("abhijeet");
		names.add("asaia");
		names.add("Don");
		names.add("man");
		names.add("alekhya");
		names.add("testa");

		List<String> data1 = names.stream().filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		//data1.forEach(s -> System.out.println(s));

		List<String> data = Arrays.asList("test1", "test2", "test3");

		Stream<String> data2=Stream.concat(data.stream(), data1.stream());
		
		Boolean test=data2.anyMatch(s->s.equalsIgnoreCase("test1"));
		
		List<Integer>dataTest=Arrays.asList(3,3,4,4,5,6,7,1,2,9,-1,0);
		
		dataTest.stream().distinct().sorted().limit(1).forEach(s->System.out.println(s));
		
		
	}

}
