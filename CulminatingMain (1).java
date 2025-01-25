// The "CulminatingMain" class.
import java.awt.*;
import java.io.*;
import hsa.Console;

public class CulminatingMain
{
    static Console c;           // The output console
    public static Image Pic;    //to implement pictures

    public static void main (String[] args) throws IOException
    {
	c = new Console ();

	//creates the link list to store the patient
	PatientLinkList pll = new PatientLinkList ();
	// creates an instance to track which illnesses have been viewed
	TrackNum track = new TrackNum ();

	//Graphics of hospital
	introGraphics ();

	//entering name of user with graphic 
	enterNameGraphic();
	String name = "Dr. ";
	c.setCursor(15,2);
	name += c.readLine ();
	c.clear();

	//intro
	intro (name);

	//writes the binary file needed for patient
	writeBin ();

	//user enters field
	enterFieldGraphic();
	int field = enterField ();
	c.clear ();

	//initializes doctor
	Doctor user = new Doctor (name, field, 0);
	doctorIDGraphic (user, track);
	c.getChar ();
	c.clear ();

	boolean cont = true;

	while (cont == true)
	{
	    //creates a patient for the user
	    Patient patient1 = newPatient (user, track);
	    if (track.getCount () <= 3)
		pll.addNode (patient1);

	    patientInfo (patient1);
	    findCure (patient1, user);
	    c.getChar ();
	    c.clear ();

	    // checks if player would like to explore a different field
	    if (track.getCount () == 3)
	    {
		c.clear ();
		c.println ("You have cured all the diseases in this field, you can explore a different field or finish your medical journey");
		cont = continuePlay ();
		c.clear ();
		if (cont == true)
		{
		    track.setCount (0);
		    user.setField (enterField ());
		    c.clear ();
		}
		else if (cont == false)
		{
		    c.clear ();
		    break;
		}
	    }
	}

	//end of the simulation where user can print linked list or search for patient by name
	int endAction = endAction ();
	if (endAction == 1)
	{
	    searchPatient (pll); // search for patient by name
	}
	else
	{
	    pll.showList (); //prints linked list
	}

	// Place your program here.  'c' is the output console
    } // main method

    //first graphic screen with hospital
    public static void introGraphics ()
    {
	//fonts for graphics
	Font title = new Font ("Impact", Font.PLAIN, 50);
	Font title2 = new Font ("Impact", Font.ITALIC, 25);

	//colour for graphics
	Color skyBlue = new Color (165, 216, 232);
	Color building = new Color (130, 118, 101);
	Color signRed = new Color (171, 46, 46);
	Color window = new Color (186, 209, 207);
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
	c.drawString ("Welcome to", 200, 75);
	c.drawString ("the Hospital Simulator", 95, 125);
	c.setFont (title2);
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
	c.getChar ();
	c.clear ();
    }
    
    public static void enterNameGraphic ()
    {
	//background color and set background
	Color background = new Color (85, 140, 203);
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//Where user will be prompted to enter name
	c.setColor (Color.white);
	c.fillRoundRect (0, 250, 640, 70, 10, 10);

	//font
	Font nameFont = new Font ("Impact", Font.PLAIN, 70);
	c.setFont (nameFont);
	c.drawString ("Enter your last name", 30, 150);
    }
    
    //intro screen about instructions
    public static void intro(String name)
    {
	//background
	Color background = new Color(206,39,56);
	c.setColor(background);
	c.fillRect(0,0,640,500);
	
	//font
	Font instructions = new Font ("Arial", Font.BOLD, 25);
	c.setFont (instructions);
	c.setColor(Color.white);
	
	//instructions
	c.drawString("Welcome to the Hospital Simulator "+ name+"!", 35,70);
	c.drawString("How to Play:", 30, 125);
	c.drawString("Here at the hospital you are tasked with diagnosing", 30, 155);
	c.drawString ("and assigning a cure to patients you encounter.", 30, 185);
	c.drawString("These patients will have conditions determined by", 30, 215);
	c.drawString("the field of medicine you want to explore.", 30, 245);
	c.drawString("By assigning the correct cures to patients you will", 30, 275);
	c.drawString("earn money, that will accumulate as you continue", 30, 305); 
	c.drawString("playing.", 30, 335);
	
	//font
	Font nameFont = new Font ("Impact", Font.PLAIN, 50);
	c.setFont(nameFont);
	
	c.drawString("Press any key to continue",50, 430);
	c.getChar();
	c.clear();
    }
    
