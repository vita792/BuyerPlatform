package myExeptions;

public class MyException extends Exception{
    public MyException() {
        super();
    }
    public void myExceptionMethod() {

        System.out.println("This is not valid value or other problem!");
    }
}
