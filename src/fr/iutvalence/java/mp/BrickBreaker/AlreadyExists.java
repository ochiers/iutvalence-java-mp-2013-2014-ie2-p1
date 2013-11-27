package fr.iutvalence.java.mp.BrickBreaker;

public class AlreadyExists extends Exception
{

    AlreadyExists(){
        System.err.println("Le joueur est déjà éxistant.");
    }
}
