package com.angular.angulartest.webscoket;

import com.angular.angulartest.dao.service.UserService;
import com.angular.angulartest.dao.service.impl.UserServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MyThread implements Runnable{
    private int sum;
    private int new_sum;
    private boolean stopMe = true;
    public void stopMe() {
        stopMe = false;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run()  {

        UserService userServiceImpl = new UserServiceImpl();
        sum=userServiceImpl.count();
        MyWebSocket wbs=new MyWebSocket();
        while(stopMe){
            new_sum=userServiceImpl.count();
            if(sum!=new_sum){
                System.out.println("change");
                sum=new_sum;
                wbs.onMessage(sum);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
