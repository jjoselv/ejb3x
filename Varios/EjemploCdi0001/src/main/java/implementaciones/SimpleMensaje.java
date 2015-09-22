package implementaciones;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import anotaciones.MaxNumber;
import anotaciones.Random;
import definiciones.Mensaje;

@RequestScoped
public class SimpleMensaje implements Mensaje {

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return "En " + getClass().getName();
	}

	private int numero = 100;

	@Produces
	@MaxNumber
	int getNumero() {
		return numero;
	}

	private java.util.Random random = new java.util.Random(
			System.currentTimeMillis());

	java.util.Random getRandom() {
		return random;
	}

	@Produces
	@Random
	int next() {
		return getRandom().nextInt(numero);
	}

	@PostConstruct
	private void despuesDeConstruir() {
		Logger.getLogger("SimpleMensaje").log(Level.INFO,
				"Después de construir");
	}

	@PreDestroy
	private void antesDeDestruir() {
		Logger.getLogger("SimpleMensaje").log(Level.INFO, "Antes de destruir");
	}
}
