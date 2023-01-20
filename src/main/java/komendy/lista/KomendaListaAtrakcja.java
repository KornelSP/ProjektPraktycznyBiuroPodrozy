package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Atrakcja;

public class KomendaListaAtrakcja implements IKomenda {

    private DataAccessObject<Atrakcja> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista atrakcji";
    }

    @Override
    public void obsluga() {
        dao.findAll(Atrakcja.class).forEach(System.out::println);
    }
}