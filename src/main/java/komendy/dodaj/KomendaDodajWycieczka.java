package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Wycieczka;

public class KomendaDodajWycieczka implements IKomenda {

    private DataAccessObject<Wycieczka> dao = new DataAccessObject<>();
//    private DataAccessObject<Atrakcja> daoAtrakcja = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj wycieczke";
    }

    @Override
    public void obsluga() {
//        System.out.println("Dodaj id atrakcji z dostepnych ponizej:");
//        daoAtrakcja.findAll(Atrakcja.class).forEach(System.out::println);
//
//        Optional<Atrakcja> atrakcjaOptional;
//        String idAtrakcjiString = "";
//        Set<Atrakcja> setAtrakcji = HashSet.newHashSet(5);
//
//        do {
//            idAtrakcjiString = IKomenda.SCANNER.nextLine();
//            Long idAtrakcji = Long.parseLong(idAtrakcjiString);
//            atrakcjaOptional = daoAtrakcja.find(Atrakcja.class, idAtrakcji);
//
//            if (atrakcjaOptional.isEmpty() && !(idAtrakcjiString.equals("0"))) {
//                System.err.println("Atrakcja o podanym id nie istnieje, podaj poprawne id:");
//            } else if (!(idAtrakcjiString.equals("0"))) {
//                setAtrakcji.add(atrakcjaOptional.get());
//                System.out.println("Atrakcja dodana, dodaj kolejna lub wpisz \"0\"");
//            }
//        } while (!(idAtrakcjiString.equals("0")));

        System.out.println("Podaj nazwe wycieczki:");
        String nazwa = IKomenda.SCANNER.nextLine();

        System.out.println("Podaj opis wycieczki:");
        String opis = IKomenda.SCANNER.nextLine();

        Wycieczka wycieczka = Wycieczka.builder()
                .nazwa(nazwa)
                .opis(opis)
//                .atrakcje(setAtrakcji)
                .build();

        dao.insert(wycieczka);
    }
}