T= int(input())
#money의 반복호출이 필요없을것같아서.. 밖으로 뺐다.=> 3
moneys=[50000, 10000, 5000, 1000, 500, 100, 50, 10]
for t in range(1,T+1):
    n= int(input()) #돈 입력
    result=[]
    for money in moneys:
        cnt= n//money
        result.append(cnt)
        if cnt >0:
            n-=(money*cnt)   
    print('#{}\n{}'.format(t, ' '.join( str(r) for r in result ) ) )
