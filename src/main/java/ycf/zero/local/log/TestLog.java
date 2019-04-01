package ycf.zero.local.log;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class TestLog {
    public void test(){
        log.warn("{} poolSize: {}, queueSize: {},  taskCount: {},completedTaskCount: {}.", "fuck", 11, 22, 33, 44, 55);
    }
}
