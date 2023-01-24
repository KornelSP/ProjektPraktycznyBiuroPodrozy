package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Atrakcja;
import model.Lokalizacja;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class KomendaListaAtrakcjaWRegionie implements IKomenda {

    private DataAccessObject<Atrakcja> dao = new DataAccessObject<>();
    private DataAccessObject<Lokalizacja> daoLokalizacja = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista atrakcji w regionie";
    }

    @Override
    public void obsluga() {
        System.out.println("Wybierz lokalizacje z ponizszych, dla ktorej chcesz znalezc atrakcje:");
        daoLokalizacja.findAll(Lokalizacja.class).forEach(System.out::println);

        String lokalizacjaId = IKomenda.SCANNER.nextLine();
        Long idLokalizacji = Long.parseLong(lokalizacjaId);
        Optional<Lokalizacja> lokalizacjaOptional = daoLokalizacja.find(Lokalizacja.class, idLokalizacji);
        if (lokalizacjaOptional.isEmpty()) {
            System.err.println("Lokalizacja o podanym id nie istnieje, podaj poprawne id:");
            return;
        }

        List<Atrakcja> atrakcje = dao.findAll(Atrakcja.class);
        List<Atrakcja> atrakcjeWRegionie = atrakcje.stream()
                .filter(atrakcja -> Objects.equals(atrakcja.getLokalizacja().getId(), idLokalizacji))
                .toList();
        System.out.println("Atrakcje w wybranym regionie to:");
        System.out.println(atrakcjeWRegionie);

    }
}