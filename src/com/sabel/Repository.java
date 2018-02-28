package com.sabel;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Eintrag> eintraege;
    private EintragService eintragService;

    public Repository() {
        eintragService = new EintragService();
        eintraege = eintragService.gibtAlleEintraege();
    }

    public void hinzufuegen(Eintrag eintrag) {
        eintraege.add(eintrag);
        eintragService.speichern(eintrag);
    }

    public int anzahl() {
        return eintraege.size();
    }

    public Eintrag loeschen(int pos) {
        if (pos < 0 || pos >= eintraege.size()) {
            throw new IllegalArgumentException("pos wrong");
        }

        return eintraege.remove(pos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Eintrag eintrag : eintraege) {
            sb.append(eintrag.getName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void close() {
        eintragService.close();
    }

}
