/*
 * Copyright (c) 2017. This software, file, content or part of it is provided
 */

package com.hamsoftug.receiptnumbers;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by USER on 1/23/2017.
 */

public class ReceiptNumbers {

    private int RN_total = 100;  //Total number of receipt numbers to be generated
    private int RN_lower_limit = 1; //The lower limit of receipt numbers
    private int RN_upper_limit = 100; //Upper limit of receipt numbers
    //private boolean RN_continue = false; //Check if to continue or regenerate new receipt numbers
    private String ReceiptNumber;
    private int Next_number = 1;

    public ReceiptNumbers(int RN_total_receipts){
        this.RN_total = RN_total_receipts;
        this.RN_upper_limit = RN_total_receipts;
    }

    public ReceiptNumbers(int RN_lower_limit, int RN_upper_limit){
        this.RN_upper_limit = RN_upper_limit;
        this.RN_lower_limit = RN_lower_limit;
        this.RN_total = (RN_upper_limit - RN_lower_limit);
        this.Next_number = RN_lower_limit;
    }

    /**
     * Default start value and end value of 1 and 100 respectively will be used*/
    public ReceiptNumbers(){

    }

    private int charLength(){
        String chars = String.valueOf(RN_upper_limit);
        return chars.length();
    }

    public int getRN_total() {
        return RN_total;
    }

    public ReceiptNumbers setRN_total(int RN_total) {
        this.RN_total = RN_total;
        return this;
    }

    public int getRN_lower_limit() {
        return RN_lower_limit;
    }

    public ReceiptNumbers setRN_lower_limit(int RN_lower_limit) {
        this.RN_lower_limit = RN_lower_limit;
        return this;
    }

    public int getRN_upper_limit() {
        return RN_upper_limit;
    }

    public ReceiptNumbers setRN_upper_limit(int RN_upper_limit) {
        this.RN_upper_limit = RN_upper_limit;
        return this;
    }

    public String getReceiptNumber(int number_index) {

        String str_number = this.checkReturn(number_index);

        return str_number;
    }

    public String getReceiptNumber() {
        String str_number = this.checkReturn();
        return str_number;
    }

    private void setReceiptNumber(String receiptNumber) {
        ReceiptNumber = receiptNumber;
    }

    private String checkReturn(){

        char[] zeros = new char[this.charLength()];

        Arrays.fill(zeros, '0');
        String format = String.valueOf(zeros);
        DecimalFormat df = new DecimalFormat(format);

        String numberAsString;

        if(Next_number<=RN_upper_limit && Next_number>=RN_lower_limit) {
            numberAsString = df.format(Next_number);

        } else if(Next_number<RN_lower_limit) {
            Next_number = this.RN_upper_limit;
            numberAsString = df.format(this.RN_upper_limit);
        } else {
            Next_number = this.RN_lower_limit;
            numberAsString = df.format(this.RN_lower_limit);
        }

        Next_number++;

        return numberAsString;
    }

    private String checkReturn(int number_index){
        String numberAsString;

        char[] zeros = new char[this.charLength()];
        Arrays.fill(zeros, '0');
        String format = String.valueOf(zeros);

        DecimalFormat df = new DecimalFormat(format);

        if(number_index<=RN_upper_limit && number_index >= RN_lower_limit) {
            numberAsString = df.format(number_index);
        } else if(number_index<RN_lower_limit) {
            numberAsString = df.format(this.RN_upper_limit);
        } else {
            numberAsString = df.format(this.RN_lower_limit);
        }

        return numberAsString;
    }
}
