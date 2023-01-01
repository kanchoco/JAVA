# JAVA
JAVA 수업 정리

## 변수
- 변수 : 저장공간
```
x	          =	        10
변수	        대입	      값(상수)
저장공간        연산자
이름
```  
### 자료형(type, 종류)

- 자료형 	type 	byte 	값

- 정수형	int	4	0, -123, 123, 2147483647...

- 실수형	float	4	3.1F, 0.0F, -12.156F, ...
  double	8	3.1, 0.0, -12.156, ...

- 문자형	char	2	'a', 'b', '한' ,...	

- 문자열	String	?	"a", "b", "배다빈", ...
- (클래스, 대문자 시작)
	

### 변수의 선언
- 자료형 변수명 = 값;
- 자료형 변수명 = 초기값;
- 자료형 변수명; ==> 이전 주소값을 공유하므로 쓰레기값이 됨

```
	예) int x = 10;
	x라는 이름의 저장공간이 할당되고 그 안에 10이 들어간다.
```

### 메모리 영역
```
RAM(휘발성 메모리)
===========================
OS kernel space		: 드라이버 
===========================
Stack			: 지역변수, 매개변수
===========================
Heap			: 동적 메모리
===========================
BSS			: 직접 초기화되지 않은 전역변수
===========================
Data 영역			: 전역변수, 정적변수
===========================
Text 영역			: 상수, 코드
===========================
```

### 주소
- int x = 10;
- x라는 이름의 저장공간이 RAM에 할당되면 고유한 값인 주소값이 부여된다.
- 계속 실행되거나 종료되는 프로그램이 있기 때문에, 주소값은 변경될 수 있으나 중복은 없다.

### ★변수의 사용
- 앞에 자료형이 있거나, 뒤에 대입연산자가 있으면 저장공간이다

### 변수 선언 시 주의사항
1. 같은 이름의 변수로 선언할 수 없다.
2. 초기화를 해준다.
3. 되도록 선언부에 한꺼번에 선언한다(영역 상단)		

### 변수명 주의사항
- 문자로 시작해야 한다.
- 특수문자는 사용할 수 없다. 단, _는 허용한다.
- 되도록 소문자만 사용한다.
- 공백을 사용할 수 없다.
```
goodBoy	: 카멜 표기법
good_boy: 파스칼 표기법, 스네이크 표기법, 팟홀 표기법
```
되도록 한글은 사용하지 않는다.
명사로 사용한다.
뜻이 있는 단어를 사용한다.
```
a,b,c,d,e...(X)
data, number, num, age, name
```

### 변수를 사용하는 이유
1. 반복되는 값을 
2. 의미 없는 값을 하나의 정보로 만들기 위해서 사용한다(자료구조)

* * *

### 서식문자(format)
- 반드시 따옴표 안에서 작성한다.
```
정수의 종류 - 이진수 팔진수 십진수 십육진수
	%d	decimal(10진수 정수)
	%o	octal(8진수 정수)
	%x	hexadecimal(16진수 정수)
	%f	float(실수) 	- 7자리부터 문제가 생김, 6자리까지 출력
	%c	char(문자형)
	%s	string(문자열)
```

*+실수의 문제*
7자리 이상부터는 실제 값을 오버한 값이 나오는 오류가 나온다.   
-> 6자리 까지 출력하는 이유는 이런 값의 오류를 없애기 위해서이다.   
--> 6자리까지가 완벽한 값이라고 여긴다.


### 출력 메소드 
- printf()	: 서식문자를 사용하여 출력할 수 있으며, 자동으로 줄바꿈되지 않는다.


* * *

## 상수 
항상 그대로인 수   
값을 변경할 수 없도록 한다   
	
	__★★final 자료형 상수명 = 값;__

상수일때는 상수명을 대문자로 사용한다.

* * *

## 형변환
	- 자동 형변환
		- 정수 + 정수 = 정수
		- 실수 + 정수 = 실수
		- 실수 + 실수 = 실수
		- 정수 + 문자 = 정수

	- 강제 형변환
		- (자료형)값

### 순서
최우선 연산자
단항 연산자
산술 연산자


### 암호화
아스키코드

### 문자열 형변환
1. 다른 자료형을 물자열로   
    - 문자열과 다른 일반 자료형을 연결하면 결과는 항상 문자열이 된다.
  
2. 문자열을 다른 자료형으로   
    - 일반 자료형은 일반 자료형끼리만 형변환이 가능   
    - 문자열은 클래스타입이므로, 일반 자료형의 클래스타입의 도움을 받아야함
    - 클래스타입 변형은 클래스타입을 이용하여 해야함
```		
	예) String(클래스)을 int로 변경
		String(클래스) 타입은 Integer 클래스를 사용					-> Integer.parseInt(""); 
			문자열에서 변환된 정수값
		-> Float.parseFloat("");							문자열에서 변환된 실수값
		-> Double.parseDouble("");
			문자열에서 변환된 실수값
```

* * *

## 입력
커서가 깜빡이고 있는 상태.   
입력하기 전에 출력을 통해 어떤 값을 입력해야할 지 사용자에게 알려주어야 한다.

