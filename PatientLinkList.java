public class PatientLinkList
{

    protected Patient top;

    //link list constructor
    public PatientLinkList ()
    {

	top = null;

    }


    //method to add node
    public void addNode (Patient t)
    {

	//if list is empty
	if (top == null)
	{
	    top = t;
	}

	//if list has other node already
	else
	{
	    Patient current = null;
	    current = top;
	    while (current.getNext () != null)
	    {
		current = current.getNext ();
	    }
	    current.setNext (t);

	}

    }


    //method to display full link list
    public void showList ()
    {

	//if list is empty
	if (top == null)
	{
	    System.out.println ("The List is Empty");

	}

	//if list is filled, prints each node until the end is reached
	else
	{

	    Patient current;
	    current = top;

	    while (current.getNext () != null) //checks if list is at the end
	    {
		System.out.println (current.getName () + " " + current.getIllness () + " " + current.getAge () + " " + current.getPatientID ());
		current = current.getNext ();
	    }
	    //prints out last node
	    System.out.println (current.getName () + " " + current.getIllness () + " " + current.getAge () + " " + current.getPatientID ());
	    System.out.println ("%%%%%%%");
	}


    }


    //method to get one node from the list
    public void getNode (String name)
    {

	Patient current;
	current = top;


	while (current.getNext () != null) //checks if list is at the end
	{
	    if (current.getName ().equals (name))
	    {

		System.out.println (current.getName () + " " + current.getIllness () + " " + current.getAge () + " " + current.getPatientID ());
		break;
	    }
	    current = current.getNext ();

	}
	//for first node searching
	if (current.getNext () == null && current.getName ().equals (name))
	{
	    System.out.println (current.getName () + " " + current.getIllness () + " " + current.getAge () + " " + current.getPatientID ());

	}
	//for last node searching
	else if (current.getNext () == null)
	{
	    System.out.println ("name not found");
	}

    }


    //method to delete node
    public void deleteNode (String name)
    {

	Patient current = null;
	current = top;

	//if node being deleted is at the top
	if (top.getName ().equals (name))
	{
	    top = current.getNext ();
	}
	//if node being deleted is anywhere but the top
	else
	{
	    while (current.getNext () != null)
	    {
		if (current.getNext ().getName ().equals (name))
		{
		    current.setNext (current.getNext ().getNext ());
		    break;

		}
		current = current.getNext ();

	    }

	}





    }







}
