//package domain;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//@Entity
//public class MelodieFactory implements Melodie{
//    @Id
//    private Long id;
//
//    public Melodie createMelodie(String melodieType, String nume) {
//        switch (melodieType.toUpperCase()) {
//            case "SINGLE":
//                return new Single(nume);
//            case "COVER":
//                return new Cover(nume);
//            case "ORIGINAL":
//                return new Original(nume);
//            default:
//                throw new IllegalArgumentException("Tip de melodie necunoscut: " + melodieType);
//        }
//    }
//
//    @Override
//    public String afiseazaDetalii() {
//        return null;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
