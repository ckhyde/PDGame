/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

import java.io.*;

/**
 *
 * @author ckhyde
 */
public class HumanPlayer extends PDPlayer
{
    //int oppLastMove=GameMove.COOPERATE;
    int iHumanMove;
    
    public HumanPlayer()
    {                          
        sSelfID = "Human Player";
        
        System.out.println("HumanPlayer Constructor");      
    }        
    
    
    public void iGetInput(int iOppMove) throws Exception
    {        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        
        System.out.println("Your opponent's last move is (0 for Cooperate, 1 for Deffect)" + iOppMove);
        
        System.out.print("Please enter your move: ");
        iHumanMove =  Integer.parseInt(reader.readLine()); 
        
        setMove(iHumanMove);
        
        //return iHumanMove;
    }        
        
                   
    //public void makeMove(int iOppMove) 
    public void makeMove(int iOppMove) 
    {         
        //int iTempHumanMove;
            
        
        // At the first round arbitrarily choose action
        
        //int iHumanMove = Integer.parseInt(console.readLine("Your move? (0 for Cooperate, 1 for Deffect)"));        
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        
        //iHumanMove =  Integer.parseInt(reader.readLine()); 
        
        //return -1;
        
        //setMove(iTempHumanMove);
        
        //return iHumanMove; 
    }
    
}
