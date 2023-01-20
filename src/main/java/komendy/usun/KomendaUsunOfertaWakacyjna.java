package komendy.usun;

import database.DataAccessObject;
import komendy.IKomenda;
import model.OfertaWakacyjna;

public class KomendaUsunOfertaWakacyjna implements IKomenda {

    private DataAccessObject<OfertaWakacyjna> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun atrakcje";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id oferty:");
        String idString = IKomenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(OfertaWakacyjna.class, id);
    }
}