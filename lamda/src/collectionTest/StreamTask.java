package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class StreamTask{
	public static void main(String[] args) {
//		1~10까지 ArrayList에 담고 출력
//		ArrayList<Integer> datas = new ArrayList<Integer>();
//		IntStream.rangeClosed(1, 10).forEach(datas::add);;
//		datas.stream().forEach(System.out::println);
		
//		1~100까지 중 홀수만 ArrayList에 담고 출력
//		ArrayList<Integer> datas = new ArrayList<Integer>();
//		IntStream.rangeClosed(1, 100).filter(n -> n%2 != 0).forEach(System.out::println);;
//		datas.stream().forEach(System.out::println);
		
//		A~F까지 ArrayList에 담고 출력
		
//		String[] alpa = {"A","B","C","D","E","F"};
//		ArrayList<String> alpas = new ArrayList<String>(Arrays.asList(alpa));
//		System.out.println(alpas);
		
//		A~F까지 중 D제외하고 ArrayList에 담고 출력 >
//		ArrayList<String> alpas = new ArrayList<String>();
//		1번 필터
//		IntStream.rangeClosed(65, 70).filter(n -> n != 68).forEach(n ->alpas.add(""+(char)n));
//		2번 맵
//		IntStream.rangeClosed(65, 70).map(n  -> n > 67? n+1 : n ).forEach(n ->alpas.add(""+(char)n));
//		System.out.println(alpas);
		
//		5개의 문자열을 입력받은 후 모두 소문자로 변경(String.toLowerCase())
//		ArrayList<String> others = new ArrayList<String>(Arrays.asList("ASD","QEW","BGT","ASDF","YUI"));
//		others.stream().map(n -> n.toLowerCase()).forEach(System.out::println);
		
//		Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력
//		ArrayList<String> fruits = new ArrayList<String>(Arrays.asList("Apple", "banana", "Melon"));
//		fruits.stream().filter(n -> n.charAt(0) < 90).forEach(System.out::println);
		
//		한글을 정수로  chars, map, forEach		
//		String hangle = "공일이삼사오육칠팔구";
//		String string = "오육이사";
//		string.chars().map(n -> (char)n).forEach(n -> System.out.print(hangle.indexOf(n)));
//		참조형으로 쓰기 위해 맵에서 변환을 모두 함
//		string.chars().map(n -> hangle.indexOf((char)n)).forEach(System.out::print);
//		맵없이도 가능
//		string.chars().forEach(n -> System.out.print(hangle.indexOf((char)n)));
		
//		정수를 한글로
//		String number = "0123456789";
//		ArrayList<String> hangle = new ArrayList<String>(Arrays.asList("공","일","이","삼","사","오","육","칠","팔","구"));
//		String hangle = "공일이삼사오육칠팔구";
//		String string = "01048273527";
//		1번 문자열로 풀기 -> 맵써서 인덱스받아오고 문자열한글에서 캐릭터앳으로 가져옴
//		string.chars().map(n -> number.indexOf((char)n)).forEach(n -> System.out.print(hangle.charAt(n)));
//		2번 리스트로 풀기 ->맵써서 넘버에 정수랑 같은 문자가있는 인덱스로 바꿈, -> 이걸 다시 한글리스트에 겟으로 가져와서 출력함
//		string.chars().map(n -> number.indexOf((char)n)).forEach(n -> System.out.print(hangle.get(n)));
		
		
	}
}
