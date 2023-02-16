package com.dkit.gd2.johnloane.collectionsrevision;

/* Dundalk has a GAA club and a Soccer club. The list of names below shows the names of players for each sport. Players can play either one or both sports.

Choose an appropriate Collection that will allow you to easily implement the questions below.
a.	Display all players who play both games.
b.	Display players who play GAA but not Soccer
c.	Display players who play Soccer but not GAA
d.	Display players who play one or both sports

GAA	Soccer
Tom	Tom
Ciara	Ciara
Conor	James
Aoife	Abby */

import java.util.HashSet;
import java.util.Set;

public class SportsClubs
{
    private Set<String> gaaPlayers;
    private Set<String> soccerPlayers;

    public SportsClubs()
    {
        this.gaaPlayers = new HashSet<>();
        this.soccerPlayers = new HashSet<>();
    }

    public Set<String> getGaaPlayers()
    {
        return gaaPlayers;
    }

    public Set<String> getSoccerPlayers()
    {
        return soccerPlayers;
    }

    public static void main(String[] args)
    {
        SportsClubs sc = new SportsClubs();
        populateSportsPlayers(sc);
        System.out.println("a.	Display all players who play both games.");
        sc.gaaPlayers.retainAll(sc.soccerPlayers);
        System.out.println(sc.gaaPlayers);
        populateSportsPlayers(sc);
        System.out.println("b.	Display players who play GAA but not Soccer");
        sc.gaaPlayers.removeAll(sc.soccerPlayers);
        System.out.println(sc.gaaPlayers);
        populateSportsPlayers(sc);
        System.out.println("c.	Display players who play Soccer but not GAA");
        sc.soccerPlayers.removeAll(sc.gaaPlayers);
        System.out.println(sc.soccerPlayers);
        populateSportsPlayers(sc);
        System.out.println("d.	Display players who play one or both sports");
        sc.gaaPlayers.addAll(sc.soccerPlayers);
        System.out.println(sc.gaaPlayers);
    }

    private static void populateSportsPlayers(SportsClubs sc)
    {
        sc.gaaPlayers.add("Tom");
        sc.gaaPlayers.add("Ciara");
        sc.gaaPlayers.add("Conor");
        sc.gaaPlayers.add("Aoife");
        sc.soccerPlayers.add("Tom");
        sc.soccerPlayers.add("Ciara");
        sc.soccerPlayers.add("James");
        sc.soccerPlayers.add("Abby");
    }
}
