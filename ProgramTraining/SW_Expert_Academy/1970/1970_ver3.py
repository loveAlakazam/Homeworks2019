T= int(input())
moneys=[50000, 10000, 5000, 1000, 500, 100, 50, 10]
for t in range(1,T+1):
    n= int(input()) #돈 입력
    print('#{}'.format(t))
    for money in moneys:
        cnt= n//money
        if cnt >0:
            n-=(money*cnt)   
        print(cnt, end=' ')
    print()
