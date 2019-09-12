T= int(input()) #테스트케이스 입력
for t in range(1,T+1):
    h1, m1, h2, m2= map(lambda x: int(x), input().split(' '))
    add= lambda x, y : x+y
    h= add(h1,h2)
    m= add(m1,m2)
    if m>=60:
        m-=60
        h+=1
    if h>=12:
        h-=12
    print('#{} {} {}'.format(t,h ,m )) 
