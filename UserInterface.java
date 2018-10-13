import java.util.*;

/**
 * Comment
 *
 * @author Team118
 * @version 1.0
 */
public class UserInterface
{
    // instance variables - replace the example below with your own
    private ArrayList<String> startMenu;
    String startRange;
    private ArrayList<String> cusStartMenu;
    String cusStartRange;
    private ArrayList<String> ownStartMenu;
    String ownStartRange;
    private ArrayList<String> cusProductMenu;
    String cusProductRange;
    private ArrayList<String> prodSelectMenu;
    String prodSelectRange;
    private ArrayList<String> cusProductMenu2;
    String cusProductRange2;
    private ArrayList<String> ownProductMenu;
    String ownProductRange;
    private ArrayList<String> ownProductMenu2;
    String ownProductRange2;
    private ArrayList<String> accDetailsMenu;
    String accDetailsRange;
    Validation valid;

    /**
     * Constructor for objects of class Menu
     */
    public UserInterface()
    {
        Scanner scan = new Scanner(System.in);
        valid = new Validation();

        //ID: 1
        startMenu = new ArrayList<String>();
        startRange = "[A-Ca-c]";
        //ID: 2
        cusStartMenu = new ArrayList<String>();
        cusStartRange = "[A-Ga-g]";
        //ID: 3
        ownStartMenu = new ArrayList<String>();
        ownStartRange = "[A-Ea-e]";
        //ID: 4
        cusProductMenu = new ArrayList<String>();
        cusProductRange = "[A-Ca-c]";
        //ID: 5
        prodSelectMenu = new ArrayList<String>();
        prodSelectRange = "[A-Ba-b]";
        //ID: 6
        ownProductMenu = new ArrayList<String>();
        ownProductRange = "[A-Da-d]";
        //ID: 7
        cusProductMenu2 = new ArrayList<String>();
        cusProductRange = "[A-Ba-b]";
        //ID: 8
        ownProductMenu2 = new ArrayList<String>();
        ownProductRange2 = "[A-Ga-g]";
        //ID: 9
        accDetailsMenu = new ArrayList<String>();
        accDetailsRange = "[A-Oa-o]";
    }

    public void loadMenuItems()
    {
        //Start menu items ID: 1
        startMenu.add("[A] Login");
        startMenu.add("[B] Register");
        startMenu.add("[C] Exit");

        //Customer menu items ID: 2
        cusStartMenu.add("Menu");
        cusStartMenu.add("[A] View Products");
        cusStartMenu.add("[B] Shopping Cart");
        cusStartMenu.add("[C] Checkout");
        cusStartMenu.add("[D] Order History");
        cusStartMenu.add("[E] Account Details");
        cusStartMenu.add("[F] Logout");
        cusStartMenu.add("[G] Exit");

        //Owner menu items ID: 3
        ownStartMenu.add("Menu");
        ownStartMenu.add("[A] Product Management");
        ownStartMenu.add("[B] Order Management");
        ownStartMenu.add("[C] Account Management");
        ownStartMenu.add("[D] Logout");
        ownStartMenu.add("[E] Exit");

        //Customer Initial product menu ID: 4
        cusProductMenu.add("Menu");
        cusProductMenu.add("[A] Product Search");
        cusProductMenu.add("[B] Browse Products");
        cusProductMenu.add("[C] Back");

        //Product selection menu (customer and owner) ID: 5
        prodSelectMenu.add("Menu");
        prodSelectMenu.add("[A] View Product Details");
        prodSelectMenu.add("[B] Back");

        //Owner initial product menu ID: 6
        ownProductMenu.add("Menu");
        ownProductMenu.add("[A] Product Search");
        ownProductMenu.add("[B] Browse Products");
        ownProductMenu.add("[C] Add Product");
        ownProductMenu.add("[D] Back");

        //Customer product interaction menu ID: 7
        cusProductMenu2.add("Menu");
        cusProductMenu2.add("[A] Purchase Product");
        cusProductMenu2.add("[B] Back");

        //Owner product interaction menu ID: 8
        ownProductMenu2.add("Menu");
        ownProductMenu2.add("[A] Edit Product");
        ownProductMenu2.add("[B] Remove Product");
        ownProductMenu2.add("[C] Add Batch");
        ownProductMenu2.add("[D] Edit Batch");
        ownProductMenu2.add("[E] Remove Batch");
        ownProductMenu2.add("[F] Add Keywords");
        ownProductMenu2.add("[G] Back");

        //Customer update account details menu ID: 9
        accDetailsMenu.add("Set Account Details");
        accDetailsMenu.add("[A] First Name");
        accDetailsMenu.add("[B] Last Name");
        accDetailsMenu.add("[C] Address");
        accDetailsMenu.add("[D] Suburb");
        accDetailsMenu.add("[E] Postcode");
        accDetailsMenu.add("[F] State");
        accDetailsMenu.add("[G] Email");
        accDetailsMenu.add("[H] Password");
        accDetailsMenu.add("[I] Bank Card Number");
        accDetailsMenu.add("[J] Bank Card Name");
        accDetailsMenu.add("[K] Bank Card CCV");
        accDetailsMenu.add("[L] Payment Preference");
        accDetailsMenu.add("[M] Delivery Preference");
        accDetailsMenu.add("[N] Unregister");
        accDetailsMenu.add("[O] Back");
    }

