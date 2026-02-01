public abstract class Asset {
    private int code;
    private String nom;
    private double prix;



    public  abstract String getType();
    public  double CalculerValeur(double quantite){
        return quantite*prix;
    }

    public Asset(int code, String nom, double prix) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
    }

 @Override
public boolean equals(Object o) {
     if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

         Asset actif = (Asset) o;
         return code == actif.code;

 }
@Override
public int hashCode(){
        return Integer.hashCode(code);
}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }




}
