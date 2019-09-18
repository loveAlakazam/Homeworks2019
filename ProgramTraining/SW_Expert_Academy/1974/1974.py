# 소요시간: 3시간 넘음.. ㅠㅠ
T= int(input())
test= sum(range(1,10))#45
for t in range(1, T+1):
    sudoku=list( list(map(int, input().split()))  for _ in range(9)) #2차원 배열생성
    result=1 #초기화(겹치는 숫자가 없다고 가정)
    # 행
    for row in range(9): 
        if( sum(sudoku[row])!=test):
            result=0
            
    #열
    for col in range(9):
        col_sum=[sudoku[row][col]  for row in range(9)]
        if test!=sum(col_sum ):
            result=0

    #3*3부분행렬
    for row in range(0,9,3):#row=0,3,6
        for col in range(0,9,3):#col=0,3,6
            sub_sum=sum([sum(sudoku[r][col:col+3]) for r in range(row, row+3)])
            if sub_sum!=test:
                result=0
                break
    print('#{} {}'.format(t, result))
