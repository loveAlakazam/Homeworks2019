public class Calculator {
	//private 접근 제한자는 해당 클래스 바깥에서는 접근이 제한되어있다.
	//private 접근 제한자를 갖는 필드를 가지고 설정(setter), 읽음(getter)을 한다.
	// setter와 getter을 사용하는 이유는 외부에서의 데이터 접근을 방지하기 위해서이다.
	// setter: 매개변수이름과, private필드이름을 동일하게하여, private필드를 저장.
	// getter: private필드값을 읽은 후 그 값으로 외부에 전달.
	private int memory=0;
	private int num2 = 0;
	private int operator=0;
	
	// 현재 입력된 상태를 저장한다. (0으로 초기한다)
	private int status=0;
	int opt;//가장최근의 연산자를 의미함.
	
	public void run(String inputString) {//입력을 inputString을 통해 전달받는다.	
		// 입력이 연산자인지 피연산자인지 확인한다.(checkOperator)
		opt=this.checkOperator(inputString);
		
		//입력이 연산자 = 라면, 연산수행->필드초기화 ->결과출력
		if(opt==99) 
		{
			//memory 필드의 값을 출력한다.
			this.printStatus();
			
			//결과 출력하면 operator, num2, status를 초기화
			this.initField();
		}
		
		// 입력이 피연산자(숫자)라면, 피연산자를 필드에 저장(setData)
		else if(opt==-1) {
			//inputString이 숫자라면 setData함수에서
			//문자로된 숫자를 int타입으로 변환시켜서 memory와 num2에 넣는다.
			this.setData(inputString);
		}
		
		//입력이 일반연산자 +,-,/,*,%,^ 라면,
		else {
			//operator을 set한다.
			operator=opt;
			this.setOperator(operator);
			this.setStatus(2); 
		}
		//연산자를 필드에 저장(setOperator)
	}
	
	public void initField() {
		//필드 operator,num2, status를 초기화 한다.
		this.setOperator(0);
		this.setNum2(0);
		// 처음 시작할때 숫자값만 memory에 넣고.. 
		//= 연산이후에는..memory에 num2에 넣어서 연산만하므로.. 2로 초기화.
		this.setStatus(2);
	}
	
	public void calculate() {
		// operator에 따라 해당 연산 메소드를 호출한다.
		int operator=getOperator();
		if (operator==1)
			this.memory=this.add();
		
		else if(operator==2)
			this.memory=this.sub();
		
		else if(operator==3)
			this.memory=this.mul();
		
		else if(operator==4)
			this.memory=this.div();
		
		else if(operator==5)
			this.memory=this.mod();
		
		else if(operator==6)
			memory=this.pow();
		
		setMemory(memory);
	}
	
	public void printStatus() {
		//print문을 사용하여 field값을 출력한다.
		//getMemory()에 저장된 값을 출력한다.
		System.out.println(this.getMemory());
	}
	
	public int checkOperator(String op) {
		//문자열 op가 연산자 인지, 피연산자인지, =연산자인지 구분.
		switch(op) {
			case "+": 
				return 1;
				
			case "-": 
				return 2;
			
			case "*":
				return 3;
				
			case "/":
				return 4;
				
			case "%":
				return 5;
				
			case "^":
				return 6;
			
			case "=": //등호연산자
				return 99;
				
			default: //피연산자
				return -1;	
		}
	}
	
	public void setData(String data) {
		//data로 전달된 값을 정수로 변환하여 memory나 num2에 저장한다.
		if(this.getStatus()==0) {//status==0: memory에 data값을 넣는다.-->status=1이됨.
			memory=Integer.parseInt(data);
			this.setMemory(memory);
			this.setStatus(1);	
		}
		
		else{//status==2: 두번째 피연산자에 data값을 넣는다.-->status=3이됨.
			num2=Integer.parseInt(data);
			this.setNum2(num2);
			//두번째 피연산자를 넣으면 status를 3으로 한다.
			this.setStatus(status=3);
			
			//두번째 변수까지 값을 넣게되면 이때 계산.
			//getStatus()가 3이라면 계산을 수행한다.
			if(this.getStatus()==3)
				this.calculate();
		}
	}
	
	public int add() {//operator=1
		return memory+num2;
	}
	
	public int sub() {//operator=2
		return memory-num2;
	}
	
	public int mul() {//operator=3
		return memory*num2;
	}
	
	public int div() {//operator=4
		if(num2==0) {//만약 num2가 0이면 계산이 안됨을 알리는 메시지 출력
			System.out.println("계산 오류 : 0으로 나눌 수 없습니다.");
			return memory; //0으로 나누는 연산은 안되므로 memory값은 이전값 그대로 유지
		}
		else //num2가 0이 아니라면.
			return (int)(memory/num2);
		
	}
	
	public int mod() {//operator=5
		//만약 num2가 0이면 계산이 안됨을 알리는 메시지 출력
		if(num2==0){
			System.out.println("계산 오류 : 0으로 나눌 수 없습니다.");
			return memory;//0으로 나누는 연산은 안되므로 moemroy값은 이전값 그대로 
		}
		else //num2가 0이 아니라면
			return (int)(memory%num2);
	}
	
	public int pow() {//operator=6
		//memory가 밑, num2가 
		int result=1;
		if(num2>0) {
			for(int i=1; i<=num2; i++) 
				result= result*memory;
			return result;
			
		}else if(num2<0) {
			for(int i=1; i<=num2; i++) 
				result= result*memory;
			return (1/result);
		}else //num2=0
			return result;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.setStatus(3);
		this.num2 = num2;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		setStatus(2);
		this.operator = operator;
	}

	public int getStatus() {//status값을 얻는다(읽는다)
		return status;
	}

	public void setStatus(int status) {//status값을 저장한다.
		this.status = status;
	}
}
