#Author: COP1000
#Date: 11-8-16
#Description:  solution to HW5 
#-----------------------------------------------------------------------------------------------
#
#
def main():
    #declarations
    ssn   = ["333", "111", "999", "555", "777", "222"]
    rate  = [12.50, 37.75, 15.00, 34.00, 10.65, 13.78]
    hours = [0   , 0    , 0  , 0   , 0     , 0]
    gross = [0.0    , 0.0  , 0.0 , 0.0  , 0.0   , 0.0]
    where = -1
    searchSSN = " "
    answer = 1
    #input hours
    getHours(ssn, hours)
    #calculate gross for all
    getGross(rate, hours, gross)
    while answer == 1:
         #get a search ssn
        searchSSN = getSSN()

        #call the search for ssn
        where = searchEmp(searchSSN, ssn)

        #call the display function
        dispEmp(ssn, rate, hours, gross, where)
        #continue?
        answer = int(input("Continue? 1 for yes 0 for no: "));
    #end while
    print("Goodbye!!!")
#complete program with the necessary calls, code a routine that allows user to repeat this program for different searches
#bring your solution to class this Thursday
#optional: add two arrays , one for first names and one for last names
#end main
#input for  hours
def getHours(ssn, hours):
    i = 0
    while i < 6:
        print("Employee ", ssn[i])
        hours[i] = int(input("Enter hours: "))
        i = i + 1
    #end while
#end getHours
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
    searchSSN = input("Enter the SSN of the employee you need to search for: ")
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
#calling main
main()
    

