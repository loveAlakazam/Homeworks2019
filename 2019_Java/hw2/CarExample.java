//package example07_10;

public class CarExample {

	public static void main(String[] args) {
		//자동차 객체 생성
		Car car = new Car();
		System.out.println("처음 타이어의 수명");
		for(int n=0; n<car.tire_set.length; n++)
			System.out.println(car.tire_set[n].location+"의 수명: "+ car.tire_set[n].age);
		System.out.println();
		
		int problemLocation=-1; //-1으로 초기화
		for(int i=1; i<5; i++) {// 5번 실행
			/*
			 * run()메소드 : 펑크난 타이어의 위치를 알려준다.
			 * */
			problemLocation=car.run(); //클래스 Car의 run()메소드 실행.=> 펑크난 곳을 확인.
			
			//펑크난 곳은 교체를 한다.
			if (problemLocation==0) {//앞 왼쪽 타이어가 고장났다 => 한국타이어로 교체
				car.frontLeftTire= new HankookTire("앞 왼쪽", 15);
				car.tire_set[problemLocation]=car.frontLeftTire;
				System.out.println("앞 왼쪽 HankookTire로 교체 => 교체 후 수명: "+car.tire_set[problemLocation].age);
			}
			
			if (problemLocation==1) {//앞 오른쪽 타이어가 고장났다 => 금호타이어로 교체
				car.frontRightTire= new KumhoTire("앞 오른쪽", 13);
				car.tire_set[problemLocation]=car.frontRightTire;
				System.out.println("앞 오른쪽 KumhoTire로 교체 => 교체 후 수명: "+car.tire_set[problemLocation].age);			
			}
			
			if (problemLocation==2) {//뒤 왼쪽 타이어가 고장났다 => 한국 타이어로 교체
				car.backLeftTire=new HankookTire("뒤 왼쪽", 14);
				car.tire_set[problemLocation]=car.backLeftTire;
				System.out.println("뒤 왼쪽 HankookTire로 교체=> 교체 후 수명: "+car.tire_set[problemLocation].age);
			}
			
			if(problemLocation==3) {//뒤 오른쪽 타이어가 고장났다 => 금호타이어로 교체
				car.backRightTire=new KumhoTire("뒤 오른쪽", 17);
				car.tire_set[problemLocation]=car.backRightTire;
				System.out.println("뒤 오른쪽 KumhoTire로 교체=> 교체 후 수명: "+car.tire_set[problemLocation].age);
			}
		
			System.out.println("---------------------------------------------------");			
		}
	}
}
