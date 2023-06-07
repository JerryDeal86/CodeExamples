#Author : COP1000
#Date: 10-4-16
#Description: this program implements a function to add two integers  ...supporting the claim of call by value
#==================================================================== 
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
def add( x, y ):  #naming a and b and sum x, y, and result respectively does not affect the program ...we are doing a call by value 
    result = 0
    result = x + y
    return result
#end add
#-----------------------------------------------------------
#calling main
main()

#for next time, move the input and output to separate functions
