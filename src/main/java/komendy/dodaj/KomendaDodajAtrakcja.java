package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Atrakcja;

public class KomendaDodajAtrakcja implements IKomenda {

    private DataAccessObject<Atrakcja> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj atrakcje";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe atrakcji:");
        String nazwa = IKomenda.SCANNER.nextLine();

        System.out.println("Podaj opis atrakcji:");
        String opis = IKomenda.SCANNER.nextLine();


        Atrakcja atrakcja = Atrakcja.builder()
                .nazwa(nazwa)
                .opis(opis)
                .build();

        dao.insert(atrakcja);
    }
}
