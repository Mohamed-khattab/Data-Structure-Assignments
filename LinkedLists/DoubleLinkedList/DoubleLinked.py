

class Node:
    def __init__(self, data):
        self.prev = None
        self.data = data
        self.next = None


class Doubly_linked_list:
    def __init__(self):
        self.head = None


    def push(self, data):
        new_node = Node(data)
        if self.head == None:
            self.head = new_node
        else:
           cur = self.head
           cur.prev = new_node
           self.head = new_node
           new_node.next = cur


    def insert(self, prev_node, data):
        insert_status = False
        if self.head != None:
            new_node = Node(data)
            cur_node = self.head
            count = self.count()
            while count != 0:
                if cur_node.data == prev_node:
                    if count == 1:
                        new_node.prev = cur_node
                        cur_node.next = new_node
                    else:
                        new_node.next = cur_node.next
                        new_node.prev = cur_node
                        cur_node.next.prev = new_node
                        cur_node.next = new_node

                    insert_status = True
                    break

                cur_node = cur_node.next
                count -= 1

        return insert_status


    def delete(self, key):
        del_status = False
        if self.head != None:
            cur_node = self.head
            count = self.count()
            while count != 0:
                if cur_node.data == key:
                    if cur_node == self.head:
                        self.head = cur_node.next
                        cur_node = None
                    elif cur_node.next == None:
                        cur_node.prev.next = None
                        cur_node = None
                    else:
                        cur_node.prev.next = cur_node.next
                        cur_node.next.prev = cur_node.prev
                        cur_node = None

                    del_status = True
                    break

                cur_node = cur_node.next
                count -= 1

        return del_status


    def display(self):
        if self.head is not None:
            ll = []
            cur_node = self.head
            while cur_node != None:
                ll.append(cur_node.data)
                cur_node = cur_node.next

            print(ll)
        else:
            print('[List is empty]')


    def count(self):
        ll_len = 0
        cur_node = self.head
        while cur_node != None:
            ll_len += 1
            cur_node = cur_node.next

        return ll_len



if __name__ == "__main__":
  link = Doubly_linked_list()
  list = input().replace("]","").replace("[","")
  array = list.split(",")

  for x in array :
    link.push(int(x))
  
  operation = input()
  
  if(operation=="add"):
    num = input() 
    link.push(int(num))
    
  if(operation=="addToIndex"):  
    lkf
  if(operation=="isEmpty"):  
        lk

  if(operation=="set"):  
    lk
  if(operation=="get"):  
    po

  if(operation=="size")   :
    lg
  if(operation=="contains"):
    kld
  if(operation =="sublist"):

  if(operation=="clear") :
