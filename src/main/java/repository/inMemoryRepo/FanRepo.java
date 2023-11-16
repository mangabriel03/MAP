package repository.inMemoryRepo;

import domain.Fan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FanRepo {
    private final List<Fan> fani = new ArrayList<>();
    private int nextIdFan = 1;
    
    public Fan createFan(String nume, String prenume, LocalDate dataNasterii){
        Fan fan = new Fan(nextIdFan,nume,prenume,dataNasterii);
        fani.add(fan);
        nextIdFan++;
        return fan;
    }
    
    public Fan getFanById(int id){
        for(Fan f : fani){
            if(f.getIdFan()==id){
                return f;
            }
        }
        return null;
    }
    
    public List<Fan> getAllFani(){
        return this.fani;
    }
    
    public Fan updateFan(Fan fan){
        for(Fan f : fani){
            if(f.getIdFan()==fan.getIdFan()){
                return fan;
            }
        }
        return null;
    }
    
    public void removeFan(int id){
        Fan fan = getFanById(id);
        if(fan != null){
            fani.remove(fan);
            
        }
    }
}
