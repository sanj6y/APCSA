public class BikeDemo 
{
     public static void main (String[] args) 
     {
          // Create two different Bicycle objects
          Bicycle bike1 = new Bicycle();
          Bicycle bike2 = new Bicycle();

          System.out.println("\n\n\nBIKE 1");
          bike1.printStates();
          // Invoke methods on those objects
          bike1.changeCadence(50);
          bike1.speedUp(10);
          bike1.changeGear(2);
          bike1.printStates();
		  System.out.println();

		  System.out.println("BIKE 2");
          bike2.printStates();
          bike2.changeCadence(50);
          bike2.speedUp(10);
          bike2.changeGear(2);
          bike2.changeCadence(40);
          bike2.speedUp(10);
          bike2.changeGear(3);
          bike2.printStates();
		  System.out.println();

		  System.out.println("MOUNTAIN BIKE 1");
//          MountainBike mbike1 = new MountainBike ( 25, 4, 5, 6 );
          MountainBike mbike1 = new MountainBike();
          mbike1.printStates();
          mbike1.changeCadence(50);
          mbike1.speedUp(10);
          mbike1.changeGear(2);
          mbike1.changeCadence(40);
          mbike1.speedUp(10);
          mbike1.changeGear(3);
          mbike1.printStates();
          System.out.println("\n\n\n");
     }
}

class Bicycle 
{
    // the Bicycle class has three fields
    private int cadence;
    private int gear;
    private int speed;
	
    // the Bicycle class has two constructors
    public Bicycle() 
    {
        gear = 1;
        cadence = 5;
        speed = 5;
    }

    public Bicycle(int startCadence, int startSpeed, int startGear) 
    {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
	
    // the Bicycle class has four methods
    public void setCadence(int newValue) 
    {
        cadence = newValue;
    }
	
    public void setGear(int newValue) 
    {
        gear = newValue;
    }
	
    public void applyBrake(int decrement) 
    {
        speed -= decrement;
    }
	
    public void speedUp(int increment) 
    {
        speed += increment;
    }

    public void changeCadence(int newValue) 
    {
        cadence = newValue;
    }

    public void changeGear(int newValue) 
    {
         gear = newValue;
    }

    public void applyBrakes(int decrement) 
    {
         speed = speed - decrement;
    }

    public void printStates() 
    {
         System.out.println("cadence:"+cadence+" speed:"+speed+" gear:"+gear);
    }
}

class MountainBike extends Bicycle 
{
    // the MountainBike subclass adds one field
    private int seatHeight;
/*
    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight, int startCadence, int startSpeed, int startGear) 
    {
//		super();		
//		super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }	
*/
    // the MountainBike subclass adds one method
    public void setHeight(int newValue) 
    {
        seatHeight = newValue;
    }	
}