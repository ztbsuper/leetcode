package jvm;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Marvin on 16/4/22.
 */
public class VolatileLongBenchmark {
    private volatile long v_i = 0;
    private long i = 0;
    private volatile AtomicLong a_v_i = new AtomicLong(0);
    private AtomicLong a_i = new AtomicLong(0);

    @Before
    public void setUp() throws Exception {
        v_i = 0;
        i = 0;
        a_v_i = new AtomicLong(0);
        a_i = new AtomicLong(0);
        for (; v_i < 99999L; v_i++) ;
        for (; i < 99999L; i++) ;
        for (; a_v_i.incrementAndGet() < 99999L; ) ;
        for (; a_i.incrementAndGet() < 99999L; ) ;
    }

    @Test
    public void should_output_benchmark_time_volatile_long() throws Exception {
        long start = DateTime.now().getMillis();
        for (; v_i < 999999999L; v_i++) ;
        System.out.println("v_i:" + v_i);
        System.out.println("volatile long running time:" + (DateTime.now().getMillis() - start));
    }

    @Test
    public void should_output_benchmark_time_long() throws Exception {
        long start = DateTime.now().getMillis();
        for (; i < 999999999L; i++) ;
        System.out.println("i:" + i);
        System.out.println("long running time:" + (DateTime.now().getMillis() - start));
    }


    @Test
    public void should_output_benchmark_time_volatile_atomic_long() throws Exception {
        long start = DateTime.now().getMillis();
        for (; a_v_i.incrementAndGet() < 999999999L; ) ;
        System.out.println("a_v_i:" + a_v_i.get());
        System.out.println("volatile atomic running time:" + (DateTime.now().getMillis() - start));

    }

    @Test
    public void should_output_benchmark_time_atomic_long() throws Exception {
        long start = DateTime.now().getMillis();
        for (; a_i.incrementAndGet() < 999999999L; ) ;
        System.out.println("a_i:" + a_i.get());
        System.out.println("atomic running time:" + (DateTime.now().getMillis() - start));


    }
}
