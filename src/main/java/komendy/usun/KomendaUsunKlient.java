package komendy.usun;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Klient;

public class KomendaUsunKlient implements IKomenda {

    private DataAccessObject<Klient> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun klienta";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id klienta:");
        String idString = IKomenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Klient.class, id);
    }
}
