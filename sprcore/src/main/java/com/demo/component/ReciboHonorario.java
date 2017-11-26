package com.demo.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pagoInformal")
public class ReciboHonorario implements ModalidadPago {

	@Override
	public String cobrar() {
		// TODO Auto-generated method stub
		return "wooooaaa... no tendre vacaciones!!";
	}

}
