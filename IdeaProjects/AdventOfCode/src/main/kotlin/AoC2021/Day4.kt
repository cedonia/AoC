package AoC2021;

import Day

public class Day4: Day() {

    override fun problem1() {
        val lines = readIn("./src/main/kotlin/AoC2021/Data/Day4");

        //Parse/setup
        var randomNums = "";
        val boards = ArrayList<Array<String>>();
        var currentBoard = "";
        var justDidNums = false;
        for(line in lines) {
            println("LINE " + line);
            if(randomNums.equals("")) {
                randomNums = line;
                justDidNums = true;
            }
            else if(line.isNotEmpty()) currentBoard += line + " ";

            else {
                if(justDidNums) {
                    justDidNums = false;
                    continue;
                }
                currentBoard = currentBoard.replace("  ", " ");
                println("BOARD $currentBoard !");
                if(currentBoard.substring(0,1).equals(" ")) currentBoard = currentBoard.substring(1);

                val newBoard = currentBoard.substring(0,currentBoard.length - 1).split(" ").toTypedArray()

                boards.add(newBoard);
                currentBoard = "";
            }
        }

        //Iteratively play the game
        for(num in randomNums.split(",")) {
            for(board in boards) {
                for(i in board.indices) {
                    if(board[i].equals(num)) {
                        board[i] = "*";

                        if(calcIfWon(board, i)) {
                            //We won!
                            println(calcWinnerScore(board, Integer.parseInt(num)));
                            return;
                        }
                        break;
                    }
                }
            }
        }

    }

    fun calcIfWon(board: Array<String>, index: Int): Boolean {
        val xLoc = index % 5;
        val yLoc = index / 5;

        var hasWon = true;
        //Calc if won in a row
        for(i in 0 until 5) {
            if(!board[(i + (5*yLoc))].equals("*")) {
                hasWon = false;
                break;
            }
        }
        if(hasWon) return true;

        //Calc if won in a col
        hasWon = true;
        for(i in 0 until 5) {
            if(!board[(xLoc + (5*i))].equals("*")) {
                hasWon = false;
                break;
            }
        }
        return hasWon;
    }

    fun calcWinnerScore(board: Array<String>, num: Int): Int {
        var tally = 0;

        for(num in board) {
            if(!num.equals("*") && num.isNotEmpty()) tally += Integer.parseInt(num);
        }

        return tally * num;
    }

    override fun problem2() {
        val lines = readIn("./src/main/kotlin/AoC2021/Data/Day4");

        var randomNums = "";
        val boards = ArrayList<Array<String>>();
        var currentBoard = "";
        var justDidNums = false;
        for(line in lines) {
            if(randomNums.equals("")) {
                randomNums = line;
                justDidNums = true;
            }
            else if(line.isNotEmpty()) currentBoard += line + " ";

            else {
                if(justDidNums) {
                    justDidNums = false;
                    continue;
                }
                currentBoard = currentBoard.replace("  ", " ");
                if(currentBoard.substring(0,1).equals(" ")) currentBoard = currentBoard.substring(1);

                val newBoard = currentBoard.substring(0,currentBoard.length - 1).split(" ").toTypedArray()

                boards.add(newBoard);
                currentBoard = "";
            }
        }

        var minBoard = -1;
        var finalNum = -1;
        var minBoardObj = boards[0];

        for(board in boards) {
            var currentMoves = 0;
            for(num in randomNums.split(",")) {
                currentMoves++;
                var done = false;

                println("CURRENT MOVES" + currentMoves);

                for(i in board.indices) {
                    if(board[i].equals(num)) {
                        board[i] = "*";

                        if(calcIfWon(board, i)) {
                            //We won!
                            if((currentMoves > minBoard)) {
                                minBoard = currentMoves;
                                minBoardObj = board;
                                finalNum = Integer.parseInt(num);
                                done = true;
                            }
                            currentMoves = 0;
                        }
                        break;
                    }
                }
                if(done) break;
            }
        }

        println(calcWinnerScore(minBoardObj, finalNum));

//        //Parse/setup
//        var randomNums = "";
//        val boards = ArrayList<Array<String>>();
//        var currentBoard = "";
//        var justDidNums = false;
//        for(line in lines) {
//            if(randomNums.equals("")) {
//                randomNums = line;
//                justDidNums = true;
//            }
//            else if(line.isNotEmpty()) {
//                currentBoard += line + " ";
//            }
//
//            else {
//                if(justDidNums) {
//                    justDidNums = false;
//                    continue;
//                }
//                currentBoard = currentBoard.replace("  ", " ");
//                if(currentBoard.substring(0,1).equals(" ")) currentBoard = currentBoard.substring(1);
//
//                val newBoard = currentBoard.substring(0,currentBoard.length - 1).split(" ").toTypedArray()
//
//                boards.add(newBoard);
//                currentBoard = "";
//            }
//        }
//
//        var currentNumIndex = 0;
//        val nums = randomNums.split(",");
//        println("NUM BOARDS " + boards.size);
//
//        for(num in nums) {
//
//            var toRemove = ArrayList<Array<String>>();
//
//            //Loop through the boards
//            for(board in boards) {
//                for(i in board.indices) {
//                    if(board[i].equals(num)) {
//                        board[i] = "*";
//
//                        if(calcIfWon(board, i)) toRemove.add(board);
//                        break;
//                    }
//                }
//            }
//
//            for(board in toRemove) {
//                boards.remove(board);
//            }
//
//            if(boards.size == 1) {
//                for(i in boards[0]) print("L"+i);
//                println("\nNUM: " + num);
//                println(calcWinnerScore(boards[0], Integer.parseInt(num)));
//                return;
//            }
//        }
    }


}
