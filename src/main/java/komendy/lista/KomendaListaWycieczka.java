package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Atrakcja;
import model.Hotel;
import model.Wycieczka;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class KomendaListaWycieczka implements IKomenda {

    private DataAccessObject<Wycieczka> dao = new DataAccessObject<>();
    private DataAccessObject<Atrakcja> daoAtrakcja = new DataAccessObject<>();
    private DataAccessObject<Hotel> daoHotel = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista wycieczek";
    }

    @Override
    public void obsluga() {
        dao.findAll(Wycieczka.class).forEach(System.out::println);
        System.out.println("Jesli chcesz poznac atrakcje i hotele zawarte w konkretnej wycieczce- wpisz jej numer id. \nJesli nie- nacisnij enter.");

        String wycieczkaId = IKomenda.SCANNER.nextLine();
        if (wycieczkaId.equals("")){
            return;
        }
        Long idWycieczka = Long.parseLong(wycieczkaId);
        Optional<Wycieczka> wycieczkaOptional = dao.find(Wycieczka.class, idWycieczka);

        if (wycieczkaOptional.isEmpty()) {
            System.err.println("wycieczka o podanym id nie istnieje");

        } else {

            List<Atrakcja> atrakcje = daoAtrakcja.findAll(Atrakcja.class);
            List<Atrakcja> atrakcjeNaWycieczce = atrakcje.stream()
                    .filter(atrakcja -> Objects.equals(atrakcja.getLokalizacja().getId(), idWycieczka))
                    .toList();
            System.out.println("Atrakcje na wybranej wycieczce to:");
            System.out.println(atrakcjeNaWycieczce);

            List<Hotel> hotele = daoHotel.findAll(Hotel.class);
            List<Hotel> hoteleNaWycieczce = hotele.stream()
                    .filter(hotel -> Objects.equals(hotel.getLokalizacja().getId(), idWycieczka))
                    .toList();
            System.out.println("Hotele na wybranej wycieczce to:");
            System.out.println(hoteleNaWycieczce);
        }
    }
}