import collections
T= int(input()) #테스트케이스 입력
for t in range(1,T+1):
    # 입력데이터 넣는다.
    n=int(input())
    #점수를 입력
    scores= [ int(x) for x in list(input().split(' ')) if x is not '']
    cnt = collections.Counter(scores)
    result=cnt.most_common()[0][0]
    print('#{} {}'.format(n, result))
