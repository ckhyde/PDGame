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
public class Judge 
{    
   public Judge()
   {   
       // Specify the Default Constructor
   }
    
   //public Judge(Player p1, Player p2, int rounds) 
   public void playMatch(Player p1, Player p2, int rounds) throws Exception
   {
       for (int i=0; i < rounds; i++) 
       { 
           System.out.println("Round" + i + ": ");
           
           playRound(p1, p2);
           
           System.out.println(p1.sGetID() + " scored " + p1.iGetScore()+ ", " + p2.sGetID() + " scored " + p2.iGetScore());
           System.out.println(p1.sGetID() + "'s total score = " + p1.iGetTotalScore()+ ", " + p2.sGetID() + "'s total score = " + p2.iGetTotalScore());
       }
   }
      
   
   public void playRound(Player p1, Player p2) throws Exception
   {
       int iTempP1Move, iTempP2Move; 
       
       // get the opponent's last move (for the Tit-for-Tat player and its variant)
       iTempP1Move = p1.iGetMove();
       //iTempP1Move = 1;
       iTempP2Move = p2.iGetMove(); 
        //System.out.println(m1);
              
       if (p1.sGetID().equals("Human Player"))           
           //iTempP1Move = ((HumanPlayer)p1).iGetInput(iTempP2Move);
           ((HumanPlayer)p1).iGetInput(iTempP2Move);
           //System.out.println("Test");
       else
           //iTempP1Move = p1.makeMove(iTempP2Move);
           p1.makeMove(iTempP2Move);
       
       //System.out.println(m1);
       if (p2.sGetID().equals("Human Player"))
           //iTempP2Move = ((HumanPlayer)p2).iGetInput(iTempP1Move);
           ((HumanPlayer)p2).iGetInput(iTempP1Move);
           //System.out.println("Test");
       else
           //iTempP2Move = p2.makeMove(iTempP1Move);
           p2.makeMove(iTempP1Move);
                  
       iTempP1Move = p1.iGetMove();
       iTempP2Move = p2.iGetMove();
       
       // Move: 0 for cooperation, 1 for defect
       // If both cooperates
       if ((iTempP1Move == GameMove.COOPERATE) && (iTempP2Move == GameMove.COOPERATE))
       {          
          p1.setScore(3);
          p2.setScore(3);
       } 
       // If Player 1 cooperates while Player 2 defects
       else if ((iTempP1Move == GameMove.COOPERATE) && (iTempP2Move == GameMove.DEFECT))
       {         
          p1.setScore(0);
          p2.setScore(5);
       } 
       // If Player 1 defects while Player 2 cooperates
       else if ((iTempP1Move == GameMove.DEFECT) && (iTempP2Move == GameMove.COOPERATE)) 
       {          
          p1.setScore(5);
          p2.setScore(0);
       }
       // If both defect
       else
       {
          p1.setScore(1);
          p2.setScore(1);
       }
       
           
   } 

}
