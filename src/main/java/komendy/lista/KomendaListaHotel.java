package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Hotel;

public class KomendaListaHotel implements IKomenda {

    private DataAccessObject<Hotel> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista hoteli";
    }

    @Override
    public void obsluga() {
        dao.findAll(Hotel.class).forEach(System.out::println);
    }
}
