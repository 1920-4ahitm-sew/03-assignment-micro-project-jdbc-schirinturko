package at.htl.baeckerei.model;

import javax.xml.bind.annotation.XmlRootElement;

//KUNDE CLASS
@XmlRootElement
public class Kunde {
    private int id;
    private String name;

    //Konstruktors
    public Kunde() {
    }

    public Kunde(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //toString
    @Override
    public String toString() {
        return id + " - " + name;
    }
}
