#Author: COP1000
#Date: 11-17-16
#Description: thsi program demonstrates validation process of a SSN
#-----------------------------------------------------------------------
#
#
def main():
    #declarations
    ssn = " "
    #input
    ssn = getSSN()
    print("this ", ssn, " is good!")
   
 


#end main
#======================
def getSSN():
    #declaration
    Input = " "
    good = False
    #input
    Input = input("Enter SSN: ")
    #validate SSN
    good = checkSSN(Input)
    while not good:
        Input = input("INvalid!...please re-enter SSN:")
        good = checkSSN(Input)
    #end while
    return Input


#end getSSN
#=======================
def checkSSN(Input):
  
    if len(Input) != 9:
        return False
    else:
        i = 0
        while i < len(Input):
            if not str.isdigit(Input[i]):
                return False
            else:
                i = i + 1
            #end if..else
        #end while
    return True
#end checkSSN
main()
        
