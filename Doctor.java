public class Doctor
{

    //doctor fields
    public String name;
    public int field; //number value corresponds to field
    //#0 optometry
    //#1 physiotherapy
    //#2 neruology
    //#3 dermatology
    //#4 cardiology
    public int moneyEarned;




    //doctor constructor
    public Doctor (String name, int field, int moneyEarned)
    {

	this.name = name;
	this.field = field;
	this.moneyEarned = moneyEarned;

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


    //field getter
    public int getField ()
    {

	return field;

    }


    //field setter
    public void setField (int newField)
    {

	field = newField;

    }


    //money getter
    public int getMoneyEarned ()
    {

	return moneyEarned;

    }


    //money setter
    public void setMoneyEarned (int newMoneyEarned)
    {

	moneyEarned = newMoneyEarned;

    }


    //money increase
    public void increaseMoney (int patientBill)
    {

	moneyEarned += patientBill;

    }


}
