package AoC2021;

import Day

public class Day2: Day() {

    override fun problem1() {
        val commands = readIn("./src/main/kotlin/AoC2021/Data/Day2");

        var depth = 0;
        var horPoz = 0;

        for(command in commands) {
            val words = command.split(" ");
            val wordLength = words[0].length;

            if(wordLength == 2) depth -= Integer.parseInt(words[1]);
            else if(wordLength == 4) depth += Integer.parseInt(words[1]);
            else horPoz += Integer.parseInt(words[1]);
        }

        println(horPoz * depth);
    }

    override fun problem2() {
        val commands = readIn("./src/main/kotlin/AoC2021/Data/Day2");

        var depth = 0;
        var horPoz = 0;
        var aim = 0;

        for(command in commands) {
            val words = command.split(" ");
            val wordLength = words[0].length;

            if(wordLength == 2) aim -= Integer.parseInt(words[1]);
            else if(wordLength == 4) aim += Integer.parseInt(words[1]);
            else {
                horPoz += Integer.parseInt(words[1]);
                depth += aim * Integer.parseInt(words[1]);
            }
        }

        println(horPoz * depth);
    }


}
