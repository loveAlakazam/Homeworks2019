import java.util.Scanner;

public class CalculatorMain {
	public static void main(String[] args) {
		//Calculator ��ü ����
		//status=0���� �ʱ�ȭ, memory=0���� �ʱ�ȭ
		Calculator cal= new Calculator();
		
		//Scanner ��ü ����
		Scanner scanner = new Scanner(System.in);
		
		//�Է�
		String inputString;

		//���� ����
		while(true) {
			System.out.print(">>> ");
			inputString= scanner.nextLine();
			// ���ʿ� �����ϴ� �����̽��� �� white charactor �� ����
			inputString.trim();
			
			// Ű q(Q)�� ������ ���ѷ����� ������������ �Ѵ�.(���� ����) 
			if(inputString.equals("q") || inputString.contentEquals("Q") )
				break;
			
			// Ű�� q(Q)�� �ٸ� ���ڶ�� ��� ����.
			cal.run(inputString);
			//cal.printStatus();
		}
		System.out.println("��� ����");
		scanner.close();
	}
}
