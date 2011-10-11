/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

import java.util.ArrayList;
import java.io.*;

import edu.gmu.css.css605Fall2011.KMeans.*;
import java.util.LinkedList;

/**
 *
 * @author ckhyde
 */
public class PDGame 
{    
    private static final int ROUNDS = 11;    
    ArrayList<Player> players;
                        
   
    public void setupTournament() 
    {
        players = new ArrayList<Player>();
        
        players.add(new RandomPlayer());
        players.add(new TitPlayer());        
        players.add(new OptTitPlayer());     
        players.add(new PessTitPlayer());     
        players.add(new CoopPlayer());     
        players.add(new DefPlayer());     
        //players.add(new HumanPlayer());    
    }
    
    public void roundRobin() throws Exception
    {
        Judge PDjudge = new Judge();
        BufferedWriter bwMatch = new BufferedWriter (new FileWriter("Match scores.csv"));
        
        for (Player p1: players)         
        {            
            for (Player p2: players) 
            {
                if (players.indexOf(p1) >= players.indexOf(p2)) 
                    continue;
                //if (p1==p2) continue;

                int iTempP1TotalScore = p1.iGetTotalScore();
                int iTempP2TotalScore = p2.iGetTotalScore();
                
                PDjudge.playMatch(p1, p2, ROUNDS);
                
                System.out.println(" ");
                
                iTempP1TotalScore = p1.iGetTotalScore() - iTempP1TotalScore;
                iTempP2TotalScore = p2.iGetTotalScore() - iTempP2TotalScore;
                
                String sMatchResults = p1.sGetID() + "," + p2.sGetID() + "," + iTempP1TotalScore + "," + iTempP2TotalScore;
                bwMatch.write(sMatchResults, 0, sMatchResults.length());
                bwMatch.write("\n");
                bwMatch.flush();    
                
                p1.setMove(GameMove.NOMOVE);
                p2.setMove(GameMove.NOMOVE);
            }
        }
    }    
    
    public void printResults() throws Exception
    {
        //BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedWriter bw = new BufferedWriter (new FileWriter("Final total scores.txt"));
        
        System.out.println("RESULTS>>>>>>>");
        
        for (Player p : players) 
        {            
            System.out.println(p.toString());
            
            bw.write(p.toString(), 0, p.toString().length());
            bw.write("\n");
            bw.flush();
        }
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
  
        
        PDGame gameStarter = new PDGame();

        gameStarter.setupTournament();
        gameStarter.roundRobin();
        gameStarter.printResults();  
        
        KMeans k = new KMeans();
        k.init(6);
        //k.reassignments();
        k.run();
    }
}
