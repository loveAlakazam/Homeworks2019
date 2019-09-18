T= int(input())
for t in range(1, T+1):
    N= int(input()) # N*N 배열을 생성한다.
    arr=[]
    for i in range(N):
        arr.extend( list(map( int, input().split()) ))    #일렬로 입력
    answer=[]
    for i in range(3):
        if i==0: # 90도
            starts=list(range(N*(N-1), N*N))
            for j in starts:
                ans=''
                for k in range(j, -1, -N):
                    ans+=str(arr[k])
                answer.append(ans)
                
        elif i==1: #180도
            starts=list( range(N*N-1, 0, -N))
            for j in starts:
                ans=''
                for k in range(j, j-N, -1):
                    ans+=str(arr[k])
                answer.append(ans)                
            
        else: #270도
            starts=list( range(N-1, -1,-1))
            for j in starts:
                ans=''
                for k in range( j, N*N, N):
                    ans+=str(arr[k])
                answer.append(ans)
    print('#{}'.format(t))
    for i in range(N):
        for j in range(i, i+(N*3),N):
            print(answer[j], end=' ')
        print()
