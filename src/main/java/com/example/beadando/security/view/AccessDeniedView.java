package com.example.beadando.security.view;

import com.example.beadando.core.component.MenuComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


public class AccessDeniedView extends VerticalLayout {

    public AccessDeniedView(){
        add(new MenuComponent());
        add("Not enough permissions");
    }

}
