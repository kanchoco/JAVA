package collectionTest;

public class ForEachTest {
	public static void main(String[] args) {
		int[][] arrData = {{10,30,80},{20,40,10}};
//		각 학생의 총점과 평균 출력
		
		double avg = 0.0;
		int i =0;
		for(int[] arData : arrData) {
			int total = 0;	//한 행 반복 후 초기화
			for(int aData : arData) {	//aData가 arData를 도는 것이므로, aData가 곧 arData의 값
					total += aData;		//
				}
			avg = total/(double)arData.length;	//강제형변환, 계산 전에해야 값이 안짤림
			avg = Double.parseDouble(String.format("%.2f", avg));	//스트링 포맷으로 소숫점 조정 후 더블로 다시 형변환
			
			System.out.println(total);
			System.out.println(avg);
			}
	}
}
