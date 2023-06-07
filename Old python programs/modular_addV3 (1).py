#Author : COP1000
#Date: 10-11-16
#Description:  now that we are assuming, under Python that a function cannot return multiple values we need to fix this
#by copding one function for each input <========constraint on hand

#==================================================================== 
#
#
def main():
    #declarations:
    a = 0
    b = 0
    sum = 0
    #input:
    a = get_a()
    b = get_b()
    #calculation:
    sum = add( a , b )

    #output:
    display(a, b, sum)
#end main
#-------------------------------------------------------#with the constraint on hand, we can only use one function for each of the input
def get_a():
    a = 0
    a = int(input("Enter a: "))
    return a
#end get_a
#-------------------------------------------------------
def get_b():
    b = 0
    b = int(input("Enter b: "))
    return b
#end get_b
 
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

#for next time, move the input and output to separate functions
