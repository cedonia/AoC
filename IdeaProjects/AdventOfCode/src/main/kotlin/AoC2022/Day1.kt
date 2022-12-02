package AoC2022;

import Day

public class Day1: Day() {

    override fun problem1() {
        val lines = readIn("./src/main/kotlin/AoC2022/Data/Day1");

        var currentTally = 0;
        var maxTally = 0;

        for(line in lines) {
            if(line.isEmpty()) {
                if(currentTally > maxTally) maxTally = currentTally;
                currentTally = 0;
            }

            else currentTally += Integer.parseInt(line);
        }

        println(maxTally);
    }

    override fun problem2() {
        val lines = readIn("./src/main/kotlin/AoC2022/Data/Day1");

        var currentTally = 0;
        var topThree = ArrayList<Int>();
        var smallestMax = 0;

        for(line in lines) {
            if(line.isEmpty()) {

                if(topThree.size < 3) {
                    topThree.add(currentTally);
                    if(smallestMax == 0) smallestMax = currentTally;
                    else if(currentTally < smallestMax) smallestMax = currentTally;
                }

                smallestMax = processNum(currentTally, smallestMax, topThree);
                currentTally = 0;
            }

            else currentTally += Integer.parseInt(line);
        }

        processNum(currentTally, smallestMax, topThree);

        println(topThree.get(0) + topThree.get(1) + topThree.get(2));

    }

    fun processNum(currentTally: Int, smallestMax: Int, topThree: ArrayList<Int>): Int {
        var newSmallestMax = smallestMax;

        if(currentTally > smallestMax) {
            topThree.add(currentTally);
            topThree.remove(smallestMax);
            newSmallestMax = currentTally;

            for(num in topThree) {
                if(num < newSmallestMax) newSmallestMax = num;
            }
        }

        return newSmallestMax;
    }


}
