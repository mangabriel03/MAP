package domain;

public class AplicaDiscountPretStrategy implements PretStrategy {
    private float procentDiscount;

    public AplicaDiscountPretStrategy(float procentDiscount) {
        this.procentDiscount = procentDiscount;
    }

    @Override
    public float calculeazaPret(float pret) {
        return pret - (pret * procentDiscount / 100);
    }
}
