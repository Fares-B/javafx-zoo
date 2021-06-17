package fr.fares.zoo;

public enum Animal
{
    // Il faut appeler l'un des constructeurs déclarés :
    SINGE("singe", false, Environnement.CAGE),
    PANDA("panda", false, Environnement.CAGE),
    TIGRE("tigre", true, Environnement.CAGE),
    LION("lion", true, Environnement.CAGE),
    GIRAFE("girafe", false, Environnement.ENCLOS),
    DAUPHIN("Dauphin", true, Environnement.AQUARIUM),
    HIPPOPOTAME("hippopotame", false, Environnement.ETANG),
    PELICAN("pélican", false, Environnement.ETANG); // <- NB: le point-virgule pour mettre fin à la liste des constantes !

    // Membres :
    private final String nom;
    private final Environnement environnement;
    private final boolean solo;

    Animal(String nom, boolean solo, Environnement environnement)
    {
        this.nom = nom;
        this.solo = solo;
        this.environnement = environnement;
    }

    public String getNom(){ return this.nom; }
    public Environnement getEnvironnement(){ return this.environnement; }
    public boolean isSolo(){ return this.solo; }
    public String getDescription() {
        return "espèce='"+ nom + "'";
    }
};