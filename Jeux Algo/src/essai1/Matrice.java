package essai1;

import java.util.Scanner;

public class Matrice {
	public Coef[][] M ; // tableau d'etats
	public int ligne = 0;
	public int col = 0;
	public Coef[] trace = new Coef[2];

	public Matrice(Coef[][] A, int ligne, int col) {
		this.ligne = ligne;
		this.col = col;
		// COPIE EN PROFFODEUR
		if(A != null) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++)
				this.M[i][j] = A[i][j];
		}
		}
	}

	public Matrice(int ligne, int col) {
		this.ligne = ligne;
		this.col = col;
		this.M = new Coef[ligne][col];
		Coef a = new Coef();
		for (int i = 0; i < this.ligne; i++) {
			for (int j = 0; j < this.col; j++)
				this.M[i][j] = a ;
		}
	}

	public Matrice() {
		// TODO Auto-generated constructor stub
	}

	public Matrice creer_matrice() {
		
		return this;
	}

	//ICI LE DEPLACEMENT MODIFI LA MATRICE
	public void deplacement(Coef a, Coef b) {
		Coef temp;
		int  taille_i = this.ligne,
				taille_j = this.col;
		if (this.deplacement_valide(b, a, taille_i, taille_j)) {
			temp = this.M[a.indice_cour.i][a.indice_cour.j];
			this.M[a.indice_cour.i][a.indice_cour.j] = this.M[b.indice_cour.i][b.indice_cour.j];
			this.M[b.indice_cour.i][b.indice_cour.j] = temp;
			this.trace[0] = b;
			this.trace[1] = a;
		}
	}

	//ICI LE DEPLACEMENT CREER UNE NOUVELLE MATRICE
	public Matrice deplacement1(Coef b, Coef a) {
		Matrice A = this.creer_matrice();
		Coef temp;
		int taille_i = A.ligne;
		int taille_j = A.col;
		if (A.deplacement_valide(b, a, taille_i, taille_j)) {
			temp = A.M[a.indice_cour.i][a.indice_cour.j];
			A.M[a.indice_cour.i][a.indice_cour.j] = A.M[b.indice_cour.i][b.indice_cour.j];
			A.M[b.indice_cour.i][b.indice_cour.j] = temp;
			A.trace[0] = b;
			A.trace[1] = a;
			return A;
		} else
			return null;
	}

	public boolean deplacement_valide(Coef b, Coef a, int taille_i, int taille_j) {
		boolean condition1 = a.indice_cour.i >= taille_i && a.indice_cour.j >= taille_j && b.indice_cour.i >= taille_i && b.indice_cour.j >= taille_j,
				condition2 = this.M[a.indice_cour.i][a.indice_cour.j].val != 0 && this.M[b.indice_cour.i][b.indice_cour.j].val != 0,
				condition3 = this.M[a.indice_cour.i][a.indice_cour.j].val == 0 && this.M[b.indice_cour.i][b.indice_cour.j].val == 0,
				condition4 = this.M[a.indice_cour.i - 1][a.indice_cour.j - 1].val != 0 && (a.indice_cour.i - 1) >= 1;
		boolean condition = condition1 || condition2 || condition3 || condition4;
		if (condition) {
			return false;
		}
		return true;

	}

	public int nbre_deplacement() {
		// fonction complexe
		return 0;
	}

	public void affiche() {
	if(this.M != null) {
		for (int i = 0; i < this.ligne; i++) {
			System.out.print("( ");
			for (int j = 0; j < this.col; j++)
				System.out.print(" " + this.M[i][j].val);
			System.out.println("  )");
		}
	}
	}

	public Matrice lecture() {
		Scanner sc = new Scanner(System.in);
		int temp;
		if (this.ligne > 0 && this.col > 0) {
			for (int i = 0; i < this.ligne; i++) {
				for (int j = 0; j < this.col; j++) {
					temp = sc.nextInt();
					if (temp < 0) {
						while (temp <= 0) {
							System.out.println("valeur non valide!");
							temp = sc.nextInt();
						}
					}
   try {
	              					this.M[i][j] = new Coef(temp, i, j);
   } 
   catch(NullPointerException e) {
	   System.out.println(e.getMessage());
	   System.out.println("yep");
   }
   finally {
	   
   }
				}

			}
			sc.close();
			return this;
		}
		sc.close();
		return null;
	}

	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("veuille entrer la taille de la plateforme portuere");
		System.out.print("nombre de ligne: ");
		a = sc.nextInt();
		System.out.println("nombre de colonne: ");
		b = sc.nextInt();
		Matrice M = new Matrice(a,b);
		try {
			
			M.lecture();
			M.affiche();
		} finally {
           sc.close();
		}
	}
}
