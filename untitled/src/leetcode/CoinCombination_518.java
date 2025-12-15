package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinCombination_518 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
       // System.out.print(change(amount, coins));
        System.out.print(Arrays.asList(changeSet(amount,coins)));
    }

    public static int change(int amount, int[] coins) {
        int[] tab = new int[amount + 1];
        tab[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                // if (i % c == 0)
                tab[i] += tab[i - c];
            }
        }
        return tab[amount];
    }

    //if we want to show all the combination of coins which will add to amount
    public static List<Integer> changeSet(int amount, int[] coins) {
        ArrayList<List<Integer>> dp = new ArrayList<>(amount + 1);
        //List<Integer> dp = new ArrayList<>(amount+1);
        dp.add(0,new ArrayList<>());
        for (int i=0;i<=amount;i++){
            if(dp.get(i)!=null){
                for (int c:coins) {
                    if(i+c<=amount) {
                        List<Integer> temp = dp.get(i);
                        temp.add(c);
                        dp.add(i + c, temp);
                    }
                }
            }
        }
        return dp.get(amount);
    }

}

