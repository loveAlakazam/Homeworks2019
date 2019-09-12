T= int(input())
for t in range(1,T+1):
    score= [ int(x) for x in input().split(' ') if x is not '']
    score.sort()
    #모두 더하고 가장큰수와 가장 작은수를 뺀다.
    result= sum(score[1:-1])
    result= float( result /(len(score)-2) )
    print('#{} {}'.format (t,round(result) ))
