package com.cegnev.modell;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Jatekos implements Serializable {

    private String nev;
    private int szint;
    private Kaszt kaszt;
    private ArrayList<String> felszerelesek;

    public Jatekos() {
    }

    public Jatekos(String nev, int szint, Kaszt kaszt)  {
        this.nev = nev;
        this.szint = szint;
        this.kaszt = kaszt;
        this.felszerelesek = new ArrayList<>();
        nemLetezoSzint();
        rovidNev();

    }

    public void nemLetezoSzint(){
        if(szint <= 0 ){
            throw new IllegalArgumentException("Nem jó így Adél!");
        }
    }

    public void rovidNev(){
        if(nev.length() < 3){
            throw new RovidNevException("Rövid  név !");
        }
    }

    public String getNev() {
        return this.nev;
    }

    public int getSzint() {
        return this.szint;
    }

    public ArrayList<String> getFelszerelesek() {
        //return new ArrayList<>(Collections.unmodifiableList(felszerelesek));
        return new ArrayList<>(felszerelesek);
    }

    public Kaszt getKaszt() {
        return kaszt;
    }

    public void setNev(String p) {
        this.nev=p;
        rovidNev();
    }

    public void setSzint(int i) {
        this.szint=i;
        nemLetezoSzint();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jatekos jatekos = (Jatekos) o;
        return szint == jatekos.szint && Objects.equals(nev, jatekos.nev) && kaszt == jatekos.kaszt && Objects.equals(felszerelesek, jatekos.felszerelesek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, szint, kaszt, felszerelesek);
    }

    public void ujFelszereles(String ujF) {
        this.felszerelesek  = new ArrayList<>(List.of(ujF));

    }


}
