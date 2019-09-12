# 답은 일치한데.. sw expert 아카데미에선 numpy를 지원 안한다네요.. ^^;
import numpy as np
T= int(input()) #테스트 케이스 입력

for t in range(1, T+1):
    N,M = map(lambda x: int(x), input().split(' ')) # N, M 입력
    flies=[]
    for n in range(N):
        flies.extend( [ int(x) for x in input().split(' ')])

    # list=> N*N array
    flies= np.array(flies).reshape(N,N)

    # 파리 죽인최대값
    max_kill=0

    # CNN 원리 이용
    # row: 마스크의 시작점의 행번호
    # col : 마스크의 시작점의 열번호
    for row in range(0, N-M+1):
        for col in range(0, N-M+1):
            mask=flies[row:row+M, col:col+M]
            kill_cnt= np.sum(mask)
            if kill_cnt> max_kill:
                max_kill= kill_cnt
            kill_cnt=0 #초기화
    print('#{} {}'.format(t, max_kill))
