T= int(input())
for t in range(1, T+1):
    N,K= map(lambda x: int(x) , input().split(' '))
    student_list, scores=[],[]
    for n in range(N):
        mid,final, hw= map(lambda x: int(x), input().split(' '))
        score= mid*0.35+ final*0.45+hw*0.2
        student_list.append( [n, score] )
        scores.append(score)
    
    grade=[ 'A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']    
    scores.sort(reverse=True)
    grade_idx=scores.index(student_list[K-1][1]) # student_list[k][1]: k번째 학생이 얻은 점수
    print('#{} {}'.format(t, grade[ grade_idx // (N//10)] ))