### 입력 클래스
```java
Scanner sc = new Scanner(System.in);
```

*tip*
```
import 선언방법
Ctrl + space
Ctrl + Shift + O >> import 단축키, 해당 클래스가 존재하는 패키지 전체를 불러줌

이름변경
 Alt + Shift + R >>rename하면 전체 rename해줌
```

### 입력 메소드
1. next() : 사용자가 입력한 문자열 값 / 공백이나 줄바꿈을 구분점으로 사용
    - 사용자가 입력한 값 중 공백 또는 줄바꿈 문자를 구분점으로 각 문자열을 
    분리한다.
    - 첫 번째 문자열을 첫 번째 next()에 담고
    두 번째 문자열은 두 번째 next()에 담는다.
2. nextLine() :  사용자가 입력한 문자열 값
    - 공백 또는 줄바꿈 문자도 값으로 취급하기 때문에 그대로 입력받는다.

* * *

## 연산자
기능이 있는 특수문자

### 연산자의 우선순위
__최__ 우선 연산자  
__단__ 항 연산자   
__산__ 술 연산자   
__쉬__ 프트 연산자   
__관__ 계 연산자   
논 __리__ 연산자   
__삼__ 항 연산자   
__대__ 입 연산자   

### 결합성
하나의 수식에 동일한 연산자가 여러 개 사용되면 알맞은 방향으로 결합되어 연산되는 성질

### ★비트 연산
- 논리 연산자
```
& (AND, 논리곱),	A & B 두 비트가 모두 1이면 1
|  (OR, 논리합)	A | B 둘 중 하나라도 1이면 1
^ (XOR, 배타논리합)	A ^ B 두 비트가 서로 달라야 1
```

- 단항 연산자
```
 ~ (NOT 논리부정)     0 -> 1,  1 -> 0   ~a = -a -1
보색찾을때 사용
```

- 쉬프트 연산자
```
<< (LEFT SHIFT, 좌쉬프트), A << B, A를 왼쪽으로 B만큼 비트이동
>> (RIGHT SHIFT, 우쉬프트), A >> B A를 오른쪽으로 B만큼 비트이동
```

### 논리형(boolean)
- 참 : true
- 거짓 : false
- 논리형 	boolean		1byte	true,false

* * *

## 조건식
결과가 참 또는 거짓, 둘 중 하나가 나오는 식

- 관계 연산자
```
==	: 같다
!=	: 같지않다
>, <	: 초과, 미만
>=, <=	: 이상, 이하
```

- 논리 연산자
```
&&	: A && B 	두 조건식 모두 참이면 참
||	: A || B 	둘 중 하나라도 참이면 참
```

- 단항 연산자
```
! (NOT)	: !A, 조건식이 참이면 거짓으로, 거짓이면 참으로 변경
```

* * *

## 삼항 연산자( : ? )
- 조건식 ? 참 : 거짓
- 단, 참과 거짓 자리에는 값만 작성할 수 있다.

### 삼항 연산자를 사용할 때
- 조건식이 단 한 개만 존재할 때 사용한다.

* * *

## 제어문

### 조건문
▷if문
```
  	 if(조건식){
    	  	실행할 문장;
  	 }
  	 위 조건식에 상관없이 모두 검사
   	
	if(조건식){
   	   	실행할 문장;
   	}
	   
	if(조건식){
	      	실행할 문장;
 	  }...


	   if(조건식){
    	  	실행할 문장;
  		 }
 	  
	위 조건식이 참이 아니면 다음 조건식 검사, 참이면 다음 조건식들은 검사하지 않는다.  	 
	else if(조건식){
  	    	실행할 문장;
  	 }
   	else if(조건식){
      		실행할 문장;
  	 }
   	...
  	else {
      		실행할 문장;
  	 }
```

▷switch문
```
	switch(변수명)	{
	case 값 1 :
		실행 문장;
		break;
	case 값2 :
		실행 문장;
		break;
	case 값3
		실행 문장;
		break;
	case 값4
	...
	
	default :
		실행 문장 ;
		break; 
		}	
```
*default문에도 break를 넣는 이유*	
```
		자바에선 break를 넣지 않아도 오류가 나지 않지만, 
		다른 언어에선 오류가 난다.
		따라서 항상 호환할 수 있는 문법을 쓰기위해서 break를 쓴다
```

* * *

## 대입 연산자(복합 대입 연산자, 누적 연산자)
+=, -=, /=, *=, %=, ...

## 증감 연산자	
++ 	--
- 전위형	: 해당 라인부터 바로 적용
   -  ++data
   -  -> 전위형의 경우 바로 반영해야하기 때문에 둘 다 써도 무관할 시, 후위형 사용
- 후위형	: 다음 라인부터 적용
   -  data++

* * *

## 반복문
### 종류
▷for
```
	for(초기식; 조건식; 증감식)	{
		실행 문장;
	}

	1. 초기식
	2. 조건식
	3. 실행할 문장
	--------------------------
	4. 증감식
	5. 조건식
	6. 실행할 문장
	7. 증감식
	8. 조건식
	9. 실행할 문장
	...
```

▷ while 문
```
	while(조건식)	{
		실행할 문장;
	}
```

