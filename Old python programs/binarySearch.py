#Author: COP1000
#Date: 11-10-16
#Description: this program implements the binary search on a sorted array (simulated by a list)
#-------------------------------------------------------------------------------------------------
#
#
def main():
    #declarations
    num = [2,9,14,25,37,92]
    x = 0
    where = -1
    #input x
    x = getX()
    #search
    where = Bsearch(x, num)
    #decision
    if where < 0:
        print(x, " is not found anywhere in the array!")
    else:
        print(x, " is found at position ", where, " in the array")
    
#end main
#================================================
def getX():
    x = 0
    x = int(input("Enter x to search for: "))
    return x
#end getX
#================================================
def Bsearch(x, num):
    first = -1
    last = 6
    middle = 0
    if x < num[first + 1] or x > num[last -1 ]:
        return -1
    else: # x >= num[first] and x <= num[last]    add two extra statements (if...else's) to check for equality at both bounds...in this case fgo back to first = 0 and last = 5
        while last != first + 1:
            
            middle = int((first + last)/2)
            if x == num[middle]:
                return middle
            else:
                if x > num[middle]:
                    first  = middle
                    
                else: #x < num[middle]
                    last = middle 
            #print("first = ", first)
            #print("last = " , last)
        #end while
        return -1
#end Bsearch
#===================================================
#calling main
main()
                
                    
            
    
