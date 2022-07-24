import model.User;

import java.util.ArrayList;
import java.util.List;

public class ListOfUsers {

    User firstUser = new User(1, "Bob", "Johnson", 100.54);
    User secondUser = new User(2, "Bella", "Swan", 84.23);
    User thirdUser = new User(3, "Rich", "Purchase", 0);

    public ListOfUsers() {
    }

    List<User> users = new ArrayList<>();

    private List<User> savedUsers() {
        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);
        return users;
    }

    public List<User> findAllUsers() {
        savedUsers();
        System.out.println();
//        System.out.println("Buyers:");
        for (User user : users) {
//            System.out.println(user);
        }
        return users;
    }

    public User findUserById(int idUser) {
        if (idUser > users.size() || idUser <= 0) {
            System.out.printf("To see all available users used '/show users'. " +
                    "Marketplace Application are not visited by User with idNumber %d.\n", idUser);
        } else {
            for (User user : users) {
                if (user.getId() == idUser) {
                    System.out.println(user.getId() + " " + user.getFirstName() + " "
                            + user.getLastName() + " " + user.getAmountOfMoney() + "$");
                    return user;
                }
            }
        }
        return new User();
    }

    @Override
    public String toString() {
        return "firstUser = " + firstUser +
                ", secondUser = " + secondUser +
                ", thirdUser = " + thirdUser;
    }
}