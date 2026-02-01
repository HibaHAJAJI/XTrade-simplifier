public class Stock extends Asset{


    public Stock(int code, String nom, double prix) {
        super(code, nom, prix);
    }

   @Override
   public String getType(){
        return "Stock";
   }

}
