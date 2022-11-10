package org.selenium.practice;

public class Main {
    public static void main() throws InterruptedException {
        HomePageTests tests = new HomePageTests();
        tests.loginAndCheckHomePageView();
        tests.checkHomePageElements();
    }
}
