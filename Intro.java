// The "Intro" class.
import java.awt.*;
import hsa.Console;

public class Intro
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	//doctor object
	Doctor user = new Doctor (" ", -1, 0);

	//fonts for graphics
	Font title = new Font ("Impact", Font.PLAIN, 50);
	Font title2 = new Font ("Impact", Font.ITALIC, 25);

	//colour for graphics
	Color skyBlue = new Color (165, 216, 232);
	Color building = new Color (130, 118, 101);
	Color signRed = new Color (171, 46, 46);
	Color window = new Color (186, 209, 207);


	//intro text(will be done using drawString on the intro screen)
	/*

				char endIntro;
				    do
				{
				    endIntro = c.getChar ();
				}
				while (endIntro != 10);

				//how to play/intructions
				c.println ("How to Play:");
				c.println ("Here at the hospital you are tasked with dianosing and assigning a cure to the patients you encounter");
				c.println ("These patients will have illnesses determined by the field of medicine you want to explore");
				c.println ("By properly assigning cures to patients you will earn money, that will accumulate as you continue playing");

				//user input for doctor
				c.println ("Enter your name");
				String name = c.readString ();

				c.println ("What field whould you like to focus on?(0-4)");
				int field = c.readInt ();

				//assignning user input into doctor object
				user.setName (name);
				user.setField (field);
		      */

	//intro screen
	c.setColor (skyBlue);
	c.fillRect (0, 0, 650, 500);

	//buildings
	c.setColor (building);
	c.fillRect (100, 300, 125, 200);
	c.fillRect (425, 300, 125, 200);
	c.fillRect (230, 200, 190, 300);

	//hospital sign
	c.setColor (Color.white);
	c.fillOval (275, 225, 100, 100);
	c.fillOval (275, 225, 100, 100);
	c.setColor (signRed);
	c.fillRect (312, 240, 25, 75);
	c.fillRect (287, 265, 75, 25);

	//intro text
	c.setFont (title);
	c.drawString ("Welcome to",200,75);
	c.drawString("the Hospital Simulator", 95, 125);
	c.setFont(title2);
	c.drawString ("press enter to start", 220, 175);

	//left windows
	c.setColor (window);
	int y = 320;
	int x = 120;

	for (int j = 0 ; j < 2 ; j++)
	{
	    for (int i = 0 ; i < 4 ; i++)
	    {
		c.fillRect (x, y, 30, 30);
		y += 40;
	    }
	    x += 50;
	    y = 320;
	}

	//right windows
	x = 445;

	for (int j = 0 ; j < 2 ; j++)
	{
	    for (int i = 0 ; i < 4 ; i++)
	    {
		c.fillRect (x, y, 30, 30);
		y += 40;
	    }
	    x += 50;
	    y = 320;
	}

	//doors
	c.fillRect (280, 430, 40, 70);
	c.fillRect (325, 430, 40, 70);




	// Place your program here.  'c' is the output console
    } // main method
} // IntroGraphics class
