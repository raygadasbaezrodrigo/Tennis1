/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ico.fes.is;

/**
 *
 * @author YO
 */
public class tennis {

	private int puntuacion1 = 0;
	private int puntuacion2 = 0;
        private String jugador1;
	private String jugador2;
	
	
	public tennis(String nombre1, String nombre2) {
		this.jugador1 = nombre1;
		this.jugador2 = nombre2;
	}

	public String getScore() {

		if (Ganador()) {
                    return jugadorMayorPuntaje() + " gana";
                        
		}
		
		if (Ventaja()) { 
			return "Ventaja: " + jugadorMayorPuntaje(); 
		}
		
		if (Deuce())
			return "Deuce";
		
		if(puntuacion1 == puntuacion2) {
			return "todos en " + translateScore(puntuacion1) ;
		}
		
		return translateScore(puntuacion1) + "," + translateScore(puntuacion2);
	}

	private boolean Deuce() {
		return puntuacion1 >= 3 && puntuacion2 == puntuacion1;
	}
	
	private String jugadorMayorPuntaje() {
		if (puntuacion1 > puntuacion2) {
			return jugador1;
		} else {
			return jugador2;
		}
	}
	
	private boolean Ganador() {
		if(puntuacion2 >= 4 && puntuacion2 >= puntuacion1 + 2 )
			return true;
		if(puntuacion1 >= 4 && puntuacion1 >= puntuacion2 + 2)
			return true;
		return false;
	}
	
	private boolean Ventaja() {
		if (puntuacion2 >= 4 && puntuacion2 == puntuacion1 + 1)
			return true;
		if (puntuacion1 >= 4 && puntuacion1 == puntuacion2 + 1)
			return true;
		
		return false;

	}

	public void playerOneScores() {
		puntuacion1++;
	}

	public void playerTwoScores() {
		puntuacion2++;
	}
	
	private String translateScore(int puntuacion) {
		switch (puntuacion) {
		case 3:
			return "cuarenta";
		case 2:
			return "treinta";
		case 1: 
			return "quince";
		case 0:
			return "amor";
		}
		throw new IllegalArgumentException("Puntuacion ilegal: " + puntuacion);
	}
    
}