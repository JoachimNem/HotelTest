package fr.afpa.beans;

public class Chambre{

    private int id;
    private String type;
    private String taille;
    private String vue;
    private String occupation;
    private int tarif;

    public static int totalChambres = 0;

    private Options options;

    // CONSTRUCTEUR 

    public Chambre(){
        
    }

    public Chambre(int id,String type,String taille,String vue,String occupation,int tarif, Options options){
        this.id=totalChambres;
        this.type=type;
        this.taille=taille;
        this.vue=vue;
        this.occupation=occupation;
        this.tarif=tarif;

        this.options=options;
        totalChambres++;
    }

    // GETTERS

    public int getId(){
        return id;
    }

    public String getType(){
        return type;
    }
    
    public String getTaille(){
        return taille;
    }

    public String getVue(){
        return vue;
    }

    public String getOccupation(){
        return occupation;
    }

    public int getTarif(){
        return tarif;
    }

    public int getTotalChambres(){
        return totalChambres;
    }

    // SETTERS

    public int setId(int id){
        this.id=id;
        return id;
    }

    public String getType(String type){
        this.type=type;
        return type;
    }
    
    public String getTaille(String taille){
        this.taille=taille;
        return taille;
    }

    public String getVue(String vue){
        this.vue=vue;
        return vue;
    }

    public String getOccupation(String occupation){
        this.occupation=occupation;
        return occupation;
    }

    public int getTarif(int tarif){
        this.tarif=tarif;
        return tarif;
    }

    public static int setTotalChambres(int totalChambres){
        Chambre.totalChambres=totalChambres;
        return totalChambres;
    }

    public String toString(){
        return id + "\n" + type + "\n" + taille + "\n" + vue + "\n" + occupation + "\n" + tarif + " euros\n" + options + "\n";
    }

}
