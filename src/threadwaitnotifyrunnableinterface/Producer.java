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
public class Producer implements Runnable{

    Resource s;
    Thread t;
    
    Producer(Resource r){
        s=r;
        t=new Thread(this,"Producer");
        t.start();
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
            s.produce(i);                        
        }
        System.out.println("Producer Terminating");
    }    
}
