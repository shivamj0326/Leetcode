Idea is to traverse each and every node using BFS starting from zeroth node and keep track of the time elapsed between node and the zeroth node.
The time taken for a packet to reach zeroth node and come back will be 2 * time taken to reach from zeroth node to ith node.

Also, the number of packets sent will be equal to the distance of node i from 0th node divided by the patience[i].
But if we have patience[i] as a multiple of distance, then when the first packet reaches the source, that particular instance should not be taken into account.
Hence, we take distance - patience[i] when patience[i] is multiple of distance.


Algo :

Do a BFS Starting from 0
Keep track of the time for each node.
Find the time when the last packet will reach the source for a given i.
For this we need to find the number of packets.
Take the max of the total time.
