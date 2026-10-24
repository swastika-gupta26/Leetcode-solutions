class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        //convert date into number of days
        int aa_month = Integer.parseInt(arriveAlice.substring(0, 2));
        int aa_day = Integer.parseInt(arriveAlice.substring(3, 5));
        int alice_arivedays = 0;
        for (int i = 1; i < aa_month; i++) {
            alice_arivedays += month[i];
        }
        alice_arivedays += aa_day;

        int ba_month = Integer.parseInt(arriveBob.substring(0, 2));
        int ba_day = Integer.parseInt(arriveBob.substring(3, 5));
        int bob_arivedays = 0;
        for (int i = 1; i < ba_month; i++) {
            bob_arivedays += month[i];
        }
        bob_arivedays += ba_day;

        int common_arrive = Math.max(alice_arivedays, bob_arivedays);

        int al_month = Integer.parseInt(leaveAlice.substring(0, 2));
        int al_day = Integer.parseInt(leaveAlice.substring(3, 5));
        int alice_leavedays = 0;
        for (int i = 1; i < al_month; i++) {
            alice_leavedays += month[i];
        }
        alice_leavedays += al_day;

         int bl_month = Integer.parseInt(leaveBob.substring(0, 2));
        int bl_day = Integer.parseInt(leaveBob.substring(3, 5));
        int bob_leavedays = 0;
        for (int i = 1; i < bl_month; i++) {
            bob_leavedays += month[i];
        }
        bob_leavedays += bl_day;
        int common_leave = Math.min(alice_leavedays, bob_leavedays);
        if(common_leave >= common_arrive){
            return (common_leave - common_arrive+1);
        }
        else{
            return 0;
        }


    }
}