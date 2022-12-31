package collectionTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest <E extends Number>{
//	E extends Number -> 요소에 타입 제한을 두는 방법, 숫자 외에 받지 않게 된다.
	
	public static void main(String[] args) {
//		<?> : 제네릭(이름이 없는)
//		객체화 시 타입을 지정하는 기법
//		설계할 때에는 타입을 지정할 수 없기 때문에 임시로 타입을 선언할 때 사용한다.
//		따로 다운 캐스팅을 할 필요가 없다.
//		지정할 타입에 제한을 줄 수 있다.
		
		
		
//		ArrayList<Integer> datas = new ArrayList<Integer>();		//생성자 쪽 꺽쇠는 생략가능
		ArrayList<Integer> datas = new ArrayList<>();		//생성자 쪽 꺽쇠는 생략가능
			
		datas.add(10);
		datas.add(20);
		datas.add(40);
		datas.add(50);
		datas.add(90);
		datas.add(80);
		datas.add(70);
		datas.add(60);
		
//		datas.size()          --> ArrayList 크기를 가져옴
		
//		for (int i = 0; i < datas.size(); i++) {
//			System.out.println(datas.get(i));
//		}
//		-> 출력시 for문 필요없이 리스트를 출력할 수 있다.
//		==> 주소 출력시 생략되는toString이 재정의(값을 출력하게끔) 되어있기 때문이다.
//		System.out.println(datas);
		
		Collections.sort(datas);					//오름차순 정렬
//		return없이도 값이 변경되는 이유 -> datas는 객체이다, 객체는 주소이므로 값에 직접 접근해서 바꾼것이기 때문에 return없이도 변경된값이 출력된다. 
		System.out.println(datas);
		
		Collections.reverse(datas);			// 좌우반전,    -내림차순으로 변경할때는 오름차순 정렬 후에 리버스를 하면 된다.
		System.out.println(datas);
		
		Collections.shuffle(datas);				//무작위로 섞기
		System.out.println(datas);				
		
		
//		추가(삽입)
//		50 뒤에 500삽입
		if(datas.contains(50))	{							//contains(Object o), o가 리스트안에 포함되어있는지 검사한다. -> 50이 datas안에 있다면,
			datas.add(datas.indexOf(50)+1, 500);		//datas.add(index, elements) index번호에 elements를 추가한다. -> elements에 50
		}															//indexOf() 위치반환. -> 50의 인덱스번호를 반환받아 +1(뒤에 삽입해야하므로)
		
//		실습 시간에 짠 코드
//		for (int i = 0; i < datas.size(); i++) {			//알고리즘은 맞았으나, 좀 더 효율적이게 짤 수 있는 방법을 항상 모색해보기.
//			if(datas.get(i) == 50)	{						
//				datas.add(i+1, 500);
//			}
//		}
//		System.out.println(datas);	
//		수정
//		90을 9로 수정
//		for (int i = 0; i < datas.size(); i++) {
//			if(datas.get(i) == 90)	{
//				datas.set(i,9);
//			}
//		}
//		System.out.println(datas);	
		
		
		if(datas.contains(90))	{								
		//contains(Object) - Object값이 리스트안에 있는지 확인해준다.
//		만약 90이 ArrayList datas안에 있다면,
			System.out.println(datas.set(datas.indexOf(datas), 9));	
//			datas.set(index, int elements) - index값을 elements값으로 세팅(변경)한다.
//			datas.indexOf(datas) datas안에서 처음으로 찾은 90의 인덱스를 반환, -> 90이 있던자리에 9를 넣음
		}

//		삭제
//		80삭제
//		1. 인덱스로 삭제
		
		if(datas.contains(80))	{
//			만약 datas가 80을 갖고 있다면,
			datas.remove(datas.remove(datas.indexOf(80)));
//			remove(Object) - Object값을 삭제한다
//			remove(index) - index에 있는 값을 삭제
//			datas.indexOf(80) 80의 인덱스를 반환, remove()에 전달한다
		}

//		2. 값으로 삭제
			if(datas.remove(Integer.valueOf(80)))	{
//				valueOf -> unboxing 메소드, Integer.valueOf(80)은 박싱되어있던 int타입의 80을 언박싱하는 것이다.
//				언박싱해야 하는 이유는?
//				-----						
//				remove는 두 개의 형태로 오버로딩되어있는데[remove(int index)와 remove(Object o)]
//				이 때 int 타입인 80은 값전달 remove로 가지 못하고 index로 자동인식되어버린다. 
//				Object에 전달했다는걸 알려주기위해 언박싱하여 값을 전달한다.
				System.out.println("삭제완료");
			}
		
//		람다식, 컬렉션 프레임워크, 업-다운 캐스팅(중요!)
		
//		실습시간 내 코드
//		for (int i = 0; i < datas.size(); i++) {
//			if(datas.get(i) == 80)	{
//				datas.remove(i);
//			}
//		}
//		System.out.println(datas);	
//		
//		for (int i = 0; i < datas.size(); i++) {
//			if(datas.get(i) == 80)	{
//				datas.remove(80);
//			}
//		}
//		System.out.println(datas);	
//		
		
		
	}
}
