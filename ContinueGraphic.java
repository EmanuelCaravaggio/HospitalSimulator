// The "ContinueGraphic" class.
import java.awt.*;
import hsa.Console;

public class ContinueGraphic
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	//fonts for grpahics
	Font h = new Font ("Impact", Font.ITALIC, 35);
	Font h2 = new Font ("Impact", Font.PLAIN, 40); //change font name
	Font h3 = new Font ("Impact", Font.ITALIC, 20); //change font name


	//colors for graphics
	Color background = new Color (216, 224, 227); //this is a repeat color
	Color directory = new Color (98, 146, 161); //repeat color


	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//directory shape
	c.setColor (directory);
	c.fillRect (100, 50, 450, 415);
	//top box
	c.setColor (Color.white);
	c.fillRect (100, 50, 450, 100);

	//for boxes below the top box
	int x = 150;
	for (int i = 0 ; i < 4 ; i++)
	{
	    c.drawRect (100, x, 450, 75);
	    x += 80;
	}

	//top box text
	c.setFont (h);
	c.setColor (directory);
	c.drawString ("Would you like to Continue?", 125, 140);

	//continue options

	//continue with same field
	c.setColor (Color.white);
	c.drawOval (120, 157, 60, 60);
	c.setFont (h2);
	c.drawString ("1", 143, 205);
	c.drawString ("Continue in Field", 200, 205);


	//change the field
	c.drawOval (120, 237, 60, 60);
	c.drawString ("2", 143, 285);
	c.drawString ("Try a New Field", 200, 285);

	//exit game
	c.drawOval (120, 317, 60, 60);
	c.drawString ("3", 143, 365);
	c.drawString ("Exit Simulation", 200, 365);

	//directory extra details
	c.setColor (directory);
	c.setFont (h3);
	c.drawString ("Hospital DIrectory", 115, 80);
	c.drawString ("Floor 1", 475, 80);



	// Place your program here.  'c' is the output console
    } // main method
} // ContinueGraphic class
