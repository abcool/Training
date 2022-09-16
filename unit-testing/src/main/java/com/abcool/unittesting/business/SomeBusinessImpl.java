package com.abcool.unittesting.business;

import com.abcool.unittesting.data.ISomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private ISomeDataService dataService;

    // Assigns an object to Interface reference
    public void setDataService(ISomeDataService dataService) {
        this.dataService = dataService;
    }
    public int returnSum(int[] arr){
        return Arrays.stream(arr).sum();
    }
    public int returnSumUsingDataService(){
        int[] input = dataService.retrieveData();
        return Arrays.stream(input).sum();
    }
}
