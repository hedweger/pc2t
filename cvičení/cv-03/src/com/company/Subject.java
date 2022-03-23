package com.company;

public interface Subject {
        public String ReturnName();
        public int FinalPoints();
        public boolean Credit();

        static final int MinCredit = 15;
}