    //graphic with the fields for user to select from
    public static void enterFieldGraphic()
    {
	//background
	Color background = new Color (85, 140, 203);
	c.setColor (background);
	c.fillRect (0, 0, 640, 350);
	
	//font
	Font nameFont = new Font ("Impact", Font.PLAIN, 30);
	c.setFont(nameFont);
	
	c.setColor(Color.white);
	//text 
	c.drawString("Enter a field you would like to explore", 90, 80); 
	c.drawString("with its corresponding number:",125, 110);
	//printing the fields
	Font font = new Font ("Impact", Font.PLAIN, 40);
	c.setFont(font);
	c.drawString("1)       Optometry", 30, 160);
	c.drawString("2)       Physiotherapy", 30, 200);
	c.drawString("3)       Neurology", 30,240);
	c.drawString("4)       Dermatology", 30,280);
	c.drawString("5)       Otolaryngology", 30, 320);
	Font font1 = new Font ("Impact", Font.PLAIN, 20);//change font to make it smaller
	c.setFont(font1);
	//description of fields
	c.drawString("(Eyes)", 300, 160);
	c.drawString("(Restoring movement)", 360, 200);
	c.drawString("(Brain, spinal cord + nerves)", 300, 240);
	c.drawString("(Hair, skin + nails)", 340, 280);
	c.drawString("(Ear, nose and throat)", 370,320);;
    }
    
    //method to allow user to choose medical field
    public static int enterField ()
    {
	int field;
	int count = 0;
	do
	{
	    c.setCursor (18, 1);
	    if (count >= 2)
	    {
		c.setTextColor (Color.red);
		c.println ("Enter the field that you would like to explore with its corresponding number:");
		c.setTextColor (Color.black);
	    }
	    else
	    {
		c.println ("Enter the field that you would like to explore with its corresponding number:");
	    }
	    field = c.readInt ();
	    count++;
	}
	while ((field > 5) || (field <= 0));
	return field - 1; //subtract one because to search for first field in binary file
    }


    public static void doctorIDGraphic (Doctor user, TrackNum track)
    {
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
	c.drawString (user.getName (), 300, 130);
	String fieldPrint = "";
	//field of study
	if (user.getField () == 0)
	{
	    fieldPrint = "Optometry";
	}
	if (user.getField () == 1)
	{
	    fieldPrint = "Physiotherapy";
	}
	if (user.getField () == 2)
	{
	    fieldPrint = "Neruology";
	}
	if (user.getField () == 3)
	{
	    fieldPrint = "Dermatology";
	}
	if (user.getField () == 4)
	{
	    fieldPrint = "Otolarynology";
	}

	c.drawString ("Doctor of ", 300, 180);
	c.drawString (fieldPrint, 300, 215);

	//patients cured
	c.drawString ("Cured" + track.getCured () + "patients", 320, 260);



	//money earned
	c.drawString ("Earned $" + user.getMoneyEarned (), 320, 310);


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
    }


    public static void writeBin () throws IOException
    {
	//creates binary and file readers
	RandomAccessFile raf = new RandomAccessFile ("patientCreator.bin", "rw");
	BufferedReader fr = new BufferedReader (new FileReader ("PatientCreator.txt"));

	for (int i = 0 ; i < 15 ; i++) //writing the patient names from the text file into the binary file
	{
	    byte[] nameBytes = new byte [10];
	    String name = fr.readLine ();
	    name.getBytes (0, name.length (), nameBytes, 0);
	    raf.seek (i * 10);
	    raf.write (nameBytes);
	}

	for (int j = 0 ; j < 5 ; j++)
	{
	    for (int i = 0 ; i < 3 ; i++)
	    {
		raf.seek ((i * 95) + 150 + (285 * j)); //seeks the right place to write the first field of conditions

		//writes condition into binary file
		byte[] conditionBytes = new byte [25];
		String condition = fr.readLine ();
		condition.getBytes (0, condition.length (), conditionBytes, 0);
		raf.write (conditionBytes);

		//writes first symptom into binary file
		byte[] symptom1Bytes = new byte [35];
		String symptom1 = fr.readLine ();
		symptom1.getBytes (0, symptom1.length (), symptom1Bytes, 0);
		raf.write (symptom1Bytes);

		//writes second symptom into binary file
		byte[] symptom2Bytes = new byte [35];
		String symptom2 = fr.readLine ();
		symptom2.getBytes (0, symptom2.length (), symptom2Bytes, 0);
		raf.write (symptom2Bytes);
	    }
	}
    }


