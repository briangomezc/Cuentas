package com.jp.cxc.controller;

import com.jp.cxc.entity.Transacciones;
import com.jp.cxc.facade.TransaccionesFacade;
import com.jp.cxc.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "transaccionesController")
@ViewScoped
public class TransaccionesController extends AbstractController<Transacciones> {

    @Inject
    private ClienteController iDClienteController;
    @Inject
    private TipodocumentosController iDTipoDocumentoController;
    @Inject
    private TipomovimientosController iDTipoMovimientoController;
    @Inject
    private MobilePageController mobilePageController;

    public TransaccionesController() {
        // Inform the Abstract parent controller of the concrete Transacciones Entity
        super(Transacciones.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        iDClienteController.setSelected(null);
        iDTipoDocumentoController.setSelected(null);
        iDTipoMovimientoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIDCliente(ActionEvent event) {
        Transacciones selected = this.getSelected();
        if (selected != null && iDClienteController.getSelected() == null) {
            iDClienteController.setSelected(selected.getIDCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the Tipodocumentos controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIDTipoDocumento(ActionEvent event) {
        Transacciones selected = this.getSelected();
        if (selected != null && iDTipoDocumentoController.getSelected() == null) {
            iDTipoDocumentoController.setSelected(selected.getIDTipoDocumento());
        }
    }

    /**
     * Sets the "selected" attribute of the Tipomovimientos controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIDTipoMovimiento(ActionEvent event) {
        Transacciones selected = this.getSelected();
        if (selected != null && iDTipoMovimientoController.getSelected() == null) {
            iDTipoMovimientoController.setSelected(selected.getIDTipoMovimiento());
        }
    }

}