▷ do ~ while 문	: 무조건 한 번은 실행해야 할 때
```
	do{
		실행할 문장;
	}while(조건식);
```

### *for문과 while문의 목적
- for : 몇 번 반복할 지 알 때
- while : 몇 번 반복할 지 모를 때

* * *

## 기타 제어문
- break 	: 즉시 해당 중괄호 영역을 탈출한다.
    - if문 안에서 사용 시 if문을 탈출하지 않고 if문을 감싸고 있는 중괄호 영역을 탈출
- continue	: 즉시 다음 반복
    - 아래의 코드를 실행하지 않기 위해서 사용한다.

* * *
## 배열
배열	: 저장공간의 나열

1. 변수를 여러 개 선언하면 이름도 여러 개 생긴다. 이 때 각 저장공간을 관리하기가 불편하다.   
 따라서 n칸 배열을 한 번만 선언하면 저장공간도 n개 생기고, 이름도 한 개이기 때문에 관리하기 편하다.
	
2. 규칙성이 없는 값에 규칙성을 부여하기 위해서
	   
### 배열의 선언
```
	자료형[] 배열명 = {값1, 값2, 값3, 값4, ... };
	(= 자료형 배열명[])
	-> 어떤 값을 넣을지 정확히 알 때 사용

	자료형[] 배열명 = new 자료형[칸수];
	-> 어떤 값을 넣을지 모르나, 몇 칸 만들지는 알 때 사용
	* new 명령어 : 동작 메모리(Heap)에 할당
	
	자료형[] 배열명 = null;
	-> 어떤 값을 넣을지도 모르고, 몇 칸 만들지도 모를 때 사용	
	*null : 어떤 주소를 넣을지 모를 때 사용하는 주소 초기값
		클래스 타입의 경우 null을 사용

	배열명 = new 자료형[칸수];
	
	※ new	: Heap 메모리에 할당, 자동초기화
	※ null	: 주소의 초기값, 어떤 주소를 넣을지 모를 때 작성
	※ 자바에서 배열은 항상 Heap(동적메모리)에 할당되기 때문에
	   메모리상 자바에서는 동적배열만 존재한다.
	{}는 new를 생략한것, 컴파일시 new를 붙여줌   
```

### 배열의 구조
```java
	int[] arData = {3, 5, 9, 6, 7};
```
- arData라는 이름의 저장공간은 한 개 만들어지며, 여기에는 한 개의 값만 담을 수 있다.
- 5개의 값을 담기 위해서는 5칸이 필요하며, 이는 Heap에 할당된다. 5칸의 저장공간 중 
첫번째 저장공간의 주소값이 arData 저장공간으로 들어가며, 다음 주소에 접근하기 위해서는 +n을 한다. 
- 예를 들어, arData + 2는 9라는 값이 담긴 저장소의 주소값이 되며,
*(arData + 2)는 해당 주소에 가서 읽어온 9라는 값이 된다.
- JAVA에서는 직접 주소에 접근하는 연산자가 없기 때문에 위와 같은 식을 []로 치환하여 사용하며, arData[2]로 사용한다.
- 각각의 방 번호는 index라고 부르며, 배열은 시작주소를 가지고 있기 때문에 인덱스 번호는 항상 0부터 시작된다.

### length
- 배열을 선언하면 length라는 상수가 선언되고, 해당 배열의 길이가 담긴다.
- 배열명.length로 사용하게 된다.

### 배열의 사용
- int[] arData = new int[5];
- arData[5]=> 오류


## 2차원 배열	: 배열 안에 배열
- 1차원 배열을 여러 개 선언할 때 관리하기 힘들기 때문에
- 2차원 배열을 한 번 선언한다.

※ 2차원 이상의 배열은 메모리 낭비가 심하므로 선호하지 않는다.

### 2차원 배열
```
	자료형[][] 배열명 = {{값1, 값2, 값3}, {값4, 값5, 값6}, ...};
	자료형[][] 배열명 = new 자료형[행][열];
	자료형[][] 배열명 = null;
	배열명 = new 자료형[행][열];

	ㅁ	arrData		arrData.length      -> 행의 길이
 ㅁㅁ	arrData[행]	arrData[행].length -> 열의 길이
ㅁㅁㅁ ㅁㅁㅁ	arrData[행][열]
```

__4차원까지    	[][][][] -> 의 면 행 열__

* * *


## 메소드
-> 저장공간
- 이름 뒤에 소괄호.
- 단, 키워드 뒤에 소괄호는 메소드가 아니다.

### 매개변수
화면에서 입력받은 값을 받아오는 공간
```
메소드명	매개변수		리턴 값
f	(X)		2x+1
```

### 메소드 선언
```
	(1)리턴타입 (2)메소드명(자료형  (3)매개변수명, ...)	{
		(4)실행할 문장;
		(5)return 리턴값;
	}
```

(1) 리턴 값이 있다면 리턴 값의 자료형을 작성하고, 리턴 값이 없다면 비워놓지 않고 void를 작성한다.   
(2) 동사로 작성한다(연필(매개변수)을 쓴다(메소드))   
(3) 외부에서 전달받을 값이 있다면, 자료형과 순서에 맞게 선언해준다.   
     생략 시, 외부에서 값을 전달받을 수 없게 된다.
