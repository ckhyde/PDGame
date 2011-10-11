/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

/**
 *
 * @author ckhyde
 */
public interface Player 
{
    
    String sGetID();
    
    //void makeMove(int iOppMove);
    void makeMove(int iOppMove);
    
    //void setScore(int iMyMove, int iOppMove, int iMyScore, int iOppScore);       
    void setScore(int iMyScore);   
    void setMove(int iMyMove);
    
    int iGetScore();
    int iGetTotalScore();
    int iGetMove();
    
    String toString();    
    
    
    
    //int makeMove();
    //void setScore(int myMove, int oppMove, int myScore, int oppScore, String oppID);
    
    
}
