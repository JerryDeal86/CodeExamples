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
    CustomerID = 100*[" "]
    CustomerFN = 100*[" "]
    CustomerLN = 100*[" "]
    RentalBal  = 100*[0.0]
    answer = 0
    searchCustomer = ""
    SearchToolID = ""
    where = -1
    submenu = 0
    submenu2 = 0

    while answer != 3:
        answer = getmenu()
        if answer == 1:
            submenu = getsubmenu()
            while submenu != 3:
                if submenu == 1:
                    getCustomer(CustomerID, CustomerFN, CustomerLN)
                if submenu == 2:
                    searchCustomer = getSearchCustomerID()
                    where = SearchCustomer(CustomerID, searchCustomer)
                    dispCustomer(CustomerID, CustomerFN, CustomerLN, where)
        if answer == 2:
            searchCustomer = getSearchCustomerID()
            where = SearchCustomer(CustomerID, searchCustomer)
            if where < 0:
                print("Customer ID not found, please enter a valid ID.")
            else:
                print("Customer found!")
                submenu2 = getsubmenu2()
                while submenu2 != 4:
                    if submenu2 == 1:
                        rentTool(CustomerID, CustomerFN, CustomerLN, where, searchCustomer, searchTool)
                    
            



        #if selection is 2, then (display a short sub menu with 'initiate' , 'search' ,  or 'add' (this one is optional)
            #if 'initiate' then call the function 'rent tool', if 'search' then call the getsearchToolID
            #if add then call the fucntion addTool()
        #prompt user to continue or abort application
        #get user answer
    #the end
    #good bye!
#end main
#==============================================================================================================
def getmenu():
    answer = 0
    answer = int(input("\nMenu\n-1-Process a Customer(Create, Search)\n-2-Process Rental(initiate, search)\n-3-Quit Program\n"))
    return answer

    
#====================customers process section=====================
def getCustomer(CustomerID, CustomerFN, CustomerLN):
    i = 0
    CustomerID[i] = 100000000 + 1
    CustomerFN[i] = input("Enter the Customers first name:")
    CustomerLN[i] = input("Enter the Customers Last name:")
    print("Customer", CustomerFN[i] , CustomerLN[i] , " is created with Customer Id of: ", CustomerID[i])
    i = i + 1
    #input the field for one single customer
#end getCustomer
#-------------------------------------------------------------------
def getSearchCustomerID():
    searchCustomer = int(input("Please enter the Customer ID to search:"))
    return searchCustomer
    
    #prompt for a customer search ID
    #return it
#end getSEarchID
#-------------------------------------------------------------------
def SearchCustomer(CustomerID, searchCustomer):
    i = 0
    while i<100:
        if searchCustomer == CustomerID[i]:
            return i
        i = i + 1
    return -1

    
    #search for this ID inside the array of customer ID's
    #return position if found
    #return -1 if not
#end searchCustomer
def dispCustomer(CustomerID, CustomerFN, CustomerLN, where):
    if where < 0:
        print("Customer ID not found, please enter a valid ID.")
    else:
        print("Customer ID:", CustomerID[where],"\nCustomer Name:", CustomerFN[where], CustomerLN[where])
    #display, using a suitable format i.e. a given customer data
#end dispCustomer
#-------------------------------------------------------------------
def getsubmenu():
    submenu = 0
    submenu = int(input("\nIf you would like to create a new customer enter 1, \nto search current customers enter 2, \nto return to main menu enter 3"))
    return submenu
#-------------------------------------------------------------------
def getsubmenu2():
    submenu2 = 0
    submenu2 = int(input("To Initiate enter 1, to search enter 2, to add enter 3, to return to previous menu enter 4"))
    return submenu2

main()
    
