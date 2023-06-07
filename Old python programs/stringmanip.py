#Author: COP1000
#Date: 11-10-16
#Description:  string manipulation
#---------------------------------
#
#
name = "qwer/t y"
L = len(name)
print("lenghth of ", name, " is ", L)
ssn = "1234/6789"
print(" length of this ssn is ", len(ssn))
i = 0
while i < len(ssn):
    if str.isdigit(ssn[i]):
        print("character at position ", i, " is a digit")
    else:
        print("character at position ", i, " is NOT a digit")
    i = i + 1
#end while i
print("===============================================")
i = 0
while i < len(name):
    if str.isalpha(name[i]) or str.isspace(name[i]):
        print("character at position ", i, " is a letter or a space")
    else:
        print("character at position ", i, " is NOT a letter or space")
    i = i + 1
#end while i
age = 0
INPUT = input("enter your age: ")
i = 0
while i < len(INPUT):
    if not str.isdigit(INPUT[i]):
        print("invalid age...please re-enter...")
        INPUT = input("enter your age: ")
        
    #end if
    i = i + 1
#end while i
age = int(INPUT)
        


              
              
              
    
