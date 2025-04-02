package com.zipcodeconway;

public class ConwayGameOfLife {

    private Object display;
    private SimpleWindow displayWindow;

    public ConwayGameOfLife(Integer dimension) {

    }

    public ConwayGameOfLife(Integer dimension, int[][] startmatrix) {
    }

    public static void main(String[] args) {
        ConwayGameOfLife sim = new ConwayGameOfLife(50);
        int[][] endingWorld = sim.simulate(50);
    }

    // Contains the logic for the starting scenario.
    // Which cells are alive or dead in generation 0.
    // allocates and returns the starting matrix of size 'dimension'
    private int[][] createRandomStart(Integer dimension) {
        int[][] world = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; i++) {
                world[i][j] = (Math.random() < .5 ? 0 : 1);
            }
        }
        return world;
    }

    public int[][] simulate(Integer maxGenerations) {
        int[][] currentGeneration= createRandomStart(50);
        int[][] nextGeneration= new int[50][50];
            for(int gen=0;gen<maxGenerations;gen++){

                this.displayWindow.display(currentGeneration,gen);


                    for(int j=0; i<50;j++){

                        nextGeneration[i][j]=isAlive(i,j,currentGeneration);
                    }
                }
                copyAndZeroOut(nextGeneration, currentGeneration);

                this.displayWindow.sleep(125);
            }

        return currentGeneration;


    }

    // copy the values of 'next' matrix to 'current' matrix,
    // and then zero out the contents of 'next' matrix
    public void copyAndZeroOut(int[][] next, int[][] current) {
    }

    // Calculate if an individual cell should be alive in the next generation.
    // Based on the game logic:
	/*
		Any live cell with fewer than two live neighbours dies, as if by needs caused by underpopulation.
		Any live cell with more than three live neighbours dies, as if by overcrowding.
		Any live cell with two or three live neighbours lives, unchanged, to the next generation.
		Any dead cell with exactly three live neighbours cells will come to life.
	*/
    private int isAlive(int row, int col, int[][] world) {
        int dimension = world.length;
        int liveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; i++) {
                if(!(i==0&&j==0)){
                    int newRow=(i+row+dimension)%dimension;
                    int newCol=(i+col+dimension)%dimension;
                    liveNeighbors += world[newCol][newRow];
                }
            }
        }
        if(world[row][col]==1){
            return (liveNeighbors<2||liveNeighbors>3) ? 0 : 1;
        }else{
            return liveNeighbors == 3 ? 0 : 1 ;}
    }
}
