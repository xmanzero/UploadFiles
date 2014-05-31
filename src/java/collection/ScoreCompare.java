/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author smile_000
 */
public class ScoreCompare implements Comparator<Score>{

    @Override
    public int compare(Score o1, Score o2) {
        double score1= o1.getScore();
        double score2= o2.getScore();
        if(score1>score2){
            return 1;
        }else if(score1==score2){
            return 0;
        }else{
            return -1;
        }
    }


    public static void main(String[] args) {
        List<Score> list = new ArrayList<Score>();
        list.add(new Score(1,2.5656));
        list.add(new Score(5,3.5656));
        list.add(new Score(2,0.5656));
        list.add(new Score(4,5.5656));
        list.add(new Score(7,5.5656));
        Collections.sort(list, new ScoreCompare());
        for(Score emp:list){
            System.out.println(emp.getScore());
        }
    }
}
