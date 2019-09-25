# -*- coding: utf-8 -*-
"""
Created on Wed Sep 25 18:51:05 2019
@author: loveAlakazam
"""

# 연결리스트의 노드 클래스
class ListNode:
    def __init__(self, item):
        self.data= item #데이터값
        self.next= None #링크주소
        
        
# 연결리스트 클래스
class LinkedList:
    def __init__(self):# 연결리스트 초기화
        # 포인터헤드(root)는 처음에 없다.
        # 선행노드는(pre)는 존재하지 않는다.
        self.root=None
        self.pre= None
        
    
    def insert_at_begin(self, item):# 맨앞에 노드를 삽입한다.
        # 새로운 노드 생성
        new_node= ListNode(item)
        
        # 헤드가 가리키는 노드가 존재하지 않는다.
        if self.root is None:
            self.root=new_node
        
        # 헤드가 가리키는 노드는 존재, 선행노드가 존재하지 않는다.
        elif self.pre is None:
            new_node.next=self.root
            self.root=new_node
            
        
    def insert_at_tail(self, item):# 맨뒤에 노드를 삽입한다.
        # 새로운 노드 생성
        new_node=ListNode(item)
        now= self.root
        if now is None:# 헤드가 가리키는 노드가 존재하지 않음.
            self.root= new_node
        else:# 헤드가 가리키는 노드가 존재함
            # 다음 링크가 None일때까지 계속 이동
            while now.next:
                now=now.next
            # now.next가 None인 (마지막노드)노드에 도달
            now.next=new_node
        
        
    def delete_at_begin(self):# 맨 앞의 노드를 지운다.
        deleted= self.root
        if deleted is not None:
            self.root= deleted.next
            
    def delete_at_tail(self): # 맨뒤의 노드를 지운다.
        deleted=self.root #지우려는 노드
        pre_deleted= None #지우려는 노드의 선행노드
        if deleted is not None:
            while(deleted.next): #마지막까지 계속 가기
                pre_deleted=deleted
                deleted= deleted.next
            pre_deleted.next=None
            
    def print_linked_list(self):
        now=self.root
        while(now):
            if now.next is None:
                print(now.data)
            else:
                print(now.data,end='-> ')
            now=now.next
            
if __name__=='__main__':
    sample_linked_list=LinkedList()
    sample_linked_list.insert_at_begin(1)   # 1
    sample_linked_list.print_linked_list() 
    
    sample_linked_list.insert_at_tail(2)    # 1->2
    sample_linked_list.print_linked_list() 
    
    sample_linked_list.insert_at_begin(3)   # 3->1->2
    sample_linked_list.insert_at_tail(9)    # 3->1->2->9
    sample_linked_list.print_linked_list()
    
    sample_linked_list.delete_at_tail()     # 3->1->2
    sample_linked_list.print_linked_list()  
    
    sample_linked_list.delete_at_begin()    # 1->2
    sample_linked_list.print_linked_list()
    
    
    
