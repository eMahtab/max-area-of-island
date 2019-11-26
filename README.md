# Max area of island

The idea is to use DFS to traverse all the cells one by one, and while traversing each cell, recursively traversing all the neighboring cells from that cell. 

If the cell represents water we will immediately return 0; otherwise If the cell represents a land, then we will mark it water (so that we don't traverse that cell again) and then traverse all its neighbours. 

This way, we will be able to traverse the one entire island and since we have to find out the max area of the island, we return the sum of traversal of all the neighbours.

Also we keep updating the max area, after each island's traversal.


### Case 1 : When we can only move horizontally (left, right) and vertically (top, down)
e.g. below 8*13 matrix have max area of 6 (note that we can only move horizontally, vertically and not diagonally)
![When we can only move horizontally and vertically](max-area-1.PNG?raw=true "Title")


### Case 2 : When we can move horizontally (left, right), vertically (top, down) and diagonally (top-right, bottom-left, bottom-right, top-left)
e.g. below 8*13 matrix have max area of 11 (note that we can only move horizontally, vertically and not diagonally)
![When we can move horizontally, vertically and diagonally](max-area-2.PNG?raw=true "Title")
