package com.company;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


class RunC implements Runnable{

        @Override
        public void run() {


            System.out.println(Thread.currentThread());
          Logger logger =  Logger.getLogger(RunC.class.getName());
            logger.log(Level.INFO,"Task1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public class ScheduledThreadPoolEx {
        public static void main(String[] args){
            Thread t = Thread.currentThread();
            Logger logger =Logger.getLogger(RunC.class.getName());
            logger.log(Level.INFO,"Start");
            int coreCount = Runtime.getRuntime().availableProcessors();
            System.out.println(coreCount);
            ScheduledExecutorService service = Executors.newScheduledThreadPool(coreCount);


            //service.schedule(new RunC(),10, TimeUnit.SECONDS);
            //service.scheduleAtFixedRate(new RunC(),5,10, TimeUnit.SECONDS);
            service.scheduleWithFixedDelay(new RunC(),5,10,TimeUnit.SECONDS);

            //service.shutdown();
        }

    }


