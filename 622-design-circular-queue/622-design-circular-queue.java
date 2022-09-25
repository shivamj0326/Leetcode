class MyCircularQueue {
    int[] arr ;
    int head ;
    int tail ;
    int k;

    public MyCircularQueue(int k) {
        arr = new int[k];    
        this.k = k ;
        head = -1;
        tail = -1;
    }
    
    public boolean enQueue(int value) {
        if(isFull() == true)
            return false;
        if(isEmpty() == true)
            head = 0 ;
        tail = (tail + 1) % k  ;
        arr[tail] = value ;
        return true;     
    }
    
    public boolean deQueue() {
        if(isEmpty() == true)
            return false;       
        if(head == tail){
            tail = -1 ;
            head = -1 ;
            return true;
        }
        head = (head + 1)% k ;         
        return true;          
    }
    
    public int Front() {
        if(isEmpty() == true)
            return -1;
        return arr[head];
        
    }
    
    public int Rear() {
        if(isEmpty() == true)
            return -1;
        return arr[tail];
    }
    
    public boolean isEmpty() {
        return (head == -1);
        
    }
    
    public boolean isFull() {
        if((tail+1)%k == head)
            return true;
        return false;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */