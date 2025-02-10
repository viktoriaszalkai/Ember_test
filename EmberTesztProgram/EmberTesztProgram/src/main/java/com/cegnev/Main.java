package com.cegnev;

import com.cegnev.modell.Jatekos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main implements Serializable {
    public static void main(String[] args) {

    }

    public static void fajlbaIr(Path fajl, List<String> sorok) throws IOException {
        Files.write(fajl, sorok, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static List<String> fajlbolOlvas(Path tempFile) {
        List<String> sorok = null;
        try {
            sorok = Files.readAllLines(tempFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sorok;
    }

    public static void jatekosSorositasa(Jatekos eredeti) {
            try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("jatekos.ser"))) {
                objKi.writeObject(eredeti);
            }catch (FileNotFoundException e){
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw  new RuntimeException();
            }

    }

    public static Jatekos jatekosDeszerializalasa() {
        Jatekos beJatekos;
        try (ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("jatekos.ser"))) {
            beJatekos = (Jatekos) objBe.readObject();
            System.out.println("A beolvasott játékos: ");
            System.out.println(beJatekos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return beJatekos;
    }
}