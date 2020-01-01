# Max area of island
## https://leetcode.com/problems/max-area-of-island

The idea is to use DFS to traverse all the cells one by one, and while traversing each cell, recursively traversing all the neighboring cells from that cell. 

If the cell represents water we will immediately return 0; otherwise If the cell represents a land, then we will mark it water (so that we don't traverse that cell again) and then traverse all its neighbours. 

This way, we will be able to traverse the one entire island and since we have to find out the area of the island, we return the sum of traversal of all the neighbours.

Also we keep updating the max area, after each island's traversal. And finally we return max area after traversing all the islands.


### Case 1 : When we can only move horizontally (left, right) and vertically (top, down)
e.g. below 8*13 matrix have max area of 6 (note that we can only move horizontally, vertically but not diagonally)
![When we can only move horizontally and vertically](max-area-1.PNG?raw=true "Title")

```java
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
```    

### Case 2 : When we can move horizontally (left, right), vertically (top, down) and diagonally (top-right, bottom-left, bottom-right, top-left)
e.g. below 8*13 matrix have max area of 11 (note that now we can move horizontally, vertically and diagonally)
![When we can move horizontally, vertically and diagonally](max-area-2.PNG?raw=true "Title")

```java
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
	               traverseIsland(grid, row-1, column) +
	               traverseIsland(grid, row-1, column+1) +
	               traverseIsland(grid, row+1, column-1) +
	               traverseIsland(grid, row-1, column-1) +
	               traverseIsland(grid, row+1, column+1);

}
```	  
	  
