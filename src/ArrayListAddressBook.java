
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * An implementation of the AddressBook interface that uses an array list to
 * store the data.
 */
public class ArrayListAddressBook implements AddressBook
{

   private ArrayList<Item> items = new ArrayList<Item>();
   private String source;
   private boolean modified;

   public void load(String sourceName)
   {
      source = sourceName;
      try
      {
         Scanner in = new Scanner(new File(source));
         items = new ArrayList<Item>();
         while (in.hasNextLine())
         {
            items.add(new Item(in.nextLine(), in.nextLine(), in.nextLine()));
         }
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
         source = null;
         items = new ArrayList<Item>();
      }
   }

   public String get(String name, String key)
   {
      for (Item it : items)
      {
         if (name.equals(it.getName()) && key.equals(it.getKey()))
         {
            return it.getValue();
         }
      }
      return null;
   }

   public String put(String name, String key, String value)
   {
      modified = true;
      for (Item it : items)
      {
         if (name.equals(it.getName()) && key.equals(it.getKey()))
         {
            String oldValue = it.getValue();
            it.setValue(value);
            return oldValue;
         }
      }
      items.add(new Item(name, key, value));
      return null;
   }

   public void save()
   {
      if (!modified)
      {
         return;
      }
      try
      {
         PrintWriter out = new PrintWriter(source);
         for (Item it : items)
         {
            out.println(it.getName());
            out.println(it.getKey());
            out.println(it.getValue());
         }
         out.close();
         modified = false;
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public String remove(String name, String key) throws NoSuchElementException
   {
	   ArrayList<Item> result = new ArrayList<Item>();
	   result.addAll(items);
	   String removed = "";
	   Item last = result.get(result.size()-1);
	   
	   for(int i=0;i<result.size();i++)
	   {
		   if(result.get(i).getName().equals(name)&&result.get(i).getKey().equals(key)){
			   result.remove(result.get(i));
			   removed = result.get(i).getValue();
			   
			   //i--;
			   result.set(i,last);
		   }
		   else{
				 // throw new NoSuchElementException();
			  }
		  
		   
	   }
		  return removed;
		  
	   
   }  
}
