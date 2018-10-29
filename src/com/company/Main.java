package com.company;
import java.util.*;
import java.lang.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        System.out.println("Enter the size of the array: "); //Letting the user choose the size of the array
        int size = in.nextInt();//Accepts user input for array size
        int salary[] = new int[size]; //Declaring the array with user input for the size

         Populate(salary); //Populating the array in case the user doesn't do so before choosing the other options
        int option;//variable declaration for user input
        do{
            //Main menu for the user
            System.out.println("Pick an option");
            System.out.println("1.Populate Array");
            System.out.println("2.Display Array");
            System.out.println("3.Minimum");
            System.out.println("4.Maximum");
            System.out.println("5.Range");
            System.out.println("6.Mode");
            System.out.println("7.Mean");
            System.out.println("8.Standard Deviation");
            System.out.println("9.Exit");
            option = in.nextInt();//Accepting user input

            //Switch cases used to accept the user input from the main menu
            switch(option)
            {
                case 1:
                    Populate(salary);
                    break;
                case 2:
                    DisplayArray(salary);
                    break;
                case 3:
                    String S3 =  "The minimum is: " + GetMin(salary);
                    JOptionPane.showMessageDialog( null, S3 );
                    break;
                case 4:
                   String S = "The maximum is: " + GetMax(salary);
                   JOptionPane.showMessageDialog( null, S );
                    break;
                case 5:
                    String rangeS =  "The range is: " + Range(salary);
                    JOptionPane.showMessageDialog( null, rangeS );
                    break;
                case 6:
                    String S6 = "The mode is: " + Mode(salary);
                    JOptionPane.showMessageDialog( null, S6 );
                    break;
                case 7:
                    String S7 =  "The mean is: " + Mean(salary);
                    JOptionPane.showMessageDialog( null, S7 );

                    break;
                case 8:
                    S =  "The Standard Deviation is: " + StandardDeviation(salary);
                    JOptionPane.showMessageDialog( null, S );
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid Input");
                    JOptionPane.showMessageDialog( null, "Invalid Input" );

            }
        }while(option < 9 && option > 0);
        System.out.println("Thanks for coming");

    }
    private static void Populate(int salary[]) //method to populate the array
    {
        Random rand = new Random();

        for(int i = 0;i < salary.length;i++)
        {
            salary[i] = (rand.nextInt(4) + 3) * 10000;
        }
    }
    private static void DisplayArray(int salary[]) //Method to display the array to the user
    {
        int counter = 0;
        for(int element : salary)
        {
            System.out.print(element + " ");
            counter++;
            if(counter == 3)
            {
                System.out.println();
                counter = 0;
            }
        }
    }
    private static int GetMin(int salary[])//Method to get the minimum value of the array
    {
        int min = salary[0];

        for(int element : salary)
        {
            if(element < min)
            {
                min = element;
            }
        }
        return min;
    }
    private static int GetMax(int salary[])//Method to get the maximum value of the array
    {
        int max = salary[0];

        for(int element : salary)
        {
            if(element > max)
            {
                max = element;
            }
        }
        return max;
    }
    private static int Range(int salary[])//Method to get the range of the array
    {
        int min = GetMin(salary);
        int max = GetMax(salary);
        return max - min;
    }
    private static int Mode(int salary[]) //Method to get the mode of the array
    {
        int mode = salary[0];
        int maxCount = 0;
        for(int element : salary)
        {
            int count = 1;
            for(int element2 : salary)
            {
                if(element2 == element)
                {
                    count++;
                }
                if(count > maxCount)
                {
                    mode = element;
                    maxCount = count;
                }
            }
        }

        return mode;
    }

   /*public static double Median(int salary[])//Method to get the Median of the array *Unneeded apparently
   //{
   //    int median;
   //
   //    Arrays.sort(salary);
   //
   //
   //
   //    median = (salary[salary.length/2] + salary[salary.length/2 - 1])/2;
   //    return median;
   }*/
    private static int Mean(int salary[])//Method to get the mean of the array
    {
        int mean;
        int total = 0;
        for(int element : salary)
        {
            total += element;
        }

        mean = total/salary.length;

        return mean;
    }
    private static double StandardDeviation(int salary [])//Method to get the standard deviation of the array
    {
        int mean = Mean(salary);//Calls the mean to be used in the equation

        double standardDeviation;
        double total = 0;


        for(int element : salary)
        {
            total += Math.pow(element - mean ,2);
        }

        standardDeviation = total/salary.length;

        standardDeviation = Math.sqrt(standardDeviation);

        return standardDeviation;
    }
}