(4) 생략이 가능하며, 메소드의 기능을 구현하는 로직을 작성한다.   
(5) 생략이 가능하다.

### 메소드 선언 순서
문제) 두 정수의 덧셈 메소드 선언

1. 메소드의 이름을 생각한다.
```java
  sum, plus, add, getTotal, compute, ...

  add(){}
```
2. 매개변수를 생각한다.
```java
  add(int num1, int num2){}
```
3. 실행할 문장을 생각한다.
```java
add(int num1, int num2)	{
    int result = num1 + num2;
  }
```
4. 리턴 값을 생각한다.
```java
  add(int num1, int num2)	{
    int result = num1 + num2;
    return result;
  }
```
5. 리턴 타입을 결정한다.
```java
  int add(int num1, int num2)	{
    int result = num1 + num2;
    return result;
  }
```

### 메소드 주의사항
- 메소드를 선언할때에는 {}중괄호가 있으며, 반드시 메소드 밖에서 선언한다.
    - 예)메인 메소드 안에서 선언X
- 메소드를 사용할 때에는 {}중괄호가 없으며, 반드시 메소드 안에서 사용한다.
	
### 메소드 사용
- 메소드의 리턴 타입이 void면 실행 메소드이므로 "값으로 봐서는 절대 안된다".
- 메소드의 리턴 타입이 void가 아니라면 사용한 부분 통제로가 리턴 값이다.
	
### 메소드의 목적
1. 재사용(특정성을 부여해서는 안된다.)
2. 소스코드 간결화

### 리턴해야 할 때
- 사용한 쪽에 로직의 결과를 전달해야 할 때,
- 메소드 내에서 모든 작업이 끝날 수 없을 때

### 리턴하면 안될 때
- 사용한 쪽에 로직의 결과를 전달할 필요가 없을 때
- 메소드 내에서 모든 작업이 완료될 때

* * *


## 클래스(반)
공통요소를 한 번만 선언해 놓고 가져다 사용만 하도록 설계한다.

- *필드 -- 클래스 안에 선언된것들
- * 클래스뒤에 소괄호는 생성자

1. 타입이다.
    - 클래스 안에 선언된 변수와 메소드를 사용하고 싶다면,
    - 해당 클래스 타입으로 변수를 선언해야 한다.
2. 주어이다.	
    - Monkey.eat(바나나)
    - 주어	동사	
```
ex) System.out.println("입력 : ");
    new Scanner(System.in).next()
----> 일회성 사용,
```

### 클래스 선언
``` 
	class 클래스명	{
		필드(변수, 메소드 선언 가능)
	}
```

### 클래스의 필드 사용
1. ＊객체화(instance) : ＊객체(instance variable)를 만드는 작업, 추상적인 개념을 구체화시키는 작업
    - 클래스명 객체명 = new 생성자();
    - 객체명.필드명
    - ※ .(마침표) : 하위 연산자, 멤버변수 접근 연산자, 닷 연산자, 점 연산자
2. static일 경우 클래스명으로 바로 접근 가능

### 객체 - 추상적인것을 구체화한것
- 추상적인 개념

- 구체적인 개념

### 생성자
- 클래스 이름 뒤에 소괄호가 있는 형태 (메소드가 대문자면 안되는 이유,)
- 메소드와 기능이 똑같지만 메소드라고 부르지 않는다.
  - 생성자는 return이 존재하지 않음, 
  - 생성자는 할당된 필드의 주소값을 return함 즉,
- 자체적으로 return해야하는 값이 있기때문에 개발자가 return하는 것을 막음

1. ＊＊해당 클래스의 필드를 메모리에 할당한 후 부여된 주소값을 가져온다.
2. 초기화

## 기본 생성자
- 매개변수와 실행할 문장이 따로 없음
- 클래스 선언 시, 자동으로 선언되며, 사용자가 직접 생성자를 선언하게 되면
- 기본 생성자는 없어진다.

## this
- 필드에 접근한 객체가 누구인지 알아야 해당 필드에 접근할 수 있다.
- 이 때 접근한 객체가 가지고 있는 필드의 주소값을 this라는 변수에 자동으로 담긴다.
- this() 생성자 호출

### 다형성(polymorphism)
1. 오버로딩(Overloading)
  매개변수의 개수 또는 타입이 다르면 동일한 이름의 메소드로 선언할 수 있다.
2.  오버라이딩(Overriding)
  부모클래스 값을 자식 클래스에서 변경한다


### 상속(inheritance)
1. 기존에 선언된 클래스의 필드를 새롭게 만들 클래스의 필드로 사용하고자 할 때
2. 여러 클래스 선언 시 필드가 겹치는 경우, 부모 클래스를 먼저 선언하고 공통 필드를 묶어서 자식 클래스에게 상속해준다.
*※다중상속도 가능*
```
상속 문법
	class A{
		A 필드
	}
	
	    (자식)	(부모)
	class B extends A{		//확장 --> 상속
		(A 필드)
		B 필드	

	}
```
A : 부모 클래스, 상위 클래스, 슈퍼 클래스, 기반 클래스   
B : 자식 클래스, 하위 클래스, 서브 클래스, 파생 클래스


