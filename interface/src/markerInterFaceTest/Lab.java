package markerInterFaceTest;
//	그룹화를 하기 위한 인터페이스
//	인터페이스는 부모로, 지정한 클래스들이 인터페이스로(하나의 타입으로) 묶이게 된다.
//	이름뒤에 Maker를 꼭 써준다.

public class Lab {
	
//	외부에서 모든 동물을 받아와서
//	초식동물인지 육식동물인지 그리고 잡식동물인지 구분하는 메소드
//	초식동물 : Herbivore
//	육식동물 : Carnivore
	
//	타입별로 인터페이스 생성, 
//	동물에 맞는 타입으로 인터페이스를 지정받으면 된다.
	
	
	public void checkKinds(Animal[] animals)  {										//Animal타입의 animals배열을 매개변수로 받는 checkKinds메소드
//		외부에서 Animal타입의 배열을 전달받고
//		instanceof를 사용하여 종을 검사
		for (int i = 0; i < animals.length; i++) {										//animals배열만큼 증가할 때,
			if(animals[i] instanceof HerbivoreMarker) {								//animals배열의 인덱스i의 값이 HerbivoreMarker타입이라면,	
				System.out.println("초식");													//"초식"을 출력한다.
			}else if(animals[i] instanceof CarnivoreMarker)	{						//초식이 아닐 때,(이전 if문이 아니라는 전제) 만약 인덱스i의 값이 CarnivoreMarker타입 이라면
				System.out.println("육식");													//"육식"을 출력한다.
			}else	{																				//전부 해당하지 않는다면
				System.out.println("잡식동물");												//"잡식동물"을 출력한다.
			}
		}
	}

	public static void main(String[] args) {											//메인, 실행부분
		Lab I = new Lab();																	//I(객체)로 Lab클래스를 객체화
		Animal[]	animals = {																	//Animal타입의 animals배열(객체)
				new Bear(),																	//	각 클래스들을 animals배열로 객체화
				new Cow(),
				new Dog(),
				new Tiger()
		};
		I.checkKinds(animals);																//I(Lab객체).checkKinds메소드에 animals를 매개변수로 전달.
		
	}
}
