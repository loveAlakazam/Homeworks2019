#13분14초
T=int(input())
for t in range(1,T+1):
    P,Q,R,S,W= map(int, input().split())
    A= W*P #A사: 1리터당 P원, W리터당=> P*W원
    #B사: (W<=R) Q원 (W>R) Q+(W-R)*S
    B=Q
    if(W>R):
        B+=S*(W-R)
    result=min(A,B)
    print('#{} {}'.format(t, result))
