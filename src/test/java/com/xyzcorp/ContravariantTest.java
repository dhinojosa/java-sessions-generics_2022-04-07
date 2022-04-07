package com.xyzcorp;

import com.xyzcorp.people.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class ContravariantTest {
    //You know the boundary but you don't know the specifics
    public void processContravariantList(List<? super American> americans) {
        americans.add(new American());
        americans.add(new Massachusettsan());
        americans.add(new Bostonian());
        americans.add(new Wisconsinite());
        americans.add(new Madisonian());
        americans.add(new NorthernCalifornian());
        americans.add(new Raleighite());
        americans.add(new Denverite());
        americans.add(new Coloradan());
        americans.add(new Missourian());
        StLouisan stLouisan = new StLouisan();
        americans.add(stLouisan);
        //americans.add(new European()); //Nein!
        //americans.add(new Person());
        americans.add(null);
        americans.remove(stLouisan); //Whoa

        Object o = americans.get(0);
        //American a = americans.get(0);
        Iterator<? super American> iterator = americans.iterator();
    }

    /*
     *
     * Space is intentional
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    //16. Contravariant Method
    @Test
    public void testContravariantMethod() {
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Object());
        processContravariantList(objects);

        List<Person> people = new ArrayList<>();
        objects.add(new Person());
        objects.add(new Canadian());
        objects.add(new American());
        processContravariantList(people);


        List<NorthAmerican> northAmericans = new ArrayList<>();
        northAmericans.add(new NorthAmerican());
        northAmericans.add(new NorthAmerican());
        processContravariantList(northAmericans);


        List<American> americans = new ArrayList<>();
        americans.add(new American());
        americans.add(new American());
        processContravariantList(americans);
    }

    //17. Contravariant Assignment
    @Test
    public void testContravariantAssignment() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Canadian());
        American american = new American();
        people.add(american);
        people.add(new Coloradan());
        people.add(new Mexican());
        people.add(new European());

        List<? super American> americansOrHigher = people;

        Object object = americansOrHigher.get(0); //special case

        //       Person person = americansOrHigher.get(0);                   //nope
        //       NorthAmerican northAmerican = americansOrHigher.get(0);     //nope
        //       American american = americansOrHigher.get(0);               //nope
        //       Massachusettsan Massachusettsan = americansOrHigher.get(0); //nope
        //       Bostonian bostonian = americansOrHigher.get(0);           //nope
        //
         //      americansOrHigher.add(new Object());
         //      americansOrHigher.add(new Person());
         //      americansOrHigher.add(new NorthAmerican());
        americansOrHigher.add(american);
        americansOrHigher.add(new Massachusettsan());
        americansOrHigher.add(new Bostonian());
        Object o = americansOrHigher.set(1, new NewMexican());
        americansOrHigher.add(null);
        americansOrHigher.remove(american);
    }
}
