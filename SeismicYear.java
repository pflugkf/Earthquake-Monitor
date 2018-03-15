
/**
 * Write a description of class SeismicYear here.
 * 
 * @author Kristin Pflug 
 * @version 10/5/14
 */
public class SeismicYear
{
    private int count; //The number of earthquakes that occured in this seismic year
    private float maximum; //The worst earthquake magnitude to occur in one year
    private float minimum; //The mildest earthquake magnitude to occur in one year
    private float average; //The average magnitude of all the earthquakes to occur in a year
    private float total; //The sum of all the earthquake magnitudes entered for this seismic year
    private int year; //The year that the entered data occured in
    
    /**Default constructor*/
    public SeismicYear()
    {
        total = 0f;
        count = 0;
        average = 0f;
        maximum = 0.0f;
        minimum = 10.0f;
    }
    
    /**
     * Parameterized constructor #1
     * @param total Float that sets amount for total number of earthquakes
     * @param max Float that sets amount for strongest earthquake
     * @param min Float that sets amount for weakest earthquake
     * @param avg Float that sets amount for average earthquake magnitude
     * @param count Int that sets amount for number of earthquakes
     * @param yr Int that sets year that earthquake information is related to
     */
    public SeismicYear(float total, float max, float min, float avg, int count, int yr)
    {
        this.total = total;
        maximum = max;
        minimum = min;
        average = avg;
        this.count = count;
        year = yr;
    }
    
    /**
     * Parameterized constructor #2
     * @param year Int that sets year that earthquake information is related to
     * @param count Int that sets the number of earthquakes that happened during that one year
     */
    public SeismicYear(int year, int count)
    {
        this.year = year;
        this.count = count;
        total = 0.0f;
        average = 0.0f;
        maximum = 0.0f;
        minimum = 10.0f;
    }
    
    public int getCount()
    {
        return count;
    }
    
    /**
     * setCount method
     * Changes value of the count field
     * @param newCount Contains new value for count
     */
    public void setCount (int newCount)
    {
        count = newCount;
    }
    
    public float getMax()
    {
        return maximum;
    }
    
    /**
     * setMax method
     * Changes value of the maximum field
     * @param newMax Contains new value for maximum
     */
    public void setMax (int newMax)
    {
        maximum = newMax;
    }
    
    public float getMin()
    {
        return minimum;
    }
    
    /**
     * setMin method
     * Changes value of the minimum field
     * @param newMin Contains new value for minimum
     */
    public void setMin (float newMin)
    {
        minimum = newMin;
    }
    
    public float getAverage()
    {
        return average;
    }
    
    /**
     * setAverage method
     * @param newAvg
     */
    public void setAverage (int newAvg)
    {
        average = newAvg;
    }
    
    public float getTotal()
    {
        return total;
    }
    
    public void setTotal (int newTotal)
    {
        total = newTotal;
    }
    
    public int getYear()
    {
        return year;
    }

    public void setYear (int newYear)
    {
        year = newYear;
    }
    
    public void read(int count)
    {
        this.count = count;

        for(int x = 1; x <= count; x++)
        {
            System.out.println("Enter an earthquake magnitude");
            float magnitude = UserInput.readFloat();
            
            if(magnitude < 0)
            {
                System.out.println("Error. Please enter a valid value.");
                magnitude = UserInput.readFloat();
                x--;
            }
            else
            {
                total += magnitude;
            
                if(magnitude > maximum)
                {maximum = magnitude;}
                if(magnitude < minimum)
                {minimum = magnitude;}
            }
        }
        
        average = total/count;
    }
    
    public void read()
    {
        this.read(count);
    }
    
    public void report()
    {
        System.out.println("****EARTHQUAKE REPORT FOR " + year + "*****");
        System.out.println("This year there were " + count + " earthquakes.");
        System.out.println("the total seismic activity was: " + total);
        System.out.println("The average intensity was: " + average);
        System.out.println("The strongest earthquake was: " + maximum);
        System.out.println("The weakest earthquake was: " + minimum);
        System.out.println("****END OF REPORT****");
    }
}
