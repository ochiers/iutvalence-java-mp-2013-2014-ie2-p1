package fr.iutvalence.java.mp.BrickBreaker;

public class ImpossibleDataAccess extends Exception
{
    ImpossibleDataAccess(){
        System.err.println("On ne peut pas accéder au fichier des joueurs.");     
    }

}
