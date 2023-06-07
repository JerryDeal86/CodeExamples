#Author: COP1000
#Date: 11-1-16
#Description: this program uses parallel arrays simulated with lists to store employees payroll
#date, calculate the gross for each, and allow a search by SSN
#-----------------------------------------------------------------------------------------------
#
#
def main():
    #declarations
    ssn   = ["333", "111", "999", "555", "777", "222"]
    rate  = [12.50, 37.75, 15.00, 34.00, 10.65, 13.78]
    hours = [40    , 25    , 20  , 10   , 44     , 20]
    gross = [0.0    , 0.0  , 0.0 , 0.0  , 0.0   , 0.0]
    where = -1
    searchSSN = " "
    #calculate gross for all


    #get a search ssn


    #call the search for ssn


    #call the display function
    

#complete program with the necessary calls, code a routine that allows user to repeat this program for different searches
#bring your solution to class this Thursday
#optional: add two arrays , one for first names and one for last names
#end main
#--------------------------------------------------------
def getGross(rate, hours, gross):
    i = 0
    while i < 6:
        gross[i] = rate[i] * hours[i]
        i = i + 1
    #end while
#end getGRoss
#--------------------------------------------------------
def getSSN():
    searchSSN = " "
    searchSSN = input("Enter the SSN of the employee you need to search for: "))
    return searchSSN
#end getSSN
def searchEmp(searchSSN, ssn):
    i = 0
    while i < 6:
        if searchSSN == ssn[i]:
            return i
        #end if
        i = i + 1
    #end while
    return -1
#endsearch
#--------------------------------------------------------
def dispEmp(ssn, rate, hours, gross, where):
    if where < 0:
        print("SSN not found!")
    else:
        print("SSN: " , ssn[where], "\nRate: ", rate[where], "\nHours: ", hours[where], "\nGross: " , gross[where])
#end dispEmp
    

