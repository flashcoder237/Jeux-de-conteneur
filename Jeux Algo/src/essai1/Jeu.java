package essai1;

public class Jeu {
    public Arbre arbre;
    private double succes = 0;
    public int niveau;
    
    public Jeu() {
    	Coef[][] var= this.arbre.noeud.M;
         var = new Coef[4][8];
         
         indice x_init = new indice(3,1);
         indice x_fin = new indice(4,6);
         var[3][1] = new Coef(3,x_init,x_fin);
       
          x_init = new indice(4,1);
          x_fin = new indice(3,6);
          var[3][1] = new Coef(1,x_init,x_fin);
          
          x_init = new indice(4,2);
          x_fin = new indice(4,2);
          var[3][1] = new Coef(2,x_init,x_fin);
          
          x_init = new indice(4,3);
          x_fin = new indice(4,7);
          var[3][1] = new Coef(4,x_init,x_fin);
          
          x_init = new indice(4,5);
          x_fin = new indice(4,1);
          var[3][1] = new Coef(5,x_init,x_fin);
          
          x_init = new indice(4,6);
          x_fin = new indice(3,7);
          var[3][1] = new Coef(6,x_init,x_fin);
          
          x_init = new indice(4,7);
          x_fin = new indice(3,1);
          var[3][1] = new Coef(8,x_init,x_fin);
          
          
       for(int i = 0; i < 4; i++) {
    	   for(int j = 0; j < 4; j++) {
    		   if(var[i][j].val == 0 ) {
    			   var[i][j] = new Coef(0,i,j);
    		   }
           } 
       }
   
       
    }
    
    
	public static void main(String[] args) {
		
 
	}

}