    public void updateMsg(String detail)
    {
        System.out.println("\n" + detail + " Updated!" + "\n");
    }

    public void userExistsMsg()
    {
        System.out.println("You already have an account. Login or register with a different email address.");
    }

    public String emailInput()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your email address: ");
        String email = "";
        while(email.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateEmail(input.trim()) == true)
            {
                email = input.trim();
            }
            else
            {
                System.out.println("Valid email addresses only mate!");
            }
        }    
        return email;
    }

    public String pwdLogin()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String pwd = "";
        while(pwd.equals(""))
        {
            String input = scan.nextLine();
            pwd = input;
        }
        return pwd;
    }

    public void loginError()
    {
        System.out.println("Error: Check your login credentials and try again.");
    }

    public String pwdInput()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String pwd = "";
        while(pwd.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validatePwd(input.trim()) == true)
            {
                System.out.println("Confirm your password: ");
                String confirm = scan.nextLine();
                if (input.equals(confirm))
                {
                    pwd = input;
                }
                else
                {
                    System.out.println("Passwords don't match, please enter a new password and confirm it again.");
                }
            }
            else
            {
                System.out.println("Passwords must be at least 5 characters long.");
            }
        }
        return pwd;
    }

    public void displayLogo()
    {
        System.out.println(" __  __ _____   __ ");
        System.out.println("|  \\/  | __\\ \\ / /");
        System.out.println("| |\\/| | _| \\ V /");                 
        System.out.println("|_|  |_|_|   \\_/ ");                    

    }

    public String displayMenu(int menuID)
    {
        String range = "";
        ArrayList<String> options = startMenu;
        String selection = "";
        Scanner scanner = new Scanner(System.in);

        switch (menuID)
        {
            case 1:
            range = startRange;
            options = startMenu;
            break;
            case 2:
            range = cusStartRange;
            options = cusStartMenu;
            break;
            case 3:
            range = ownStartRange;
            options = ownStartMenu;
            break;
            case 4:
            range = cusProductRange;
            options = cusProductMenu;
            break;
            case 5:
            range = prodSelectRange;
            options = prodSelectMenu;
            break;
            case 6:
            range = ownProductRange;
            options = ownProductMenu;
            break;
            case 7:
            range = cusProductRange2;
            options = cusProductMenu2;
            break;
            case 8:
            range = ownProductRange2;
            options = ownProductMenu2;
            case 9:
            range = accDetailsRange;
            options = accDetailsMenu;
            break;
            default:
            System.out.println("Menu failed to initialise, give it a valid argument.");
        }

        for (String i : options)
        {
            System.out.println(i);
        }

        while (selection.equals(""))
        {
            String input = scanner.nextLine();
            if (input.trim().matches(range))
            {
                selection = input.trim();
            }
            else
            {
                System.out.println("Valid selections only mate!");
            }
        }

        return selection;
    }

    public String searchBox()
    {
        clearScreen();
        System.out.println("Enter the name of the product you want to search:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.trim();
    }

    public void searchResult(String input, Product p)
    {
        clearScreen();
        System.out.println("Searched keyword: " + input);
        System.out.println();
        System.out.println("Closest match");
        displayProduct(p);
    }

    public void browseResult(Product p)
    {
        clearScreen();
        displayProduct(p);
    }

    public String displayAllProduct(Product[] products)
    {
        clearScreen();
        for (Product p : products)
        {
            displayProduct(p);
        }
        //Needs validation
        System.out.println("Enter Product ID to select the product: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public void displayProduct(Product p)
    {
        System.out.println("Product ID:" + p.getProductID() +"\t Name: " + p.getName());
    }

    public void searchError(String keyword)
    {
        clearScreen();
        System.out.println("Searched keyword: " + keyword);
        System.out.println("The searched product does not exist. Or check the spelling and try again");
        pressEnter();
    }

    private void clearScreen()
    {
        System.out.print('\u000C');
    }

    private void pressEnter()
    {
        System.out.println("Press Enter to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void regSuccess()
    {
        System.out.println("\n" + "Registration Successful!" + "\n");
    }

    public void logSuccess()
    {
        System.out.println("\n" + "Login Successful!" + "\n");
    }

    public String updateFname()
    {
        Scanner scan = new Scanner(System.in);
        String fName = "";
        System.out.println("Enter your first name: ");
        while (fName.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateName(input.trim()) == true)
            {
                fName = input.trim();
            }
            else
            {
                System.out.println("Enter a valid name.");
            }
        }
        return fName;
    }

    public String updateLname()
    {
        Scanner scan = new Scanner(System.in);
        String lName = "";
        System.out.println("Enter your last name: ");
        while (lName.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateName(input.trim()) == true)
            {
                lName = input.trim();
            }
            else
            {
                System.out.println("Enter a valid name.");
            }
        }
        return lName;
    }

    public String updateAddress()
    {
        Scanner scan = new Scanner(System.in);
        String address = "";
        System.out.println("Enter your street name and number (e.g. 1 Monash Drive): ");
        while (address.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateAddress(input.trim()) == true)
            {
                address = input.trim();
            }
            else
            {
                System.out.println("Enter a valid address.");
            }
        }
        return address;
    }

    public String updateSuburb()
    {
        Scanner scan = new Scanner(System.in);
        String suburb = "";
        System.out.println("Enter your suburb: ");
        while (suburb.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateName(input.trim()) == true)
            {
                suburb = input.trim();
            }
            else
            {
                System.out.println("Enter a valid suburb.");
            }
        }
        return suburb;
    }

    public String updatePostcode()
    {
        Scanner scan = new Scanner(System.in);
        String pc = "";
        System.out.println("Enter your postcode: ");
        while (pc.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validatePostcode(input.trim()) == true)
            {
                pc = input.trim();
            }
            else
            {
                System.out.println("Enter a valid postcode.");
            }
        }
        return pc;
    }

    public String updateState()
    {
        Scanner scan = new Scanner(System.in);
        String state = "";
        System.out.println("Enter your state: ");
        while (state.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateState(input.trim()) == true)
            {
                state = input.trim();
            }
            else
            {
                System.out.println("Enter a valid state.");
            }
        }
        return state;
    }

    public String updateCardNumber()
    {
        Scanner scan = new Scanner(System.in);
        String cardno = "";
        System.out.println("Enter your card number: ");
        while (cardno.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateCardNumber(input.trim()) == true)
            {
                cardno = input.trim();
            }
            else
            {
                System.out.println("Enter a valid card number.");
            }
        }
        return cardno;
    }

    public String updateCardName()
    {
        Scanner scan = new Scanner(System.in);
        String cardname = "";
        System.out.println("Enter your full name as it appears on your card: ");
        while (cardname.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateCardName(input.trim()) == true)
            {
                cardname = input.trim();
            }
            else
            {
                System.out.println("Enter a valid name.");
            }
        }
        return cardname;
    }

    public String updateCCV()
    {
        Scanner scan = new Scanner(System.in);
        String ccv = "";
        System.out.println("Enter your CCV: ");
        while (ccv.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateCCV(input.trim()) == true)
            {
                ccv = input.trim();
            }
            else
            {
                System.out.println("Enter a valid CCV.");
            }
        }
        return ccv; 
    }

    public String updatePayPref()
    {
        Scanner scan = new Scanner(System.in);
        String paypref = "";
        System.out.println("To set your payment preference, enter 'c' for cash or 'b' for bank card: ");
        while (paypref.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Cc]|[Bb]"))
            {
                paypref = input.trim();
            }
            else
            {
                System.out.println("Enter a valid selection.");
            }
        }
        return paypref;  
    }

    public String updateCollectionPref()
    {
        Scanner scan = new Scanner(System.in);
        String collpref = "";
        System.out.println("To set your order collection preference, enter 'p' for pick up or 'd' for delivery: ");
        while (collpref.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Pp]|[Dd]"))
            {
                collpref = input.trim();
            }
            else
            {
                System.out.println("Enter a valid selection.");
            }
        }
        return collpref; 
    }

    public String unregister()
    {
        Scanner scan = new Scanner(System.in);
        String unregister = "";
        System.out.println("Are you sure you want to unregister? Enter 'y' for yes or 'n' for no.");
        while (unregister.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Yy]|[Nn]"))
            {
                unregister = input.trim();
            }
            else
            {
                System.out.println("Enter a valid selection.");
            }
        }
        return unregister; 
    }

    public String prodNameInput()
    {
        Scanner scan = new Scanner(System.in);
        String prodName = "";
        System.out.println("Enter the product name: ");
        while (prodName.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateProdName(input.trim()) == true)
            {
                prodName = input.trim();
            }
            else
            {
                System.out.println("Enter a valid product name.");
            }
        }
        return prodName; 
    }

    public String minShelfLifeInput()
    {
        Scanner scan = new Scanner(System.in);
        String minShelf = "";
        System.out.println("Enter the product's minimum shelf life in days: ");
        while (minShelf.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateShelfLife(input.trim()) == true)
            {
                minShelf = input.trim();
            }
            else
            {
                System.out.println("Enter a valid product name.");
            }
        }
        return minShelf; 
    }

    public String maxShelfLifeInput()
    {
        Scanner scan = new Scanner(System.in);
        String maxShelf = "";
        System.out.println("Enter the product's minimum shelf life in days: ");
        while (maxShelf.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateShelfLife(input.trim()) == true)
            {
                maxShelf = input.trim();
            }
            else
            {
                System.out.println("Enter a valid product name.");
            }
        }
        return maxShelf; 
    }

    public String saleTypeInput()
    {
        Scanner scan = new Scanner(System.in);
        String saleType = "";
        System.out.println("Enter the product's sale type (e.g. 'kg', 'bag', 'box', 'punnet'): ");
        while (saleType.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateSaleType(input.trim()) == true)
            {
                saleType = input.trim();
            }
            else
            {
                System.out.println("Enter a valid sale type.");
            }
        }
        return saleType; 
    }

    public String addSaleType()
    {
        Scanner scan = new Scanner(System.in);
        String response = "";
        System.out.println("Do you want to add an additional sale type? (enter 'y' for yes or 'n' for no): ");
        while (response.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Yy]|[Nn])"))
            {
                response = input.trim();
            }
            else
            {
                System.out.println("Enter a valid response.");
            }
        }
        return response; 
    }

    public void addProductMsg()
    {
        System.out.println("\n" + "Product Added!" + "\n");
    }
    // add batch
    public String addBatchRecievedDate()
    {
        //Date date = new Date();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter batch recieved date as dd/mm/yyyy: ");
        String date = sc.next();
        while (!date.matches("(0[1-9]|1[0-9]|2[0-9]|3[0-1])[/](0[1-9]|1[0-2])[/](201[8-9]|202[0-9])")){
            System.out.println("Invalid date, try agin: ");
            date = sc.next();
        }
        return date;
    }
    
    public int addBatchSaleMethod(String sOne, String sTwo){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Batch Sale method from: "  + sOne + " or " + sTwo + ". Press 1 for " + sOne + " or press 2 for " + sTwo);
        int choice = 0;
        while (choice == 0){
             try
             {
                 int input = Integer.parseInt(sc.next());
                 if (input == 1  || input == 2)
                    choice = input;
                 else
                    System.out.println("invalid choice, try again");
             }
             catch (NumberFormatException nfe)
             {
                  System.out.println("NumberFormatException, try again: ");
             }
        }
        return choice;
    }
    
    public boolean removeBatch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 to confirm deletion or press 0 to go back");
        int choice = 2;
        while (choice == 2){
             try
             {
                 int input = Integer.parseInt(sc.next());
                 if (input == 1  || input == 0)
                    choice = input;
                 else
                    System.out.println("invalid choice, try again");
             }
             catch (NumberFormatException nfe)
             {
                  System.out.println("NumberFormatException, try again: ");
             }
        }
        if (choice == 0)
            return false;
        else
            return true;
    }
    
    public int addBatchQuantity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter batch qty");
        int qty = 0;
        while (qty == 0){
             try
             {
                 int input = Integer.parseInt(sc.next());
                 if (input > 0  && input < 1000)
                    qty = input;
                 else
                    System.out.println("invalid qty range, try again");
             }
             catch (NumberFormatException nfe)
             {
                  System.out.println("NumberFormatException, try again: ");
             }
        }
        return qty;
    }
    
    public double addBatchPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter batch price");
        double price = 0.0;
        while (price == 0){
             try
             {
                 int input = Integer.parseInt(sc.next());
                 if (input > 0  && input < 1000)
                    price = input;
                 else
                    System.out.println("invalid price range, try again");
             }
             catch (NumberFormatException nfe)
             {
                  System.out.println("NumberFormatException, try again: ");
             }
        }
        return price;
        }
 
    public String addBatchName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter batch Name");
        String input = sc.next();
        while(!valid.validateProdName(input)){
            System.out.println("try again: ");
            input = sc.next();
        }
        String name = input;
        return name;
    }
    
     public String addBatchSource(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter batch Source");
        String input = sc.next();
        while(!valid.validateProdName(input)){
            System.out.println("try again: ");
            input = sc.next();
        }
        String source = input;
        return source;
    }
}
