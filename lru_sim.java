import java.io.*;
import java.util.Scanner;

class lru_sim
{
  static int[][] data = {{8, 0}, {4, 1}, {12, 2}, {5, 3}, {3, 4}, {1, 5}, {0, 6}, {20,7}};
  static File source = new File("SOURCE.TXT");
  static int hit = 0;
  static int miss = 0;

  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner file = new Scanner(source);

    System.out.println("Initial State");
    printData();

    while (file.hasNextInt())
    {
      int current = file.nextInt();
      check(current);
    }

    System.out.println("Final State");
    printData();

    System.out.println("Hit: " + hit);
    System.out.println("Miss: " + miss);
  }

  public static void check(int current)
  {
    for (int i = 0; i < data.length; i++)
    {
      if (data[i][0] == current)
      {
        hit++;
        update(data[i][1]);
        data[i][1] = 7;
        return;
      }
    }

    miss++;

    int i = 0;
    update(i);

    while (data[i][1] != 0)
      i++;

    data[i][0] = current;
    data[i][1] = 7;
  }

  public static void update(int start)
  {
    for (int i = 0; i < data.length; i++)
    {
      if (data[i][1] > start)
      {
        data[i][1]--;
      }
    }
  }

  public static void printData()
  {
    System.out.println("Location\tValue\tSequence");

    for (int i = 0; i < data.length; i++)
    {
      System.out.println(i + "\t\t" + data[i][0] + "\t" + data[i][1]);
    }
    System.out.println();
  }
}
