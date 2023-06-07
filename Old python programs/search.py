#Author: COP1000
#Date: 10-20-16
#Descritpion: search for an integer x into an array num (array simulated with a list
#----------------------------------------------------------------------------------------
#
#
#declarations
x = 0
num  = [17, 14, 23, 9, 45]
i = 0
flag = False
#input
x = int(input("Enter x to search for: "))
#search and display
while i < 5 and flag == False:  #quit as soon as a match is found , don't keep looking becasue there are no duplicate
    if x == num[i]:
        print(x, " is found at position " , i)
        flag = True
    #end if
    i = i + 1
#end while
if flag != True:
    print(x, " not found anywhere!")
    
        

