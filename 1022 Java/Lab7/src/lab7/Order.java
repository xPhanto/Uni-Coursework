package lab7;

public class Order {

	private int NumofChilds;
	private Child[] Childs;
	
	
	public Order(){
		this.Childs = new Child[5];
		this.NumofChilds = 0;
	}

	public void addChildtoOrder(Child kiddo) {
		
		if(this.NumofChilds == 5) {
			return;
		}
		
		Child[] newOrder = new Child[this.NumofChilds+1];
		
		for(int i = 0; i < this.NumofChilds;i++) {
			newOrder[i] = this.Childs[i];
			
		}
		newOrder[this.NumofChilds] = kiddo;
		
		this.Childs = newOrder;
		this.NumofChilds++;
	}
	
	public void removeChildfromOrder(Child kiddo) {
			
		int index = -1;
		for(int i = 0; i< this.Childs.length; i++) {
			if(this.Childs[i] == kiddo) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
			Child[]temp = new Child[this.Childs.length-1];
			int j = 0;
			for(int i = 0; i < this.Childs.length;i++) {
				if(i != index) {
					temp[j++] = this.Childs[i];
				}
			}
			this.Childs = temp;
			this.NumofChilds -= 1;
		}
		
		
	}

	public int getNumofChilds() {
		return NumofChilds;
	}


	public Child[] getChilds() {
		return Childs;
	}

	public String toString() {
		String result = String.format("The order contains %d Childs", this.getNumofChilds());
		return result;
	}
}
