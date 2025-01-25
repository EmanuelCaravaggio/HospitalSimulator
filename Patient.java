public class Patient
{

    //patient feilds
    public String name;
    //connects to the illnesses stored in the illness class
    public Illness patientIllness;
    public int patientID;
    public int age;

    //for the patient link list
    public Patient nextPatient;

    //patient constructor
    public Patient (String name, Illness patientIllness, int patientID, int age)
    {
	this.name = name;
	this.patientIllness = patientIllness;
	this.patientID = patientID;
	this.age = age;
	nextPatient = null;

    }


    // link list getter
    public Patient getNext ()
    {
	return nextPatient;
    }


    //link list setter
    public void setNext (Patient nextPatient)
    {
	this.nextPatient = nextPatient;
    }


    //name getter
    public String getName ()
    {

	return name;

    }


    //name setter
    public void setName (String newName)
    {

	name = newName;

    }


    //illness getter
    public Illness getIllness ()
    {

	return patientIllness;

    }


    //illness setter
    public void setIllness (Illness newIllness)
    {

	patientIllness = newIllness;

    }


    //ID getter
    public int getPatientID ()
    {

	return patientID;

    }


    //ID setter
    public void setPatientID (int newID)
    {

	patientID = newID;

    }


    //age getter
    public int getAge ()
    {

	return patientID;

    }


    //age setter
    public void setAge (int newAge)
    {

	age = newAge;

    }


    public String toString ()
    {

	return ("the patients name is " + name + ", they have" + patientIllness + ", they are " + age + " years old and their ID number is " + patientID);

    }









}


