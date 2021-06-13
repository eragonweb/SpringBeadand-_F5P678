package com.example.beadando.core.component;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MenuComponenet extends HorizontalLayout {

    public MenuComponenet(){
        Anchor carLink=new Anchor();
        carLink.setHref("/carmanager");
        carLink.setText("Cars");

        Anchor manufacturerLink=new Anchor();
        manufacturerLink.setHref("/manufacturermanager");
        manufacturerLink.setText("Manufacturers");

        Anchor userLink=new Anchor();
        userLink.setHref("/usermanager");
        userLink.setText("Users");

        add(carLink,manufacturerLink,userLink);

    }
}
