#Author: COP1000
#Date: 11-22-16
#Description: class employee: intro to Object Oriented Programming
#-------------------------------------------------------------------
#
#==============================================================================================================================
class employee():
    #employee def
    def __init__(self):
        self.name = " "
        self.rate = 0.0
        self.hours = 0
        self.gross = 0.0
    #end init
    #fucntions that act on an employee
    def getEmp(self):
        self.name = input("Enter name: ")
        self.rate = float(input("Enter rate: "))
        self.hours = int(input("Enter hours: "))
    #end getEmp
    #--------------------------------------------
    def calculateGross(self):
        self.gross = self.rate * self.hours
    #end calculate gross
    #--------------------------------------------
    def dispEmp(self):
        print("Name: ", self.name, "\nRate:$ ", self.rate, "\nHours: ", self.hours, "\nGross:$ ", format(self.gross, "2.2f"))
    #end dispEmp
#end class emplyee
#=================================================================================================================================
def main():
    #declaration
    emp = employee()  #let's construct an employee called emp
    #let's get data for this employee...emp
    emp.getEmp()
    #let's get the gross
    emp.calculateGross()
    #let's display this employee
    emp.dispEmp()
#end main
#calling main
main()
