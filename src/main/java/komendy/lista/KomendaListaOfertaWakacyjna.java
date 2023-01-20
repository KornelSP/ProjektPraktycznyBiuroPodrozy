package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.OfertaWakacyjna;

public class KomendaListaOfertaWakacyjna implements IKomenda {

    private DataAccessObject<OfertaWakacyjna> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista ofert wakacyjnych";
    }

    @Override
    public void obsluga() {
        dao.findAll(OfertaWakacyjna.class).forEach(System.out::println);
    }
}