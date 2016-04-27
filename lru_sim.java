import java.io.*;
import java.util.Scanner;

class lru_sim
{
  static int[] data = new int[]{8, 4, 12, 5, 3, 1, 0, 20};
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
      if (data[i] == current)
      {
        hit++;
        update(i);
        break;
      } else if (i == data.length-1)
      {
        miss++;
        update();
      }
    }

    data[data.length-1] = current;
  }

  public static void update()
  {
    update(0);
  }

  public static void update(int start)
  {
    for (int i = start; i < data.length - 1; i++)
    {
      data[i] = data[i+1];
    }
  }

  public static void printData()
  {
    System.out.println("Location\tValue");

    for (int i = 0; i < data.length; i++)
    {
      System.out.println(i + "\t\t" + data[i]);
    }
    System.out.println();
  }
}
