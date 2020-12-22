package com.company.zlf.leetcode;

import java.util.Scanner;

public class vjudge629 {
    public static void main(String[] args) {
        char s[] = new char[1000000];
        int a[] = new int[1000000];
        Scanner in = new Scanner(System.in);
        String inputStr = in.next();
        int l = 1;
        int r = inputStr.length();
        for (int i = 0; i < r; i++) {
            if (s[i]=='l'){
                a[r--]=i+1;
            }
            else {
                a[l++]=i+1;
            }
        }
        for (int i=1;i<=r;i++){
            System.out.println(a[i]);
        }
        
    }
}

