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
@FacesValidator("Validators.NumericValidator")
public class NumericValidator implements Validator {
    
   @Override
   public void validate(FacesContext facesContext,
      UIComponent component, Object value)
      throws ValidatorException {
       try{
           if(Integer.parseInt(value.toString()) < 0 ){
           FacesMessage msg = new FacesMessage("Valor Invalido");
           msg.setSeverity(FacesMessage.SEVERITY_INFO);
           throw new ValidatorException(msg);
       }
       }catch(Exception e){
           if(Double.parseDouble(value.toString()) < 0){
                FacesMessage msg = new FacesMessage("Valor Invalido");
           msg.setSeverity(FacesMessage.SEVERITY_ERROR);
           throw new ValidatorException(msg);
           }
       }
       
       
   }
}
