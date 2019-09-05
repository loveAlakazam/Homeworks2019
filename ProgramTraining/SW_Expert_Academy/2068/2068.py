T=int(input()) #테스트 케이스를 읽는다.
for t in range(1,T+1):
  N=input().split()
  N=[ int(x) for x in N]
  print("#{} {}".format(t, max(N)))