### super()	: 부모 생성자
- 자식 클래스 타입의 객체로 부모필드에 접근할 수 있다.
- 하지만 자식 생성자만 호출하기 때문에, 자식 필드만 메모리에 할당된다고 생각할 수 	  있다.
- 사실 자식 생성자에는 항상 부모 생성자를 호출하기 때문에
- 자식 생성자 호출 시 부모와 자식 필드 모두 메모리에 할당된다.
- 이 때 부모 생성자를 호출하는 방법은 super()를 사용하는 것이다.
- 만약, super()를 작성하지 않더라도 컴파일러가 자동으로 작성해준다.


### 다형성(polymorphism)
※메소드는 저장공간※
1. 오버로딩(Overloading)
  - 매개변수의 개수 또는 타입이 다르면 동일한 이름의 메소드로 선언할 수 있다.

2.  오버라이딩(Overriding)
- 부모필드를 무시하고 새로씀, -> 재정의
- 부모 필드에서 선언한 메소드를 자식 필드에서 수정하고자 할 때 사용
- 이는 자식에서 부모 필드의 메소드와 동일한 이름으로 선언하는 것
- 부모 필드가 메모리에 먼저 할당되고 a라는 메소드가 먼저 올라간다 할 때
- 자식 필드가 메모리에 할당되면서 재정의한 a메소드가 새롭게 만들어지는   
것이 아니라 기존에 할당된 a메소드 저장공간에 새롭게 재정의한 자식 필드의 소스코드 주소가 들어가게 된다. 
- 따라서 자식 객체로 a메소드에 접근하면 자식 필드에서 재정의한 소스코드의 내용이 읽히게 된다.

* * *

## Storage class(저장 기억 부류)
```
	Stack			Data영역
	지역변수, 매개변수		전역변수, 정적변수(static)

  초기화	직접			자동
  생명주기	}			new, 프로그램 종료 시
```
### 전역변수
- 생성자를 통해 메모리에 할당되며, 객체가 각각 가지고 있는 변수
### 정적변수(static 변수)
- 컴파일러를 통해 메모리에 1개 할당되며, 모든 객체가 공유하는 변수

* * *

## 접근 권한 제어자(접근자)
- default	: 다른 패키지에서 접근 불가
- public	: 모든 곳에서 접근 가능   
    해당 파일의 메인 클래스일 경우만 가능
- protected	: 다른 패키지에서 접근 불가 , 단 자식클래스는 가능
- private	: 다른 클래스에서 접근 불가   
    메소드로만 접근   
  -> jsp | getter, setter 사용   
  단축키 : Alt + Shift + R 

* * *

## ★★★★★Casting
-> 형변환
- up casting	: 자식 값을 부모 타입으로 형 변환
        - 예) 65를 char타입 변수에 넣으면 'A'로 바뀜
        
※모든 자식은 부모타입이기 때문에 타입이 달라도 업캐스팅이 가능하다.	
-> 반대로는 불가능하므로 다운캐스팅을 할 때에는 강제형변환이 필요하다. 

down casting	up casting된 객체를 자식 타입으로 형 변환
						

### ※ 부모 값을 자식 타입으로 형변환 시 오류
- 공간이 남으면(구현되지 않은 필드는) 메모리에 할당이 되지 않는다. 따라서 부모타입을 자식으로 바꿀 수 없다.   
단, 업캐스팅 된 값을 '다시' 자식타입으로 변환하면 변환하면서 남는 공간을 채우게 되므로 오류가 되지 않는다.

### Casting을 사용하는 이유
- 모든 자식 값을 전달받기 위해서는 동일한 타입의 저장공간으로 받아야 한다.
- 하지만 자식끼리는 서로 타입이 다르기 때문에 한 번에 전달받을 수가 없다.
- 이 때 up casting을 사용하면, 모든 자식이 부모 타입이므로 하나의 저장공간에   
모든 자식을 받을 수 있게 한다.
- 만약 up casting으로 자식 값을 전달받았다면, 자식에서 새롭게 구현한 기능들은
- 사용할 수 없기 때문에 down casting을 통해서 복구하고 사용한다.

### 객체 간 타입 비교(instanceof)
a instanceof A : 조건식, 참 또는 거짓 중 하나가 나오는 식
- a가 A타입이면 true
- a가 A타입이 아니면 false


* * *

## 추상 클래스
- 필드 안에 구현이 안된 메소드가 선언되어 있는 클래스를 추상 클래스라고 한다.
- 이 때 구현되지 않은 메소드를 추상메소드라고 부른다.
- 반드시 재정의를 통해 구현을 해야지만 메모리에 할당되기 때문에
- "강제성"을 부여하기 위해서 추상 메소드로 선언한다.

### 추상 클래스 선언
```
	abstract class 클래스명{
		abstract 리턴타입 메소드명(매개변수, ...);
		일반 메소드도 선언 가능(구분점을 꼭 둬야한다.)
	}
```

* * *


