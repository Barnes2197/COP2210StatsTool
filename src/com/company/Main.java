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
                    String S3 =  "The minimum is: " + GetMin(salary);
                    JOptionPane.showMessageDialog( null, S3,"Minimum"
                    ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                   String S = "The maximum is: " + GetMax(salary);
                   JOptionPane.showMessageDialog( null, S,"Maximum"
                   ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5:
                    String rangeS =  "The range is: " + Range(salary);
                    JOptionPane.showMessageDialog( null, rangeS,"Range"
                            ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 6:
                    String S6 = "The mode is: " + Mode(salary);
                    JOptionPane.showMessageDialog( null, S6, "Mode"
                            ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 7:
                    String S7 =  "The mean is: " + Mean(salary);
                    JOptionPane.showMessageDialog( null, S7,"Mean"
                            ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 8:
                    S =  "The Standard Deviation is: " + StandardDeviation(salary);
                JOptionPane.showMessageDialog( null, S, "Standard Deviation"
                        ,JOptionPane.INFORMATION_MESSAGE);
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
            if(counter > 5)
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
