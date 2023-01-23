package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Wycieczka;

public class KomendaListaWycieczka implements IKomenda {

    private DataAccessObject<Wycieczka> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista wycieczek";
    }

    @Override
    public void obsluga() {
        dao.findAll(Wycieczka.class).forEach(System.out::println);
    }
}