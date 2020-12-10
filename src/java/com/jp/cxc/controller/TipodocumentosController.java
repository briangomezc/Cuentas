package com.jp.cxc.controller;

import com.jp.cxc.entity.Tipodocumentos;
import com.jp.cxc.entity.Transacciones;
import java.util.Collection;
import com.jp.cxc.facade.TipodocumentosFacade;
import com.jp.cxc.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipodocumentosController")
@ViewScoped
public class TipodocumentosController extends AbstractController<Tipodocumentos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isTransaccionesCollectionEmpty;

    public TipodocumentosController() {
        // Inform the Abstract parent controller of the concrete Tipodocumentos Entity
        super(Tipodocumentos.class);
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
        Tipodocumentos selected = this.getSelected();
        if (selected != null) {
            TipodocumentosFacade ejbFacade = (TipodocumentosFacade) this.getFacade();
            this.isTransaccionesCollectionEmpty = ejbFacade.isTransaccionesCollectionEmpty(selected);
        } else {
            this.isTransaccionesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transacciones entities
     * that are retrieved from Tipodocumentos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Transacciones page
     */
    public String navigateTransaccionesCollection() {
        Tipodocumentos selected = this.getSelected();
        if (selected != null) {
            TipodocumentosFacade ejbFacade = (TipodocumentosFacade) this.getFacade();
            Collection<Transacciones> selectedTransaccionesCollection = ejbFacade.findTransaccionesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transacciones_items", selectedTransaccionesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/transacciones/index";
    }

}
