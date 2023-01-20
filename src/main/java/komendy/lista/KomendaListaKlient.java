package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Klient;

public class KomendaListaKlient implements IKomenda {

    private DataAccessObject<Klient> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista klientow";
    }

    @Override
    public void obsluga() {
        dao.findAll(Klient.class).forEach(System.out::println);
    }
}