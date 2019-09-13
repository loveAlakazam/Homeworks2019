T=int(input())
for t in range(1,T+1):
    N = int(input()) 
    nums= [ int(x) for x in input().split(' ') ]
    nums.sort()
    result= ' '.join( str(x) for x in nums)
    print('#{} {}'.format( t,  result))
