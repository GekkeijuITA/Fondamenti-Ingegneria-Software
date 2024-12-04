package videostore;

public class PrezzoRegolare extends Prezzo{
    public int getCodicePrezzo() {
        return Film.REGOLARE;
    }

    @Override
    public double getAmmontare(int giorniNoleggio) {
        return giorniNoleggio > 2 ? 2 + (giorniNoleggio - 2) * 1.5 : 2;
    }
}
