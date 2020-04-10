package com.company;
import java.util.*;


class Entry
{
    String key;  // create nodes like in c program with
    String value;
    Entry next;


    public Entry(String key, String value) //  a constructor to instantiate the key and value of the Entry field
    {
        this.key = key;
        this.value = value;
    }

}

class MyHashTable1
{

    private static int tableSize; // initial capacity of Arraylist
    private static int size;   // initial  size of Arraylist
    private static ArrayList<Entry> MyLinkedList; //Array list to dynamically allocate Entry
    public MyHashTable1()
    {
        MyLinkedList=new ArrayList<>();
         tableSize = 20;
        size = 0;


        for (int i = 0; i < tableSize; i++) //Instantiate  the arraylist with null(empty) value
            MyLinkedList.add(null);
    }

    public static int size() { return size; }
    public static boolean isEmpty() { return size() == 0; }


        private static int getCellIndex(String key)
    {
      int index =Math.abs( key.hashCode() % tableSize);
        return index;
    }

    public static void remove(String key)
    {

            int position = getCellIndex(key);

            Entry head = MyLinkedList.get(position);

            Entry previous = null; //looking for the key in the table
            while (head != null) {
                if (head.key.equals(key)) { //if the key is found break the loop and jump out
                    if (previous != null)
                        previous.next = head.next;
                    else
                        MyLinkedList.set(position, head.next);
                    System.out.println("The value: " + head.value + " was removed");
                    size -= 1;
                    break;
                } else {
                    previous = head;
                    head = head.next;
                    if (head == null) {  //if the key is not available
                        System.out.println("The the key  " +key+ " was not found on the table!");
                    }
                }
            }

 }

    // Returns value for a key
    public static Object get(String  key)
    {
        // Find head of chain for given key
        int indexOfItem = getCellIndex(key);
     Entry head=  MyLinkedList.get(indexOfItem);
     while(head!=null){
         if(head.key.equals(key))
             return head.value;
             head= head.next;

     }
       return null;
    }


    public void add(String  key, String  value)// Adds a key value pair to hash
    {

        int position = getCellIndex(key);   // Find head of chain for given key
        Entry head = MyLinkedList.get(position);


        while (head != null)     // Check if key is already present
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }

         size++;
        head = MyLinkedList.get(position);
        Entry node = new Entry(key, value);
        node.next = head;
        MyLinkedList.set(position, node);


        if ((size)/tableSize >= 0.7)
        {
            ArrayList<Entry> tmp = MyLinkedList;
            MyLinkedList = new ArrayList<>();
            tableSize = 2 * tableSize;
            size = 0;
            for (int i = 0; i < tableSize; i++)
                MyLinkedList.add(null);

            for (Entry entry : tmp)
            {
                while (entry != null)
                {
                    add(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }
    }


    public static boolean contains(String key) {
        int position = getCellIndex(key);

        Entry head = MyLinkedList.get(position);


        while (head != null) {
            if (head.key.equals(key)) {
                 System.out.println("The key "+ head.key + " is found");
                return true;
            } else {


                head = head.next;
                System.out.println("the key "+ head.key +" is not available");
            }


        }

       return false;
    }

    //Iterator<ArrayList<String>> it = MyLinkedList.keySet().iterator();







}
