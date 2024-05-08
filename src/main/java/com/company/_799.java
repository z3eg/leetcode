package com.company;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/*799. Champagne Tower
        https://leetcode.com/problems/champagne-tower/description/?envType=daily-question&envId=2023-09-24*/
public class _799 {

    class Glass {
        double poured;
        int row;
        int index;
        Glass left;
        Glass right;
        Glass par;

        public Glass(int row, int index,  Glass par) {
            this.index = index;
            this.par = par;
        }

        void pour(double poured) {
            this.poured+=poured;
            if (this.poured > 1) {
                double extra = this.poured-1;
                if (left!=null) {
                    left.pour(extra/2);
                    right.pour(extra/2);
                }
            }
        }
    }

    //use an array instead?
    /*public double champagneTower(int poured, int query_row, int query_glass) {
        Glass root = new Glass(0, 0, null);
        root.left = new Glass(1, 0, root);
        root.right = new Glass(1, 1,root);
        Queue<Glass> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        Glass cur = q.poll();
        while (cur.row<query_row+1) {
            if (cur.par.left.right==null) {
                cur.left = new Glass(cur.row+1,cur.index,cur);
            }
            else {
                cur.left = cur.par.left.right;
            }
            cur.right = new Glass(cur.row+1, cur.index+1, cur);
            q.add(cur.left);
            q.add(cur.right);
            cur = q.poll();
        }
        root.pour(poured);
        while(query_row < root.row) {
            if (query_glass > root.index)
                root = root.right;
            else
                root = root.left;
        }
        return root.poured;
    }*/

    /*2ms
    Beats 98.73%of users with Java*/
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[query_row+2][query_row+2];
        arr[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i][j] > 1) {
                    double xtra = arr[i][j] - 1;
                    arr[i][j] = 1;
                    arr[i+1][j] += xtra/2;
                    arr[i+1][j+1] += xtra/2;
                }
            }
        }
        return arr[query_row][query_glass];
    }

    @Test
    public void test() {
        assertEquals(0.6666666, champagneTower(4, 2,1), 1);
        assertEquals(1, champagneTower(100000009, 33,17), 0);
        assertEquals(0, champagneTower(1, 1,1), 0);
        assertEquals(0.5, champagneTower(2, 1,1), 0);
    }
}
