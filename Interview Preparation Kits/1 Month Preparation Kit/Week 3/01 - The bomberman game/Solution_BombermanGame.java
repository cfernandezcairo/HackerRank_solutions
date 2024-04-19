import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_BombermanGame {

    static Map<Integer,Map<Integer,Integer>> threeSecondBombs = new HashMap<>();
    static Map<Integer,Map<Integer,Integer>> twoSecondBombs = new HashMap<>();
    static Map<Integer,Map<Integer,Integer>> oneSecondBombs = new HashMap<>();
    static Map<Integer,Map<Integer,Integer>> damagedBombs = new HashMap<>();

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    private static List<String> detonate(List<String> bombGrid) {

        int r = bombGrid.size();
        int c = bombGrid.get(0).toCharArray().length;

        char[][] result = bombGrid.stream().map(String::toCharArray).toArray(char[][]::new);

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(result[i][j] == 'D') {
                    result[i][j] = '.';

                    if(i - 1 >= 0)
                        result[i - 1][j] = result[i - 1][j] == 'D' ? 'D' : '.';
                    if(i + 1 < r)
                        result[i + 1][j] = result[i + 1][j] == 'D' ? 'D' : '.';
                    if(j - 1 >= 0)
                        result[i][j - 1] = result[i][j - 1] == 'D' ? 'D' : '.';
                    if(j + 1 < c)
                        result[i][j + 1] = result[i][j + 1] == 'D' ? 'D' : '.';
                }
            }
        }

        return Arrays.stream(result).map(v -> String.valueOf(v)).collect(toList());
    }

    private static List<String> updateGridPrevDetonate(List<String> grid) {
        for(int it = 0; it < grid.size(); it++) {
            grid.set(it, grid.get(it).replace("O", "D").replace(".", "O"));
        }

        return grid;
    }
    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here

        if(n == 1) {
            return grid;
        }

        List<String> result = new ArrayList<>(grid);
        if(n % 2 == 0) {
            for(String s : grid)
                result.add(s.replaceAll(".", "O"));
        }

        if (n == 3)
            result =  detonate(updateGridPrevDetonate(result));
        else {
            if (n % 4 == 1) {
                result =  detonate(updateGridPrevDetonate(detonate(updateGridPrevDetonate(result))));
            } else {
                result =  detonate(updateGridPrevDetonate(detonate(updateGridPrevDetonate(detonate(updateGridPrevDetonate(result))))));
            }
        }

        return result;

    }









    private static char[][] createGrid(int r, int c, char[][] gridAtPreviousStep, char[][] gridAtNextStep) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char currentCell = gridAtPreviousStep[i][j];
                if (currentCell == 'O') {
                    gridAtNextStep[i][j] = '.';
                    if (i - 1 >= 0) {
                        gridAtNextStep[i - 1][j] = '.';
                    }
                    if (i + 1 <= r - 1) {
                        gridAtNextStep[i + 1][j] = '.';
                    }
                    if (j - 1 >= 0) {
                        gridAtNextStep[i][j - 1] = '.';
                    }
                    if (j + 1 <= c - 1) {
                        gridAtNextStep[i][j + 1] = '.';
                    }
                }
            }
        }

        return gridAtNextStep;
    }
    public static List<String> bomberMan_AlessandroBardini(int n, List<String> grid) {
        // Write your code here
        int r = grid.size();
        int c = grid.get(0).toCharArray().length;

        char[][] gridAfterFirstDetonation = new char[r][c];
        char[][] gridAfterSecondDetonation = new char[r][c];
        char[][] gridAfterThirdDetonation = new char[r][c];
        char[][] gridAtEvenTimes = new char[r][c];

        char[][] initialGrid = grid.stream().map(String::toCharArray).toArray(char[][]::new);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                gridAfterSecondDetonation[i][j] = 'O';
                gridAfterThirdDetonation[i][j] = 'O';
                gridAtEvenTimes[i][j] = 'O';
                gridAfterFirstDetonation[i][j] = 'O';
            }
        }

        gridAfterFirstDetonation = createGrid(r, c, initialGrid, gridAfterFirstDetonation);

        if (n % 2 == 0) {
            return Arrays.stream(gridAtEvenTimes).map(v -> String.valueOf(v)).collect(toList());
        } else if (n < 4) {
            {
                if (n == 1) {
                    return Arrays.stream(initialGrid).map(v -> String.valueOf(v)).collect(toList());
                }
                if (n == 3) {
                    return Arrays.stream(gridAfterFirstDetonation).map(v -> String.valueOf(v)).collect(toList());
                }

            }
        } else {
            gridAfterSecondDetonation = createGrid(r, c, gridAfterFirstDetonation, gridAfterSecondDetonation);
            gridAfterThirdDetonation = createGrid(r, c, gridAfterSecondDetonation, gridAfterThirdDetonation);

            if (n % 4 == 1) {
                return Arrays.stream(gridAfterSecondDetonation).map(v -> String.valueOf(v)).collect(toList());
            } else {
                return Arrays.stream(gridAfterThirdDetonation).map(v -> String.valueOf(v)).collect(toList());
            }
        }

        return null;


    }





    //Plants a bomb on all open tiles
    static void plantBombs(Map<Integer,Map<Integer,Integer>> bombSet, char[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '.') {
                    //System.out.println("Planting 2s Bomb");
                    if(bombSet.get(i) == null) {
                        //System.out.println("No bomb in row "+i);
                        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
                        bombSet.put(i, map);
                        bombSet.get(i).put(j,0);
                    } else {
                        bombSet.get(i).put(j,0);
                    }
                    grid[i][j] = 'O';
                }
            }
        }
    }
    static void removeBomb(int x, int y) {
        if(damagedBombs.get(x) == null) {
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            damagedBombs.put(x, map);
            damagedBombs.get(x).put(y,0);
        } else {
            damagedBombs.get(x).put(y,0);
        }
    }
    static void removeDamage(int x, int y, char[][] grid) {
        grid[x][y] = '.';
        removeBomb(x, y);

        //Left
        if(y-1 >= 0) {
            grid[x][y-1] = '.';
            removeBomb(x, y-1);
        }

        //Right
        if(y+1 < grid[0].length) {
            grid[x][y+1] = '.';
            removeBomb(x, y+1);
        }

        //Up
        if(x-1 >= 0) {
            grid[x-1][y] = '.';
            removeBomb(x-1, y);
        }

        //Down
        if(x+1 < grid.length) {
            grid[x+1][y] = '.';
            removeBomb(x+1, y);
        }
    }
    static void detonateBombs(Map<Integer,Map<Integer,Integer>> bombSet, char[][] grid) {

        for(Map.Entry<Integer, Map<Integer,Integer>> x : bombSet.entrySet()) {
            int px = x.getKey();
            for(Map.Entry<Integer,Integer> y : x.getValue().entrySet()) {
                removeDamage(px,y.getKey(),grid);
            }
        }

        for(Map.Entry<Integer, Map<Integer,Integer>> x : damagedBombs.entrySet()) {
            int px = x.getKey();
            for(Map.Entry<Integer,Integer> y : x.getValue().entrySet()) {
                //System.out.println("Removing Bomb at("+px+","+y.getKey()+")");
                if(threeSecondBombs.get(px) != null) {
                    threeSecondBombs.get(px).remove(y.getKey());
                    //System.out.println("Removing 3s Bomb");
                }
                if(twoSecondBombs.get(px) != null) {
                    twoSecondBombs.get(px).remove(y.getKey());
                    //System.out.println("Removing 2s Bomb");
                }
                if(oneSecondBombs.get(px) != null) {
                    oneSecondBombs.get(px).remove(y.getKey());
                    //System.out.println("Removing 1s Bomb");
                }
            }
        }
        damagedBombs = new HashMap<>();//Remove the bombs now that we have removed all damage
    }
    public static List<String> bomberMan_RyanFehr(int n, List<String> inputGrid) {
        // Write your code here

        if(n % 2 == 0) {//If n is even we always have a full grid of bombs
            n = 2;
        }
        else if(n > 3) { //We are in a repeated pattern(See example above) so we only do either 5 or 7 iterations
            n = (n % 4)+4;
        }

        //Initialze variables according to input grid
        int row = inputGrid.size();
        int col = inputGrid.get(0).toCharArray().length;
        char[][] grid = new char[row][col];

        for(int i = 0; i < row; i++) {
            String readRow  = inputGrid.get(i);
            for(int j = 0; j < col; j++) {
                if(readRow.charAt(j) == 'O') {
                    if(threeSecondBombs.get(i) == null) {
                        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
                        threeSecondBombs.put(i, map);
                        threeSecondBombs.get(i).put(j,0);
                    } else {
                        threeSecondBombs.get(i).put(j,0);
                    }
                }
                grid[i][j] = readRow.charAt(j);
            }
        }

        int cycle = 2; //Plant all the 2 second bombs
        if(cycle <= n) { //2 second cycle
            plantBombs(twoSecondBombs, grid);
            cycle++;
            //System.out.println("Plant 2 sec bombs");
            //System.out.println("Cycle: 2");
            //printGrid(grid);
        }

        if(cycle <= n) { //3 second cycle
            detonateBombs(threeSecondBombs, grid);
            threeSecondBombs = new HashMap<>();
            cycle++;
            //System.out.println("Detonate 3 sec bombs");
            //System.out.println("Cycle: 3");
            //printGrid(grid);
        }

        //All future cycles
        //These will function as switches where false is place bomb and true is detonate bomb
        boolean one = false;
        boolean two = true;
        boolean three = false;

        while(cycle <= n) {
            //System.out.println("Cycle: "+cycle);

            if(cycle % 3 == 1) {//One cycle
                if(!one) {
                    plantBombs(oneSecondBombs, grid);
                    one = !one;
                    //System.out.println("Plant 1 sec bombs");
                } else {
                    detonateBombs(oneSecondBombs, grid);
                    one = !one;
                    //System.out.println("Detonate 1 sec bombs");
                }
            }
            else if(cycle % 3 == 2) {//Two cycle
                if(!two) {
                    plantBombs(twoSecondBombs, grid);
                    two = !two;
                    //System.out.println("Plant 2 sec bombs");
                } else {
                    detonateBombs(twoSecondBombs, grid);
                    two = !two;
                    //System.out.println("Detonate 2 sec bombs");
                }
            }
            else if(cycle % 3 == 0) {//Three cycle
                if(!three) {
                    plantBombs(threeSecondBombs, grid);
                    three = !three;
                    //System.out.println("Plant 3 sec bombs");
                } else {
                    detonateBombs(threeSecondBombs, grid);
                    three = !three;
                    //System.out.println("Detonate 3 sec bombs");
                }
            }
            cycle++;
            //printGrid(grid); //Grid after each cycle
        }

        return Arrays.stream(grid).map(v -> String.valueOf(v)).collect(toList());

    }

}

public class Solution_BombermanGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result_BombermanGame.bomberMan_AlessandroBardini(n, grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}