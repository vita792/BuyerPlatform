package myExeptions;

public class MyException extends Exception{
    public MyException(String message) {
        super(message + "This is not valid value or other problem!");
//        System.out.println("This is not valid value or other problem!");
    }
}
