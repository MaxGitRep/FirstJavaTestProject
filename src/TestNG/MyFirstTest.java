package TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

/**
 * Created by mpa on 4/7/2017.
 */

public class MyFirstTest{

    @Test
    public void SearchJobAndCheck() throws Exception {
        System.out.println("Start");
        PrepareTest prepare_test = new PrepareTest();
        WebDriver startBrowser = prepare_test.startBrowser("firefox");

        LoginTest checkSearchFunctionality = new LoginTest(startBrowser).openMainPage("http://indeed.co.uk")
                .addSearchData("Selenium", "London");

        assertEquals(checkSearchFunctionality.getCheckSearchCount(), "Jobs 1 to 10 of 800");
        assertEquals(checkSearchFunctionality.getCheckSearchTitle(), "Selenium Jobs, vacancies in London | Indeed.co.uk");
        System.out.println("Finish");
    }

    @Test(enabled = false)
        public void notATest1() {

        System.out.println("NoLog");

    }

//Task 1
    static String b = "Hi";
    String c = "5";
    int x = 7;

    //psvm
    public static void main(String[] args) {
        //Ctrl+D
        //sout
        System.out.println(b+" Max");
        double Bart;
        Bart = 46.155;

        double df, dfdf, dfdfdf;
        df = 56;
        dfdf = 10;
        dfdfdf = df / dfdf;
        System.out.println("You have "+dfdfdf);
        System.out.print("but I wonna ");
        System.out.println(Bart);
//Task 2
        int Fry = 20;
        if (Fry >= 15){
            System.out.println("Fry just got " + Fry + " years");
        } else {
            System.out.println("Fry not just got " + Fry + " years");
        }
// Task 3
        int Homer = 110;
        int Peter = 120;

        if (Homer > 100 || Peter > 130){
            System.out.println("Ideal width!");
        } else {
            System.out.println("Go and eat!");
        }

        int Beer = 3;
//Task 4
        switch (Beer){
            case 1:
                System.out.println("Only 1 beer");
                break;
            case 2:
                System.out.println("2 beer");
                break;
            case 3:
                System.out.println("3 beer");
                break;
            case 4:
                System.out.println("4 beer");
                break;
            default:
                System.out.println("Too much beer");
                break;
        }

//Task 5
        int[] odd = {6, 15, 10, 20, 4, 2};
        int a = odd[0];

        for (int i: odd){
            if (a < i){
                a = i;
            }
        }
        System.out.printf("%s is a biggest number", a);
        System.out.println("!");

//Task 6
        int Hom = 110;
        System.out.println(Hom > 115 ? "Yes, very fat" : "Good, you are sporty!");

//Task 7



    }


//Task 8
    public static String cool(){
        //First Calc
        Scanner Bender = new Scanner(System.in);
        double fn, sn, result;
        System.out.println("Please, enter first number: ");
        fn = Bender.nextDouble();
        System.out.println("Now enter second number: ");
        sn = Bender.nextDouble();
        result = fn + sn;
        System.out.println("Sum: " + result);
        return "I m cool!";
    }

}
