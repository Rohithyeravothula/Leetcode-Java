package leetcode;

import java.util.*;

public class getConnections {

    // function provided in the question
    public static List<String> getConnections(String name){
        return null;
    }

    public static int getBaconNumber(String name){
        List<String> curiter;
        int number=1;
        curiter = new ArrayList<>();
        curiter.add("Kevin Bacon");
        while(!curiter.isEmpty()){
            HashSet<String> poss = new HashSet<String>();
            for(String curname: curiter){
                for(String conn: getConnections(curname)){
                    if(conn.equals(name)){
                        return number;
                    }
                    poss.add(conn);
                }
            }
            number++;
            curiter = new ArrayList<>(poss);
        }
        // not connected to kevin bacon, so no bacon number
        return -1;
    }
}
