package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Klient;

public class KomendaDodajKlient implements IKomenda {

    private DataAccessObject<Klient> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj klienta";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe klienta:");
        String nazwa = IKomenda.SCANNER.nextLine();

        System.out.println("Podaj wiek klienta:");
        int wiek = IKomenda.SCANNER.nextInt();


        Klient klient = Klient.builder()
                .nazwa(nazwa)
                .wiek(wiek)
                .build();

        dao.insert(klient);
    }
}
