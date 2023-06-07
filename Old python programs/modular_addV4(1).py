#Author : COP1000
#Date: 10-13-16
#Description:   
#we will declare our variables outside of all functions to make them available to all
#version with fixes
#==================================================================== 
#
#
#global variablees
#declarations:
a = 0
b = 0
sum = 0
def main():
    
    #input:
    get_a_b()
    #calculation:
    add()

    #output:
    display()
#end main
#------------------------------------------------------ 
def get_a_b():

    global a, b
    
    a = int(input("Enter a: "))

  
    b = int(input("Enter b: "))
  
#end get_a_b
 
#----------------------------------------------------------
def add(   ):

    global a, b, sum
    
    sum = a + b
     
#end add
#-----------------------------------------------------------
def display():
    
     print("sum of ", a, " and " , b , " is " ,sum)
#end display
    
#calling main
main()

 


