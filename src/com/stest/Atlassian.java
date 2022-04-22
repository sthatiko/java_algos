package com.stest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Atlassian {


    static class Plan{
        String planType;
        Float monthlyCost;

        public Plan(String planType, Float monthlyCost){
            this.planType = planType;
            this.monthlyCost = monthlyCost;

        }

        static Map<String, Float> planDetails = new HashMap<>();
        static {
            planDetails.put("BASIC", 9.99f);
            planDetails.put("PREMIUM", 249.99f);
            planDetails.put("STANDARD", 49.99f);

        }


        public static Plan getPlanInfo(String planType){
            Float cost = planDetails.get(planType);
            return new Plan(planType, cost);
        }
    }

    static class Subscription{
        String customerId;
        String productName;
        String planType;
        Date startDate;

        public Subscription(String planType, Date date){
            this.planType = planType;
            this.startDate = date;
        }
    }

    class PaymentInfo{
        Float[] monthlyPrice;
        Float yearlyPrice;

        public PaymentInfo(Float[] monthlyPrice, Float yearlyPrice){
            this.monthlyPrice = monthlyPrice;
            this.yearlyPrice = yearlyPrice;
        }

    }

    public PaymentInfo getPaymentData(Subscription sub){
        PaymentInfo result;
        Plan p = Plan.getPlanInfo(sub.planType);
        int starMonth = sub.startDate.getMonth();
        Float[] monthlyInfo = new Float[12];
        for(int i=0;i< starMonth;i++){
            monthlyInfo[i]=0f;
        }
        for(int i=starMonth;i< 12;i++){
            monthlyInfo[i]=p.monthlyCost;
        }
        result = new PaymentInfo(monthlyInfo, p.monthlyCost*(12-starMonth));
        return result;
    }

    public static void main(String[] args) throws ParseException {
        Atlassian at = new Atlassian();
        String sDate1="01/01/2022";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        Subscription s = new Subscription("STANDARD", date1);
        PaymentInfo p = at.getPaymentData(s);
        System.out.println(p.yearlyPrice);
        System.out.println(Arrays.asList(p.monthlyPrice));

    }
}

//
//[{
//        "planId": "BASIC",
//        "monthlyCost": "9.99"
//        }, {
//        "planId": "STANDARD",
//        "monthlyCost": "49.99"
//        }, {
//        "planId": "PREMIUM",
//        "monthlyCost": "249.99"
//        }]
//
//
//        {
//        "customerId": "c1",
//        "product": {
//        "name": "Jira",
//        "subscription" : {
//        "planId": "BASIC",
//        "startDate": "2021-01-01"  //  YYYY-MM-DD format
//        }
//        }
//        }