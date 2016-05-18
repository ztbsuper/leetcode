package jvm;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Marvin on 16/4/22.
 */
public class VolatileIntBenchmark {
    private volatile int v_i = 0;
    private int i = 0;
    private volatile AtomicInteger a_v_i = new AtomicInteger(0);
    private AtomicInteger a_i = new AtomicInteger(0);

    @Before
    public void setUp() throws Exception {
        v_i = 0;
        i = 0;
        a_v_i = new AtomicInteger(0);
        a_i = new AtomicInteger(0);
        for (; v_i < 99999L; v_i++) ;
        for (; i < 99999L; i++) ;
        for (; a_v_i.incrementAndGet() < 99999L; ) ;
        for (; a_i.incrementAndGet() < 99999L; ) ;
    }

    @Test
    public void should_output_benchmark_time_volatile_long() throws Exception {
        long start = DateTime.now().getMillis();
        for (; v_i < 999999999L; v_i++) ;
        System.out.println("volatile int running time:" + (DateTime.now().getMillis() - start));
    }

    @Test
    public void should_output_benchmark_time_long() throws Exception {
        long start = DateTime.now().getMillis();
        for (; i < 999999999L; i++) ;
        System.out.println("int running time:" + (DateTime.now().getMillis() - start));
    }


    @Test
    public void should_output_benchmark_time_volatile_atomic_long() throws Exception {
        long start = DateTime.now().getMillis();
        for (; a_v_i.incrementAndGet() < 999999999L; ) ;
        System.out.println("volatile atomic running time:" + (DateTime.now().getMillis() - start));

    }

    @Test
    public void should_output_benchmark_time_atomic_long() throws Exception {
        long start = DateTime.now().getMillis();
        for (; a_i.incrementAndGet() < 999999999L; ) ;
        System.out.println("atomic running time:" + (DateTime.now().getMillis() - start));


    }
}
