/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ico.fes.is.tennis;

/**
 *
 * @author YO
 */
public class TennisTest {

    //Nueva objeto Juego
    tennis juego = new tennis("Marcelo", "Jesus");
    
    private void Puntuacion(int marcador1, int marcador2){
        for (int i=0; i<marcador1; i++){
            juego.playerOneScores();
        }
        for (int i=0; i<marcador2; i++){
            juego.playerTwoScores();
        }     
    }
   
    
    @Test
    public void TodosEnCero(){
        Puntuacion(0, 0);
        String puntuacion = juego.getScore();
        assertEquals("todos en amor", puntuacion);
    }
    
    @Test
    public void TodosEnQuince(){   
        Puntuacion(1, 1);
        
        String puntuacion = juego.getScore();
        assertEquals("todos en quince", puntuacion);
        
    }
    
    @Test
    public void TodosEnTreinta(){
        Puntuacion(2,2);
        String puntuacion = juego.getScore();
        assertEquals("todos en treinta", puntuacion);    
    }
   
    //Si un jugadoro tiene una puntuacion igual o mayor a 4 y es mayor o igual a
    //a la del oponente al sumarle 2, entonces gana 
    @Test
    public void JesusGana(){
        Puntuacion(0, 4);
        String marcador = juego.getScore();
        assertEquals("Jesus gana", marcador);
    }
    
    
    @Test 
    public void MarceloGana(){
        Puntuacion (4, 2);
        String marcador = juego.getScore();
        assertEquals("Marcelo gana", marcador);
    }
    
    //Puntuaciones iguales o mayore a 3 es empate //
    @Test
    public void Dedude(){
        Puntuacion (5,5);
        String marcador = juego.getScore();
        assertEquals("Deuce", marcador);
    }  
    
    @Test
    public void MarceloTieneVentaja(){
        Puntuacion(4, 3);
        String marcador = juego.getScore();
        assertEquals("Ventaja: Marcelo", marcador);
        
    }
    
    @Test
    public void JesusTieneVentaja(){
        Puntuacion(3, 4);
        String marcador = juego.getScore();
        assertEquals("Ventaja: Jesus", marcador);   
    }
}
