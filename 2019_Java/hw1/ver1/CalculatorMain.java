import java.util.Scanner;

public class CalculatorMain {
	public static void main(String[] args) {
		//Calculator 객체 생성
		//status=0으로 초기화, memory=0으로 초기화
		Calculator cal= new Calculator();
		
		//Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);
		
		//입력
		String inputString;
		System.out.print(">>> ");
		//무한 루프
		while(true) {
			inputString= scanner.nextLine();
			// 양쪽에 존재하는 스페이스바 등 white charactor 를 제거
			inputString.trim();
			
			// 키 q(Q)를 누르면 무한루프를 빠져나가도록 한다.(계산기 종료) 
			if(inputString.equals("q") || inputString.contentEquals("Q") )
				break;
			
			// 키가 q(Q)외 다른 문자라면 계속 동작.
			cal.run(inputString);
			cal.printStatus();
		}
		System.out.println("계산 종료");
		scanner.close();
	}

}
