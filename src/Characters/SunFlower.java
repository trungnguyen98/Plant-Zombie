package Characters;

public abstract class SunFlower extends GameObject{
	
	public int speed =1;
	int hp;
	int damage;
	/*
	 * 	Constructor
	 */
	public SunFlower(int x,int y)
	{
		super(x,y);
	}
	/*
	 * 	Get-Set method
	 */
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
