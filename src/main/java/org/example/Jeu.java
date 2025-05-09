package org.example;

public class Jeu {
    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque banque) {
        this.banque = banque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé");
        }

        int mise = joueur.mise();
        
        try {
            // Débiter le joueur
            joueur.debiter(mise);
            
            // Encaisse la mise
            banque.crediter(mise);
            
            // Lancer les dés
            int resultat1 = de1.lancer();
            int resultat2 = de2.lancer();
            int somme = resultat1 + resultat2;
            
            // Vérifier si le joueur a gagné (somme = 7)
            if (somme == 7) {
                // Le joueur gagne deux fois sa mise
                int gain = mise * 2;
                joueur.crediter(gain);
                banque.debiter(gain);
                
                // Vérifier si la banque est encore solvable
                if (!banque.est_solvable()) {
                    fermer();
                }
            }
        } catch (DebitImpossibleException e) {
            // Le joueur est insolvable, on ne fait rien
        }
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
} 