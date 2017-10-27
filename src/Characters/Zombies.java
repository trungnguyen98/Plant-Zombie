package Characters;

import org.newdawn.slick.*;
import java.util.ArrayList;

public class Zombies extends GameObject{
	
	protected int hp=100;
	protected int damage;
	protected double speed=-0.2;
	
	public Zombies(int x,int y)
	{
		super(x,y);
	}
	
	public void moving()
	{
		xPos+=speed;
	}
	
	public void attack(Plants plant)        // have not been used yet
	{
		plant.hp-=this.damage;
	}
	
	public boolean checkShot(Bullet b)        // have not been used yet
	{
		if(b.xPos==this.xPos)
		{
			return true;
		}
		return false;
	}
	
	public void draw( ArrayList<Image> zom,double i)
	{
		zom.get((int)i).draw((int)this.xPos, (int)this.yPos, zom.get((int)i).getWidth()/3, zom.get((int)i).getHeight()/3);
		//use this code to RESIZE image
	}
}
