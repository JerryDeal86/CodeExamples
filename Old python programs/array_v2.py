#Author: COP1000
#Date: 10-18-16
#Description: this program simulates the implementation of arrays using lists
#in Python. We will limit ourselves to tools that act on "arrays" only
#no tool or technique specific to list will be used
#---------------------------------------------------------------------------------
#
num = [0,0,0,0,0] # an "array" with 5 entries all set to zero
i = 0
while i < 5:
    num[i] = int(input("Enter an integer: "))
    i = i + 1
#end while
i = 0
while i < 5:
    print("The value stored at position " , i, " is ", num[i])
    i = i + 1
#end while
