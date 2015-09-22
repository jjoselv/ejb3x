package implementaciones;

import anotaciones.Informal;
import definiciones.Mensaje;

@Informal
public class InformalMensaje implements Mensaje {

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return "En " + getClass().getName();
	}

}
