# Max area of island

The idea is to use DFS to traverse all the cells one by one, and while traversing each cell, recursively traversing all the neighboring cells from that cell. 

If the cell represents water we will immediately return 0; otherwise If the cell represents a land, then we will mark it water (so that we don't traverse that cell again) and then traverse all its neighbours. 

This way we will be able to traverse the one entire island and at the end we return 1 for one single island.
