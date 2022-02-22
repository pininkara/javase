// 2022/2/21 19:32

package nnk.nono.sw.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    @Scheduled(cron="0 38 19 * * ?")
    public void hello(){
        System.out.println("你被执行哩");
    }
}
