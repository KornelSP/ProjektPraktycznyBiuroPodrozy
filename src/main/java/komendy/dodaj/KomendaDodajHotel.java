package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Hotel;
import model.Lokalizacja;

import java.util.Optional;

public class KomendaDodajHotel implements IKomenda {

    private DataAccessObject<Hotel> dao = new DataAccessObject<>();

    private DataAccessObject<Lokalizacja> daoLokaliacja = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj hotel";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id lokalizacji z dostepnych ponizej:");
        daoLokaliacja.findAll(Lokalizacja.class).forEach(System.out::println);

        boolean flag;
        Optional<Lokalizacja> lokalizacjaOptional;
        do {
            String idLokalizacjiString = IKomenda.SCANNER.nextLine();
            Long idLokalizacji = Long.parseLong(idLokalizacjiString);
            lokalizacjaOptional = daoLokaliacja.find(Lokalizacja.class, idLokalizacji);
            if (lokalizacjaOptional.isEmpty()) {
                System.err.println("Lokalizacja o podanym id nie istnieje, podaj poprawne id:");
                flag = true;
            } else {
                flag = false;
            }
        }while (flag);

        System.out.println("Podaj nazwe hotelu:");
        String nazwa = IKomenda.SCANNER.nextLine();

        System.out.println("Podaj opis hotelu:");
        String opis = IKomenda.SCANNER.nextLine();

        System.out.println("Podaj standard hotelu (ilosc gwiazdek 1-5):");
        int gwiazdki = 0;
        do {
            gwiazdki = IKomenda.SCANNER.nextInt();
        } while (!(gwiazdki <= 5 && gwiazdki >= 1));

        Hotel hotel = Hotel.builder()
                .lokalizacja(lokalizacjaOptional.get())
                .nazwa(nazwa)
                .opis(opis)
                .standard(gwiazdki)
                .build();

        dao.insert(hotel);
    }
}
