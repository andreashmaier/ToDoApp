package com.sabel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Eintrag {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Eintrag() {
    }

    public Eintrag(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eintrag eintrag = (Eintrag) o;
        return Objects.equals(name, eintrag.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Eintrag{" +
                "name='" + name + '\'' +
                '}';
    }
}
