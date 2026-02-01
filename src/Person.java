public class Person {
    public int getId() {
        return id;
    }
// getters and setters
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private int id;
    private String nom;
    // Constracter
    public Person(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
