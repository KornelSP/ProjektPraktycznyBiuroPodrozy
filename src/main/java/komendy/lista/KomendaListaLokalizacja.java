package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Lokalizacja;

public class KomendaListaLokalizacja implements IKomenda {

    private DataAccessObject<Lokalizacja> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista lokalizacji";
    }

    @Override
    public void obsluga() {
        dao.findAll(Lokalizacja.class).forEach(System.out::println);
    }
}