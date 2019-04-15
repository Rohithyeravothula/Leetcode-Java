package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ProductReviewScore{
    Integer productId;
    Double reviewScore;

    public ProductReviewScore(Integer productId, Double reviewScore){
        this.productId = productId;
        this.reviewScore = reviewScore;
    }

    public static ArrayList<ProductReviewScore> build(int [] ids, double [] scores){
        ArrayList<ProductReviewScore> ans = new ArrayList<>();
        for(int i=0;i<ids.length;i++){
            ans.add(new ProductReviewScore(ids[i], scores[i]));
        }
        return ans;
    }
}

public class HighestFive {
    public Map<Integer, Double> calculateHighestFive(int scoreCount,
                                                     ArrayList<ProductReviewScore>
                                                             reviewScoreArrayList){

        Map<Integer, PriorityQueue<Double>> scores = new HashMap<>();
        PriorityQueue<Double> cur;
        for(ProductReviewScore prs: reviewScoreArrayList){
            if(scores.containsKey(prs.productId)){
                cur = scores.get(prs.productId);
                if(cur.size() < 5 || cur.peek() < prs.reviewScore){
                    cur.add(prs.reviewScore);
                }
                if(cur.size() > 5){
                    cur.poll();
                }
            }
            else{
                cur = new PriorityQueue<>();
                cur.add(prs.reviewScore);
                scores.put(prs.productId, cur);
            }
        }

        Map<Integer, Double> ans = new HashMap<Integer, Double>();
        Double cursum;
        Integer size;
        for(Integer pid: scores.keySet()){
            cur = scores.get(pid);
            cursum = 0d;
            size = cur.size();
            while(!cur.isEmpty()){
                cursum += cur.poll();
            }
            ans.put(pid, cursum/size);
        }
        return ans;
    }

    public static void main(String[] args) {
        HighestFive hf = new HighestFive();
        int[] ids = {1,1,1,1,1,1,2,2,2,2,2,2,2,2};
        double[] score = {10,1,1,1,1,1,0,0,0,0,10,0,0,0};
        ArrayList<ProductReviewScore> prs = ProductReviewScore.build(ids, score);
        Map<Integer, Double> scores = hf.calculateHighestFive(ids.length, prs);
        System.out.println(scores.toString());
    }
}
