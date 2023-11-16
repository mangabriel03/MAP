package repository.inMemoryRepo;

import domain.Piesa;
import domain.Trupa;
import domain.Turneu;

import java.util.ArrayList;
import java.util.List;

public class PieseRepo {
    private final List<Piesa> piese = new ArrayList<>();
    private int nextIdPiesa = 1;


    public Piesa createPiesa(String titlu, float durata){
        Piesa piesa = new Piesa(nextIdPiesa,titlu,durata);
        nextIdPiesa++;
        piese.add(piesa);
        return piesa;
    }


    public Piesa getPiesaById(int id){
        for(Piesa p : piese){
            if(p.getIdPiesa()==id){
                return p;
            }
        }
        return null;
    }

    public List<Piesa> getAllPiese(){
        return this.piese;
    }

    public Piesa updatePiesa(Piesa piesa){
        for(Piesa p : piese){
            if(p.getIdPiesa()==piesa.getIdPiesa()){
                p.setTitlu(piesa.getTitlu());
                p.setDurata(piesa.getDurata());
            }
        }
        return piesa;
    }

    public void removePiesa(int id){
        Piesa piesaToRemove = getPiesaById(id);
        if (piesaToRemove != null) {
            piese.remove(piesaToRemove);
        }
    }



}
