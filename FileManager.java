import java.io.*;
import java.util.*;
/**
 * FileManager class for retreving, editing, deleting and saving the database.
 * 
 * @author M Muhtasim Ayaz Rahman 
 * @version 21/09/2018
 */
public class FileManager
{
    // instance variables - replace the example below with your own
    private Hashtable<Integer, Product> products;
    private HashMap<String, Integer> keywords;
    private List<User> users;
    private List<Order> orders;

    /**
     * Constructor for objects of class FileManager
     */
    public FileManager()
    {
        products = new Hashtable<Integer, Product>();
        keywords = new HashMap<String, Integer>();
        //loggedUser = new User();
        users  = new ArrayList<User>();
        orders = new ArrayList<Order>();
    }

    //getters
    public Hashtable<Integer, Product> getProducts()
    {
        return products;
    }

    /**
     * returns an array of products instead of the entire hashtable
     */
    public Product[] getProductArray()
    {
        return products.values().toArray(new Product[0]);
    }

    public HashMap<String, Integer> getKeywords()
    {
        return keywords;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    //setters
    public void setProducts(Hashtable<Integer, Product> newProducts)
    {
        products = newProducts;
    }

    public void setKeywords(HashMap<String, Integer> newKeywords)
    {
        keywords = newKeywords;
    }

    /*public void setLoggedUser(User newUser)
    {
    loggedUser = newUser;
    }*/

    public void setUsers(List<User> newUsers)
    {
        users = newUsers;
    }

    public void setOrders(List<Order> newOrders)
    {
        orders = newOrders;
    }

    /**
     * This method is used to reads from the Products.csv file and creates all the products.
     * @return Nothing.
     */
    private void createProducts()
    {
        String filename = ("Products.csv");

        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {   
                String [] productInfo = parser.nextLine().split(",");
                String[] saleTypes = {productInfo[4].trim(), (productInfo[5].equals(" ") ? productInfo[5] : productInfo[5].trim())};
                int productID = Integer.parseInt(productInfo[0].trim());
                String name = productInfo[1].trim();
                products.put(productID, new Product(productID, 
                        name, 
                        Integer.parseInt(productInfo[2].trim()),
                        Integer.parseInt(productInfo[3].trim()),
                        saleTypes));
                //add to HashMap if name is not in keywords
                if (!keywords.containsKey(name.toLowerCase()))
                {
                    keywords.put(name.toLowerCase(), productID);
                }
            }
            inputFile.close();
        }

        catch(FileNotFoundException e)
        {
            System.out.println(filename + " not found");
        }

        catch(IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
    }

    /**
     * This method is used to reads from Batches.csv files and creates and adds the products 
     * @return Nothing.
     */
    private void createBatches()
    {
        String filename = ("Batches.csv");

        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                String [] batchInfo = parser.nextLine().split(",");

                int batchID = Integer.parseInt(batchInfo[0].trim()); 
                int productID = batchID/10000;
                Product p = products.get(productID);
                int quantity = Integer.parseInt(batchInfo[1].trim());
                String dateReceived = batchInfo[2].trim();
                String saleMethod =  batchInfo[3].trim();
                double price = Double.parseDouble(batchInfo[4].trim());
                String source = batchInfo[5].trim();
                String name = batchInfo[6].trim();

                p.addBatch(batchID, quantity, dateReceived, saleMethod, price, source, name);
                //add to dictionary if keyword doesnt exist
                if (!keywords.containsKey(name.toLowerCase()))
                {
                    keywords.put(name.toLowerCase(), productID);
                }
            }
            inputFile.close();
        }

        catch(FileNotFoundException e)
        {
            System.out.println(filename + " not found");
        }

        catch(IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
    }

