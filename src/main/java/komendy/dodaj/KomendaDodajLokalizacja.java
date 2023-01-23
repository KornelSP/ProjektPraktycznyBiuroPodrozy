package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Lokalizacja;

public class KomendaDodajLokalizacja implements IKomenda {

    private DataAccessObject<Lokalizacja> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj lokalizacje";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe lokalizacji:");
        String nazwa = IKomenda.SCANNER.nextLine();

        Lokalizacja lokalizacja = Lokalizacja.builder()
                .lokalizacja(nazwa)
                .build();

        dao.insert(lokalizacja);
    }
}
