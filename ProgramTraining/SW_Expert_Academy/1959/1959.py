# 소요시간 34분 5
T=int(input())
for t in range(1,T+1):
    N,M= map( int , input().split())
    A=list(map(int , input().split()))
    B=list(map(int, input().split()))
    result_list=[]
    if(M>=N):
        for i in range(M-N+1):
            result=0
            for j in range(N):
                result+=A[j]*B[i+j]
            result_list.append(result)
    else:#M<N
        for i in range(N-M+1):
            result=0
            for j in range(M):
                result+=A[i+j]*B[j]
            result_list.append(result)
    result=max(result_list)
    print('#{} {}'.format(t, result))
