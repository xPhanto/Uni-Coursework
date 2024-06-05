package lab7;

public class Child {
	
	private String name;
	private int age;
	private Toy[] toys;
	private int numtoys;
	
	public Child(String name, int age, Toy[] toys) {
		
		this.name = name;
		this.age = age;
		
		if(toys != null) {
			this.numtoys = toys.length;
			for(int i = 0; i < toys.length; i++) {
				toys[i] = new Toy(toys[i]);
			}
		}else {
			this.numtoys = 0;
		}
		
		this.toys = toys;

	}
	
	public Child(Child kiddo) {
		this.name = kiddo.name;
		this.age = kiddo.age;

		if(kiddo.toys != null) {
			Toy[] newtoys = new Toy[kiddo.toys.length];
			for(int i = 0; i < kiddo.toys.length; i++) {
				newtoys[i] = new Toy(kiddo.toys[i]);
			}
			this.toys = newtoys;
			this.numtoys = newtoys.length;
			
		}else {
			this.numtoys = 0;
			this.toys = null;
		}
		
	}
	
	public void disposeToys() {
		this.toys = null;
		this.numtoys = 0;
	}
	
	public void donate(Child kiddo) {
		
		int len = 0;
		int index = 0;
		
		if(kiddo.toys == null) {
			kiddo.toys = this.toys;
			kiddo.numtoys = kiddo.toys.length;
			
		}else { 
			len = (kiddo.toys.length + this.toys.length);
			Toy[] temp = new Toy[len];
				
			for (int i = 0; i < kiddo.toys.length; i++) {
				temp[index] = kiddo.toys[i];
				index++;
			}
		
			for (int i = 0; i < this.toys.length; i++) {
				temp[index] = this.toys[i];
				index++;
			}
			kiddo.toys = temp;
			kiddo.numtoys = temp.length;
		}
		
		this.disposeToys();
	}
	
	
	

	public String getChildName() {
		return name;
	}

	public int getChildAge() {
		return age;
	}


	public Toy[] getChildToy() {
		return toys;
	}
	
	public int getNumberofToys() {
		return numtoys;
		
		/*if(toys == null) {
			return 0;
		}
		return toys.length; */
	}
	
	public void setChildName(String name) {
		this.name = name;
	}
	
	public void setChildAge(int age) {
		this.age = age;
	}
	
	
	public String toString() {
		
		return String.format("Child [%s] of age <%d> has (%d) toys", name, age, numtoys);
	}

}
