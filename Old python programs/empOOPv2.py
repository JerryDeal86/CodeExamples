#Author: COP1000
#Date: 11-22-16
#Description: this program handles multiple objects of type employee
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
    empList = []  #this list will be a container for all emp's 
    #let's get data for this employee...emp
    emp.getEmp()
    #let's get the gross
    emp.calculateGross()
    #store this employee in the list ...empLIst 'add this employee to the drawer '
    empList.append(emp) #"append means add this emp to the end of the list
    #let's add two more employees:
    emp = employee()
    emp.getEmp()
    emp.calculateGross()
    empList.append(emp)
            #====one more==>:
    emp = employee()
    emp.getEmp()
    emp.calculateGross()
    empList.append(emp)
    #let's display all the employees we processed sofar:
    #i = 0
    #while i < len(empList):
    for i in range(len(empList)):
        empList[i].dispEmp()
        #i = i + 1
    #en while

#end main
#calling main
main()
