#Author: COP1000
#Date: 11-17-16
#Description: this program demonstrates validation process of a city name assume the name has one word
#-----------------------------------------------------------------------
#
#
def main():
    city = " "

    city = getcity()

    print("The city ", city , " is good!")


#end main
#================================
def getcity():
    Input = " "
    good = False

    Input = input("Enter City Name: ")
    good = checkcity(Input)
    while good == False:
        Input = input("Invalid name!...please re-enter city: ")
        good = checkcity(Input)
    #end while
    return Input


#end getcity()
#=================================
def checkcity(Input):
    i = 0
    while i < len(Input):
        if not str.isalpha(Input[i]) and not str.isspace(Input[i]):
            return False
        else:
            i = i + 1
        #end if...else
    #end while
    return True
#end checkcity
#===================
main()
        
        
    
