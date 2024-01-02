package unionfind;

import java.util.Arrays;

public class QuickFindUF {
   private final int[] ids;

   public QuickFindUF(int size) {
       ids = new int[size];

       for(int i = 0; i < size; i++) {
           ids[i] = i;
       }
   }

   public void union(int p, int q) {
       int valueAtP = ids[p];
       int valueAtQ = ids[q];

       for(int i = 0; i < ids.length; i++) {
           if(ids[i] == valueAtQ) ids[i] = valueAtP;
       }
   }

   public int[] getDS() {
       return ids;
   }

   public boolean connected(int p, int q) {
       return ids[p] == ids[q];
   }
}
