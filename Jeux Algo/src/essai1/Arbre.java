package essai1;

public class Arbre {
	public Matrice noeud;
	public Arbre[] Nr;// noeuds resultant
	public int indice = 0; // indice libre
	public int proffondeur = 0;
	public static int Ns = 0;// nombres de noeuds
	public int Nf = 0;// nombres de noeuds resultant

	Arbre(Matrice noeud) {
		this.noeud = noeud;
		this.proffondeur++;
	}

	public void insert(Matrice M, int proffondeur) {
		Arbre noeud_sui = this.Nr[0];
		for (int i = 1; i <= proffondeur; i++) {
			noeud_sui = noeud_sui.Nr[0];
		}
		noeud_sui.Nr[noeud_sui.indice].noeud = M;
		noeud_sui.indice++;

	}
	
	public Arbre Arbre_jeu() {
		return null;
	}
	public boolean est_vide() {
		return false;
		
	}
}
