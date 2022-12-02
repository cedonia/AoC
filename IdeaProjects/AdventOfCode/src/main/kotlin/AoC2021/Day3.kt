package AoC2021;

import Day

public class Day3: Day() {

    override fun problem1() {
        val lines = readIn("./src/main/kotlin/AoC2021/Data/Day3");

        var gammaBinary = "";
        var epsilonBinary = "";

        for(i in 0 until lines[0].length) {
            var gammaIndicator = 0;

            for(line in lines) {
                if(line.substring(i, i+1).equals("0")) gammaIndicator--;
                else gammaIndicator++;
            }

            if(gammaIndicator >= 0) {
                gammaBinary += "1";
                epsilonBinary += "0";
            }
            else {
                gammaBinary += "0";
                epsilonBinary += "1";
            }
        }
        println(gammaBinary.toLong(2) * epsilonBinary.toLong(2));
    }

    override fun problem2() {
        val lines = readIn("./src/main/kotlin/AoC2021/Data/Day3");

        var oxygenGeneratorList = ArrayList<String>();
        var scrubberRatingList = ArrayList<String>();

        //TODO FIX
        for(line in lines) {
            oxygenGeneratorList.add(line);
            scrubberRatingList.add(line);
        }

        var currentSpot = 0;

        while(currentSpot < oxygenGeneratorList.get(0).length) {

            //Oxygen generator
            if(oxygenGeneratorList.size > 1) {
                var gammaIndicator = calcGamma(oxygenGeneratorList, currentSpot);
                oxygenGeneratorList = calcReplacement(oxygenGeneratorList, true, (gammaIndicator >= 0), currentSpot);
            }

            //Scrubber rating
            if(scrubberRatingList.size > 1) {
                var gammaIndicator = calcGamma(scrubberRatingList, currentSpot);
                scrubberRatingList = calcReplacement(scrubberRatingList, false, (gammaIndicator >= 0), currentSpot);
            }
            currentSpot++;
        }

        println(oxygenGeneratorList.get(0).toLong(2) * scrubberRatingList.get(0).toLong(2));
    }

    fun calcGamma(list: ArrayList<String>, currentSpot: Int): Int {
        var gammaIndicator = 0;
        for(line in list) {
            if(line.substring(currentSpot, currentSpot + 1).equals("0")) gammaIndicator--;
            else gammaIndicator++;
        }
        return gammaIndicator;
    }

    fun calcReplacement(list: ArrayList<String>, isOxygen: Boolean, gammaIsPos: Boolean, currentSpot: Int): ArrayList<String> {
        val replacement = ArrayList<String>();
        for(line in list) {
            val currentChar = line.substring(currentSpot, currentSpot + 1)

            if(gammaIsPos && ((isOxygen && currentChar.equals("1")) || (!isOxygen && currentChar.equals("0")))) replacement.add(line);
            else if(!gammaIsPos && ((isOxygen && currentChar.equals("0")) || (!isOxygen && currentChar.equals("1")))) replacement.add(line);
        }

        return replacement;
    }


}