## 인터페이스(interface)
틀	|클래스와 흡사하지만, 아예 다른 문법
-> 강제성 부여를 위해 사용

- 임의로 변경하면 안됨, -> 상수와 추상메소드만을 사용한다.
- 추상클래스를 고도화시킨 문법(강제성을 심화)
- 상수와 추상메소드만 존재
- 구현은 인터페이스를 지정한 클래스에서 진행하고,
- 인터페이스를 다른 클래스에 지정할 때에는 implements 키워드를 사용한다
	
## 추상클래스와 인터페이스 간의 관계
- 인터페이스를 클래스에 바로 지정하면 모든 메소드에 강제성이 부여되어서
- 전부 다 구현해야 한다. 하지만 일반적인 상황에서는 모든 것이 아닌,
- 필요한 메소드를 골라서 재정의해야한다.
- 인터페이스를 직접 지정하지 않고 다른 클래스에 지정한 후 바디를 만들어 놓는	다면, 강제성이 소멸되고 이 클래스를 상속받아서 필드를 구현한다면, 골라서 재정의할 수 있게 된다.    
- 추상 클래스 이름 뒤에는 Adapter를 붙여 목적을 알	려준다.

* * *


## 마커 인터페이스(Marker Interface)
- 그룹화를 하기 위함.
- 클래스들을 그룹화하기 위한 목적으로 사용
- 인터페이스는 지정한 클래스의 부모이며, 모든 자식은 부모 타입이므로
- 마커 인터페이스를 지정받은 클래스들이 하나의 타입(부모)으로 묶이게 된다.
- 이름 뒤에 Marker를 붙여줘야 한다.

* * *


## 내부 클래스(Inner Class)
- extends를 사용할 필요가 없어진다
- 하나의 클래스에서 a작업과 b작업이 있을 때에는 따로 분리하여 클래스로 만들지 않고, 클래스 안에 클래스를 선언하여 설계한다. 
- 이 때 밖에 있는 클래스를 외부 클래스라고 하며, 안에 선언된 클래스를 내부 클래스라고 한다. 외부 클래		스가 메모리에 할당되어야 내부 클래스를 객체화할 수 있기 때문에 클래스를 숨		기기 위해서 내부 클래스를 사용하기도 하며, 이를 캡슐화 또는 은닉화라고 한			다. 내부 클래스는 외부 클래스의 필드이기 때문에 외부 클래스의 필드를 자신			의 필드처럼 가져다 사용할 수 있게 된다.


※ 메소드 안에서도 클래스 생성가능, 어떤 영역안에서 생성되면 전부 내부 클래스   

*캡슐화, 은닉화 = 다른곳에서 따로 접근할 수 없게 하는 것.*

### 익명 클래스(Anonymous Inner Class) -> 구현을 위한 클래스
- 이름이 없는 클래스이며 구현되지 않은 필드를 구현하기 위해 일회성으로 생성되는 클래스이다.

* * *

## 다중 상속

### 다중 상속 <- JAVA는 다중상속 지원 안함, 모호성때문에 이걸 보완하기 위해 interface
- 여러 부모 클래스를 상속하는 것을 다중 상속이라고 한다.
```	
JAVA는 모호성 때문에 다중 상속을 지원하지 않는다.
하지만 JDK8버전부터는 인터페이스에 default 메소드 선언을 허용하며,
여러 개를 지정할 수 있는 인터페이스 특성상 다중 상속을 지원하는 것이나 다름이 없다.
```

### 모호성(ambiguity)
- 하나의 자식이 여러 부모를 상속받을 때 부모 필드에 동일한 이름의 필드가 있다면, 어떤 부모의 필드인지 알 수가 없다. 이를 모호성이라고 부른다.

### 모호성 해결 방법
- 상황 1
    - 두 개의 인터페이스 내에 같은 이름과 매개변수가 똑같은 메소드가 선언되어 있다. -> 모호성 발생
    - 해결 ====> 자식 클래스에서 재정의하여 사용
- 상황 2
	  - 부모 "클래스"의 메소드와 "인터페이스"의 디폴트 메소드의 이름과 매개변수가 똑같이 선언되어 있다.
    - 해결 ====> 부모 클래스가 우선순위가 더 높다

* * *

## 함수형 인터페이스(Functional interface)
-> 추상메소드 1개   
@FunctionalInterface 붙이고 생성,(추상메소드 2개시 에러)
	
- 인터페이스 중 추상 메소드를 하나만 가지고 있는 인터페이스를 함수형 인터페이스라고 한다.
- 이 때 @FunctionalInterface를 인터페이스 위에 작성하여 단 하나의 추상 메소드만 선언할 수 있도록 제한해야 한다.

### 람다식(Lamda Expression) -> 익명 메소드/함수형 인터페이스
- 이름이 없는 메소드로서 변수처럼 사용이 가능하며, 매개변수로도 전달이 가능하다.
- 함수형 인터페이스는 추상 메소드가 한 개만 선언되기 때문에 메소드 이름이 필요 없다. 따라서 람다식을 익명 메소드(Anonymous Method)라고도 부른다.

