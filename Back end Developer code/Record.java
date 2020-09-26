// --== CS400 File Header Information ==--
// Name: Neil Bhutada
// Email: nbhutada@wisc.edu
// Team: MG
// TA: Mr. Harit
// Lecturer: Dr. Florian Heimeirl
// Notes to Grader: My Program worked perfectly fine on Eclipse

public class Record <KeyType, ValueType> //This class will contain info about the records to be stored in the Hash Table.
{                                 
  	public KeyType key;  // Contain key of the record 
  	public ValueType value; // Contain value of the record
  	Record(KeyType K , ValueType V)
  	{
  		this.key = K; 
  		this.value = V; 
  		
  	}


}
