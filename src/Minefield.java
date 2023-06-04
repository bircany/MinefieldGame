public class Minefield {
    public static void main(String[] args) {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.println("Welcome to Minesweeper , Please enter the dimensions you want to play.");

        System.out.println("Enter the number of lines :");
        int row = kb.nextInt();
        System.out.println("Enter the number of columns : ");
        int column = kb.nextInt();
        System.out.println("Enter the difficulty between 20% - 80%");
        int difficulty = kb.nextInt();
        if (difficulty > 20 && difficulty < 80) {

            String[][] map = getMap(row, column);
            displayMap(row, column, map);

            System.out.println("\n" +
                    "Game Launching...., Landing Mines...");

            int[][] newMap = gameMapGenerator(row, column, difficulty);
            System.out.println(".....");
            startGame(row, column, map, newMap);
        }
    }
    public static String[][] getMap(int row, int column) {
        String[][] map = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                map[i][j] = "*";
            }
        }
        return map;
    }

    public static void displayMap(int a, int b, String[][] arr) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] gameMapGenerator(int row, int column, int difficulty) {
        int[][] newMap = new int[row][column];
        java.util.Random rnd = new java.util.Random();

        int mine = row * column * difficulty / 100;
        int count = 0;
        while (true) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    newMap[i][j] = rnd.nextInt(2);

                    if (newMap[i][j] == 1)
                        count++;

                    else
                        newMap[i][j] = 0;
                }
            }
            if (count == mine)
                break;
            else
                count = 0;
        }
        return newMap;
    }

    public static void startGame(int row, int column, String[][] map, int[][] newMap) {
        int point = 0;
        while (true) {
            java.util.Scanner kb = new java.util.Scanner(System.in);
            System.out.println("Enter the Row and Column you want to open in an order: ");
            int newRow = kb.nextInt();
            int newColumn = kb.nextInt();

            if (newMap[newRow][newColumn] == 0) {
                point += 5;
                map[newRow][newColumn] = "0";
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        System.out.print(map[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            if (newMap[newRow][newColumn] == 1) {
                System.out.printf("You Lose , Point : %d%n", point);
                map[newRow][newColumn] = "1";
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        System.out.print(map[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }
}

