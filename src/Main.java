public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<< Hello Marketplace Application! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();

        Menu menu = new Menu();
//        menu.initScanner();
        System.out.println("\nEnter data:\n" +
                "/start\n(for initialising system show users and products)\n" +
                "/show products\n" +
                "/show users\n\n(for showing users and products before trading)\n" +
                "/show users/show user with id\n" +
                "/show products/show product with id\n\n" +
                "/trade  //now you can trade! after that you can use options downs\n" +
                "/trade/show bought for user with id\n" +
                "/trade/sold products by id\n" +
                "/show users/show user with id after trade\n" +
                "/exit\n");
        do {
            menu.menuWord(menu.scanner.nextLine());
        } while (menu.scanner.hasNextLine());

        menu.exit();
    }
}