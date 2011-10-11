/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

/**
 *
 * @author ckhyde
 */
public abstract class PDPlayer implements Player 
{
    String sSelfID = "";
    
    private int iSelfScore;
    private int iTotalSelfScore;
    private int iSelfMove;    
    
    public PDPlayer()
    {        
        sSelfID = "Naive Player";        
        
        iSelfScore = 0;
        iTotalSelfScore = 0; 
        iSelfMove = GameMove.NOMOVE;
      
        System.out.println("PDPlayer Constructor");
    }        
    
    public void setID(String id) 
    {
        sSelfID = id;
    }   
    
    public String sGetID() 
    {
        return(sSelfID);
    }
    
    //public void makeMove(int iOppMove) 
    //{}
    
    //public void setScore(int iMyMove, int iOppMove, int iMyScore, int iOppScore) 
    public void setScore(int iMyScore) 
    {
        iSelfScore = iMyScore;
        iTotalSelfScore += iMyScore; 
        
        //System.out.println("Plaer A score " + String.valueOf(iMyScore)+ ", Player B Score" + String.valueOf(iOppScore));
    }
    
    /*
    public void setScore(int myMove, int oppMove, int myScore, int oppScore, String oppID) {
       totalScore+=myScore;
       System.out.println("Score"+myScore+" over "+oppScore+" My total: "+totalScore);
    } 
     * 
     */
    
    public void setMove(int iMyMove)
    {
        iSelfMove = iMyMove;
    }
    
    public int iGetScore()
    {
        return iSelfScore;
    }
    
    public int iGetTotalScore()
    {
        return iTotalSelfScore;
    }    
    
    public int iGetMove()
    {               
        return iSelfMove;
    }
            

    public String toString() {
        return(sSelfID + " earned "+ iTotalSelfScore);
    }    
}    
