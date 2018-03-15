
/**
 * Write a description of class SeismicRecords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeismicRecords
{
   private SeismicYear maxQuake; //SeismicYear object with the biggest earthquake
   private SeismicYear minQuake; //SeismicYear object with the smallest earthquake
   private SeismicYear mostQuakes; //SeismicYear object with the most earthquakes
   private SeismicYear leastQuakes; //SeismicYear object with the least earthquakes
   private float total; //The total seismic activity over all the years entered into the system
   private int totalQuakes; //Count of earthquakes that happened over all the years entered
   private int yearCount; //How many different years earthquakes were entered into the system
   private String locale; //The location these seismic records are for
   
   public SeismicRecords(String locale)
   {
       this.locale = locale;
       total = 0.0f;
       totalQuakes = 0;
       yearCount = 0;
       maxQuake = null;
       minQuake = null;
       mostQuakes = null;
       leastQuakes = null;
   }
   
   public SeismicYear getMaxQuake()
   {
       return maxQuake;
   }
   
   public void setMaxQuake(SeismicYear newMaxQuake)
   {
       maxQuake = newMaxQuake;
   }
   
   public SeismicYear getMinQuake()
   {
       return minQuake;
   }
   
   public void setMinQuake(SeismicYear newMinQuake)
   {
       minQuake = newMinQuake;
   }
   
   public SeismicYear getMostQuakes()
   {
       return mostQuakes;
   }
   
   public void setMostQuakes(SeismicYear newMostQuakes)
   {
       mostQuakes = newMostQuakes;
   }
   
   public SeismicYear getLeastQuakes()
   {
       return leastQuakes;
   }
   
   public void setLeastQuakes(SeismicYear newLeastQuakes)
   {
       leastQuakes = newLeastQuakes;
   }
   
   public float getTotal()
   {
       return total;
   }
   
   public void setTotal(float newTotal)
   {
       total = newTotal;
   }
   
   public float getTotalQuakes()
   {
       return totalQuakes;
   }
   
   public void setTotalQuakes(int newTotalQuakes)
   {
       total = newTotalQuakes;
   }
   
   public int getYearCount()
   {
       return yearCount;
   }
   
   public void setYearCount(int newYearCount)
   {
       yearCount = newYearCount;
   }
   
   public String getLocale()
   {
       return locale;
   }
   
   public void setLocale(String newLocale)
   {
       locale = newLocale;
   }
   
   public void read()
   {
       int yr;
       System.out.println("Enter a year; enter 0 to exit");
       yr = UserInput.readInt();
       
       while(yr != 0)
       {
           System.out.println("How many earthquakes happened that year?");
           int numQuakes = UserInput.readInt();
           
           SeismicYear newSYObject = new SeismicYear(yr, numQuakes);
           newSYObject.read();
           total += newSYObject.getTotal();
           totalQuakes += newSYObject.getCount();
           
           maxQuake = new SeismicYear();
           minQuake = new SeismicYear();
           mostQuakes = new SeismicYear();
           leastQuakes = new SeismicYear();
           leastQuakes.setCount(100);
           
           if(newSYObject.getMax() > maxQuake.getMax())
           {maxQuake = newSYObject;}
           if(newSYObject.getMin() < minQuake.getMin())
           {minQuake = newSYObject;}
           if(numQuakes > mostQuakes.getCount())
           {mostQuakes = newSYObject;}
           if(numQuakes < leastQuakes.getCount())
           {leastQuakes = newSYObject;}
           
           yearCount++;

           
           System.out.println("Enter a year");
           yr = UserInput.readInt();
       }
       
       System.out.println("Input complete");
   }
   
   public void report()
   {
       System.out.println("#####EARTHQUAKE REPORT FOR " + locale + "#####");
       System.out.println("Years recorded: " + yearCount);
       System.out.println("Total number of earthquakes: " + totalQuakes);
       System.out.println("Total seismic activity: " +  total);
       System.out.println("The biggest earthquake was " + maxQuake.getMax()
                            + " in " + maxQuake.getYear());
       System.out.println("The smallest earthquake was " + minQuake.getMin()
                            + " in " + minQuake.getYear());
       System.out.println("The year with the most earthquakes was " + mostQuakes.getYear() +
                            " with " + mostQuakes.getCount());
       System.out.println("The year with the least earthquakes was " + leastQuakes.getYear() +
                            " with " + leastQuakes.getCount());
       System.out.println("\n");                     
       maxQuake.report();
       System.out.println("\n");
       mostQuakes.report();
   }
   
   public void displayMenu()
   {
       System.out.println("===Earthquake Monitor Menu===");
       System.out.println("1: Enter earthquake data");
       System.out.println("2: View summary report");
       System.out.println("3: View report of year with the biggest earthquake");
       System.out.println("4: View report of year with the smallest earthquake");
       System.out.println("5: View report of year with the most earthquakes");
       System.out.println("6: View report of year with the least earthquakes");
       System.out.println("7: Exit");
   }
   
   public void menu()
   {
      int menuChoice;
       do
       {
           displayMenu();
           menuChoice = UserInput.readInt();
           if(menuChoice == 1)
           {read();}
           else if(menuChoice == 2)
           {report();}
           else if(menuChoice == 3)
           {maxQuake.report();}
           else if (menuChoice == 4)
           {minQuake.report();}
           else if (menuChoice == 5)
           {mostQuakes.report();}
           else if (menuChoice == 6)
           {leastQuakes.report();}
       }
      while(menuChoice != 7);
      
      System.out.println("**Program has exited**");
       
   }
   
}
