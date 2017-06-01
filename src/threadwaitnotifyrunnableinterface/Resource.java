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
public class Resource {
    int n=-1;
    boolean flag = true;
    
    synchronized void produce(int a){
        while(!flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
            }           
        }
        n=a;
        System.out.println("Producer ::: "+n);
        flag=false;
        notify();
    }
    synchronized int consume(){
        while(flag){
            try {
                wait();
            } catch (Exception e) {
            }
        }
        flag = true;
        notify();
        System.out.println("Consume ::: "+n);
        return n;
    }
}
