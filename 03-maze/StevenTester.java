import java.io.FileNotFoundException;

public class StevenTester {
    public static void main(String[] args) throws FileNotFoundException {
        // Maze test = new Maze("data.txt");
        // for(int i = 2; i < 15; i++){
        //     System.out.println(test.moveNext(7, i));
        // }
        // System.out.println(test.moveNext(8, 13));
        // test.moveBack(7, 12);
        // test.moveBack(7, 11);
        // System.out.println(test.solve());
        // System.out.println(test);
        // Maze data1 = new Maze("data1.dat");
        // Maze data2 = new Maze("data2.dat");
        // Maze data3 = new Maze("data3.dat");
        // Maze data5 = new Maze("data5.dat");
        // data5.setAnimate(true);
        // System.out.println(data1.solve());
        // System.out.println(data2.solve());
        // System.out.println(data3.solve());
        // System.out.println(data5.solve());
        // Maze dataVari = new Maze("dataVari.dat");
        // System.out.println(dataVari.solve());
        char [][] gen1 = makeMaze(30,60);
        char [][] gen2 = makeMaze(10,15);
        // System.out.println(MazeGenerator.toString(gen1));
        // System.out.println(MazeGenerator.toString(gen2));
        // MazeGenerator.generate(gen1, 0, 0, 5, 5);
        // System.out.println(MazeGenerator.toString(gen1));
        MazeGenerator.generate(gen2, 0, 0, 2, 5);
        System.out.println(colorize(MazeGenerator.toString(gen2)));
    }
    private static char[][] makeMaze(int row, int col){
        char maze[][] = new char[row][col]; 
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                maze[i][j] = '#';
            }
        }
        return maze;
    }
    public static String colorize(String maze){
        String result = maze.replaceAll(" ", "\033[45m\033[37mP\033[0m");
        result.replaceAll("#", "\033[44m\033[37m \033[0m");
        return result;
    }
}
