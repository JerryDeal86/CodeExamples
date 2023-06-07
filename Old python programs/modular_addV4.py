#Author : COP1000
#Date: 10-11-16
#Description:   
#we will declare our variables outside of all functions to make them available to all
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
    sum = add( a , b )

    #output:
    display(a, b, sum)
#end main
#------------------------------------------------------ 
def get_a_b():

    global a, b
    
    a = int(input("Enter a: "))

  
    b = int(input("Enter b: "))
  
#end get_a_b
 
#----------------------------------------------------------
def add( a, b ):   
    sum = 0
    sum = a + b
    return sum
#end add
#-----------------------------------------------------------
def display(a, b, sum):
     print("sum of ", a, " and " , b , " is " ,sum)
#end display
    
#calling main
main()

#for Thursday, now that all variables are global, fix the program so it takes advantage of this new approach


