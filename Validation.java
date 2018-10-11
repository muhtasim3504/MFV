import java.math.BigInteger; 
import java.util.*;
import java.util.regex.*;
import java.time.*;
import java.time.format.DateTimeFormatter;  
//import java.time.LocalDateTime;
// java.time.LocalDate;  
/**
 * Write a description of class Validation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validation
{
    private ArrayList<String> postcodes;
    private ArrayList<String> states;
    private ArrayList<String> saleTypes;

    /**
     * Constructor for objects of class Validation
     */
    public Validation()
    {
        postcodes = new ArrayList<>(Arrays.asList("3122", "3142", "3143", "3144", "3145", "3146", "3161", "3162", "3163", "3166", "3181", "3182",
                                                  "3183", "3184", "3185", "3186", "3187", "3188", "3204"));
        states = new ArrayList<>(Arrays.asList("VIC", "Victoria", "NSW", "New South Wales", "QLD", "Queensland", "ACT", "Australian Capital Territory", 
                                               "SA", "South Australia", "NT", "Northern Territory", "TAS", "Tasmania", "WA", "Western Australia"));
        saleTypes = new ArrayList<>(Arrays.asList("kg", "bag", "box", "punnet", "piece", "bundle", "stalk"));                                       
    }
    
    public boolean validatePwd(String pwd)
    {
        if (pwd.length() >= 5)
        return true;
        else
        return false;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean validateName(String name)
    {
        for (char c : name.toCharArray()) {
            if (!Character.isAlphabetic(c)){
                System.out.println("INVALID");
                return false;
            }
        }
        
        if (name.length() < 2 || name.length() > 10)
            return false;
        return true;
    }
    
    public boolean validateCardNumber(String cardNumber)
    {
        cardNumber = cardNumber.replaceAll("\\s","");
        try 
        { 
            // checking valid integer using parseInt() method 
            new BigInteger(cardNumber); ; 
        }  
        catch (NumberFormatException e)  
        { 
            System.out.println(cardNumber + " is not a valid integer number"); 
            return false;
        }
        if (cardNumber.length() != 16)
                return false;
        return true;
    }
    
    public boolean validateEmail(String email)
    {
         String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
    
    public boolean validateAddress(String address)
    {
        String addressRegex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
        Pattern pat = Pattern.compile(addressRegex);
        if (address.trim() == "")
        return false;
        else
        return address.matches(addressRegex);
    }
    
    public boolean validatePostcodeDelivery(String pc)
    {
        if (pc.trim() == "")
            return false;
        for (String s : postcodes) 
        {
            if (pc.equals(s))
            return true;
        }
        return false;
    }
    
    public boolean validatePostcode(String pc)
    {
        String postcodes = "^(0[289][0-9]{2})|([1345689][0-9]{3})|(2[0-8][0-9]{2})|(290[0-9])|(291[0-4])|(7[0-4][0-9]{2})|(7[8-9][0-9]{2})$";
        if (pc.trim() == "")
            return false;
        else if (pc.matches(postcodes))
        {
            return true;
        }
        return false;
    }
    
    public boolean validateState(String state)
    {
        if (state.trim() == "")
            return false;
        for (String s : states)
        {
            if (state.trim().equalsIgnoreCase(s))
            return true;
        }
        return false;
    }
    
    public boolean validateCardName(String name)
    {
        for (char c : name.toCharArray()) {
            if (!Character.isAlphabetic(c)){
                System.out.println("INVALID");
                return false;
            }
        }
        
        if (name.length() < 2 || name.length() > 25)
            return false;
        return true;
    }
    
    public boolean validateCCV(String ccv)
    {
        String s = ccv.trim();
        String regex = "^[0-9]{3,4}$";
        if (s.trim() == "")
        return false;
        else 
        return s.matches(regex);
    }
    
    public boolean validateProdName(String prodName)
    {
        for (char c : prodName.toCharArray()) {
            if (!Character.isAlphabetic(c)){
                System.out.println("INVALID");
                return false;
            }
        }
        
        if (prodName.length() < 2 || prodName.length() > 20)
            return false;
        return true;
    }
    
    public boolean validateShelfLife(String days)
    {
        if (days.trim().matches("^[0-9]{1,3}$") && days.trim() != "0")
        {
            return true;
        }
        else
            return false;
    }
    
    public boolean validateSaleType(String saleType)
    {
        if (saleType.trim() == "")
            return false;
        for (String s : saleTypes)
        {
            if (saleType.trim().equalsIgnoreCase(s))
            return true;
        }
        return false;
    }
    
    public boolean validateQty(String qty)
    {
        if (qty.trim().matches("^[0-9]{1,3}$") && qty.trim() != "0")
        {
            return true;
        }
        else
            return false;
    }
    
    //validating date entred for system report
    //checking the formate to match dd/mm/yyyy
    //prevent future dates
    public static boolean validateDate(String entredDate)
    {
        String dateRegex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        Pattern p = Pattern.compile(dateRegex);
        Matcher m = p.matcher(entredDate);
      
        if (m.matches())
        {
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String todayString = today.format(formatter);
          
            LocalDate entredDateToDate = LocalDate.parse(entredDate,formatter);
            LocalDate todayStringToDate = LocalDate.parse(todayString,formatter);

            if (entredDateToDate.isBefore(todayStringToDate)) 
            {
                System.out.println("Date is valid ");
                return true;
            }
            if (entredDateToDate.isAfter(todayStringToDate)) 
            {
                System.out.println("Future date not acceptable");
                return false;
            }
            if (entredDateToDate.isEqual(todayStringToDate)) 
            {
                System.out.println("Date should not be current date, select past date please");
                return false;
            }
            else
            System.out.println("Date is not valid  ");
            return false;
        }
        System.out.println("Date format is not valid");
        return false;
    }
}
