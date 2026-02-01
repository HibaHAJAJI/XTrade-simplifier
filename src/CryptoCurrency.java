public class CryptoCurrency extends Asset{

    public CryptoCurrency(int code, String nom, double prix) {
        super(code, nom, prix);
    }

    @Override
    public String getType(){
        return "Crypto";
    }
}
