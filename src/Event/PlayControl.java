package Event;
import Characters.*;
import GUI.*;
import java.util.concurrent.ThreadLocalRandom;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import java.util.ArrayList;

public class PlayControl {
	
	public LevelControl level=new LevelControl();
	public int limitness=0;
	
	Physic phy =new Physic();
	private ArrayList<Zombies> zombies=new ArrayList<>();
	private ArrayList<Bullet> bullets=new ArrayList<>();
	private ArrayList<Sun> sun=new ArrayList<>();
	private Integer[] stopPos=new Integer[5];
	Zombies tempZombie;
	Plants shooter;
	Bullet tempBullet;
	Sun tempSun;
	StateBasedGame sbg;
	GameContainer gc;
	Main screen;
	Graphics g;
	Sound Punch;
	Sound ZomWalk;

	private int check ;
	private int delayTimeSun=0;
	private int delaySun=getDelayTimeSun(80);

//	double a, b, c, d;
	public int getDelayTimeSun(int maxTime)
	{
		return (int)(Math.random()*maxTime)+1;
	}
	//private int k=595;                                    // sun fall into random area
	
	//--------------------------------------PLANTS--------------------------------------
	public void renderPlants(Plants p) throws SlickException
	{
		level.drawPlants(p);
	}
	//--------------------------------------BULLET---------------------------------------
			public void shoot()
			{
				for(int i=0;i<bullets.size();i++)             //shoot all the bullets in the list
				{
					tempBullet=bullets.get(i);

					if(tempBullet.xPos>screen.WIDTH)       // remove bullets out of screen
					{
						removeBullet(tempBullet);
					}

					if(phy.Collision(tempBullet, zombies))
					{
						removeBullet(tempBullet);
					}
					tempBullet.flying();
				}
			}

			public void renderBullet(Graphics g) throws SlickException              // draw bullets
			{
				
				for(int i=0;i<bullets.size();i++)
				{
					tempBullet=bullets.get(i);
					//tempBullet.draw(g,png);
					level.drawBullets(tempBullet);
					//tempBullet.dr
				}
			}

			public void addBullet(Bullet b)
			{
				bullets.add(b);
			}

			public void removeBullet(Bullet b)
			{
				bullets.remove(b);
			}



	//--------------------------------------ZOMBIE---------------------------------------
	public void zomWalk() throws SlickException
	{
		for(int i=0;i<zombies.size();i++)  ///shoot all the bullets in the list
		{
			Punch = new Sound("res/Play/Punch.wav");
			ZomWalk = new Sound("res/Play/zombie.wav");
			tempZombie=zombies.get(i);

			tempZombie.moving();
			//ZomWalk.loop();
			//if(tempZombie.xPos<0 || tempZombie.getHp()<=0)

			if(tempZombie.xPos<165 || tempZombie.getHp()<=0)
			{
				removeZombie(tempZombie);
				limitness++;
				checkToSwitchLevel();
				Punch.play();
			}
			if(phy.Collision(tempZombie, bullets))
			{
				//tempZombie.setHp(tempZombie.getHp()-20);
				level.setHp(tempZombie);
			}
		}

	}
	public void renderZombie(ArrayList<Image> png,double n)
	{

		for(int i=0;i<zombies.size();i++)
		{
			tempZombie=zombies.get(i);
			tempZombie.draw(png,n);
		}
	}

	public void addZombie(Zombies z)
	{
		zombies.add(z);
	}

	public void removeZombie(Zombies z)
	{
		zombies.remove(z);
	}

	//--------------------------------------SUN---------------------------------------

	public void fall() throws SlickException
	{	stopPos[0]=195;
		stopPos[1]=295;
		stopPos[2]=395;
		stopPos[3]=495;
		stopPos[4]=595;


		for(int i=0;i<sun.size();i++)             //shoot all the bullets in the list
		{
			tempSun=sun.get(i);

			if(tempSun.yPos <= stopPos[tempSun.getRandomInt()])
				tempSun.yPos += 1;
			}			
			
	}

	public void renderSun(Graphics g,Image png)              // draw bullets
	{

		for(int i=0;i<sun.size();i++)
		{
			tempSun=sun.get(i);
			tempSun.draw(g,png);
		}
	}

	public void addSun(Sun b)
	{
		sun.add(b);
	}

	public void removeSun(Sun b)
	{
		//tempSun.stop();
		sun.remove(b);
		/*
		}*/
	}


	
	public void checkToSwitchLevel()
	{
		if(limitness==level.setLimitness())
		{
			level.gameLevel++;
			limitness=0;
		}
	}
}
	
