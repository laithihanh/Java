/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 *
 * @author USER
 */
public class BTH5 {
    private static class MyWatchQueueReader implements Runnable {
        private WatchService myWatcher;

        public MyWatchQueueReader(WatchService myWatcher) {
            this.myWatcher = myWatcher;
        }
    
        @Override
        public void run() {
            try {
                WatchKey key = myWatcher.take();
                while (key != null) {
                for (WatchEvent event : key.pollEvents()) {
                System.out.printf("Received %s event for file: %s\n",
                event.kind(), event.context());
                }
                key.reset();
                key = myWatcher.take();
                }
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            System.out.println("Stopping thread");
        }
        public static final String DIRECTORY_TO_WATCH = "/Home/test";
        
        public static void main(String[] args) throws Exception{
            Path toWatch = null;
            try {
                toWatch = Paths.get(DIRECTORY_TO_WATCH);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (toWatch == null) {
            throw new UnsupportedOperationException("Không tìm thấy thư mục");
            }
            WatchService myWatcher = toWatch.getFileSystem().newWatchService();
            
            MyWatchQueueReader fileWatcher = new MyWatchQueueReader(myWatcher);
            Thread th = new Thread(fileWatcher, "FileWatcher");
            th.start();
            
            toWatch.register(myWatcher, ENTRY_CREATE, ENTRY_MODIFY);
            th.join();
        }
    
    }
}
