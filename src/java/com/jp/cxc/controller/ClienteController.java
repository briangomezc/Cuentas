package com.jp.cxc.controller;

import com.jp.cxc.entity.Cliente;
import com.jp.cxc.entity.Balances;
import com.jp.cxc.entity.Transacciones;
import java.util.Collection;
import com.jp.cxc.facade.ClienteFacade;
import com.jp.cxc.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "clienteController")
@ViewScoped
public class ClienteController extends AbstractController<Cliente> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isBalancesCollectionEmpty;
    private boolean isTransaccionesCollectionEmpty;

    public ClienteController() {
        // Inform the Abstract parent controller of the concrete Cliente Entity
        super(Cliente.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsBalancesCollectionEmpty();
        this.setIsTransaccionesCollectionEmpty();
    }

    public boolean getIsBalancesCollectionEmpty() {
        return this.isBalancesCollectionEmpty;
    }

    private void setIsBalancesCollectionEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isBalancesCollectionEmpty = ejbFacade.isBalancesCollectionEmpty(selected);
        } else {
            this.isBalancesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Balances entities that
     * are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Balances page
     */
    public String navigateBalancesCollection() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            Collection<Balances> selectedBalancesCollection = ejbFacade.findBalancesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Balances_items", selectedBalancesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/balances/index";
    }

    public boolean getIsTransaccionesCollectionEmpty() {
        return this.isTransaccionesCollectionEmpty;
    }

    private void setIsTransaccionesCollectionEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isTransaccionesCollectionEmpty = ejbFacade.isTransaccionesCollectionEmpty(selected);
        } else {
            this.isTransaccionesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transacciones entities
     * that are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Transacciones page
     */
    public String navigateTransaccionesCollection() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            Collection<Transacciones> selectedTransaccionesCollection = ejbFacade.findTransaccionesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transacciones_items", selectedTransaccionesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/transacciones/index";
    }

}
