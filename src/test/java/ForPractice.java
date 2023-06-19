public class ForPractice {

    public static void staticMethodPrintMyAge(){
    System.out.println("My age is 47; static method");
    }
    public void nonStaticMethodPrintMyAge(){
        System.out.println("My age is 47, non static method");
    }
    public static void printMyAge(){
        ForPractice.staticMethodPrintMyAge();

        ForPractice myAgeObjectInstanceOfClass = new ForPractice();
        myAgeObjectInstanceOfClass.nonStaticMethodPrintMyAge();
    }
}
