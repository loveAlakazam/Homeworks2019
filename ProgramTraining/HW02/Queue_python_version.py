# -*- coding: utf-8 -*-
"""
Created on Wed Sep 25 22:56:31 2019

@author: loveAlakazam (Eun Kang Choi)
"""
import sys
class QueueNode:
    def __init__(self, item):
        self.data=item
        self.next=None

class Queue:
    def __init__(self):
        self.front=None
        self.rear=None
        
    def is_empty(self):
        if(self.front is None)and(self.rear is None):
            return True
        return False
    
    def enqueue(self, item):
        # 새로운 노드 생성
        new_node= QueueNode(item)
        
        if self.is_empty(): #큐가 비어있다면
            self.front=new_node
        else: #비어 있지 않다면
            self.rear.next=new_node
        self.rear=new_node
    
    def dequeue(self):
        if self.is_empty():
            self.print_error_message('[error] 큐가 비어있습니다!')
        else:
            deleted=self.front
            pop_out_data= deleted.data
            
            # front 의 위치 옮기기 : 현재front의 다음노드로 함.
            self.front=self.front.next
            
            if self.front is None:
                self.rear=None
            del(deleted) # 삭제대상 노드 삭제
            return pop_out_data

    def print_error_message(self, msg):
        print(msg)
        sys.exit()
        
    def print_queue(self):# 현재 큐상태 프린트
        now=self.front
        if now: #가리키는 큐가 존재하면
            while(now!=self.rear):
                print(now.data,end='->')
                now=now.next
            # now==self.rear
            print(now.data, '\n')
    

if __name__ =='__main__':
    queue=Queue() #큐생성
    queue.enqueue(5)    
    queue.enqueue(4)
    queue.print_queue() # 5->4
    
    queue.dequeue() # 4
    for i in range(9,0,-1):
        queue.enqueue(i)
        queue.print_queue()
        
    queue.dequeue() # 9->8->7->6->5->4->3->2->1 
    queue.print_queue()
    
    queue.dequeue() # 8->7->6->5->4->3->2->1
    queue.print_queue()