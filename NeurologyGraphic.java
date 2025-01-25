// The "NeurologyGraphic" class.
import java.awt.*;
import hsa.Console;

public class NeurologyGraphic
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	//Removal surgery", "2) Physical, occupational/ speech therapy", "3)Anti-eliptic drugs and a ketogenic diet

	//colors for graphics
	Color background = new Color (216, 224, 227); //this is a repeat color
	Color textbox = new Color (84, 72, 52); //repeat
	Color neuro = new Color (196, 149, 184);

	//fonts
	Font infoText = new Font ("Impact", Font.PLAIN, 20);

	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//text/info box
	c.setColor (textbox);
	c.fillRect (50, 20, 540, 300);
	c.setColor (Color.white);
	c.fillRect (60, 30, 520, 280);

	//brain graphic
	c.setColor (neuro);
	c.fillOval (250, 335, 130, 150);

	//brain details
	c.fillOval (265, 340, 30, 30);
	c.fillOval (245, 370, 60, 60);
	c.fillOval (250, 420, 50, 50);

	c.fillOval (330, 340, 40, 40);
	c.fillOval (325, 370, 60, 60);
	c.fillOval (330, 420, 45, 45);

	c.setColor (Color.black);
	c.drawLine (315, 335, 315, 485);

	//line details on left side of brain
	c.drawArc (250, 390, 30, 30, 90, 90);
	c.drawArc (255, 410, 30, 50, 270, 180);
	c.drawArc (270, 355, 30, 20, 0, 180);
	c.drawArc (280, 350, 30, 50, 200, 90);
	c.drawArc (270, 430, 30, 40, 270, 120);
	c.drawArc (260, 410, 30, 30, 180, 90);

	//line details on the right side of brain
	c.drawArc (330, 370, 30, 30, 90, 90);
	c.drawArc (325, 410, 30, 50, 270, 120);
	c.drawArc (325, 355, 30, 20, 0, 90);
	c.drawArc (355, 350, 30, 50, 200, 90);
	c.drawArc (325, 440, 20, 30, 90, 180);
	c.drawArc (335, 405, 40, 30, 90, 90);




	c.setColor (Color.black);
	c.setFont (infoText);
	//first sentence(intro to field)
	c.drawString ("The field of Neurology focuses the treatment of conditions and", 70, 50);
	c.drawString ("diseases involving the brain, the spinal cord and the nerves", 70, 75);

	//second sentence(associated dieases)
	c.drawString ("Diseases associated with this field are Brain tumours, which", 70, 110);
	c.drawString ("is a growth of abnormal cells in your brain, Cerebral palsy, a", 70, 135);
	c.drawString ("group of disorders that affect a person's ability to move and", 70, 160);
	c.drawString ("maintain balance and Epilepsy, which is when brain activity", 70, 185);
	c.drawString ("becomes abnormal, causing seizures and unusual behavior", 70, 210);

	//third paragraph(what to look for when making a diagnosis)
	c.drawString ("Some common cures within this field are removal surgery,", 70, 245);
	c.drawString ("physical, occupational/ speech therapy and,", 70, 270);
	c.drawString ("anti-eliptic drugs and a ketogenic diet.", 70, 295);

	//to continue
	c.drawString ("Press Enter to Continue", 225, 480);
	// Place your program here.  'c' is the output console
    } // main method
} // NeurologyGraphic class
