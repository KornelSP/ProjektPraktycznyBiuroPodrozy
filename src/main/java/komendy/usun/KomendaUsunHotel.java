package komendy.usun;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Hotel;

public class KomendaUsunHotel implements IKomenda {

    private DataAccessObject<Hotel> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun hotel";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id hotelu:");
        String idString = IKomenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Hotel.class, id);
    }
}