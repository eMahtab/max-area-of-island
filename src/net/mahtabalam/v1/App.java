package net.mahtabalam.v1;

public class App {
	public static void main(String[] args) {
	    int arr[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
	                   {0,0,0,0,0,0,0,1,1,1,0,0,0},
	                   {0,1,1,0,1,0,0,0,0,0,0,0,0},
	                   {0,1,0,0,1,1,0,0,1,0,1,0,0},
	                   {0,1,0,0,1,1,0,0,1,1,1,0,0},
	                   {0,0,0,0,0,0,0,0,0,0,1,0,0},
	                   {0,0,0,0,0,0,0,1,1,1,0,0,0},
	                   {0,0,0,0,0,0,0,1,1,0,0,0,0}
	                  };
	    int res = maxAreaOfIsland(arr);     
	    System.out.println("Max area of Island : "+res);        
	  }   
	  
	  public static int maxAreaOfIsland(int[][] grid) {
		  if(grid == null || grid.length == 0) {
			  return 0;
		  }
	        int rows = grid.length;
	        int columns = grid[0].length;
	        int maxRegion = 0;
	        for(int i = 0; i < rows; i++){
	          for(int j = 0; j < columns; j++){
	            if(grid[i][j] == 1){
	              maxRegion = Math.max(maxRegion, traverseIsland(grid, i, j));
	            }
	          }
	        }
	        return maxRegion; 
	  }

	  public static int traverseIsland(int[][] grid, int row, int column){
	    if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || 
	    		grid[row][column] == 0){
	         return 0;
	    }
	    
	    grid[row][column] = 0;

	    return 1 + traverseIsland(grid, row, column+1) + 
	               traverseIsland(grid, row, column-1) +
	               traverseIsland(grid, row+1, column) +
	               traverseIsland(grid, row-1, column);

	  }
}
