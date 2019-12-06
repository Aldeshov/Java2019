abstract class Phone {
 private String typeOfPhone;
 private String model;
 public Phone(String typeOfPhone,String model) {
	 this.typeOfPhone=typeOfPhone;
	 this.model=model;
 }
 public String getTypeOfPhone() {
	 return typeOfPhone;
 }
 public void setTypeOfPhone(String newTypeOfPhone) {
	 this.typeOfPhone=newTypeOfPhone;
 }
 
 public String getModel() {
	 return model;
 }
 public void setModel(String newModel) {
	 model=newModel;
 }
 public abstract void call();
 public abstract void sendMessage();
 
}
class Nokia extends Phone{
	public Nokia(String typeOfPhone, String model) {
		super(typeOfPhone, model);
	}
	@Override
	public void call() {
		
	}
	@Override
	public void sendMessage() {
		
	}
}
class Samsung extends Phone {
public Samsung(String typeOfPhone,String model) {
	super(typeOfPhone,model);
}

@Override
public void call() {
	
}
@Override
public void sendMessage() {
	
}
}
////////////////////////////////////////////////////////
interface Moveable{
	int walk = 0;
	int jump = 1;
	int fly = 2;
	void move();
}
interface Flyable extends Moveable{
	void move();
}
class Mosquito implements Flyable {
	   private int ability;
	   private String name;
	   private String timeOfLife;
	   public Mosquito(String name,String timeOfLife) {
		   this.name=name;
		   this.timeOfLife=timeOfLife;
		   this.ability = fly;
	   }
	    public String getName() {
	    return name;
	    }
	    public void setName(String newName) {
	    	this.name=newName;
	    }
	    public String getTimeOfLife() {
	    	return timeOfLife;
	    }
	    public void setTimeOfLife(String newTimeOfLife) {
	    	this.timeOfLife=newTimeOfLife;
	    }
		public int getAbility() {
			return ability;
		}
		@Override
		public void move() {
			// TODO Auto-generated method stub
			
		}
	 }
class Plain implements Flyable{
	   private int ability;
	   private String route;
	   private String  numberOfPlain;
	   private String timeOfWay;
	   public Plain(String route,String numberOfPlain,String timeOfWay) {
		  this.numberOfPlain=numberOfPlain;
		  this.route=route;
		  this.timeOfWay=timeOfWay;
		  this.ability = fly;
	   }

		public void setRoute(String newRoute) {
			this.route=newRoute;
		}
		public void setNumberOfPlain(String newNumberOfPlain) {
			this.numberOfPlain=newNumberOfPlain;
		}
		public void setTimeOfWay(String newTimeOfWay) {
			this.timeOfWay=newTimeOfWay;
		}
		public String getRoute() {
			return route;
		}
		public int getAbility() {
			return ability;
		}
		public String getTimeOfWay() {
			return timeOfWay;
		}
		public String getNumberOfPlain() {
			return numberOfPlain;
		}
		@Override
		public void move() {
			// TODO Auto-generated method stub
			
		}
	}
public class problem1 {
	public static void main(String args[]) {
		
	}
}
