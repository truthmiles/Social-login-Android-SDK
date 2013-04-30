package example.mobb_sdk;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.os.Looper;
import android.util.Log;

/*
 * used to execute task in background(parallel) using thread concept 
 */
public class ThreadUtils {
	  private static ThreadPoolExecutor sExecutor;
	    static {
	        sExecutor = new ThreadPoolExecutor(0, 10, 600, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
	        final ThreadFactory originalFactory = sExecutor.getThreadFactory();
	        sExecutor.setThreadFactory(new ThreadFactory() {
	            public Thread newThread(Runnable runnable) {
	                Thread t = originalFactory.newThread(runnable);
	                t.setName("LR-ThreadUtils~" + t.getName());
	                return t;
	            }
	        });
	    }
	        public static void executeInBg(Runnable r) {
	            if (Looper.myLooper() == null) {
	            	Log.e("IF Block",r.getClass().toString());
	                r.run();
	            } else {
	            	Log.e("Else Block",r.getClass().toString());
	                sExecutor.execute(r);
	            }
	        }
	    }
