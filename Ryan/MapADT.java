// --== CS400 File Header Information ==--
// Name: Neil Bhutada
// Email: nbhutada@wisc.edu
// Team: MG
// TA: Mr. Harit
// Lecturer: Dr. Florian Heimeirl
// Notes to Grader: My Program worked perfectly fine on Eclipse

import java.util.NoSuchElementException;
public interface MapADT <KeyType, ValueType> {
	public boolean put(KeyType key, ValueType value);
	public ValueType get(KeyType key) throws NoSuchElementException;
	public int size();
	public boolean containsKey(KeyType key);
	public ValueType remove(KeyType key);
	public void clear();
}
