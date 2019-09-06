T= int(input()) #테스트 케이스 입력
for t in range(1,T+1):
    # N입력
    N= int(input())
    p=[]
    for row in range(N):
        p.append([])
        for col in range(row+1):
            if col==0 or col==row:
                p[row].append(1)
            elif row>col:
                p[row].append(p[row-1][col-1]+p[row-1][col])
    
    print("#{}".format(t))
    for row in range(N):
        print(' '.join( str(s) for s in p[row]))
