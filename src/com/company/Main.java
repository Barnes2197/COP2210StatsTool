/*
Team leader: Maurice Barnes, 5443793, U08
Student: <name>, <PID>, <class section>
Programming Project 5 - Write a program that simulates a statistics tool, by letting the user determine the minimum, the maximum, the range (maximum – minimum), the mode (value that is repeated more often), the mean (average), and the standard deviation of a set of numbers. These numbers, that will be stored in an array, represent salaries in the $30K – $60K range and are to be generated randomly. This is the definition of standard deviation, √ ∑ (𝑥𝑖 − 𝑥̅) 𝑛 2 𝑖=1 𝑛 − 1 where x̄denotes the average, and n is the total number of elements in the array. The program will present the user a menu with these choices:

Populate Array
Display Array
Minimum
Maximum
Range
Mode
Mean
Standard Deviation
Exit and will let the user run them until “Exit” is entered.
 */
package com.company;
import java.util.*;
import java.lang.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String size2 = JOptionPane.showInputDialog("Enter the size of the array: "); //Letting the user choose the size of the array
        int size = Integer.parseInt(size2);//Accepts user input for array size
        int salary[] = new int[size]; //Declaring the array with user input for the size

         Populate(salary); //Populating the array in case the user doesn't do so before choosing the other options
        int option;//variable declaration for user input
        do{
            //Displaying the Main Menu in a Dialog box
            String mainMenu = "Pick an option\n1.Populate Array\n2.Display Array\n3.Minimum\n" +
                    "4.Maximum\n5.Range\n6.Mode\n7.Mean\n8.Standard Deviation\n9.Exit";
            String option2 = JOptionPane.showInputDialog(mainMenu);
            option = Integer.parseInt(option2);

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
                    String minimum =  "The minimum is: " + GetMin(salary);
                    JOptionPane.showMessageDialog( null, minimum,"Minimum"
                    ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                   String maximum = "The maximum is: " + GetMax(salary);
                   JOptionPane.showMessageDialog( null, maximum,"Maximum"
                   ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5:
                    String range =  "The range is: " + Range(salary);
                    JOptionPane.showMessageDialog( null, range,"Range"
                            ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 6:
                    String mode = "The mode is: " + Mode(salary);
                    JOptionPane.showMessageDialog( null, mode, "Mode"
                            ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 7:
                    String mean =  "The mean is: " + Mean(salary);
                    JOptionPane.showMessageDialog( null, mean,"Mean"
                            ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 8:
                    String standardDeviation =  "The Standard Deviation is: " + StandardDeviation(salary);
                JOptionPane.showMessageDialog( null, standardDeviation, "Standard Deviation"
                        ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog( null, "Invalid Input" );

            }
        }while(option < 9 && option > 0);//Ending the while loop
        JOptionPane.showMessageDialog( null, "Thanks for Coming" );

    }
    private static void Populate(int salary[])//method to populate the array
    {
        Random rand = new Random();

        for(int i = 0;i < salary.length;i++)
        {
            salary[i] = (rand.nextInt(30000)) + 30000;
        }
    }
    private static void DisplayArray(int salary[]) //Method to display the array to the user
    {
        StringBuilder result = new StringBuilder();
        int counter = 0;

        for(int element : salary)
        {
            counter++;
            if(counter > 5)// used to keep 5 numbers per row
            {
                result.append(element).append("\n");
                counter = 0;
            }
            else
            {
                result.append(element).append(" ");
            }

        }
        JOptionPane.showMessageDialog(null, result.toString(), "Displaying Array",
                JOptionPane.INFORMATION_MESSAGE);
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





























































































//Completed by Maurice Barnes on 10/30/18