package com.company;

import ibcsutils.ReadViaURL;
import java.util.Random;
public class Main
{

    public static void main(String[] args)
    {

        String addr = "https://www-personal.umich.edu/~jlawler/wordlist";

        // read, remove punctuation and digits, to lowercase
        String[] words = ReadViaURL.readWords(addr, true, true, true);
        int numToSort = 15;

        // shuffle
        System.out.println("Shuffled list: ");

        Random rand = new Random();

        for (int l = 0; l < words.length; l++)
        {
            int indToSwap = rand.nextInt(words.length);
            swap(words, indToSwap, l);
        }
        for (int l = 0; l < numToSort; l++)
            System.out.print(words[l] + " ");

        // sort

        System.out.println();
        System.out.println();
        System.out.println("Sorted list: ");

        for (int i = 0; i < numToSort - 1; i++)
        {
            for (int j = i + 1; j < numToSort; j++)
            {
                int compare = words[i].compareTo(words[j]);
                if (compare > 0)
                {
                    swap(words, i, j);
                }
            }
        }
        for (int k = 0; k < numToSort; k++)
            System.out.print(words[k] + " ");
        System.out.println();

    }

    // swap method
    static void swap (String[] arr, int i, int j)
    {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
