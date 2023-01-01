import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Player  implements Comparable<Player> {
    public final int x ;
    public final int y ;
    public final int area ;

    public Player(int x, int y, int area) {
        this.x    = x;
        this.y    = y;
        this.area = area;
    }

    public int compareTo(Player other) {

        return (x != other.x) ? x - other.x : y - other.y;
    }
    public Point toprint() {

        return new Point(x,y);
    }

}

 interface IPlayersFinder {
    void ExtractPlayers(String[] photo, int team, int threshold);

    Player extract(char[][] photo, int x, int y, int k) ;

}


public class PlayerFinder implements IPlayersFinder{    // implement IPlayersFinder

    static ArrayList<Point> moves = new ArrayList<Point>();

    public static void ExtractPlayers(char[][] photo, int team, int threshold) {

        ArrayList<Player> players = new ArrayList<Player>();  // list of players

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[0].length; j++) {
                if (photo[i][j] == team + '0') {
                    Player p = extract(photo, j, i, team);

                    if (p.area >= threshold) {
                        players.add(p);
                    }

                }
            }

        }
        Collections.sort(players);

        ArrayList<Point> output = new ArrayList<Point>();
        for (int i = 0; i < players.size(); i++) {
            output.add(players.get(i).toprint());
        }
        System.out.print("[");
        for (int i = 0; i < output.size(); i++) {
            System.out.print("(" + (output.get(i).x) + ", " + output.get(i).y + ")");

            if (i != output.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

    }

    static Player extract(char[][] photo, int x, int y, int k) {
        int m = photo.length;      //number of rows
        int n = photo[0].length;   // number of columns


        int squareBegin_X = 2 * x;  // squareBegin_X  squareBegin_y
        int squareBegin_y = 2 * y;
        int squareEnd_x = 2 * (x + 1);  // squareEnd_x squareEnd_y
        int squareEnd_y = 2 * (y + 1);
        int area = 4;

        ArrayList<Point> stack = new ArrayList<Point>();

        stack.add(new Point(x, y));

        photo[y][x] = '-'; // make it dont care ;

        while (stack.size() > 0) {
            Point coordinates = stack.remove(0);

            int xt = coordinates.x;
            int yt = coordinates.y;

            // this part is for the movement between different squares  up , down , left , right ;
            moves.add(new Point(-1, 0));
            moves.add(new Point(1, 0));
            moves.add(new Point(0, -1));
            moves.add(new Point(0, 1));


            for (int j = 0; j < moves.size(); j++) {
                Point move = moves.get(j);
                int xNew = xt + move.x;
                int yNew = yt + move.y;

                if (xNew < 0 || xNew >= n || yNew < 0 || yNew >= m || photo[yNew][xNew] != k + '0') {
                    continue;
                }
                squareBegin_X = Math.min(squareBegin_X, xNew * 2);
                squareBegin_y = Math.min(squareBegin_y, yNew * 2);
                squareEnd_x = Math.max(squareEnd_x, (xNew + 1) * 2);
                squareEnd_y = Math.max(squareEnd_y, (yNew + 1) * 2);

                area += 4;

                photo[yNew][xNew] = '-';

                stack.add(new Point(xNew, yNew));

            }

        }

        int xCenter = (squareBegin_X + squareEnd_x) / 2;
        int yCenter = (squareBegin_y + squareEnd_y) / 2;

        return new Player(xCenter, yCenter, area);
    }

    public static void main (String[] args){
        /* Implement main method to parse the input from stdin and print output to stdout */

        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(",");
        int rowSize = Integer.parseInt(size[0].trim());
        int coloumSize = Integer.parseInt(size[1].trim());

        String[] photo = new String[rowSize];

        for (int i = 0; i < rowSize; i++) {
            photo[i] = scanner.nextLine();               // take an input form user as array of strings
        }

        char[][] photo2D = new char[photo.length][];   // now it is time to convert it to 2d array of chars

        for (int i = 0; i < photo.length; i++) {
            photo2D[i] = photo[i].toCharArray();
        }            //    WE HAVA A photo 2d now
        int teamIdentifier = Integer.parseInt(scanner.nextLine());
        int minArea = Integer.parseInt(scanner.nextLine());
        

        PlayerFinder.ExtractPlayers(photo2D,teamIdentifier,minArea) ;


    }
}




