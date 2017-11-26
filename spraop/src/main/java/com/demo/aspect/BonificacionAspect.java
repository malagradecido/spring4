package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.demo.bean.Producto;

@Component
@Aspect
public class BonificacionAspect {

	@Pointcut("execution(** com.demo.service.ComercialService.bonificar(..))")
	public void bonificar() {}
	
	@Pointcut("execution(** com.demo.service.ComercialService.validarStock(int)) && args(codigoProducto)")
	public void validarStock(int codigoProducto) {};
	
	@Pointcut("execution(** com.demo.service.ComercialService.validarStock(com.demo.bean.Producto)) && args(producto)")
	public void validarStockObject(Producto producto) {};
	
	@Before("bonificar()")
	public void reservarStock() {
		System.out.println("reservando stock");
	}
	
	@AfterReturning("bonificar()")
	public void realizarMovimientosAlmacen() {
		System.out.println("realizando movimientos de almacen");
	}
	
	@AfterThrowing("bonificar()")
	public void revertirReservaStock() {
		System.out.println("revirtiendo reserva de stock");
	}
	
	@Before("validarStock(codigoProducto)")
	public void consultarStock(int codigoProducto){
		System.out.println(
		String.format("consultando stock en almacen.. %d",codigoProducto));
	}
	
	@AfterReturning("validarStock(codigoProducto)")
	public void actualizarStock(int codigoProducto){
		System.out.println(
		String.format("actualizando stock en almacen.. %d",codigoProducto));
	}
	
	@AfterThrowing("validarStock(codigoProducto)")
	public void revertirStock(int codigoProducto){
		System.out.println(
		String.format("revirtiendo stock en almacen.. %d",codigoProducto));
	}
	
	/*@AfterReturning("validarStockObject(producto)")
	public void actualizarStockObject(Producto producto){
		System.out.println("actualizando stock en almacen de objecto producto..");
	}*/
	
	@Around("validarStockObject(producto)")
	public void actualizarStockObject(ProceedingJoinPoint jp, Producto producto){
		
		try {
			System.out.println("actualizando stock en almacen de objecto producto..");
			jp.proceed();
			System.out.println("actualizando inventario..");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error actualizando inventario..");
		}
		
	}
}
