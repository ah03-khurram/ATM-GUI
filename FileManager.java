import java.io.*;
/**
 * Write a description of class FileManager here.
 *
 * @author (Khurram Ahmed)
 * @date (Due: 30 Nov, 2023)
 */
public class FileManager
{

    public static Bank read(String filename)
    {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) 
        {
            return  (Bank) in.readObject();
        } catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void write(String filename, Bank bank)
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            out.writeObject(bank);
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
