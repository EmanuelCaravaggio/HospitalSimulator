// The "CardiologyGraphic" class.
import java.awt.*;
import hsa.Console;

public class CardiologyGraphic
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

       

	c.setColor (Color.black);
	c.setFont (infoText);
	//first sentence(intro to field)
	c.drawString ("The ENT branch of medicine deals with the surgical", 70, 50);
	c.drawString ("and medical management of conditions of the head and neck.", 70, 75);

	//
	c.drawString ("Diseases associated with this field are Coronary heart disease,", 70, 110);
	c.drawString ("a buildup in the arteries that supply blood to the heart, High", 70, 135);
	c.drawString ("blood pressure, which occures when force of the blood pushing", 70, 160);
	c.drawString ("against the artery walls is high, and Heart attack, which occurs ", 70, 185);
	c.drawString ("when the blood flow to the heart is greatly reduced or blocked.", 70, 210);

	c.drawString ("Some cures within this field are Prescription antibiotics,", 70, 245);
	c.drawString ("Lifestyle changes; avoid acidic and fatty foods, and", 70, 270);
	c.drawString ("and Mental and physical rest.", 70, 295);

	//Prescription antibiotics", "2) Lifestyle changes; avoid acidic and fatty foods", "3)Hearing aids
	// Place your program here.  'c' is the output console
    } // main method
} // CardiologyGraphic class
