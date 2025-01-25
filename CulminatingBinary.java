// The "CulminatingBinary" class.
import java.io.*;
public class CulminatingBinary
{
    public static void main (String[] args) throws IOException
    {
	RandomAccessFile raf = new RandomAccessFile ("patientCreator.bin", "rw");

	BufferedReader fr = new BufferedReader (new FileReader ("patientCreator.txt"));

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


	Doctor doctor = new Doctor ("", 4, 0);
	Illness illness = new Illness ("", "", "", 0);

	int num = (int) (Math.random () * 3);
	//seeks location of condition by field and randomly pciks one of the three from binary file
	raf.seek (150 + doctor.getField () * 285 + 95 * num);
	byte[] conBytes = new byte [25];
	raf.read (conBytes);
	String condition = new String (conBytes, 0);
	illness.setCondition (condition);
	byte[] symptom1Bytes = new byte [35];
	raf.read (symptom1Bytes);
	String symptom1 = new String (symptom1Bytes, 0);
	illness.setSymptom1 (symptom1);
	byte[] symptom2Bytes = new byte [35];
	raf.read (symptom2Bytes);
	String symptom2 = new String (symptom2Bytes, 0);
	illness.setSymptom2 (symptom2);
	illness.setCure (num + 1);

	System.out.println (illness.getCondition ());
	System.out.println (illness.getSymptom1 ());
	System.out.println (illness.getSymptom2 ());
	System.out.println (illness.getCure ());

	Patient patient = new Patient ("", illness, 0, 0);
	raf.seek (10 * ((int) (Math.random () * 15)));
	byte[] nameBytes = new byte [10];
	raf.read (nameBytes);
	String name = new String (nameBytes, 0);
	patient.setName (name);

	System.out.println (patient.getName ());
    } // main method
} // CulminatingBinary class
