package mph;

interface Flyer{
	public void takeOff();
	public void land();
	public void fly();
	
}

interface Sailer{
	public void dock();
	public void cruise();
}
abstract class Vehicle{
	
}

class AirPlane extends Vehicle implements Flyer{

	@Override
	public void takeOff() {
		// TODO Auto-generated method stub
		System.out.println("take off airplane");
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		System.out.println("land of airplane");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println(" fly airplane");
	}
	
}

class SeaPlane extends AirPlane implements Sailer{
    
	public void dock() {
		System.out.println("dock of seaplane");
		
	}
	public void cruise() {
		System.out.println("cruise of seaplane");
		
	}
	
}

class HeliCopter extends AirPlane{
	public void takeOff() {
		System.out.println("helicopter method takeoff");
		
	}
	
	public void land() {
		System.out.println("helicopter land");
	}
	public void fly() {
		System.out.println("fly helicopter");
	}
	
}

class RiverBarge extends Vehicle implements Sailer{

	@Override
	public void dock() {
		// TODO Auto-generated method stub
		System.out.println("dock of RiverBarge");
	}

	@Override
	public void cruise() {
		// TODO Auto-generated method stub
		System.out.println("cruise of RiverBarge");
	}
	
	
	
}

public class DynamicPolymorphismEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      Sailer s = new SeaPlane();
      s.dock();
      s.cruise();
      AirPlane h = new HeliCopter();
      h.takeOff();
      h.fly();
      h.land();
      Sailer R = new RiverBarge();
      R.dock();
      R.cruise();
	}

}