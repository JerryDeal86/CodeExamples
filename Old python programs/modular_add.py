#Author : COP1000
#Date: 9-29-16
#DEscription: this program implements a function to add two integers
#=================================================================================
#
#
def main():
    #declarations:
    a = 0
    b = 0
    sum = 0
    #input:
    a = int(input("Enter a: "))
    b = int(input("Enter b: "))
    #calculation:
    sum = add( a , b )

    #output:
    print("sum of ", a, " and " , b , " is " ,sum)
#end main
#----------------------------------------------------------
def add( a, b ):
    sum = 0
    sum = a + b
    return sum
#end add
#-----------------------------------------------------------
#calling main
main()

#for next time, move the input and output to separate functions
