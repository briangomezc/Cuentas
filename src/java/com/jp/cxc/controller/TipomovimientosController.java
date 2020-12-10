package com.jp.cxc.controller;

import com.jp.cxc.entity.Tipomovimientos;
import com.jp.cxc.entity.Transacciones;
import java.util.Collection;
import com.jp.cxc.facade.TipomovimientosFacade;
import com.jp.cxc.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipomovimientosController")
@ViewScoped
public class TipomovimientosController extends AbstractController<Tipomovimientos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isTransaccionesCollectionEmpty;

    public TipomovimientosController() {
        // Inform the Abstract parent controller of the concrete Tipomovimientos Entity
        super(Tipomovimientos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTransaccionesCollectionEmpty();
    }

    public boolean getIsTransaccionesCollectionEmpty() {
        return this.isTransaccionesCollectionEmpty;
    }

    private void setIsTransaccionesCollectionEmpty() {
        Tipomovimientos selected = this.getSelected();
        if (selected != null) {
            TipomovimientosFacade ejbFacade = (TipomovimientosFacade) this.getFacade();
            this.isTransaccionesCollectionEmpty = ejbFacade.isTransaccionesCollectionEmpty(selected);
        } else {
            this.isTransaccionesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transacciones entities
     * that are retrieved from Tipomovimientos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Transacciones page
     */
    public String navigateTransaccionesCollection() {
        Tipomovimientos selected = this.getSelected();
        if (selected != null) {
            TipomovimientosFacade ejbFacade = (TipomovimientosFacade) this.getFacade();
            Collection<Transacciones> selectedTransaccionesCollection = ejbFacade.findTransaccionesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transacciones_items", selectedTransaccionesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/transacciones/index";
    }

}
