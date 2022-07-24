public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<< Hello Marketplace Application! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();

        Menu menu = new Menu();
//        menu.initScanner();
        System.out.println("Enter data:\n" +
                "/start\n" +
                "/show products\n" +
                "/show users\n" +
                "/trade  //use this only after showing users and products\n" +
                "/exit");
        do {
            menu.menuWord(menu.scanner.nextLine());
        } while (menu.scanner.hasNextLine());

        menu.exit();
    }
}