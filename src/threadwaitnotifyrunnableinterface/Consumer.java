/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwaitnotifyrunnableinterface;

/**
 *
 * @author tiago.lucas
 */
public class Consumer implements Runnable{
    Resource s;
    Thread t;
    
    Consumer(Resource r){
        s=r;
        t=new Thread(this,"Consumer");
        t.start();
    }

    @Override
    public void run() {
        int i;
        do{
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
            i=s.consume();
        }while(i!=10);
        System.out.println("Consumer Terminating");
    }    
}