### 람다식 문법
1. (매개변수 형식 나열,...) -> 리턴값;
2. (매개변수 형식 나열,...) -> {2개 이상의 문장 작성; retrun 리턴값;}


* * *

## 예외처리
- 에러 : 심각한 오류
- 예외 : 덜 심각한 오류

### 예외 처리 문법
```
	try{
		예외가 발생할 수 있는 문장
	}catch(예외이름(클래스) 객체명){
		예외 발생 시 실행할 문장
```
- 예외 발생 시 해당 예외 필드가 메모리에 할당된다.
- 할당된 주소를 선언한 객체로 받지 못한다면 프로그램이 강제 종료된다.
- 이를 막기 위해 동일한 예외 타입의 객체를 catch문 안에 선언하여 
- 전달되는 주소를 잡아준다.
- 해당 예외 주소가 담긴 catch문의 문장이 실행된다.
```
	}catch(예외이름 객체명)	{
		예외 발생 시 실행할 문장
	}...
```
- 예외 발생시 자동으로 생성자가 만들어지며 필드에 값이 할당된다. 
- 이 주소값을 받을 공간이 없는경우 예외가 발생한다, 이때 catch를 사용하여 주소값을 받을 공간을 만	들면 catch문이 실행된다.

```
	finally{
		예외 발생 여부에 상관없이 무조건 실행할 문장(특정 경우)
		※ 외부장치와 연결했을 경우 다시 닫을 때 주로 사용한다.
		JDBC에서 사용
	}
```

* * *

## API (Application Programming Interface)
-> 처음보는 메소드와 클래스를 정확히 사용하는것이 학습목표   
-> 배포할때는 주석이 모두 사라진다!! -- API주석을 달아야한다. \**  *\   
	개발에 필요한 라이브러리들의 집합   
	선배 개발자들이 많들어 놓은 소스코드

- 내부 API
    - JDK 설치 시 제공해주는 기본 API
    - docs.oracle.com/javase
- 외부 API
    - 선배 개발자들이 개발한 패키지 및 클래스들을 의미한다.
    - 보통 JAR파일로 배포하며 자바 프로젝트의 buildPath에 추가하여 사용할 수 있다.


### JAR 파일로 배포하기
```
   배포할 클래스 또는 패키지 우클릭
   > Export > JAVA/JAR file 선택 > Next
   > destination을 원하는 경로로 선택
   > Export Java source files... 체크
   > Finish
```

### JAR 파일을 프로젝트에 추가하기
```
   배포된 JAR파일을 다운 받기
   > 프로젝트 우클릭 > Build Path > Configure Build Path
   > Libraries 탭 클릭 > ClassPath(안되면 ModulePath) 클릭 > Add External JARs
   > 저장된 경로의 .jar파일을 더블 클릭으로 추가 > Apply 클릭
   > Orders and Exports 탭 클릭
   > Select All 클릭 > Apply and Close
```

* * *

## Object 클래스
-> 모든 클래스의 최상위 부모 클래스   
-> 모든 클래스는 자동으로 Object를 상속받는다.

1. toString()
    - 항상 객체명을 출력할 때에는 toString()이 생략되어 있다.
    - toString()을 통해 출력되는 문자열이 마음에 들지 않는다면, 재정의하여 수정하도록 한다.
    - --> 실무에서는 클래스 선언 시 각 필드의 초기화 여부를 확인하기 위해 사용한다,
2. equals()
    - 주소값 비교(==)
    - String 클래스에서 equals를 값 비교로 재정의하여 사용하기 때문에 문자열 비교는 무조건 equals()로 비교한다.

3. hashCode()
    - (!= 주소값)
    - 메모리를 가기전에 거쳐가는 주소,(= 실제 메모리에 부여될 주소 이전의 주소)
    - JVM에서 관리하는 중복없는 값,실제 메모리에 할당되는 주소와 다르다.
    - String 클래스에서는 필드의 해시코드값이 아닌 필드 안에 있는 문자열 상수값의 해시코드 값을 리턴하도록 재정의하였다.
  
  __※ 컬렉션 프레임워크 챕터에서 재정의 목적을 이해하도록 한다.__

* * *


## Wrapper Class 
### 기본 자료형들의 클래스 타입

- 클래스타입 객체 = new 클래스타입(일반타입의 값); => 권장하지 않음   
-> 일반타입이 클래스타입 객체에 감싸지는 것, boxing
- 클래스타입 객체 = 클래스타입.valueOf(일반타입의 값)  => 권장
- 일반타입 변수 = 객체.000Value(); //unboxing
```
ex) int  --> Integer
   float --> Float
처럼 기본자료형을 클래스로 만들어놓은것
```
- JDK 4버전 이상부터는 auto를 지원한다.
```
클래스타입 객체 = 일반타입의 값; //auto boxing
일반타입 변수 = 객체; //auto unboxing
```
### Wrapper Class를 사용하는 이유
- 원시타입(일반타입)을 박싱하면 다양한 메소드를 제공받을 수 있다.
- 여러 일반 타입을 하나의 타입으로 묶기 위해서는 반드시 클래스 타입(Wrapper	Class)으로 사용해야 되고, 이 때에는 박싱을 해준다.

* * *

