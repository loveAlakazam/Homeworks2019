T= int(input())
for t in range(1,T+1):
    input_str= list(input())
    len_input = len(input_str) #입력글자 길이
    first_char= input_str[0] #첫번째 글자
    second_char=input_str[1] #두번째글자
    result=0 # 초기화
    for idx, i in enumerate(input_str): #idx :index, i: value
        if (i==first_char) and (input_str[idx+1]==second_char)and idx>=2:
            result= len(input_str[:idx])
            break
            
    print('#{} {}'.format(t, result) )
