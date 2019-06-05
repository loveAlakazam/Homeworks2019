//package example07_10;

// 금호타이어, 한국타이어의 부모 객체
public class Tire {
	//필드
	public int maxRotation;			//타이어 최대 회전수 0으로 초기화
	public int accumulatedRotation; //타이어 누적 회전수 0으로 초기화
	public String location; 		//타이어 위치
	public int age; //타이어의 수명
	
	//생성자: 외부에서  location과 maxRotation으로 받아서 객체 생성
	public Tire(String location, int maxRotation) 
	{
		this.location = location;
		this.maxRotation=maxRotation;
		//객체 생성시..->타이어 수명 : 최대회전수로 초기화.
		this.age=maxRotation; 
	}
	
	// Tire의 메소드
	public boolean roll() {
		++accumulatedRotation;
		age=maxRotation-accumulatedRotation;
		if (accumulatedRotation<maxRotation) {
			System.out.println(location+" 타이어의 수명: "+age);
			return true;
		}
		else {// accumulatedRotation>=maxRotation :펑크남.
			System.out.println("****"+location +"타이어 펑크 남  ****");
			return false;
		}
	}
}
