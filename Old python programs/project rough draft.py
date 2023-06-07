#Author:
#Date due:
#Date submitted:
#Description:
#------------------------------------------------------
#
#
def main():

    ToolID =   ["CS012" , "CC007", "AC004", "CM002", "FS008"]
    ToolType = ["chain saw", "concrete cutter", "air compressor", "cement mixer", "floor sander"]
    Fullday =  [ 56.00, 125.00, 39.00, 45.00, 75.00]
    Halfday =  [ 45.00, 95.00, 29.00, 39.00, 55.00]
    Rented =   [ False, False, False, False, False]
    answer = 0
    where = -1
    submenu = 0
    cust = Customer()
    custList = []
    searchCustomer = 0
    i = -1


    while answer != 3:
        if answer == 1:
            submenu = getsubmenu()
            while submenu != 3:
                if submenu == 1:
                    cust.getcust()
                    custList.append(cust)
                    cust = Customer()
                if submenu == 2:
                    searchCustomer = cust.getSearchCustomerID()
                    for i in range(len(custList)):
                        if custList[i].CustomerID == searchCustomer:
                            custList[i].dispCustomer()
                submenu = getsubmenu()
        if answer == 2:
            searchCustomer = cust.getSearchCustomerID()
            custExists = False
            for i in range(len(custList)):
                if custList[i].CustomerID == searchCustomer:
                    custExists = True
                    processRental(ToolID, ToolType, Fullday, Halfday)
            if custExists == False:
                print("Customer not found, please enter a valid customer or create a new profile.")
                
        answer = getmenu()
                    
            



        #if selection is 2, then (display a short sub menu with 'initiate' , 'search' ,  or 'add' (this one is optional)
            #if 'initiate' then call the function 'rent tool', if 'search' then call the getsearchToolID
            #if add then call the fucntion addTool()
        #prompt user to continue or abort application
        #get user answer
    #the end
    #good bye!
#end main
#==============================================================================================================
class Customer():
    def __init__(self):
        self.CustomerID = 0
        self.CustomerFN = ""
        self.CustomerLN = ""
        self.Rentalbal = 0.0
    def getcust(self):
        self.CustomerID = int(input("Enter account number:"))
        self.CustomerFN = input("Enter the Customers first name:")
        self.CustomerLN = input("Enter the Customers Last name:")
        self.Rentalbal = 0.0
    def dispCustomer(self):
        print("Customer ID:", self.CustomerID,"\nCustomer Name:", self.CustomerFN, self.CustomerLN,"\n")
    def getSearchCustomerID(self):
        searchCustomer = int(input("Please enter the Customer ID to search:"))
        return searchCustomer
#==============================================================================================================
def processRental(ToolID, ToolType, Fullday, Halfday):
    print("Tool IDs are: ")
    for i in range(len(ToolID)):
        print(ToolID[i], " ")
    print("Tool types are: ")
    for i in range(len(ToolType)):
        print(ToolType[i]," ")
    print("Full day rates are:$")
    for i in range(len(Fullday)):
        print(Fullday[i]," ")
    print("Half day rates are:$")
    for i in range(len(Halfday)):
        print(Halfday[i]," ")

#--------------------------------------------------------------------------------------------------------------
def getmenu():
    answer = 0
    answer = int(input("\nMenu\n-1-Process a Customer(Create, Search)\n-2-Process Rental(initiate, search)\n-3-Quit Program\n"))
    return answer

#-------------------------------------------------------------------

def getsubmenu():
    submenu = 0
    submenu = int(input(" -1-create a new customer enter \n -2-search current customers \n -3-return to main menu\n"))
    return submenu
#-------------------------------------------------------------------

def rentTool(CustomerID, CustomerFN, CustomerLN, where, searchCustomer, SearchToolID, ToolID, ToolType, Fullday, Halfday, Rented):
        i = 0
        while i < 5:
            print("Tool IDs are:", ToolID[i], "\nTool types are:", ToolType[i],"\nFullday rental costs:$",Fullday[i],"\nHalf day rentals cost:$", Halfday[i])
            i = i + 1
main()
