package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Hotel;

public class KomendaDodajHotel implements IKomenda {

    private DataAccessObject<Hotel> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj hotel";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe hotelu:");
        String nazwa = IKomenda.SCANNER.nextLine();

        System.out.println("Podaj opis hotelu:");
        String opis = IKomenda.SCANNER.nextLine();


        Hotel hotel = Hotel.builder()
                .nazwa(nazwa)
                .opis(opis)
                .build();

        dao.insert(hotel);
    }
}
