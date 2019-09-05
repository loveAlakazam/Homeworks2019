T=int(input()) #테스트케이스를 읽는다.
for t in range(1,T+1):
  result=0
  N=int(input()) #숫자입력
  for i in range(1, N+1):
    if i%2 !=0: #홀수는 더하고
      result+=i
    else: #짝수는 뺀다.
      result-=i
  print("#{} {}".format(t,result))
