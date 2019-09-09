import collections
T = int(input()) #테스트케이스 입력
for t in range(1, T+1):
    pattern= input() #입력글
    len_pattern= len(pattern)
    char_cnt= list(collections.Counter(pattern).keys()) #카운터결과의 key값(글자)
    first_char=pattern[0] # 입력글의 첫번째 글자.
    last_char_cnt_idx= pattern.index(char_cnt[-1]) #카운터결과에서 제일마지막 글자의 index
    for idx in range(last_char_cnt_idx,  len_pattern):
        #마지막글자의 위치를 시작점으로 첫번째 글자와 같은지 확인
        if pattern[idx]==first_char: 
            last_char_cnt_idx= idx
            break
    print('#{} {}'.format(t, len(pattern[:idx])))