    public static Patient newPatient (Doctor doctor, TrackNum track) throws IOException
    {
	//creates binary reader
	RandomAccessFile raf = new RandomAccessFile ("patientCreator.bin", "rw");

	Illness illness = new Illness ("", "", "", 0);
	int num;
	if (track.getCount () < 3)
	    num = track.track ();
	else
	    num = (int) (Math.random () * 3);

	//seeks location of condition by field and randomly picks one of the three from binary file
	raf.seek (150 + doctor.getField () * 285 + 95 * num);
	//reads the patient data from the binary file
	byte[] conBytes = new byte [25];
	raf.read (conBytes);
	String condition = new String (conBytes, 0);
	illness.setCondition (condition.trim ());
	byte[] symptom1Bytes = new byte [35];
	raf.read (symptom1Bytes);
	String symptom1 = new String (symptom1Bytes, 0);
	illness.setSymptom1 (symptom1.trim ());
	byte[] symptom2Bytes = new byte [35];
	raf.read (symptom2Bytes);
	String symptom2 = new String (symptom2Bytes, 0);
	illness.setSymptom2 (symptom2.trim ());
	/*sets the cure variable equal to the location of the condition in the
	field, i.e. second optometry condition has a cure variable of 2*/
	illness.setCure (num + 1);

	//cteates patient identification number
	int ID = (int) (Math.random () * (899) + 100); //random ID number

	//cteates patient age
	int age = (int) (Math.random () * (39) + 10);

	//creates the instance of the patient class that will be sent back to main
	Patient patient = new Patient ("", illness, "" + ID, "" + age, (int) (Math.random () * (1 + 1)));
	int ran;
	if (patient.getGender () == 1)
	{
	    do
	    {
		ran = (int) (Math.random () * 15);
	    }
	    while (ran % 2 == 0);
	}
	else
	{
	    do
	    {
		ran = (int) (Math.random () * 15);
	    }
	    while (ran % 2 == 1);
	}
	raf.seek (10 * ran);
	byte[] nameBytes = new byte [10];
	raf.read (nameBytes);
	String name = new String (nameBytes, 0);
	patient.setName (name.trim ());

	return patient;
    }


