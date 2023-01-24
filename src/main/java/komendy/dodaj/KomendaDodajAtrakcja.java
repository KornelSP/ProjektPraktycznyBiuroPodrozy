package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Atrakcja;
import model.Lokalizacja;
import model.Wycieczka;

import java.util.Optional;

public class KomendaDodajAtrakcja implements IKomenda {

    private DataAccessObject<Atrakcja> dao = new DataAccessObject<>();

    private DataAccessObject<Lokalizacja> daoLokaliacja = new DataAccessObject<>();

    private DataAccessObject<Wycieczka> daoWycieczka = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj atrakcje";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id lokalizacji z dostepnych ponizej:");
        daoLokaliacja.findAll(Lokalizacja.class).forEach(System.out::println);

        Optional<Lokalizacja> lokalizacjaOptional;
        String idLokalizacjiString;
        do {
            idLokalizacjiString = IKomenda.SCANNER.nextLine();
            Long idLokalizacji = Long.parseLong(idLokalizacjiString);
            lokalizacjaOptional = daoLokaliacja.find(Lokalizacja.class, idLokalizacji);
            if (lokalizacjaOptional.isEmpty()) {
                System.err.println("Lokalizacja o podanym id nie istnieje, podaj poprawne id:");
            } else {
                System.out.println("Lokalizacja dodana.");
            }
        } while (lokalizacjaOptional.isEmpty());

        System.out.println("Podaj id wycieczki z dostepnych ponizej:");
        daoWycieczka.findAll(Wycieczka.class).forEach(System.out::println);

        Optional<Wycieczka> wycieczkaOptional;
        String idWycieczkiString;
        do {
            idWycieczkiString = IKomenda.SCANNER.nextLine();
            Long idWycieczki = Long.parseLong(idWycieczkiString);

            wycieczkaOptional = daoWycieczka.find(Wycieczka.class, idWycieczki);
            if (wycieczkaOptional.isEmpty()) {
                System.err.println("Wycieczka o podanym id nie istnieje, podaj poprawne id:");
            } else {
                System.out.println("Wycieczka zostala dodana.");
            }
        } while (wycieczkaOptional.isEmpty());

        System.out.println("Podaj nazwe atrakcji:");
        String nazwa = IKomenda.SCANNER.nextLine();

        System.out.println("Podaj opis atrakcji:");
        String opis = IKomenda.SCANNER.nextLine();

        Atrakcja atrakcja = Atrakcja.builder()
                .lokalizacja(lokalizacjaOptional.get())
                .wycieczka(wycieczkaOptional.get())
                .nazwa(nazwa)
                .opis(opis)
                .build();

        dao.insert(atrakcja);
    }
}
