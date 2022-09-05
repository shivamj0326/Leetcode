Idea is to traverse the tree in level order.
Only difference is we have n children instead of two.
At each level, we pop out the elements and add them to a list of queue and insert their children. At the end of iteration we add this list to the final result. 



