/*
 *  Written by : Bin Hong Lee
 *  Last edited : 4/26/2016
 *
 *  CST 450 - Computer Architecture
 *  Project 2
 */

import java.io.*;
import java.util.Scanner;

class lru_sim
{
  //Initializing data array with desired data
  static int[][] data = {{8, 0}, {4, 1}, {12, 2}, {5, 3}, {3, 4}, {1, 5}, {0, 6}, {20,7}};

  //Specifying the source file
  static File source = new File("SOURCE.TXT");

  //Initializing hit and miss counts
  static int hit = 0;
  static int miss = 0;

  public static void main(String[] args) throws FileNotFoundException
  {
    //Declaring scanner to scan from the source file
    Scanner file = new Scanner(source);

    //Print the initial state of the data array
    System.out.println("Initial State");
    printData();

    //Loop until EOF
    while (file.hasNextInt())
    {
      int current = file.nextInt();
      //Check if the integer already exist in the data array and carry out the
      //desired action
      check(current);
    }

    //Print the ending state of the data array
    System.out.println("Final State");
    printData();

    //Print the hit and miss counts
    System.out.println("Hit: " + hit);
    System.out.println("Miss: " + miss);
  }

  public static void check(int current)
  {
    //Loop through the array to check if the new integer already exist
    for (int i = 0; i < data.length; i++)
    {
      //If it is a hit
      if (data[i][0] == current)
      {
        //hit count increases
        hit++;
        //Update the data array according to the position of this existing data
        update(data[i][1]);
        //Update the sequence of this current data
        data[i][1] = 7;
        //Quit the method
        return;
      }
    }

    //miss count increases
    miss++;

    //Update the data array sequence by reducing all the sequence position by 1
    int i = 0;
    update(i);

    //Look for the least recently used data
    while (data[i][1] != -1)
      i++;

    //Replace it with the new data
    data[i][0] = current;
    data[i][1] = 7;
  }

  public static void update(int start)
  {
    //Looping through the data array
    for (int i = 0; i < data.length; i++)
    {
      /* If the data has a higher or same sequence position than the hit number,
       * its sequence position is reduced by 1.
       * ('or same' is implemented to prevent repeated '0' in the sequence before
       * the new value is updated, in that case, the data should be replaced is
       * in the '-1' position, while the data that is previously at '1' is now at
       * '0', etc.)
       */

      if (data[i][1] >= start)
      {
        data[i][1]--;
      }
    }
  }

  public static void printData()
  {
    //Print the labelling row
    System.out.println("Location\tValue\tSequence");

    //Loop through the data array to print the data in the array
    for (int i = 0; i < data.length; i++)
    {
      System.out.println(i + "\t\t" + data[i][0] + "\t" + data[i][1]);
    }

    //Empty line for formatting purpose
    System.out.println();
  }
}
