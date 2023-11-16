package domain;

public class AdaugaAdaosPretStrategy implements PretStrategy {
    private float procentAdaos;

    public AdaugaAdaosPretStrategy(float procentAdaos) {
        this.procentAdaos = procentAdaos;
    }

    @Override
    public float calculeazaPret(float pret) {
        return pret + (pret * procentAdaos / 100);
    }
}
