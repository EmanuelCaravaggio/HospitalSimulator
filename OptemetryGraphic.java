// The "OptemetryGraphic" class.
import java.awt.*;
import hsa.Console;

public class OptemetryGraphic
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	//colors for graphics
	Color background = new Color (216, 224, 227); //this is a repeat color
	Color textbox = new Color (84, 72, 52);

	//fonts
	Font infoText = new Font ("Impact", Font.PLAIN, 20);

	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//eye graphic
	c.setColor (Color.white);
	c.fillOval (225, 350, 200, 125);
	//eye details
	c.setColor (textbox);
	c.fillOval (275, 350, 100, 100);

	c.setColor (Color.black);
	c.fillOval (300, 375, 50, 50);

	c.setColor (Color.white);
	c.fillRoundRect (325, 370, 20, 20, 5, 5);

	//text/info box
	c.setColor (textbox);
	c.fillRect (50, 20, 540, 300);
	c.setColor (Color.white);
	c.fillRect (60, 30, 520, 280);

	c.setColor (Color.black);
	c.setFont (infoText);
	//first sentence(intro to field)
	c.drawString ("The field of Optometry focuses on examinig and diagnosing", 70, 50);
	c.drawString ("patients with eye related issues.", 70, 75);

	//second sentence(associated dieases)
	c.drawString ("Some diseases associated with this field are Cataracts, ", 70, 110);
	c.drawString ("which is a cloudy area in the lens of your eye, Glaucoma, ", 70, 135);
	c.drawString ("a disease which damages a nerve in the back of your eye", 70, 160);
	c.drawString ("called the optic nerve and Myopia, which is where", 70, 185);
	c.drawString ("near objects appear clear, but objects farther away look blurry", 70, 210);

	//third paragraph(what to look for when making a diagnosis)
	c.drawString ("To help patient rid of their diseases doctors will", 70, 245);
	c.drawString ("preform eye surgey, give the patient eyeglasses and", 70, 270);
	c.drawString ("give Prescription to lower pressure in eye", 70, 295);


	//to continue
	c.drawString ("Press Enter to Continue", 230, 480);





	// Place your program here.  'c' is the output console
    } // main method
} // OptemetryGraphic class
