# -*- coding: utf-8 -*-
"""
Created on Wed Sep 25 18:51:05 2019
@author: loveAlakazam(Eun Kang Choi)
"""      
import sys
# 스택 클래스
class Stack:
    # Stack 클래스 초기화
    def __init__(self):
        self.stack_body=[]
        self.top=-1
        
    # 비어있는지 확인
    def is_empty(self):
        if (self.top<=-1) and (len(self.stack_body)==0):
            return True
        return False
        
    # error프린트
    def error_message(self, msg):
        print(msg)
        sys.exit()
    
    # push함수 
    def push(self, item):
        self.stack_body.append(item)
        self.top= self.top+1
    
    # peek함수
    def peek(self):
        if self.is_empty(): #비어있는 스택이면 peek불가
            self.error_message('[Error] 비어있습니다')
        else: #비어있지 않았다면
            # 파이썬은 마지막 원소의 인덱스를 -1로 한다.
            return self.stack_body[-1]
    
    # pop함수
    def pop(self):
        if self.is_empty():
            self.error_message('[Error] 비어있습니다.')
        else:
            # 가장 마지막 원소(인덱스가 -1인 원소)를 뺀다.
            del(self.stack_body[-1])
            self.top= self.top-1
            
if __name__=='__main__':
    def print_stack_info(stack):
        print('stack: {}, top: {}\n'.format(stack.stack_body, stack.top))
    
    stack=Stack()
    print_stack_info(stack)
    
    for i in range(1,11):
        stack.push(5*i)
    print_stack_info(stack)
    
    print('맨 위의 원소: ',stack.peek())
    
    for i in range(1,12):
        stack.pop()
        print_stack_info(stack)
