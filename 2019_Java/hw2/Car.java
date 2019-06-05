//package example07_10;

public class Car {
	//필드
	//Tire타입의 객체
	Tire frontLeftTire = new Tire("앞 왼쪽", 6);	//최대회전수: 6
	Tire frontRightTire = new Tire("앞 오른쪽",2);	//최대회전수: 2
	Tire backLeftTire = new Tire("뒤 왼쪽", 1);	//최대회전수: 3
	Tire backRightTire = new Tire("뒤 오른쪽",3);	//최대회전수: 4
	
	Tire [] tire_set= {frontLeftTire, frontRightTire, backLeftTire, backRightTire};
	
	//생성자(기본생성자)
	//public Car() {}
	
	//메소드
	int funk_tire=-1;
	int run() {
		System.out.println("자동차가 달립니다.");
		for(int i=0; i<tire_set.length; i++) {
			if( tire_set[i].roll()==false) //tire_set[i]가 가리키는 타이어에서 펑크났다.
			{
				funk_tire=i;
				
				//펑크난 이후의 타이어의 회전수도 고려해야하므로.
				for(int j=funk_tire+1; j<tire_set.length; j++) //funk_tire 이후의 타이어의 회전수도 고려해야하므로..
					tire_set[j].age-=1;	
				stop();
			}	
		}
		return funk_tire;	
	}
	
	final void stop() {//메소드 재정의(오버라이딩)가 안됨. 부모 그대로 사용.
		System.out.println("자동차가 멈춥니다.");
	}
}
