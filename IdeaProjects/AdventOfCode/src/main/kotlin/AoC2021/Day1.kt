package AoC2021;

import Day

public class Day1: Day() {

    override fun problem1() {
        val depths = readIn("./src/main/kotlin/AoC2021/Data/Day1");

        var countIncrease = 0;

        for(i in 1 until depths.size) {
            if(Integer.parseInt(depths.get(i)) > Integer.parseInt(depths.get(i-1))) countIncrease++;
        }

        println(countIncrease);
    }

    override fun problem2() {
        val depths = readIn("./src/main/kotlin/AoC2021/Data/Day1");

        var countIncrease = 0;

        for(i in 3 until depths.size) {
            if(Integer.parseInt(depths.get(i)) > Integer.parseInt(depths.get(i-3))) countIncrease++;
        }

        println(countIncrease);
    }


}
