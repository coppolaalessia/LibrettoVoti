package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	 private List<Voto> voti;
	 
	 public Libretto() {
		 this.voti=new ArrayList<Voto>();
	 }
	
	 public void add(Voto v) {
		 this.voti.add(v);
	 }
	 
	 public Libretto filtraPunti(int punti) {
		 // creo un altro libretto contenente solo gli esami aventi il punteggio inserito come paramentro
		 Libretto result =new Libretto();
		 for(Voto v : this.voti){
			 if(v.getPunti()==punti)
				 result.add(v);
		 }
		 return result;
	 }
	 
	 //creo la documntazione per la funzione
	 
	 /**
	  * Restituisce il punteggio ottenuto all'esame di cui specifico il nome
	  * @param nome Nome dell'esame
	  * @return punteggio numerico, oppure {@code null} se l'esame non esiste
	  */
	 public Integer puntiEsame(String nome) { // metto come valore di ritorno Integer così posso ritornare anche null
		 									  //(mentre se mettessi int non potrei farlo, poichè un Integer può essere null, mentre un int no)
		 for(Voto v : this.voti) {
			 if(v.getNome().equals(nome))
				 return v.getPunti();
		 }
		 // return -1;          //
		return null;
		//throw new IllegalArgumentException ("Corso non trovato"); // oppure posso generare un'eccezione (posso farlo anche con un try-catch)
		
	 }
	 
	 public boolean isDuplicato(Voto v) {
		 for(Voto v1: this.voti) {
			// if(v1.getNome().equals(v.getNome()) && v1.getPunti()== v.getPunti()) ---> è meglio delegare alla classe Voto
			 if(v1.equals(v)) 	// doto la classe Voto di un metodo equals()
				 return true;
		 }
		 return false;
	 }
	 
	 public boolean isConflitto(Voto v) {
		 Integer punti= this.puntiEsame(v.getNome());
		 
		 if (punti!=null && punti==v.getPunti())
			 return true;
		 else 
			 return false;
	 }
	 
	 public String toString() {
		 return this.voti.toString(); // voti è un ArrayList che sa come stamparsi, ma la classe Voto no e devo dotarlo di una toString()
	 }
}
