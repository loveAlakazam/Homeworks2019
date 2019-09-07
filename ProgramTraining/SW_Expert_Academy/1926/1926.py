# N 입력
N= int(input())
claps=['3','6','9']
result=[]
for n in range(1, N+1): # 1,2,..., N
    str_n=str(n) #문자열타입으로 변환
    str_len=len(str_n)
    ans=''
    # n의 각 자리의 숫자들
    cnt=0 #3,6,9 개수
    for s in range(str_len):# 각 자리수마다 3,6,9가 있는지 확인
        if str_n[s] in claps:
            ans+='-'
            cnt+=1	
    if cnt>0: # 3,6,9 개수만큼 -를 넣는다.
        result.append(ans)    
    else:# 그냥 숫자를 넣는다.
        result.append(str_n) 
print(' '.join(result))