    /**
     * This method is used to reads from Keyword.csv file and creates and adds the keyword to similar products 
     * @return Nothing.
     */
    private void createKeyword()
    {
        String filename = ("Keyword.csv");

        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                String [] keys = parser.nextLine().split(",");

                if (!keywords.containsKey(keys[0].trim().toLowerCase()))
                {
                    keywords.put(keys[0].trim().toLowerCase(), Integer.parseInt(keys[1].trim()));
                }
            }
            inputFile.close();
        }

        catch(FileNotFoundException e)
        {
            System.out.println(filename + " not found");
        }

        catch(IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
    }

    /**
     * This method is used to read from User.csv files and create and add the Users 
     * @return Nothing.
     */
    private void createUsers()
    {
        String filename = ("User.csv");

        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);

            //for admin user
            String[] adminInfo = parser.nextLine().split(",");
            Administrator admin = new Administrator();
            admin.setUId(Integer.parseInt(adminInfo[0].trim())); 
            admin.setFName(adminInfo[1].equals(" ") ? adminInfo[1] : adminInfo[1].trim());
            admin.setLName(adminInfo[2].equals(" ") ? adminInfo[2] : adminInfo[2].trim());
            admin.setAddress(adminInfo[3].equals(" ") ? adminInfo[3] : adminInfo[3].trim());
            admin.setSuburb(adminInfo[4].equals(" ") ? adminInfo[4] : adminInfo[4].trim());
            admin.setPostcode(Integer.parseInt(adminInfo[5].trim()));
            admin.setState(adminInfo[6].equals(" ") ? adminInfo[6] : adminInfo[6].trim());
            admin.setEmail(adminInfo[7].trim());
            admin.setPassword(adminInfo[8].trim());
            admin.setAccountStatus(Boolean.parseBoolean(adminInfo[9].trim()));
            users.add(admin);

            //for all other users
            while (parser.hasNextLine())
            {
                String [] userInfo = parser.nextLine().split(",");

                Customer newCustomer = new Customer();

                newCustomer.setUId(Integer.parseInt(userInfo[0].trim())); 
                newCustomer.setFName(userInfo[1].equals(" ") ? userInfo[1] : userInfo[1].trim());
                newCustomer.setLName(userInfo[2].equals(" ") ? userInfo[2] : userInfo[2].trim());
                newCustomer.setAddress(userInfo[3].equals(" ") ? userInfo[3] : userInfo[3].trim());
                newCustomer.setSuburb(userInfo[4].equals(" ") ? userInfo[4] : userInfo[4].trim());
                newCustomer.setPostcode(Integer.parseInt(userInfo[5].trim()));
                newCustomer.setState(userInfo[6].equals(" ") ? userInfo[6] : userInfo[6].trim());
                newCustomer.setEmail(userInfo[7].trim());
                newCustomer.setPassword(userInfo[8].trim());
                newCustomer.setCardNumber(userInfo[9].equals(" ") ? userInfo[9] : userInfo[9].trim());
                newCustomer.setCardName(userInfo[10].equals(" ") ? userInfo[10] : userInfo[10].trim());
                newCustomer.setCardCCV(userInfo[11].equals(" ") ? userInfo[11] : userInfo[11].trim());
                newCustomer.setAccountStatus(Boolean.parseBoolean(userInfo[12].trim()));
                newCustomer.setPaymentPreference(userInfo[13].equals(" ") ? userInfo[13] : userInfo[13].trim());
                newCustomer.setCollectionPreference(userInfo[14].equals(" ") ? userInfo[14] : userInfo[14].trim());

                users.add(newCustomer);

            }
            inputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(filename + " not found");
        }

        catch(IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * This method is used to reads from Orders.csv files and creates and adds the orders 
     * @return Nothing.
     */
    private void createOrders()
    {
        String filename = ("Orders.csv");

        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                String [] orderInfo = parser.nextLine().split(",");
                Order orderItem  = new Order();
                orderItem.setOrderStatus(Boolean.parseBoolean(orderInfo[0].trim()));
                orderItem.setAccID(orderInfo[1].trim());
                orderItem.setPrice(Double.parseDouble(orderInfo[2].trim()));
                orderItem.setOrderDate(orderInfo[3].trim());
                orderItem.setDeliveryDate(orderInfo[4].trim());
                orderItem.setDelivery(Boolean.parseBoolean(orderInfo[5].trim()));
                orderItem.setPaymentMethod(orderInfo[6].trim());
                String[] lineInfo = parser.nextLine().split(",");
                if (lineInfo[0].trim().equals("--Start--"))
                {
                    lineInfo = parser.nextLine().split(",");
                    while (parser.hasNextLine() && !(lineInfo[0].trim().equals("--End--")))
                    {

                        String name = lineInfo[0].trim();
                        int qty = Integer.parseInt(lineInfo[1].trim());
                        double unitPrice = Double.parseDouble(lineInfo[2].trim());
                        String batchID = lineInfo[3].trim();
                        orderItem.addLineItem(name, qty, unitPrice, batchID);
                        lineInfo = parser.nextLine().split(",");
                    }
                }
                orders.add(orderItem);
            }
            inputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(filename + " not found");
        }

        catch(IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * This method is used to Loads data from the CSV files according to the type of entity
     * @return Nothing.
     */
    public void loadData()
    {
        products = new Hashtable<Integer, Product>();
        keywords = new HashMap<String, Integer>();
        users  = new ArrayList<User>();
        orders = new ArrayList<Order>();
        
        createProducts();
        createBatches();
        createUsers();
        createOrders();
        createKeyword();
    }

    /**
     * This method is used to Sava data into the corresponding CSV files
     * @return Nothing.
     */
    public void saveData()
    {
        Product[] allProducts = getProductArray();
        saveProducts(allProducts);
        saveBatches(allProducts);
        saveUsers();
        saveOrders();
        saveKeyword();
    }

    /**
     * This method is used to Saves all Products information into Products.csv file
     * @return Nothing.
     */
    private void saveProducts(Product[] allProducts)
    {
        String filename = ("Products.csv");
        try
        {
            PrintWriter outputFile = new PrintWriter(filename);
            for (Product p : allProducts)
            {
                outputFile.println(p.toString());
            }
            outputFile.close();
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        finally
        {
            System.out.println("Products saved");
        }
    }

    /**
     * This method is used to Saves all Batch information into Batches.csv
     * @return Nothing.
     */
    private void saveBatches(Product[] allProducts)
    {
        String filename = ("Batches.csv");
        try
        {
            PrintWriter outputFile = new PrintWriter(filename);
            for (Product p : allProducts)
            {
                for (Batch b : p.getBatches())
                {
                    outputFile.println(b.toString());
                }
            }
            outputFile.close();
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        finally
        {
            System.out.println("Batches saved");
        }
    }

    /**
     * This method is used to Saves all Keyword information into Keyword.csv file
     * @return Nothing.
     */
    private void saveKeyword()
    {
        //products.values().toArray(new Product[0])

        String filename = ("Keyword.csv");
        try
        {
            PrintWriter outputFile = new PrintWriter(filename);
            for (Map.Entry<String, Integer> entry : keywords.entrySet())
            {
                outputFile.println(entry.getKey()+","+entry.getValue());
            }
            outputFile.close();
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        finally
        {
            System.out.println("Keywords saved");
        }
    }

    /**
     * This method is used to Saves all Users information into User.csv file
     * @return Nothing.
     */
    private void saveUsers()
    {
        String filename = ("User.csv");

        try
        {
            PrintWriter outputFile = new PrintWriter(filename);
            for (User u : users)
            {
                outputFile.println(u.toString());
                //System.out.println(u.toString());
            }
            outputFile.close();
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        finally
        {
            System.out.println("Users saved");
        }
    }

    /**
     * This method is used to Saves all Orders information into Orders.csv file
     * @return Nothing.
     */
    private void saveOrders()
    {
        String filename = ("Orders.csv");

        try
        {
            PrintWriter outputFile = new PrintWriter(filename);
            for (Order o : orders)
            {
                String[] s = o.toStringArray();
                for (String line: s)
                {
                    outputFile.println(line);
                }
            }
            outputFile.close();
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        finally
        {
            System.out.println("Orders saved");
        }
    }

    /**
     * This method is used to Adds a new product to the hashtable
     * @return Nothing.
     */
    public boolean addProduct(int productID, String name, 
    int minShelfLife, int maxShelfLife, String[] saleTypes)
    {
        int initialSize = products.size();

        products.put(productID, new Product(productID, name, minShelfLife,maxShelfLife, saleTypes));
        if (!keywords.containsKey(name))
        {
            keywords.put(name, productID);
        }
        return (products.size() == (initialSize + 1));
    }

    /**
     * This method is used to Adds a batch to it relevant product
     * @return Nothing.
     */
    private boolean addBatch(int batchID, int quantity, String dateReceived, String saleMethod, 
    double price, String source, String name)
    {
        int productID = batchID/10000;
        Product p = products.get(productID);
        int initialSize = p.getBatches().size();
        p.addBatch(batchID, quantity, dateReceived, saleMethod, price, source, name);
        if (!keywords.containsKey(name))
        {
            keywords.put(name, productID);
        }
        return (p.getBatches().size() == (initialSize + 1));
    }

    /**
     * This method is used to remove batch with its given ID
     * @return Nothing.
     */
    public boolean removeBatch(int batchID)
    {
        int productID = batchID/10000;
        Product p = products.get(productID);
        return p.removeBatch(batchID);
    }

}
