public class car {
   
   int speed, year;
   String name;
   
   public car() {
      speed = 240;
      year = 2002;
      name = "Ferrari";
   }
   
   public car(int s, int y, String n) {
      speed = s;
      year = y;
      name = n;
   }
   
   public int getSpeed() {
      return speed;
   }
   
   public void setSpeed(int s) {
      speed = s;
   }
   
   public int search(int y, String n) {
      if (year == y && name.equals(n))
         return speed;
      return 0;
   }
   
   public static void main(String[] args) {
      car theCar = new car(340, 1654, "BMW");
      int speedOfCar1 = theCar.getSpeed();
      car car2 = new car();
      car2.setSpeed(100);
      int checkSpeed = car2.search(2002, "Ferrari");
      int speedOfCar2 = car2.getSpeed();
      System.out.println(speedOfCar1+"\n");
      System.out.println(speedOfCar2+"\n");
      System.out.println(checkSpeed);
   }
}

