//package example07_10;

public class CarExample {

	public static void main(String[] args) {
		//�ڵ��� ��ü ����
		Car car = new Car();
		System.out.println("ó�� Ÿ�̾��� ����");
		for(int n=0; n<car.tire_set.length; n++)
			System.out.println(car.tire_set[n].location+"�� ����: "+ car.tire_set[n].age);
		System.out.println();
		
		int problemLocation=-1; //-1���� �ʱ�ȭ
		for(int i=1; i<5; i++) {// 5�� ����
			/*
			 * run()�޼ҵ� : ��ũ�� Ÿ�̾��� ��ġ�� �˷��ش�.
			 * */
			problemLocation=car.run(); //Ŭ���� Car�� run()�޼ҵ� ����.=> ��ũ�� ���� Ȯ��.
			
			//��ũ�� ���� ��ü�� �Ѵ�.
			if (problemLocation==0) {//�� ���� Ÿ�̾ ���峵�� => �ѱ�Ÿ�̾�� ��ü
				car.frontLeftTire= new HankookTire("�� ����", 15);
				car.tire_set[problemLocation]=car.frontLeftTire;
				System.out.println("�� ���� HankookTire�� ��ü => ��ü �� ����: "+car.tire_set[problemLocation].age);
			}
			
			if (problemLocation==1) {//�� ������ Ÿ�̾ ���峵�� => ��ȣŸ�̾�� ��ü
				car.frontRightTire= new KumhoTire("�� ������", 13);
				car.tire_set[problemLocation]=car.frontRightTire;
				System.out.println("�� ������ KumhoTire�� ��ü => ��ü �� ����: "+car.tire_set[problemLocation].age);			
			}
			
			if (problemLocation==2) {//�� ���� Ÿ�̾ ���峵�� => �ѱ� Ÿ�̾�� ��ü
				car.backLeftTire=new HankookTire("�� ����", 14);
				car.tire_set[problemLocation]=car.backLeftTire;
				System.out.println("�� ���� HankookTire�� ��ü=> ��ü �� ����: "+car.tire_set[problemLocation].age);
			}
			
			if(problemLocation==3) {//�� ������ Ÿ�̾ ���峵�� => ��ȣŸ�̾�� ��ü
				car.backRightTire=new KumhoTire("�� ������", 17);
				car.tire_set[problemLocation]=car.backRightTire;
				System.out.println("�� ������ KumhoTire�� ��ü=> ��ü �� ����: "+car.tire_set[problemLocation].age);
			}
		
			System.out.println("---------------------------------------------------");			
		}
	}
}