    //screen for when user is given patient data
    public static void patientInfo (Patient patient1) throws IOException
    {
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


	//patient pictures
	if (patient1.getGender () == 1)
	{
	    //generates random number to randomize pitures
	    int ranNum = (int) (Math.random () * (2 + 1));
	    if (ranNum == 0)
	    {
		new Picture2 ("headshot1.jpg", c, Pic, 120, 90);
	    }
	    if (ranNum == 1)
	    {
		new Picture2 ("headshot4.jpg", c, Pic, 120, 90);
	    }
	    if (ranNum == 2)
	    {
		new Picture2 ("headshot5.jpg", c, Pic, 120, 90);
	    }
	}
	else
	{
	    int ranNum = (int) (Math.random () * (1 + 1));
	    if (ranNum == 0)
	    {
		new Picture2 ("headshot2.jpg", c, Pic, 120, 90);
	    }
	    if (ranNum == 1)
	    {
		new Picture2 ("headshot3.jpg", c, Pic, 120, 90);
	    }
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

	c.setFont (patientInfo2);
	c.drawString (patient1.getPatientID (), 440, 220);

	//Symptoms
	c.setFont (patientInfo);
	c.drawString ("Symptoms", 120, 280);

	c.setFont (patientInfo2);
	//symptom 1
	c.drawString ("-", 125, 300);
	c.drawString ((patient1.getIllness ()).getSymptom1 (), 150, 300);

	//symptom 2
	c.drawString ("-", 125, 320);
	c.drawString ((patient1.getIllness ()).getSymptom2 (), 150, 320);

	c.drawString ("Condition:", 125, 380);
	c.drawString (patient1.getIllness ().getCondition (), 210, 380);

    }


    // on patient info screen where they must select correct cure to proceed to next patient
    public static void findCure (Patient patient1, Doctor user)
    {
	//arrays to store the cure to print to user
	String[] opt_cure = {"1) Eye surgery", "2) Prescription to lower pressure in eye", "3) Eyeglasses"};
	String[] phys_cure = {"1) Rest, ice, compression, elevation", "2) Anti-inflammatory drugs", "3) Mental and physical rest"};
	String[] neur_cure = {"1) Removal surgery", "2) Physical, occupational/ speech therapy", "3)Anti-eliptic drugs and a ketogenic diet"};
	String[] derm_cure = {"1) Surgical excision", "2) Topical steroid creams or oinments", "3)Antifungal drugs (oral/topical)"};
	String[] ent_cure = {"1)Prescription antibiotics", "2) Lifestyle changes; avoid acidic and fatty foods", "3)Hearing aids"};

	//prints possible cures to user based on their medical field
	c.drawString ("Possible cures:", 125, 400);
	int j = 420;
	if (user.getField () == 0)
	{
	    for (int i = 0 ; i < 3 ; i++)
	    {
		c.drawString (opt_cure [i], 125, j);
		j += 20;
	    }
	}
	else if (user.getField () == 1)
	{
	    for (int i = 0 ; i < 3 ; i++)
	    {
		c.drawString (phys_cure [i], 125, j);
		j += 20;
	    }
	}
	else if (user.getField () == 2)
	{
	    for (int i = 0 ; i < 3 ; i++)
	    {
		c.drawString (neur_cure [i], 125, j);
		j += 20;
	    }
	}
	else if (user.getField () == 3)
	{
	    for (int i = 0 ; i < 3 ; i++)
	    {
		c.drawString (derm_cure [i], 125, j);
		j += 20;
	    }
	}
	else if (user.getField () == 4)
	{
	    for (int i = 0 ; i < 3 ; i++)
	    {
		c.drawString (ent_cure [i], 125, j);
		j += 20;
	    }
	}
	//graphics to prompt user to enter the correct cure number
	Color signRed = new Color (171, 46, 46);
	c.setColor (signRed);
	c.fillRect (380, 240, 250, 120);
	c.setColor (Color.black);
	c.drawRect (380, 240, 250, 120);
	c.drawString ("Enter the correct cure with", 330, 260);
	c.drawString ("its corresponding number", 330, 280);
	int user_cure;
	do
	{
	    user_cure = c.readInt ();
	}
	while (user_cure != patient1.getIllness ().getCure ());//user can only enter correct num that matches the cure before proceeding to next patient
	user.increaseMoney(100);//each patient cured, user's money will increase by $100
	
    }


    //when user has finished exploring the 3 patients in the field
    public static boolean continuePlay ()
    {
	boolean continuePlay;
	char enter;
	do
	{
	    c.println ("Would you like to continue exploring different medical fields \n Y or N");
	    enter = c.getChar ();
	}
	while ((enter != 'Y') && (enter != 'y') && (enter != 'n') && (enter != 'N')); //error checking
	if ((enter == 'Y') || (enter == 'y'))
	    continuePlay = true; //this will all
	else
	    continuePlay = false;
	return continuePlay;
    }


    //when user has finished in medical fields
    public static int endAction ()
    {
	int endActivity;
	do
	{
	    c.println ("Would you like to search for a patient(1) or print all patients cured(2)?");
	    endActivity = c.readInt ();
	}
	while ((endActivity != 1) && (endActivity != 2)); //error checking
	return endActivity;
    }


    //method to continously search patient data based on users choice
    public static void searchPatient (PatientLinkList pll)
    {
	while (true)
	{
	    c.println ("Enter a patient name you would like to recieve their patient data:");
	    String name = c.readString ();
	    pll.getNode (name); //searches through linked list and prints patient data if found

	    char continueSearch;
	    //user is able to continue searching for patients 
	    do
	    {
		c.println ("Would you like to continue searching for another patient? Y/N");
		continueSearch = c.getChar ();

	    }
	    while ((continueSearch != 'Y') && (continueSearch != 'y') && (continueSearch != 'n') && (continueSearch != 'N'));

	    if ((continueSearch == 'N') || (continueSearch == 'n'))
	    {
		break; //changes the loop to false when the user does not want to search for anymore patients data
	    }
	}

    }



} // CulminatingMain class
