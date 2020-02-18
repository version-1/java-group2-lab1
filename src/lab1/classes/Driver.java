package lab1.classes;

public class Driver {

  public static void main(String[] args) {
    Model tiger = new Model("Tiger", "Woods", 72, 190, true, false);

    tiger.printDetails();

    Model susan = new Model("Susan", "Smith", 0 , 120, true, false);
    susan.setHeight(5, 10);

    susan.displayModelDetails();
  }
}