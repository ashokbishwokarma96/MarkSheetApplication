package com.meroapp.marksheetapplication.MarksCalculation;

public class PercentageCalculator {

    private float iot,android,webApi;

    public PercentageCalculator(float iot, float android, float webApi) {
        this.iot = iot;
        this.android = android;
        this.webApi = webApi;
    }
    public float percentageCalculator(){
        return (iot+android+webApi)/300*100;

    }
}
