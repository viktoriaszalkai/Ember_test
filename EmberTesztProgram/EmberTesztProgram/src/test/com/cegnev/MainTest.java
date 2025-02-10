//package com.cegnev;
//
//import com.cegnev.modell.Jatekos;
//import com.cegnev.modell.Kaszt;
//import org.junit.jupiter.api.Test;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MainTest {
//    @Test
//    void testFajlbaIras() throws Exception {
//        Path tempFile = Files.createTempFile("testFile", ".txt");
//        try {
//            List<String> sorok = List.of("Fájlba", "író", "teszt, 3 sorral.");
//            Main.fajlbaIr(tempFile, sorok);
//            assertTrue(Files.exists(tempFile));
//
//            List<String> beolvasottSorok = Files.readAllLines(tempFile);
//            assertEquals(sorok, beolvasottSorok);
//        } finally {
//            Files.deleteIfExists(tempFile);
//        }
//    }
//
//    @Test
//    void testFajlbolOlvasas() throws Exception {
//        Path tempFile = Files.createTempFile("testFile", ".txt");
//
//        try {
//            List<String> sorok = List.of("Line 1", "Line 2", "Line 3");
//            Files.write(tempFile, sorok);
//
//            List<String> beolvasottSorok = Main.fajlbolOlvas(tempFile);
//
//            assertEquals(sorok, beolvasottSorok);
//        } finally {
//            Files.deleteIfExists(tempFile);
//        }
//    }
//
//    @Test
//    void testSzerializacio() throws IOException {
//        Jatekos eredeti = new Jatekos("Kübli", 23, Kaszt.HARCOS);
//        Main.jatekosSorositasa(eredeti);
//        assertTrue(Files.exists(Path.of("jatekos.ser")));
//
//        Jatekos deszerializalt = Main.jatekosDeszerializalasa();
//
//        assertEquals(eredeti, deszerializalt, "A deszerralizált objektumnak egyeznie kell az eredetivel.");
//
//    }
//}