/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorsebtung;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sebastian Brann-Singer
 */
public class StatisticsOperations {

    public static Double findMean(List<Integer> intList) {
        Double sum = 0.0;
        for (Integer values : intList) {
            sum += values;
        }
        return sum / intList.size();
    }

    public static Double findMedian(List<Integer> intList) {
        intList.sort(Comparator.naturalOrder());
        if (intList.size() % 2 == 0){
            return intList.get(intList.size() / 2).doubleValue();
        } else {
            List<Integer> tempList = new ArrayList();
            tempList.add(intList.get(intList.size() / 2));
            tempList.add(intList.get((intList.size() / 2) + 1));
            return findMean(tempList);
        }
    }

    public static Integer findMode(List<Integer> intList) {
        intList.sort(Comparator.naturalOrder());
        Map<Integer, Integer> map = new HashMap();
        int maxOccurances = 0;
        int mode = 0;
        for (Integer values : intList) {
            //if value is not in hashmap
            if (map.get(values) == null){
            //put it in hashmap
                map.put(values, 1);
            } else {
                //get occurances and add one
                //store in hashmap
                map.put(values, map.get(values) + 1);
                if (map.get(values) > maxOccurances){
                    mode = values; //update mode
                }
            }
                
        }
        return mode;
    }

}
