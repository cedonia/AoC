package AoC2022;

import Day

public class Day2: Day() {

    override fun problem1() {
        val lines = readIn("./src/main/kotlin/AoC2022/Data/Day2");

        var score = 0;

        for(line in lines) {
            val entries = line.split(" ");

            val tempScore = calcScoreForRound(entries);
            score+= tempScore;
        }

        println(score);

    }

    fun calcScoreForRound(entries: List<String>): Int {
        var score = 0;
        var iPlay: String;
        var theyPlay: String;

        //Calc the score for what I played
        if(entries[1].equals("Y")) {
            score+=2;
            iPlay = "Paper";
        }
        else if(entries[1].equals("X")) {
            score+=1;
            iPlay="Rock";
        }
        else {
            score+=3;
            iPlay = "Scissors";
        }

        //Calc the score including what other person plays
        if(entries[0].equals("A")) theyPlay = "Rock";
        else if(entries[0].equals("B")) theyPlay = "Paper";
        else theyPlay = "Scissors";

        if(iPlay.equals(theyPlay)) return score + 3;

        if(iWin(iPlay, theyPlay)) return score + 6;
        return score;

    }

    fun iWin(iPlay: String, theyPlay: String): Boolean {
        if(iPlay.equals("Rock")) return theyPlay.equals("Scissors");
        if(iPlay.equals("Paper")) return theyPlay.equals("Rock");
        else return theyPlay.equals("Paper");
    }

    override fun problem2() {
        val lines = readIn("./src/main/kotlin/AoC2022/Data/Day2");

        var score = 0;

        for(line in lines) {
            val entries = line.split(" ");

            val tempScore = calcScoreForRound2(entries);
            score+= tempScore;
        }

        println(score);

    }

    fun calcScoreForRound2(entries: List<String>): Int {
        var score = 0;
        var iPlay: String;
        var theyPlay: String;


        if(entries[0].equals("A")) theyPlay = "Rock";
        else if(entries[0].equals("B")) theyPlay = "Paper";
        else theyPlay = "Scissors";

        if(entries[1].equals("Y")) {
            iPlay = theyPlay;
            score+=3;
        }

        else if(entries[1].equals("X")) {
            if(theyPlay.equals("Rock")) iPlay = "Scissors";
            else if(theyPlay.equals("Paper")) iPlay = "Rock";
            else iPlay = "Paper";
        }

        else {
            if(theyPlay.equals("Rock")) iPlay = "Paper";
            else if(theyPlay.equals("Paper")) iPlay = "Scissors";
            else iPlay = "Rock";

            score+=6;
        }

        if(iPlay.equals("Rock")) score+=1;
        else if(iPlay.equals("Paper")) score+=2;
        else score+=3;

        return score;

    }

}
