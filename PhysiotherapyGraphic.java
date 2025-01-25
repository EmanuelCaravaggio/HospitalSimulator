// The "PhysiotherapyGraphic" class.
import java.awt.*;
import hsa.Console;

public class PhysiotherapyGraphic
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	//colors for graphics
	Color background = new Color (216, 224, 227); //this is a repeat color
	Color textbox = new Color (84, 72, 52); //repeat

	//fonts
	Font infoText = new Font ("Impact", Font.PLAIN, 20);

	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//text/info box
	c.setColor (textbox);
	c.fillRect (50, 20, 540, 300);
	c.setColor (Color.white);
	c.fillRect (60, 30, 520, 280);

	//bone grpahic
	c.setColor (Color.white);
	c.fillRoundRect (180, 400, 250, 50, 20, 20);

	c.fillOval (160, 380, 50, 50);
	c.fillOval (160, 420, 50, 50);

	c.fillOval (420, 380, 50, 50);
	c.fillOval (420, 420, 50, 50);


	c.setColor (Color.black);
	c.setFont (infoText);

	//first sentence(intro to field)
	c.drawString ("The field of Physiotherapy addresses the illnesses that limit", 70, 50);
	c.drawString ("a person's abilities to move and perform functional activities.", 70, 75);

	//second sentence(associated dieases)
	c.drawString ("Some diseases associated with this field are Arthritis, which ", 70, 110);
	c.drawString ("is the inflammation or swelling of one or more joints, Soft", 70, 135);
	c.drawString ("tissue injuries, which occures when trauma or overuse occurs", 70, 160);
	c.drawString ("to muscles, tendons or ligaments, and Concussions, a type of", 70, 185);
	c.drawString ("traumatic brain injury caused by a blow, or jolt to the head.", 70, 210);

	//third paragraph(what to look for when making a diagnosis)
	c.drawString ("Some common cures within this field are", 70, 245);
	c.drawString ("Rest, ice, compression and elevation, Anti-inflammatory drugs", 70, 270);
	c.drawString ("and Mental and physical rest.", 70, 295);

	//to continue
	c.drawString ("Press Enter to Continue", 225, 480);
	// Place your program here.  'c' is the output console
    } // main method
} // PhysiotherapyGraphic class
