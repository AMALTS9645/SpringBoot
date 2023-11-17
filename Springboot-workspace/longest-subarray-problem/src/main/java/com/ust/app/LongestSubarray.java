package com.ust.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class LongestSubarray
{
	public int getSum(int s,int e, int[] arr) {
		int sum = 0;
		
		for(int k=s;k<e;k++) {
			sum+=arr[k];
		}
		
		return sum;
	}
	
	
    public SubarrayResult findLongestSubarray(int[] array) {
    	int start = 0;
    	int end = 0;
    	int sum = Integer.MIN_VALUE;
    	
    	Map<List<int[]>,List<Integer>> map = new HashMap<>();
    	
    	for(int i=0;i<array.length;i++) {
    		for(int j=i;j<array.length;j++) {
    			
    			int sumSub = getSum(i, j, array);
    			
    			if(sumSub >= sum) {
    				sum = sumSub;
    				start = i;
    				end = j;
    				map.put(Arrays.asList(Arrays.copyOfRange(array, start, end)), List.of(i,j));
    			}
    		}
    	}
    	
    	int len =0;
    	int[] a = {};
    	for(List<int[]> i:map.keySet()) {
    		if(i.size() > len) {
    			len = i.size();
    		}
    	}
    	
    	
    	SubarrayResult sub = new SubarrayResult(Arrays.copyOfRange(array, start, end), start, end);

        return sub;
    }
}


class SubarrayResult {
    private int[] subarray;
    private int startIndex;
    private int endIndex;

    public SubarrayResult(int[] subarray, int startIndex, int endIndex) {
        this.subarray = subarray;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int[] getSubarray() {
        return subarray;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}

