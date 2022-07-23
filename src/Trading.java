import model.Product;
import model.User;
import myExeptions.MyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trading {
    private ListOfUsers listOfUsers = new ListOfUsers();
    private List<User> allUsers = listOfUsers.findAllUsers();

    private ListOfProducts listOfProducts = new ListOfProducts();
    private List<Product> allProducts = listOfProducts.findAllProducts();

    private List<Product> buyListOfFirstUser = new ArrayList<>();
    private List<Product> buyListOfSecondUser = new ArrayList<>();
    private List<Product> buyListOfThirdUser = new ArrayList<>();
    public Map<User, List<Product>> tradeHistory = new HashMap<>();

    public void buyProd(int user, Product product) {
//        System.out.println("__________Method trading_____________");
        User idU = allUsers.get(user - 1);
        int switchNumber = idU.getId();
//        System.out.println(idU);
        Product idP = allProducts.get(product.getId() - 1);
//        System.out.println(idP);
        switch (switchNumber) {
            case 1:
                if (idU.getAmountOfMoney() <= 0 || (idU.getAmountOfMoney() - product.getPrice()) < 0) {
                    System.out.println("Not enough money");
                } else {
//                    System.out.println("list before buy " + buyListOfFirstUser);
                    double money = (idU.getAmountOfMoney() - product.getPrice());
//                    System.out.println(money);
                    idU.setAmountOfMoney(money);
                    buyListOfFirstUser.add(idP);
                    tradeHistory.put(idU, buyListOfFirstUser);
                    System.out.println("Bought! " + tradeHistory.keySet());
//                    System.out.println(tradeHistory.keySet());
//                    System.out.println(tradeHistory.entrySet());
                }
                break;
            case 2:
                if (idU.getAmountOfMoney() <= 0 || (idU.getAmountOfMoney() - product.getPrice()) < 0) {
                    System.out.println("Not enough money");
                } else {
//                    System.out.println("list before buy " + buyListOfSecondUser);
                    double money = (idU.getAmountOfMoney() - product.getPrice());
//                    System.out.println(money);
                    idU.setAmountOfMoney(money);
                    buyListOfSecondUser.add(idP);
                    tradeHistory.put(idU, buyListOfSecondUser);
                    System.out.println("Bought! " + tradeHistory.keySet());
//                    System.out.println(tradeHistory);
//                    System.out.println(tradeHistory.entrySet());
                }
                break;
            case 3:
                if (idU.getAmountOfMoney() <= 0 || (idU.getAmountOfMoney() - product.getPrice()) < 0) {
                    System.out.println("Not enough money");
                } else {
                    System.out.println("list before buy " + buyListOfThirdUser);
                    double money = (idU.getAmountOfMoney() - product.getPrice());
//                    System.out.println(money);
                    idU.setAmountOfMoney(money);
                    buyListOfThirdUser.add(idP);
                    tradeHistory.put(idU, buyListOfThirdUser);
                    System.out.println("Bought! " + tradeHistory.keySet());
//                    System.out.println(tradeHistory);
//                    System.out.println(tradeHistory.entrySet());
                }
                break;
            default:
                new MyException().myExceptionMethod();
        }
    }

    public void showBoughtByUserId(int id) {
        switch (id) {
            case 1:
                System.out.println("Product list of first user " + buyListOfFirstUser);
                break;
            case 2:
                System.out.println("Product list of second user " + buyListOfSecondUser);
                break;
            case 3:
                System.out.println("Product list of third user " + buyListOfThirdUser);
                break;
            default:
                new MyException().myExceptionMethod();
        }
    }

    public void soldProducts(int idProduct) {
        System.out.println(tradeHistory.values());
    }
}
