T= int(input()) # 테스트케이스 입력
for t in range(1,T+1):
    n= int(input()) # 압축된문서의 알파벳과 쌍의개수
    result=[]
    #알파벳, 알파벳 개수 입력
    for x in range(n):
        ci, ki= map(lambda x: x, input().split(' '))
        ki = int(ki)
        result.append( ci*ki)
    #리스트-> 문자열
    result=''.join(result)
    #result 길이 , 10글자로 나눌때 행의개수
    result_len =len(result)
    row_len=result_len//10
    if result_len%10 !=0: #result_len이 10으로 나누어떨어지는 수가 아니라면
        row_len+=1
    print('#{}'.format(t))
    for r in range(row_len):
       	if r==row_len-1:
            print( result[r*10:])
       	else:
            print( result[r*10:(r+1)*10])
print()
