package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Atrakcja;
import model.Lokalizacja;

import java.util.Optional;

public class KomendaDodajAtrakcja implements IKomenda {

    private DataAccessObject<Atrakcja> dao = new DataAccessObject<>();

    private DataAccessObject<Lokalizacja> daoLokaliacja = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj atrakcje";
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

        System.out.println("Podaj nazwe atrakcji:");
        String nazwa = IKomenda.SCANNER.nextLine();

        System.out.println("Podaj opis atrakcji:");
        String opis = IKomenda.SCANNER.nextLine();

        Atrakcja atrakcja = Atrakcja.builder()
                .lokalizacja(lokalizacjaOptional.get())
                .nazwa(nazwa)
                .opis(opis)
                .build();

        dao.insert(atrakcja);
    }
}
