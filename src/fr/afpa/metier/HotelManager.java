package fr.afpa.metier;

import java.util.Scanner;

import fr.afpa.beans.Chambre;

public class HotelManager {

    public HotelManager(){
        startProgram();
    }

    private void startProgram(){

        boolean stop = false;

        Scanner in = new Scanner(System.in);

        String entry = "";

            String listeChambresCsv[] = {"Type chambre;Taille;Vues;Occupation;tarif;Nombre de chambre;Options",
            "Chambre Vue Piscine;44 mètres carrés;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
            "Chambre Vue Jardin;44 mètres carrés;Jardin, Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
            "Chambre Vue Océan;44 mètres carrés;Partielle Océan et Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
            "Chambre vue imprenable sur l'océan;44 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
            "Suite CDA;82 mètres carrés;Océan et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
            "Suite Executive;140 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;550;5;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
            "Suite Ambassadeur;230 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;1650;7;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
            "Suite Royale;342 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;2400;4;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24"};
            
            String attribute = "";
            int start = 0;
            boolean stopCat=false;

            Chambre[] Hotel = new Chambre[65];

            int nbChambres = 0;

            String type = "";
            String taille = "";
            String vue = "";
            String occupation = "";
            int tarif = 0;
            int total = 0;

            // Boucle parcourant chaque itération du tableau CSV

            for(int i = 1; i<listeChambresCsv.length;i++){

                start=0;

                // Boucle parcourant la chambre à l'itération listeChambresCsv[i] j ne peut donc pas dépasser la taille de la chaine de caractère à cet emplacement

                for(int j=0;j<listeChambresCsv[i].length();j++){

                    // stop cat est réinitialisé pour permettre a la boucle récupérant l'attribut en cours de se relancer ( on reset aussi attribute )
                    
                    stopCat=false;

                    attribute="";

                    // Si le caractère est un ; on ne le met pas dans l'entrée

                    if(listeChambresCsv[i].charAt(j)!=';'){

                        entry = entry + listeChambresCsv[i].charAt(j);

                    }

                    // Si le caractère est un ; ou que l'on a atteint la fin de la chaine
                    
                    if(listeChambresCsv[i].charAt(j)==';' || j == listeChambresCsv[i].length()-1){

                        // Boucle parcourant la première itération de listeChambresCsv afin de récupérer la propriété actuelle que nous parcourons

                        for(int k=start; !stopCat ;k++){
                            if(listeChambresCsv[0].charAt(k)!=';' && k<listeChambresCsv[0].length()-1){
                                attribute = attribute + listeChambresCsv[0].charAt(k);
                                start++;
                            }
                            else{
                                stopCat=true;
                                start++;
                            }
                        }

                        // Choix de l'attribut en fonction de l'entrée récupérée

                        switch(attribute){
                            case "Type chambre":
                                type = entry;
                                break;
                            case "Taille":
                                taille = entry;
                                break;
                            case "Vues":
                                vue = entry;
                                break;
                            case "Occupation":
                                occupation = entry;
                                break;
                            case "tarif":
                                tarif = Integer.parseInt(entry);
                                break;
                            case "Nombre de chambre":
                                nbChambres = Integer.parseInt(entry);
                                break;
                            case "Options":
                                System.out.println("Option Attribut");
                                break;
                        }

                        entry="";

                    }
                    
                } // Fin du parcours du CSV

                // Création de chaque chambre et insertion de celles ci dans le tableau d'objets chambre

                if(!type.equals("") && !taille.equals("") && !vue.equals("") && !occupation.equals("") && tarif !=0 && nbChambres>0){

                    for(; nbChambres > 0 ;){

                        Hotel[total] = new Chambre(0,type,taille,vue,occupation,tarif,null);

                        nbChambres--;
                        
                        System.out.println(Hotel[total].toString());

                        total++;
                        
                    
                    }
                    
                    

                }

            }
        
        while(stop==false){

            System.out.println("\n\n+---------------------- -! WELCOME TO STEPHANE PLAZA HOTEL !- ----------------------+\n\n  [A]  Etat de L'Hotel");

            System.out.println("  [B]  Afficher le nombre de chambres chambres reservees");

            System.out.println("  [C]  Afficher le nombre de chambres chambres libres");

            System.out.println("  [D]  Afficher le numero de la premiere chambre libre");

            System.out.println("  [E]  Afficher le numero de la derniere chambre libre");

            System.out.println("  [F]  Reserver une chambre ( ADMIN VISIBLE ONLY )");
            
            System.out.println("  [G]  Liberer une chambre ( ADMIN VISIBLE ONLY )");

            System.out.println("  [H]  Modifier une reservation ( ADMIN VISIBLE ONLY )");

            System.out.println("  [I]  Annuler une reservation ( ADMIN VISIBLE ONLY )");

            System.out.println("  [Q]  Quitter l'interface\n\n+---------------------- -! WELCOME TO STEPHANE PLAZA HOTEL !- ----------------------+\n\n");

            String choix = in.next();

            switch(choix.toUpperCase()){
                case "A":
                    break;
                case "B":
                    break;
                case "C":
                    break;
                case "D":
                    break;
                case "E":
                    break;
                case "Q":
                    System.out.println("\nMerci d'avoir utilis\u00e9 l'application Stephane Plaza Hotel !");
                    System.out.println("*Fin de transmission*\n");
                    System.exit(0);
                    break;
            }
        }
        in.close();
    }
    
}