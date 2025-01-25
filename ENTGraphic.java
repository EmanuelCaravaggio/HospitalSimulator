// The "ENTGraphic" class.
import java.awt.*;
import hsa.Console;

public class ENTGraphic
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

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

	//ent graphic
	c.setColor(Color.black);
	c.drawLine(330,340,280,405);
	c.drawArc(280,390,40,40,110,180);
	c.drawArc(295,415,30,20,0,180);
	c.drawArc(305,395,40,30,270,150);



	c.setColor (Color.black);
	c.setFont (infoText);
	//first sentence(intro to field)
	c.drawString ("The ENT branch of medicine deals with the surgical", 70, 50);
	c.drawString ("and medical management of conditions of the head and neck.", 70, 75);

	//second sentence(associated dieases)
	c.drawString ("Diseases associated with this field are Ear infections,", 70, 110);
	c.drawString ("which is an infection of the middle ear, Gastric reflux", 70, 135);
	c.drawString (", which occurs when stomach acid flows back into the tube ", 70, 160);
	c.drawString ("connecting your mouth and stomach, and Hearing loss, which is ", 70, 185);
	c.drawString ("a loss of hearing that occurs gradually as you age.", 70, 210);

	//third paragraph(what to look for when making a diagnosis)
	c.drawString ("Some cures within this field are Prescription antibiotics,", 70, 245);
	c.drawString ("Lifestyle changes; avoid acidic and fatty foods, and", 70, 270);
	c.drawString ("Hearing aids.", 70, 295);

	//to continue
	c.drawString ("Press Enter to Continue", 225, 480);
	// Place your program here.  'c' is the output console
    } // main method
} // ENTGraphic class
