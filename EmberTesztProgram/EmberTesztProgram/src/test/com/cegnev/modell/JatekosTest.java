package com.cegnev.modell;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JatekosTest {
    @Test
    void testKonstruktorParaméterekTipusa() throws NoSuchMethodException {
        Constructor<Jatekos> constructor = Jatekos.class.getConstructor(String.class, int.class, Kaszt.class);
        Parameter[] parameters = constructor.getParameters();
        Parameter param = parameters[2];
        assertTrue(param.getType().isEnum(), "nem jók a paraméterek: String, int, enum");
    }

    @Test
    void testKonstruktorJo(){
        Jatekos jatekos = new Jatekos("Gründi", 3, Kaszt.VARAZSLO);
        assertTrue(jatekos.getNev().length() >= 3);
        assertTrue(jatekos.getSzint() > 0);
        assertTrue(jatekos.getFelszerelesek().isEmpty());
    }

    @Test
    void testKonstruktorNemLetezoSzint(){
        assertThrows(IllegalArgumentException.class, () -> new Jatekos("Pál", 0, Kaszt.HARCOS));
    }


    @Test
    void testKonstruktorRovidNev(){
        assertThrows(RovidNevException.class, () -> new Jatekos("P", 3, Kaszt.HARCOS));
    }

    @Test
    void testSetRovidNev(){
        Jatekos jatekos = new Jatekos("Pál", 1, Kaszt.HARCOS);
        assertThrows(RovidNevException.class, () -> jatekos.setNev("P"));
    }

    @Test
    void testSetNemLetezoSzint(){
        Jatekos jatekos = new Jatekos("Pál", 1, Kaszt.HARCOS);
        assertThrows(IllegalArgumentException.class, () -> jatekos.setSzint(0));
    }

    @Test
    void testEgyformak(){
        Jatekos j1 = new Jatekos("Kübli", 23, Kaszt.HARCOS);
        Jatekos j2 = new Jatekos("Kübli", 23, Kaszt.HARCOS);
        assertEquals(j1.hashCode(), j2.hashCode());
        assertEquals(j1, j2);
    }

    @Test
    public void testJatekosSzerializalhato() {
        assertTrue(Serializable.class.isAssignableFrom(Jatekos.class), "A Jatekos osztálynak implementálnia kell a Serializable felületet.");
    }

    @Test
    void testUjFelszereles(){
        Jatekos jatekos = new Jatekos("Kübli", 23, Kaszt.HARCOS);
        jatekos.ujFelszereles("pajzs");
        assertEquals(1, jatekos.getFelszerelesek().size());
    }

    @Test
    void testNemModosithatoFelszereles(){
        Jatekos jatekos = new Jatekos("Kübli", 23, Kaszt.HARCOS);
        jatekos.ujFelszereles("pajzs");
        ArrayList<String> felszerelesek = jatekos.getFelszerelesek();
        felszerelesek.add("kard");
        assertEquals(1, jatekos.getFelszerelesek().size());
    }
}