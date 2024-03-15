package EVA_Methoden;

import java.util.Scanner;

public class BMI_Calculator {
    double bmi;
    double weight;
    double height;
    String status;
    public static void main(String[] args) {
        BMI_Calculator bmi = new BMI_Calculator();

        bmi.input();
        bmi.process();
        bmi.output();
    }
    void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("*******************************************************************");
        System.out.println("                           BMI-Calulator                           ");
        System.out.println("*******************************************************************");
        System.out.println();

        System.out.print("Enter your height (cm): ");
        height = scan.nextDouble() /100;
        System.out.print("Enter your weight (kg): ");
        weight = scan.nextDouble();

    }
    void process(){
        bmi = weight / (height * height);
        bmi = ((int) (bmi * 100)) / 100.0;
        if(bmi < 18.5){
            status = "underweight";
        }
        else if(bmi >= 18.5 && bmi < 24.9){
            status = "normalweight";
        }
        else if(bmi >= 25 && bmi <29.9){
            status = "overweight";
        }
        else {
            status = "Obesity";
        }


    }
    void output(){
        System.out.println("Your BMI: " + bmi);
        System.out.println("You are: " + status);
    }
}
