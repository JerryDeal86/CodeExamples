#Author: COP1000
#Date: 9-13-16
#Description: this program evaluate eligibility of membership in a club
#to be a member one must have an age that is greather than 30 and gpa that is larger or equal to 3.0
#===================================================================================================
#
#
#declarations:
first = " "   #name is a text initial value a blank space
last  = " "
age   = 0
gpa  = 0.0
#input
first = input("Enter your first name: ")
last  = input("Enter your last name: ")
age = int(input("Enter your age: "))
gpa = float(input("Enter your GPA: "))
                                        #for age and gpa , you can use 'eval' instead of 'int' or 'float'
#evaluation
if age > 30:
    if gpa >= 3.0:
        print("Eligible!")
    else:
        print("Not eligible!")
else:
    print("Not eligible")

    















        
     
    
