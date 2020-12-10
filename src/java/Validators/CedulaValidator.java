/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

/**
 *
 * @author Andres Tareas
 */
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
// Este validator es para comprobar valores numericos
@FacesValidator("Validators.CedulaValidator")


public class CedulaValidator implements Validator {

public static boolean validarCedula(String cedula){
	
    int suma = 0;

    final char[] peso = { '1', '2', '1', '2', '1', '2', '1', '2', '1', '2' };

    // Comprobaciones iniciales
	
    if ((cedula == null) || (cedula.length() != 11)){
    	return false;
    }

    // Si no es un nº => la descartamos  

 	try{
		Long.parseLong(cedula);
	}
	catch (Exception e){
    	return false;
	}
    
	for (int i = 0; i < 10; i++){

		int a = Character.getNumericValue(cedula.charAt(i));

		int b = Character.getNumericValue(peso[i]);
	
        char[] mult = Integer.toString(a * b).toCharArray();

	    if (mult.length > 1){
			a = Character.getNumericValue(mult[0]);
            b = Character.getNumericValue(mult[1]);
        }
		else{
           	a = 0;
            b = Character.getNumericValue(mult[0]);
    	}

		suma = suma + a + b;
	}

	int digito = (10 - (suma % 10)) % 10;

    // Comprobamos que el dígito de control coincide    
	if (digito != Character.getNumericValue(cedula.charAt(10))){
	    return false;
	}

    return true;
}    

          @Override
   public void validate(FacesContext facesContext,
      UIComponent component, Object value)
      throws ValidatorException {
           if(!validarCedula(value.toString()) ){
           FacesMessage msg = new FacesMessage("Cedula Invalida");
           msg.setSeverity(FacesMessage.SEVERITY_ERROR);
           throw new ValidatorException(msg);
       }
    }
    

}    
       
   

