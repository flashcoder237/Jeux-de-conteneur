package essai1;

public class Coef {
	public indice indice_cour;
	public int val = 0;
	public indice indice_fin;

	Coef(int val, int i, int j) {
		this.indice_cour = new indice(i,j);
		this.val = val;
		this.indice_fin = this.indice_cour;
	}
	
	Coef(int val, indice x){
		new Coef(val, x.i, x.j);
	}
    
	Coef(int val ,indice indice_cour,indice indice_fin){
		new Coef(val, indice_cour);
		this.indice_fin = indice_fin;
	}
	public Coef() {

	}

}
