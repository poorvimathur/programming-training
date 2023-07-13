/*
Poorvi Mathur
1/29/23
Description of program:
Returns average, median, mode, and most of the array inputted by the user.
*/
import java.util.Arrays;
import java.util.Scanner;
public class Statistics
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Statistics!\n" +
                "This program will calculate the average, median, \n" +
                "mode, and most of any number of (double) values!\n" +
                "\n" +
                "How many values will you be entering?\n");
        int n = input.nextInt();
        double[] arr = new double[n];

        for (int i = 1; i < n + 1; i++)
        {
            System.out.println(" > Please enter value #" + i + ":");
            arr[i - 1] = input.nextDouble();
        }

        double average = average(arr);
        System.out.println("Average:" + average);
        double median = median(arr);
        System.out.println("Median:" + median);
        double[] mode = mode(arr);
        System.out.println("Mode:");
        ArrayHelper.display(mode); // displays the actual array
        double[] most = most(arr);
        System.out.println("Most:");
        ArrayHelper.display(most);

    }
    public static double average(double[] values)
    {
        double sum = 0;
        for(double x : values)
        {
            sum += x;
        }
        sum = sum / values.length; // divides the sum by array length that is inputted by user.
        return sum;
    }

    public static double median(double[] values)
    {
        values = sort(values);
        int mid = values.length / 2;
        if (values.length % 2 == 0)
            return (values[mid - 1] + values[mid]) / 2.0; //gets average of middle two numbers
        return values[mid];
    }

    public static double[] mode(double[] values)
    {
        double[] count = new double[values.length];
        for(int i = 0; i < values.length; i++)
        {
            count[i] = ArrayHelper.count(values, values[i]); //calling count method to count how many times a number was in each array.
        }
        double max = ArrayHelper.max(count);
        double[] most = new double[values.length];
        int countMost = 0;

        for (int i = 0; i < values.length; i++)
        {
            double counter = count[i];
            double values2 = values[i];
            boolean inc = true;

            if (counter == max)
            {
                for (int j = 0; j < countMost; j++)
                {
                    if (most[j] == values2)
                    {
                        inc = false;
                    }
                }
                if(inc)
                    most[countMost++] = values2;
            }
        }
        return count;
    }

    public static double[] most(double[] values)
    {
        int count = 0;
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] >= Statistics.average(values)) //compares with average
                count++;
        }

        double[] values2 = new double[count];
        int counter = 0;

        for (int i = 0; i < values.length; i++)
        {
            if (values[i] >= Statistics.average(values))
            {
                values2[counter] = values[i];
                counter++;
            }
        }
        return values2;
    }

    // returns a sorted copy of values
    // does not modify vaules
    public static double[] sort(double[] values)
    {
        double[] temp = values.clone();
        Arrays.sort(temp);
        return temp;
    }
}