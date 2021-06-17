package fr.fares.zoo;

public enum Environnement {
    CAGE("cage", 10),
    AQUARIUM("aquarium", 100),
    ETANG("étang", 50),
    ENCLOS("enclos", 20);

    private String nom;
    private int place;
    Environnement(String nom, int place) {
        this.nom = nom;
        this.place = place;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPlace() {
        return this.place;
    }

    public String getDescription() {
        return "environnement='" + nom + "', place='" + place + "'";
    }
}
