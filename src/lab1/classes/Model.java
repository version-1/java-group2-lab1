package lab1.classes;

public class Model {
  private String firstName;
  private String lastName;
  private int height;
  private double weight;
  private boolean canTravel;
  private boolean smokes;

  public static final int INCHES_PER_FOOT = 12;
  public static final double POUNDS_PER_KG = 2.2046;
  public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
  public static final int TALL_INCHES = 67;
  public static final double THIN_POUNDS = 140.0;
  public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
  public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
  public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;


  public Model() {
  }

  public Model(String firstName, String lastName, int height, double weight, boolean canTravel, boolean smokes) {
    setFirstName(firstName);
    setLastName(lastName);
    setWeight(weight);
    setHeight(height);
    setCanTravel(canTravel);
    setSmokes(smokes);
  }

  public Model(String firstName, String lastName, int height, double weight) {
    setFirstName(firstName);
    setLastName(lastName);
    setWeight(weight);
    setHeight(height);
    setCanTravel(true);
    setSmokes(false);
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public int getHeight() {
    return this.height;
  }

  public double getWeight() {
    return this.weight;
  }

  public boolean getCanTravel() {
    return this.canTravel;
  }

  public boolean getSmokes() {
    return this.smokes;
  }

  public String getHeightInFeetAndInches() {
    final int feet = this.height / INCHES_PER_FOOT;
    final int inches = this.height % INCHES_PER_FOOT;
    return feet + " feet " + inches + " inches";
  }

  public long getWeightKg() {
    return Math.round((long) (this.weight / POUNDS_PER_KG));
  }


  public void setFirstName(String firstName) {
    if (firstName.length() < 2 && firstName.length() > 20 ) {
      return;
    }
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    if (lastName.length() < 2 && lastName.length() > 20 ) {
      return;
    }
    this.lastName = lastName;
  }

  public void setCanTravel(boolean canTravel) {
    this.canTravel = canTravel;
  }

  public void setSmokes(boolean smokes) {
    this.smokes = smokes;
  }

  public void setWeight(double pound) {
    if (pound < 80 && pound > 280) {
      return;
    }
    this.weight = pound;
  }

  public void setWeight(long kilograms) {
    double pound = kilograms * POUNDS_PER_KG;
    if (pound < 80 && pound > 280) {
      return;
    }
    this.weight = pound;
  }

  public void setHeight(int inches) {
    if (inches < 24 && inches > 84) {
      return;
    }
    this.height = inches;
  }

  public void setHeight(int feets, int inches) {
    int height = feets * INCHES_PER_FOOT + inches;
    if (height < 24 && height > 84) {
      return;
    }
    this.height = height;
  }

  public void printDetails() {
    String travel = getCanTravel() ? "Does travel" : "Does not travel";
    String smokes = getSmokes() ? "Does smokes" : "Does not smokes";
    System.out.println(
      "Name: "  + getFirstName() + " " + getLastName() + "\n" +
      "Height: " + getHeight() + " inches\n" +
      "Weight: " + getWeight() + " pounds\n" +
      travel + "\n" +
      smokes + "\n"
    );
  }

  public int calculatePayDollarsPerHour () {
    int salary = BASE_RATE_DOLLARS_PER_HOUR;
    if (getHeight() > TALL_INCHES && getWeight() < THIN_POUNDS) {
      salary += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
    }
    if (getCanTravel()) {
      salary += TRAVEL_BONUS_DOLLARS_PER_HOUR;
    }
    if (getSmokes()) {
      salary -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
    }
    return salary;
  }

  public void displayModelDetails () {
    String travels = getCanTravel() ? "yep" : "nope";
    String smokes = getSmokes() ? "yep" : "nope";
    System.out.println(
      "Name: "  + getFirstName() + " " + getLastName() + "\n" +
      "Height: " + getHeightInFeetAndInches() + "\n" +
      "Weight: " + getWeight() + " pounds\n" +
      "Travels: " + travels + "\n" +
      "Smokes: " + smokes + "\n" +
      "Hourly rate: " + "$" + calculatePayDollarsPerHour()
    );
  }
}