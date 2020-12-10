package com.jp.cxc.controller;

import com.jp.cxc.entity.Balances;
import com.jp.cxc.facade.BalancesFacade;
import com.jp.cxc.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "balancesController")
@ViewScoped
public class BalancesController extends AbstractController<Balances> {

    @Inject
    private ClienteController iDClienteController;
    @Inject
    private MobilePageController mobilePageController;

    public BalancesController() {
        // Inform the Abstract parent controller of the concrete Balances Entity
        super(Balances.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        iDClienteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIDCliente(ActionEvent event) {
        Balances selected = this.getSelected();
        if (selected != null && iDClienteController.getSelected() == null) {
            iDClienteController.setSelected(selected.getIDCliente());
        }
    }

}
