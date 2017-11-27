package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LiquidarAspect {
	
	@Pointcut("execution(** com.demo.service.ComercialService.liquidarCaja(..))")
	public void liquidarCaja() {}
	
	@Around("liquidarCaja()")
	public void watchLiquidarCaja(ProceedingJoinPoint jp) {
		try {
			System.out.println("validar pagos");
			jp.proceed();
			System.out.println("actualizar caja");
		} catch (Throwable e) {
			System.out.println("ajustar pagos");
		}
	}
}
