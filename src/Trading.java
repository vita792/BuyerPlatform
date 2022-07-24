import model.Product;
import model.User;
import myExeptions.MyException;

import java.util.*;
import java.util.stream.Collectors;

public class Trading {
    private ListOfUsers listOfUsers = new ListOfUsers();
    private List<User> allUsers = listOfUsers.findAllUsers();

    private ListOfProducts listOfProducts = new ListOfProducts();
    private List<Product> allProducts = listOfProducts.findAllProducts();

    private List<Product> buyListOfFirstUser = new ArrayList<>();
    private List<Product> buyListOfSecondUser = new ArrayList<>();
    private List<Product> buyListOfThirdUser = new ArrayList<>();
    private List<User> buyersListOfFirstProduct = new ArrayList<>();
    private List<User> buyersListOfSecondProduct = new ArrayList<>();
    private List<User> buyersListOfThirdProduct = new ArrayList<>();
    public Map<User, List<Product>> tradeHistory = new HashMap<>();
    public Map<Product, List<User>> tradingProducts = new HashMap<>();
    public void buyProd(int user, int product) throws MyException {
//        System.out.println("__________Method trading_____________");
        if (user <= 0 || product <= 0 || user >  allUsers.size() || product > allProducts.size()) {
            System.out.println("Marketplace Application haven`t that article, or are not visited by User with that idNumber.");
        } else {
            User idU = allUsers.get(user - 1);
            int switchNumber = idU.getId();
            Product idP = allProducts.get(product - 1);
            switch (switchNumber) {
                case 1:
                    if (idU.getAmountOfMoney() <= 0 || (idU.getAmountOfMoney() - idP.getPrice()) < 0) {
                        System.out.println("Not enough money");
                        throw new MyException("Cannot buy! ");
                    } else {
                        double money = (idU.getAmountOfMoney() - idP.getPrice());
                        idU.setAmountOfMoney(money);
                        buyListOfFirstUser.add(idP);
                        tradeHistory.put(idU, buyListOfFirstUser);
                        System.out.println("Bought! " + tradeHistory.keySet().stream()
                                .filter(id -> id.getId() == idU.getId()).collect(Collectors.toList()));
                        putUserIntoListOfProduct(idP, 0);
                    }
                    break;
                case 2:
                    if (idU.getAmountOfMoney() <= 0 || (idU.getAmountOfMoney() - idP.getPrice()) < 0) {
                        System.out.println("Not enough money");
                        throw new MyException("Cannot buy! ");
                    } else {
                        double money = (idU.getAmountOfMoney() - idP.getPrice());
                        idU.setAmountOfMoney(money);
                        buyListOfSecondUser.add(idP);
                        tradeHistory.put(idU, buyListOfSecondUser);
                        System.out.println("Bought! " + tradeHistory.keySet().stream()
                                .filter(id -> id.getId() == idU.getId()).collect(Collectors.toList()));
                        putUserIntoListOfProduct(idP, 1);
                    }
                    break;
                case 3:
                    if (idU.getAmountOfMoney() <= 0 || (idU.getAmountOfMoney() - idP.getPrice()) < 0) {
                        System.out.println("Not enough money");
                        throw new MyException("Cannot buy! ");
                    } else {
                        double money = (idU.getAmountOfMoney() - idP.getPrice());
                        idU.setAmountOfMoney(money);
                        buyListOfThirdUser.add(idP);
                        tradeHistory.put(idU, buyListOfThirdUser);
                        System.out.println("Bought! " + tradeHistory.keySet().stream()
                                .filter(id -> id.getId() == idU.getId()).collect(Collectors.toList()));
                        putUserIntoListOfProduct(idP, 2);
                    }
                    break;
                default:
                    throw new MyException("Something goes wrong!");
            }
        }
    }

    private void putUserIntoListOfProduct(Product product, int indexUser) {
        if (product.getId() == 1) {
            buyersListOfFirstProduct.add(allUsers.get(indexUser));
            tradingProducts.put(product, buyersListOfFirstProduct);
        } else if (product.getId() == 2) {
            buyersListOfFirstProduct.add(allUsers.get(indexUser));
            tradingProducts.put(product, buyersListOfFirstProduct);
        } else if (product.getId() == 3) {
            buyersListOfFirstProduct.add(allUsers.get(indexUser));
            tradingProducts.put(product, buyersListOfFirstProduct);
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
                break;
        }
    }

    public void soldProducts(int idProduct) {
        switch (idProduct) {
            case 1:
                System.out.println("Users list of first product " + buyersListOfFirstProduct);
                break;
            case 2:
                System.out.println("Users list of second product " + buyersListOfSecondProduct);
                break;
            case 3:
                System.out.println("Users list of third product " + buyersListOfThirdProduct);
                break;
            default:
                break;
        }
    }

    public void findBuyersById(int idUser) {
        System.out.println(tradeHistory.keySet().stream()
                .filter(id -> id.getId() == idUser).collect(Collectors.toList()));
    }
}
