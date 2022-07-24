import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    private ListOfProducts listOfProducts = new ListOfProducts();
    private ListOfUsers listOfUsers = new ListOfUsers();
    private Trading trade = new Trading();

//    public void initScanner() {}

    public void menuWord(String itemMenu) {
        switch (itemMenu) {

            case "/start":
                System.out.println();
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<< Hello Marketplace Application! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println();

                System.out.println("\nEnter data:\n" +
                        "/start\n" +
                        "/show products\n" +
                        "/show users\n\n(for showing users and products before trading)\n" +
                        "/show users/show user with id\n" +
                        "/show products/show product with id\n\n" +
                        "/trade  //now you can trade! after that you can use options downs\n" +
                        "/trade/show bought for user with id\n" +
                        "/trade/sold products by id\n" +
                        "/show users/show user with id after trade\n" +
                        "/exit\n");
                break;

            case "/show products":
                System.out.println("Today in our Market You can buy:");
                listOfProducts.findAllProducts();
                System.out.println();
                break;

            case "/show products/show product with id":
                System.out.println("Enter id from 1 to 3");
                scanner.hasNextInt();
                System.out.println("___ProductById___");
                listOfProducts.findByIdProducts(scanner.nextInt());
                System.out.println();
                break;

            case "/show users":
                System.out.println("___AllUsers___");
                listOfUsers.findAllUsers();
                System.out.println();
                break;

            case "/show users/show user with id":
                System.out.println("Enter id from 1 to 3");
                scanner.hasNextInt();
                System.out.println("___UserById___");
                listOfUsers.findUserById(scanner.nextInt());
                System.out.println();
                break;

            case "/show users/show user with id after trade":
                System.out.println("Enter id from 1 to 3");
                scanner.hasNextInt();
                System.out.println("___UserById___");
                trade.findBuyersById(scanner.nextInt());
                System.out.println();
                break;
            case "/trade":
                System.out.println("For start trading choose user. Enter id from 1 to 3");
                scanner.hasNextInt();
                System.out.println("Now choose product. Enter id from 1 to 3");
                trade.buyProd(scanner.nextInt(), listOfProducts.findByIdProducts(scanner.nextInt()));
                break;
            case "/trade/show bought for user with id":
                System.out.println("Enter id from 1 to 3");
                scanner.hasNextInt();
                trade.showBoughtByUserId(scanner.nextInt());
                break;
            case "/trade/sold products by id":
                System.out.println("Enter id from 1 to 3");
                scanner.hasNextInt();
                trade.soldProducts(scanner.nextInt());
                break;

            case "/exit":
                System.out.println();
                System.out.println("<<<<<<<<<<<<<<<<<<<< Thank You for visited Marketplace Application! >>>>>>>>>>>>>>>>>>>>>");
                System.out.println();
                break;

            default:
                break;
        }
    }

    public void exit() {
        scanner.close();
    }
}
