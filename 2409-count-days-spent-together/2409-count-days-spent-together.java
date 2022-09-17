class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int days = 0 ;
        
        //Get Max Arrival date :
        String arrive = arriveAlice.compareTo(arriveBob) < 0 ? arriveBob : arriveAlice;
        
        //Get Min Arrival date:
        String depart = leaveAlice.compareTo(leaveBob) <= 0 ? leaveAlice : leaveBob;
        
        int monthArrive = Integer.parseInt(arrive.substring(0, 2));
        
        int monthLeave = Integer.parseInt(depart.substring(0, 2));
        
        //if arrive month > leave month return 0
        if(monthArrive > monthLeave)
            return 0 ;
        
        int dayArrive = Integer.parseInt(arrive.substring(3, 5));
        
        int dayLeave = Integer.parseInt(depart.substring(3, 5));
        
        int[] months = new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      
        if(monthArrive == monthLeave){
            //if arrive and leave month same return 0 if dayArrive > dayLeave
            if(dayArrive > dayLeave)
                return 0 ;
            else
                return dayLeave - dayArrive + 1; 
        }    
        else{
            //calculate days excluding arrive month and end month
            for(int i = monthArrive + 1 ; i < monthLeave ; i++){
                days += months[i];
            }
            //arrive month days will be total days in arrive month - dayArrive + 1
            days += months[monthArrive] - dayArrive + 1;
            //leave days will be simply dayleave
            days += dayLeave;
            return days;
        }
               
    }
}