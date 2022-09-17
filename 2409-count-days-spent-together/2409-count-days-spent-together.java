class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int days = 0 ;
        
        String arrive = arriveAlice.compareTo(arriveBob) < 0 ? arriveBob : arriveAlice;
        
        String depart = leaveAlice.compareTo(leaveBob) <= 0 ? leaveAlice : leaveBob;
        
        int monthArrive = Integer.parseInt(arrive.substring(0, 2));
        
        int monthLeave = Integer.parseInt(depart.substring(0, 2));
        
        if(monthArrive > monthLeave)
            return 0 ;
        
        int dayArrive = Integer.parseInt(arrive.substring(3, 5));
        
        int dayLeave = Integer.parseInt(depart.substring(3, 5));
        

        System.out.println(dayArrive + " " + dayLeave);
        
        int[] months = new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      
        if(monthArrive == monthLeave){
            if(dayArrive > dayLeave)
                return 0 ;
            else
                return dayLeave - dayArrive + 1; 
        }    
        else{
            for(int i = monthArrive + 1 ; i < monthLeave ; i++){
                days += months[i];
            }
            days += months[monthArrive] - dayArrive + 1;
            days += dayLeave;
            return days;
        }
         
        
    }
}