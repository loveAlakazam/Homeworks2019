T= int(input())
months_days=[0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
for t in range(1,T+1):
    sm,sd, em, ed= map(int, input().split())
    days=0
    if(sm<em):# (sm+1)월~(em-1)월 동안 요일
        for m in range(sm+1, em):
            days+=months_days[m]
        days+=(months_days[sm]-sd+ed+1)
    else:# sm=em
        days=ed-sd+1
    print('#{} {}'.format(t, days))
