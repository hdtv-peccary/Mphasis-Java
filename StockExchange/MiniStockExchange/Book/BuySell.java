package com.mph.book;

public class BuySell {

        private String buySell;


        public static enum buySell{
            BUY_ORDER,
            SELL_ORDER
        }

        private BuySell(String buySell) {
            this.buySell = buySell;
        }

        @Override
        public String toString() {
            return "BuySell{" +
                    "buySell='" + buySell + '\'' +
                    '}';
        }

    }


