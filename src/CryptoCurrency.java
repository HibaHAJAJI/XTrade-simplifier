public class CryptoCurrency extends Asset{

    public CryptoCurrency(String code, String nom, double prix) {
        super(code, nom, prix);
    }

    @Override
    public String getType(){
        return "Crypto";
    }
}
