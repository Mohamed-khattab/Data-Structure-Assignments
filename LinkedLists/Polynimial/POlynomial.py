

class Node:    
    def __init__(self, data):                           # define the attributes for the node obj 
        self.prev = None                                # since it  is double linked list it has a prev and next refrences 
        self.data = data
        self.next = None
        


class Doubly_linked_list:
    def __init__(self,name):                                   # construtor to initialize sone data   
        self.head = None
        self.size =0

        self.name = name


    def getObjectName(self):
        return self.name

    def add(self, data ):
                                                        # add tot the end method 
        if self.head is None:                           # check if it is empty or not if empty create a node 
            new_node = Node(data)
            self.head = new_node            
        else :    
            curr = self.head                                # if not empty it map to the last node and insert a one after it 
            while curr.next is not None:
                curr = curr.next
            new_node = Node(data)
            curr.next = new_node
            new_node.prev = curr

        self.size += 1
    
    def get(self,index):
        if index < 0 or index >= self.size :                       #
            return "Error"                      # check if the index is valid or not 
        count =0
        curr = self.head 
        while curr is not None:                             # check till the end searching forthe index then return the value 
            if count == index:
                break
            curr = curr.next
            count +=1   

        return curr.data

    # def set(self,index, data ):                                 # set specific value to element 
    #     if index < 0 or index >= self.size :
    #         print("Error")
    #     else : 
    #         count =0
    #         curr = self.head 
    #         while curr is not None:                                 # iterate till find the index , then change the corrosponding value 
    #             if count == index:
    #                 curr.data = data
    #                 break
    #             curr = curr.next
    #             count +=1   

    #         self.display()   


    def clear(self):                                       # clear all values dd the list 
        count = self.size                                            # map on eack element and pass it to the renove method 
        while count :
            self.remove(0,"inremove")
            count -=1
        self.display()    


    def remove(self,index,method ):  
        if index < 0 or index >= self.size :
            print("Error")
        else :                             # remove the node by index 
            if self.head != None:
                curr = self.head
                count = 0                        # check if empty or not 
                
                while (curr is not None ) :
                    if count == index :
                        if curr == self.head:               # chaeck if that element is the first element or not , if yes put the prev to none 
                            self.head = curr.next
                            curr = None
                        elif curr.next == None:             # check if that element  is the last one or not , if then put next to none 
                            curr.prev.next = None
                            curr = None
                        else:
                            curr.prev.next = curr.next      # if it in the midlde of the list delete it, shift the other  
                            curr.next.prev = curr.prev
                            curr = None
                        break
                    curr = curr.next
                    count += 1
            self.size -= 1 
            if method == "remove":
                self.display()        


    def Size(self):                                     # return the size of the list
                                                        # return self.size 
        print(self.size)
    

    def display(self):                                  # diaplay all the values of the list 
        # if self.head is not None:
        numbers = []                                # check if empty od not , cewate an array then apped all values on it then print it  
        curr = self.head                            
        while curr != None:
            numbers.append(curr.data)
            curr = curr.next

        return numbers

# def 


if __name__ == "__main__":
    
    for i in range(3) :
        operation = input()

        dictionary = dict()

        if(operation == "set") :
            polynomial = input()
            polynomial = Doubly_linked_list(polynomial)
            numbers  = input()      
            list = numbers.replace("]","").replace("[","").split(",")                                              # create new object called link                                                                                                             # take the input as string an remove the brackets 
            if not(len(list) ==1 and str(list[0])=="") :                                                                        #  split the stream by , and put the to array  
                    for x in list :                             # push the values of the input to link obj 
                            polynomial.add(int(x))
            
            dictionary.update({polynomial.getObjectName:polynomial})
            

        #    if (operation=="print"):
        #     var = input()
        #     if(var in list):
        #         polynomial.
        #     # polynomial.


        if operation=="add":

            arrayone = dictionary[input()].display()
            arraytwo =dictionary[input()].display()

            r =[]
            if(arrayone.lenght == len(arraytwo)):
                for i in range(len(arrayone)) :
                    r.append(arrayone[i]+arraytwo[i])
            else :
                print("balah")

            R = Doubly_linked_list()
            for x in r :   # add r element in r object 
                R.add(x)

            print(R.display())    



    # if operation=="sub":
    #     inone = input()
    #     intwo = input()

    #     #  here u must specify the methos to return th eobject fron the list

    #     arrayone = polynomial.display()
    #     arraytwo =polynomial.display()

    #     r =[]
    #     if(arrayone.lenght == len(arraytwo)):
    #         for i in range(len(arrayone)) :
    #             r.append(arrayone[i] - arraytwo[i])

    #     R = Doubly_linked_list()
    #     for x in r :   # add r element in r object 
    #         R.add(x)

    # if operation=="mult":
    #     inone = input()
    #     intwo = input() 

    #     #  here u must specify the methos to return th eobject fron the list

    #     arrayone = polynomial.display()
    #     arraytwo =polynomial.display()

    #     r =[]
    #     if(arrayone.lenght == len(arraytwo)):
    #         for i in range(len(arrayone)) :
    #             r.append(arrayone[i] * arraytwo[i])

    #     R = Doubly_linked_list()
    #     for x in r :   # add r element in r object 
    #         R.add(x)

    # if(operation=="clear") :
    #     inone = input
    #     polynomial.clear()


    # if operation == "eval":
    #     inone = input()
    #     evaluateValue = input()
        
    #     r =0
    #     array = polynomial.display()
    #     for i in range(len(array)-1 ,0,-1) :
    #         r += array[i]**i 


# set
# A
# [1,-3,2]
# set
# B
# [1,-5,6]
# add
# A
# B