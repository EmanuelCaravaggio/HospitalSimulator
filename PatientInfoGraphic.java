// The "PatientInfoGraphic" class.
import java.awt.*;
import hsa.Console;
import java.io.*;


public class PatientInfoGraphic
{
    static Console c;           // The output console
    public static Image Pic;    //to implement pictures

    public static void main (String[] args) throws IOException
    {
	c = new Console ();
	//colours for graphics
	Color background = new Color (216, 224, 227);
	Color clipboard = new Color (145, 125, 105);

	//fonts for graphics
	Font patientInfo = new Font ("Impact", Font.PLAIN, 25);
	Font patientInfo2 = new Font ("Impact", Font.PLAIN, 20);



	//background
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//clipboard
	c.setColor (clipboard);
	c.fillRect (105, 75, 420, 450);

	//paper (part of clipboard)
	c.setColor (Color.white);
	c.fillRect (115, 80, 400, 450);

	//metal clip(part of clipboard)
	c.setColor (Color.gray);
	c.fillOval (285, 5, 75, 75);
	c.fillArc (262, 45, 120, 75, 0, 180);

	//generates random number to randomize pitures
	int ranNum = (int) (Math.random () * (4 + 1));


	//patient pictures
	if (ranNum == 0)
	{
	    new Picture2 ("headshot1.jpg", c, Pic, 120, 90);
	}
	if (ranNum == 1)
	{
	    new Picture2 ("headshot2.jpg", c, Pic, 120, 90);
	}
	if (ranNum == 2)
	{
	    new Picture2 ("headshot3.jpg", c, Pic, 120, 90);
	}
	if (ranNum == 3)
	{
	    new Picture2 ("headshot4.jpg", c, Pic, 120, 90);
	}
	if (ranNum == 4)
	{
	    new Picture2 ("headshot5.jpg", c, Pic, 120, 90);
	}

	//patient information
	c.setColor (Color.black);

	//name
	c.setFont (patientInfo);
	c.drawString ("Name: ", 310, 140);
	c.setFont (patientInfo2);
	c.drawString (patient1.getName (), 390, 140);

	//age
	c.setFont (patientInfo);
	c.drawString ("Age: ", 310, 180);
	c.setFont (patientInfo2);
	c.drawString (patient1.getAge (), 370, 180);

	//patient ID
	c.setFont (patientInfo);
	c.drawString ("ID Number: ", 310, 220);

	int ID = (int) (Math.random () * (999 + 1)); //random ID numeber
	patient1.setPatientID (ID); //random ID numeber

	c.setFont (patientInfo2);
	c.drawString (patient1.getPatientID (), 440, 220);

	//Symptoms
	c.setFont (patientInfo);
	c.drawString ("Symptom(s)", 120, 300);

	c.setFont (patientInfo2);
	//symptom 1
	c.drawString ("-", 125, 340);
	c.drawString (patient1.getSymptom1, 150, 340);

	//symptom 2
	c.drawString ("-", 125, 380);
	c.drawString (patient1.getSymptom2, 150, 380);



	// Place your program here.  'c' is the output console
    } // main method
} // PatientInfoGraphic class
