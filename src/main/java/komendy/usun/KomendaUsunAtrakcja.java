package komendy.usun;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Atrakcja;

public class KomendaUsunAtrakcja implements IKomenda {

    private DataAccessObject<Atrakcja> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun atrakcje";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id atrakcji:");
        String idString = IKomenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Atrakcja.class, id);
    }
}
