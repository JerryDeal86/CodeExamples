#Author : COP1000
#Date: 10-11-16
#Description: this program implements a function to add two integers   ...adding fucntions for input and output..we will use Python own way of
#using a single fucntion for all input

#==================================================================== 
#
#
def main():
    #declarations:
    a = 0
    b = 0
    sum = 0
    #input:
    a, b = get_a_b() #let's assume we cdannot receive more than a single value frm a function via a return statement
    #calculation:
    sum = add( a , b )

    #output:
    display(a, b, sum)
#end main
#-------------------------------------------------------
def get_a_b():
    a = 0
    b = 0
    a = int(input("Enter a: "))
    b = int(input("Enter b: "))
    return a, b #we will not use this technique again!  we will assume from now on that Python does not support this
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

#for next time, move the input and output to separate functions
