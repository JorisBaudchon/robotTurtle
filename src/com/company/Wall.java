package com.company;

public class Wall {

        String type;
        boolean amovible;
        boolean destructible;


        public Wall(String type, boolean amovible, boolean destructible) {

            this.type = type;
            this.amovible=amovible;
            this.destructible=destructible;

        }

        public String getType() {
            return type;
        }

        public boolean isAmovible() {
            return amovible;
        }

        public boolean isDestructible() {
            return destructible;
        }



}
