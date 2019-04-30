public class Calculator {
	//private ���� �����ڴ� �ش� Ŭ���� �ٱ������� ������ ���ѵǾ��ִ�.
	//private ���� �����ڸ� ���� �ʵ带 ������ ����(setter), ����(getter)�� �Ѵ�.
	// setter�� getter�� ����ϴ� ������ �ܺο����� ������ ������ �����ϱ� ���ؼ��̴�.
	// setter: �Ű������̸���, private�ʵ��̸��� �����ϰ��Ͽ�, private�ʵ带 ����.
	// getter: private�ʵ尪�� ���� �� �� ������ �ܺο� ����.
	private int memory=0;
	private int num2 = 0;
	private int operator=0;
	
	// ���� �Էµ� ���¸� �����Ѵ�. (0���� �ʱ��Ѵ�)
	private int status=0;
	int opt;//�����ֱ��� �����ڸ� �ǹ���.
	
	public void run(String inputString) {//�Է��� inputString�� ���� ���޹޴´�.	
		// �Է��� ���������� �ǿ��������� Ȯ���Ѵ�.(checkOperator)
		opt=this.checkOperator(inputString);
		
		//�Է��� ������ = ���, �������->�ʵ��ʱ�ȭ ->������
		if(opt==99) 
		{
			//memory �ʵ��� ���� ����Ѵ�.
			this.printStatus();
			
			//��� ����ϸ� operator, num2, status�� �ʱ�ȭ
			this.initField();
		}
		
		// �Է��� �ǿ�����(����)���, �ǿ����ڸ� �ʵ忡 ����(setData)
		else if(opt==-1) {
			//inputString�� ���ڶ�� setData�Լ�����
			//���ڷε� ���ڸ� intŸ������ ��ȯ���Ѽ� memory�� num2�� �ִ´�.
			this.setData(inputString);
		}
		
		//�Է��� �Ϲݿ����� +,-,/,*,%,^ ���,
		else {
			//operator�� set�Ѵ�.
			operator=opt;
			this.setOperator(operator);
			this.setStatus(2); 
		}
		//�����ڸ� �ʵ忡 ����(setOperator)
	}
	
	public void initField() {
		//�ʵ� operator,num2, status�� �ʱ�ȭ �Ѵ�.
		this.setOperator(0);
		this.setNum2(0);
		// ó�� �����Ҷ� ���ڰ��� memory�� �ְ�.. 
		//= �������Ŀ���..memory�� num2�� �־ ���길�ϹǷ�.. 2�� �ʱ�ȭ.
		this.setStatus(2);
	}
	
	public void calculate() {
		// operator�� ���� �ش� ���� �޼ҵ带 ȣ���Ѵ�.
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
			memory=this.mod();
		
		setMemory(memory);
	}
	
	public void printStatus() {
		//print���� ����Ͽ� field���� ����Ѵ�.
		//getMemory()�� ����� ���� ����Ѵ�.
		System.out.println(this.getMemory());
	}
	
	public int checkOperator(String op) {
		//���ڿ� op�� ������ ����, �ǿ���������, =���������� ����.
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
			
			case "=": //��ȣ������
				return 99;
				
			default: //�ǿ�����
				return -1;	
		}
	}
	
	public void setData(String data) {
		//data�� ���޵� ���� ������ ��ȯ�Ͽ� memory�� num2�� �����Ѵ�.
		if(this.getStatus()==0) {//status==0: memory�� data���� �ִ´�.-->status=1�̵�.
			memory=Integer.parseInt(data);
			this.setMemory(memory);
			this.setStatus(1);	
		}
		
		else{//status==2: �ι�° �ǿ����ڿ� data���� �ִ´�.-->status=3�̵�.
			num2=Integer.parseInt(data);
			this.setNum2(num2);
			//�ι�° �ǿ����ڸ� ������ status�� 3���� �Ѵ�.
			this.setStatus(status=3);
			
			//�ι�° �������� ���� �ְԵǸ� �̶� ���.
			//getStatus()�� 3�̶�� ����� �����Ѵ�.
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
		if(num2==0) {//���� num2�� 0�̸� ����� �ȵ��� �˸��� �޽��� ���
			System.out.println("��� ���� : 0���� ���� �� �����ϴ�.");
			return 0;
		}
		else //num2�� 0�� �ƴ϶��.
			return (int)(memory/num2);
		
	}
	
	public int mod() {//operator=5
		//���� num2�� 0�̸� ����� �ȵ��� �˸��� �޽��� ���
		if(num2==0){
			System.out.println("��� ���� : 0���� ���� �� �����ϴ�.");
			return 0;
		}
		else //num2�� 0�� �ƴ϶��
			return (int)(memory%num2);
	}
	
	public int pow() {//operator=6
		// 2^5=32 , what about .. 2^(-5)=...?
		int result=1;
		for(int i=1; i<=num2; i++) 
			result= result*memory;
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

	public int getStatus() {//status���� ��´�(�д´�)
		return status;
	}

	public void setStatus(int status) {//status���� �����Ѵ�.
		this.status = status;
	}
}
