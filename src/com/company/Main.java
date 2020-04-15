
package com.company;



import java.util.Hashtable;

import java.util.Set;

import java.util.logging.Handler;



public class Main {

    public static void main(String[] args)

    {



        MyHashTable1 myHashTable1 = new MyHashTable1();

        System.out.println(myHashTable1.isEmpty());

        myHashTable1.add("Solomon","watched them all" );
        myHashTable1.add("Caldour","the bottom of all " );

        System.out.println( myHashTable1.contains("Solomon"));

        myHashTable1.add("MR.Frodo","The ring keeper" );

        myHashTable1.add("Dr.Strange","stone keeper " );

        myHashTable1.add("Spiderman","not Marvel anymore" );

        myHashTable1.add("Spiderman","My be Sony owns it" );

        System.out.println(myHashTable1.size());

        System.out.println(myHashTable1.get("MR.Frodo"));

       MyHashTable1.remove("Dr.55");

        System.out.println(myHashTable1.get("Spiderman"));

        myHashTable1.contains("Spiderman");









//        System.out.println(MyHashTable1.size());


    }

}