## 알고리즘
- 어떤 문제가 발생되었을 때 해결할 수 있는 절차 혹은 순서

## 자료구조
- 의미없는 데이터를 하나의 정보로 만들어주는 알고리즘들의 집합,
- 수집한 자료를 저장하는 방법

## ☆★컬렉션 프레임워크	: 자료구조
- 많은 데이터를 쉽고 효과적으로 관리할 수 있는 표준화된 방법을 제공하는 클래스들의 집	합

## 1. List extends Collection
- List 구현 클래스
- Vector : 용량 관리, 보안성 강화, 처리량 감소 -> 요즘트렌드에 맞지않음
		
### LinkedList : 연결된, 리스트
     FILO(선입후출)으로 인해 넣을 때는 빨라도 뺄 때에는 상대적으로 느리다
     
### ArrayList	: 대다수는 ArrayList이다.
- 인덱스로 데이터를 관리한다.
- 컬렉션 클래스 중 실무에서 가장 많이 사용되는 클래스이다.
- 배열의 특징인 인덱스를 이용하여 값을 저장하고 관리한다.

### 배열과 ArrayList의 차이
- 배열은 길이에 제한을 두어야 할 때 자주 사용하고
- ArrayList는 몇 개의 데이터가 들어올 지 알 수 없을 때 사용한다.

## 2. Set extends Collection
### Set : 집합(절대 중복된 자료를 넣을 수 없다)

### 구현 클래스
- HashSet(검색 특화 자료구조)
    - 집합에서는 중복되는 원소를 포함할 수 없는 것 처럼 
    - HashSet이라는 자료구조는 중복되는 값을 무시한다.
    - 저장된 값들은 인덱스가 없기 때문에 순서가 없다.   
    -> 값을 가져올 수 없다.
    - 값의 유무 검사에 특화되어 있는 자료구조이고
    - 해시코드로 유무 검사가 진행되고 속도가 상대적으로 좋다.   
    --> 검사에 적합한 자료구조, contains()특화
    
- DBMS에서 자료의 조회와 검사시 사용하는 자료구조
    - 순서 부여 : Iterator()
    - 순서가 없는 객체에 순서를 부여하거나, 순서가 있어도 iterator방식의 순서로 변경하고자 할 때 사용한다.
    - hasNext()를 통해 다음 값이 있는 지 검사하고, next()를 사용하여 값을 가져온다

### Set과 ArrayList
Set은 검사의 목적이 있기 때문에 순서 정보를 관리할 필요가 없어서 데이터 크기에 상관없이   
검색에 걸리는 시간이 매우 짧다.   
반면 ArrayList는 index를 관리해야하기 때문에 상대적으로 시간이 오래 걸린다.   
그러므로 기능적 차이가 없다면 Set을 사용한다.

## 3. Map
컬렉션을 상속받지 않는다.

### 구현 클래스
- HashMap(서버 간 데이터 교환)
    - Key(set)와 Value(collection) 한 쌍으로 저장되며, 검색의 목적을 가지고 있다.
    - key는 중복된 값을 넣으면 Value가 최근 값으로 수정되고
    - 중복되지 않은 값을 넣으면 새롭게 추가된다.
    - Value는 중복이 가능하다.

* * *

## 쓰레드
	프로세스 처리 경로

### 단일 쓰레드
- 처리 경로를 한 개만 가지고 있기 때문에 직렬적이다.
- 동시에 많은 양을 처리하기 힘들기 때문에 상대적으로 비효율적이다.
- 하지만 하나의 작업에 문제가 발생하더라도 다른 작업에는 영향을 끼치지 않는다.
- 따라서 안정성이 보장되고 설계 시 멀티 스레드에 비해 쉽다	

### 멀티 스레드
- 하나의 프로세스를 동시에 처리하는 것처럼 보이지만 사실은 매우 짧은 단위로 분할해서 차례로 처리한다.
- 여러 개의 처리 경로를 가질 수 있도록 하며, 동시 작업이 가능해진다.
- 설계하기 굉장히 어려우며 하나의 스레드 문제 발생 시 모든 쓰레드에 문제가 발생하게 된다.
- JAVA 웹 서버가 대표적인 멀티 스레드이다, 멀티 스레드로 설계했다면, 처리량 증가, 효율성 증가,
- 처리비용 감소의 장점이 있기 때문에 단점을 감수하고 설계하는 편이다.

### 멀티 스레드 구현 방법
핵심 : run() 메소드 재정의

1. Thread 클래스 상속
2. Runnable 인터페이스 지정
	
* * *

## 동기화(Synchronized)
- 하나의 쓰레드가 자원에 접근 중일 때 다른 쓰레드가 동시에 같은 자원을 접근하지 못하게 막는 것
- 즉, 자원 공유 문제를 해결할 수 있다.

### 동기화 문법
- 블럭 : synchronized(mutex)	{....}
    - 동기화 블럭이라고 부르며, 일부 소스코드만 동기화를 걸어준다.

- 키워드	: synchronized
    - 영역 전체에 동기화를 걸어주며, 메소드 리턴 타입 앞에 작성하면
    - 해당 메소드 전체에 동기화가 걸린다.
	
