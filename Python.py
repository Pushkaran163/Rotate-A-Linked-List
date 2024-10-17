class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
def rotate(head, k):
    if(k==0 or head == None):
        return head
    
    curr = head
    length = 1
    
    while(curr.next is not None):
        curr = curr.next
        length += 1
    
    k %= length
    
    if(k == 0):
        return head
    
    curr.next = head
    
    curr = head
    for _ in range(1, k):
        curr = curr.next
        
    new_head = curr.next
    curr.next = None
    
    return new_head

def printList(node):
    while(node is not None):
        print(node.data, end=" ")
        node = node.next
    print()
    
    
if __name__ == "__main__":
    head = Node(10)
    head.next = Node(20)
    head.next.next = Node(30)
    head.next.next.next = Node(40)
    head.next.next.next.next = Node(50)
    
    print("Given linked list: ", end="")
    printList(head)
    
    k = 6
    head = rotate(head, k)
    
    print("Rotated linked list: ", end="")
    printList(head)
    