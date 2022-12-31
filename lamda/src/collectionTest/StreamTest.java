package collectionTest;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
//		람다의 유무에 따라 코테 점수차이가 심함
//		forEach()
//		여러 값을 가지고 있는 컬렉션 객체에서 forEach 메소드를 사용할 수 있다.
//		forEach 메소드에는 Consumer 인터페이스 타입의 값을 전달해야 한다.
//		Consumer는 함수형 인터페이스이기 때문에 람다식을 사용할 수 있다.
//		매개변수에는 켤렉션 객체 안에 들어있는 값들이 순서대로 담기고,
//		화살표 뒤에서는 실행하고 싶은 문장을 작성한다.
		HashMap<String, Integer> chinaTown = new HashMap<String, Integer>();
//		ArrayList<Integer> datas = new ArrayList<Integer>();
		
		chinaTown.put("자장면", 4500);
		chinaTown.put("짬뽕", 5500);
		chinaTown.put("탕수육", 14500);
		
//		값을 가져와서(collection) stream타입으로 변환한다, -> stream API를 사용하기 위함
		chinaTown.values().stream().forEach(price -> System.out.println(price));
		chinaTown.values().forEach(price -> System.out.println(price));
		chinaTown.values().forEach(System.out::println);
		
//		datas.add(10);
//		datas.add(20);
//		datas.add(30);
//		datas.add(40);
//		datas.add(50);
//		datas.add(60);
//		datas.add(70);
//		
//		전달받은 매개변수를 그대로 메소드에 사용할 경우에느 ㄴ참조형 문접을 사용할 수 있다.
//		소속 ::메소드명 --> 전달받은 값을 메소드에 매개변수로 바로 전달
//		datas.forEach(System.out::println);
		
//		datas.forEach(value -> {				//람다는 간결하게 하기 위해 사용하므로, 코드를 길게 쓰게되면 목적에 부합해진다.
//			System.out.println(value);
//			System.out.println("안녕");
//		});	
//		
		
//		InStream.range(start, end) -> start부터 end-1
//		InStream.rangeClosed(start, end) -> start부터 end
		IntStream.range(1, 10).forEach(System.out::println);
//		1~10
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
		
//		chars() : 문자열을 IntStream으로 변경
//		String data = "ABC";
//		data.chars().forEach(number -> System.out.println((char)number)); 	//-> intstream은 정수로 바꿔주므로 바로 참조형으로 출력할 수 없다.

//		map() : 기존 값을 원하는 값으로 변경
//		String data = "ABC";
//		data.chars().map(number ->  number+3).forEach(v -> System.out.print((char)v));
		
//		filter() : 조건식을 작성하여 false일 경우 제외시킨다.
//		IntStream.rangeClosed(1, 10).filter(n -> n % 2 == 0).forEach(System.out::println);
		
//		sorted()
//		Integer[] arData = {10,40,20,30};
//		배열을 어레이리스트로
//		ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(arData));
		ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(10,40,20,30));
//		배열값이 datas리스트값으로 들어감
		System.out.println(datas);
//		메소드를 찾을 때 없으면 stream으로 변환해서 생각해본다.
		datas.stream().sorted().forEach(System.out::println);		//오름차순
		datas.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);		//내림차순
		
//		collect()
//		toList -> 리스트에 담음, Collectors가 구현해줌
//		ArrayList<Integer> results =
//				(ArrayList<Integer>)datas.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());//List가 부모타입, 따라서 형변환 후 다운캐스팅
//			System.out.println(results);
		
//		Collectors.joining("구분점")
//		문자열 타입의 값을 원하는 구분점으로 연결하여 리턴
//		문자열 타입이 아닌 값은 joining을 사용할 수 없다.-> map으로  변환
//		000value -> 언박싱, valueOf -> 박싱, integer를  string으로 박싱한다.
		String result = datas.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(result);
		
	}
}
