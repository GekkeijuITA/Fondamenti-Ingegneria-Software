package videostore;

public class PrezzoBambini extends Prezzo{
    public int getCodicePrezzo() {
        return Film.BAMBINI;
    }

    @Override
    public double getAmmontare(int giorniNoleggio) {
        return giorniNoleggio > 3 ? 1.5 + (giorniNoleggio - 3) * 1.5 : 1.5;
    }
}
