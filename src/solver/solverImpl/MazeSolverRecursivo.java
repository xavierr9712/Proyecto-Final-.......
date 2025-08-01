package solver.solverImpl;

import java.util.ArrayList;
import java.util.List;
import models.*;
import solver.MazeSolver;

public class MazeSolverRecursivo implements MazeSolver{

    private List<Cell> path;
    private boolean[][] visited;

    @Override
    public SolveResults solve(Cell[][] maze, Cell start, Cell end) {
        long startTime = System.nanoTime();
        path = new ArrayList<>();
        visited = new boolean[maze.length][maze[0].length];
        
        boolean found = findPath(maze, start.getRow(), start.getCol(), end);
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        if (!found) {
            path.clear();
        }

        String mazeSize = maze.length + "x" + maze[0].length;
        AlgorithmResult algoResult = new AlgorithmResult("Recursivo (2 dir)", path.size(), duration, mazeSize);
        return new SolveResults(path, algoResult);
    }

    private boolean findPath(Cell[][] maze, int r, int c, Cell end) {
        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || visited[r][c] || maze[r][c].getState() == CellState.WALL) {
            return false;
        }

        visited[r][c] = true;
        path.add(maze[r][c]);

        if (maze[r][c].equals(end)) {
            return true;
        }

        // Solo se mueve a la derecha o hacia abajo
        if (findPath(maze, r, c + 1, end)) return true;
        if (findPath(maze, r + 1, c, end)) return true;

        path.remove(path.size() - 1); // Backtrack
        return false;
    }
    
}
