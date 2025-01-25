// The "IDGraphic" class.
import java.awt.*;
import hsa.Console;

public class IDGraphic
{
    static Console c;           // The output console
    public static Image Pic;


    public static void main (String[] args)
    {
	c = new Console ();

	//colours for graphics
	Color background = new Color (216, 224, 227); //this is a repeat color
	Color userID = new Color (147, 179, 189);
	Color userID2 = new Color (98, 146, 161);

	//fonts for graphics
	Font IDFont = new Font ("Impact", Font.ITALIC, 30);

	//background
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//ID card shape
	c.setColor (userID);
	c.fillRoundRect (100, 50, 450, 275, 50, 50);

	//card Color details
	c.setColor (userID2);
	c.fillArc (100, 50, 50, 50, 90, 90);
	c.fillRect (125, 50, 400, 25);
	c.fillArc (500, 50, 50, 50, 0, 90);
	c.fillRect (100, 75, 450, 20);

	//user information
	c.setFont (IDFont);

	//name
	c.drawString ("Dr.", 300, 130);
	c.drawString (user.getName (), 320, 130);

	//field of study
	if (doctor.getField () == 0)
	{
	    String fieldPrint = "Optometry"
	}
	if (user.getField () == 1)
	{
	    String fieldPrint = "Physiotherapy"
	}
	if (user.getField () == 2)
	{
	    String fieldPrint = "Neruology"
	}
	if (user.getField () == 3)
	{
	    String fieldPrint = "Dermatology"
	}
	if (user.getField () == 5)
	{
	    String fieldPrint = "Cardiology"
	}

	c.drawString ("Doctor of ", 300, 180);
	c.drawString (fieldPrint, 300, 215);

	//patients cured
	c.drawString ("Cured" + track.patientsCured () + "patients", 320, 260);



	//money earned
	c.drawString ("Earned $" + user.getMoenyEarned (), 320, 310);


	//card extras

	//photo
	new Picture2 ("IDphoto.png", c, Pic, 120, 110);

	//photoframe
	c.drawRect (140, 110, 145, 175);



	//signature
	new Picture2 ("Signature.png", c, Pic, 160, 283);

	//location
	c.setColor (userID);
	c.drawString ("Oakville Hospital", 110, 90);












	// Place your program here.  'c' is the output console
    } // main method
} // IDGraphic class
