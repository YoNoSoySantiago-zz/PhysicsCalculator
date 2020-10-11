package com.feraldragons.physicscalculator;

import android.text.PrecomputedText;

public class Calculator {


    public double[]calculateFinalVelocities(double mass1, double mass2, double initialVelocity1, double initialVelocity2){
        double results[] = new double[2];
        results[0]= calculateVFinal1(mass1,mass2,initialVelocity1,initialVelocity2);
        results[1]= calculateVFinal2(mass1,mass2,initialVelocity1,initialVelocity2,results[0]);

        return results;
    }
    private double calculateVFinal1(double mass1,double mass2,double initialVelocity1,double initialVelocity2){
        double result= 0;
        result = ((mass1-mass2)/(mass1+mass2))*initialVelocity1 + ((2*mass2)/(mass1+mass2))*initialVelocity2;
        return result;
    }
    private double calculateVFinal2(double mass1,double mass2,double initialVelocity1,double initialVelocity2,double finalVelocity1){
        double result= 0;
        result = ((mass1/mass2)*(initialVelocity1-finalVelocity1))+initialVelocity2;
        return result;
    }
    public double[]calculateInitialVelocities(double mass1, double mass2, double finalVelocity1, double finalVelocity2){
        double results[] = new double[2];
        results[0]= calculateVInitial1(mass1,mass2,finalVelocity1,finalVelocity2);
        results[1]= calculateVInitial2(mass1,mass2,finalVelocity1,finalVelocity2,results[0]);

        return results;
    }
    private double calculateVInitial1(double mass1,double mass2,double finalVelocity1, double finalVelocity2){
        double result= 0;
        result = ((mass1-mass2)/(mass1+mass2))*finalVelocity1 + ((2*mass2)/(mass1+mass2))*finalVelocity2;
        return result;
    }
    private double calculateVInitial2(double mass1,double mass2,double finalVelocity1, double finalVelocity2,double initialVelocity1){
        double result= 0;
        result = finalVelocity2+((mass1/mass2)*(initialVelocity1-finalVelocity1));
        return result;
    }

}
