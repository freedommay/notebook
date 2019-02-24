package concert.annotation;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(* concert.annotation.Performance.perform(..))")
    public void performance() { }

    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("Silencing cell phone");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
