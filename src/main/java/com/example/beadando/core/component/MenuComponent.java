package com.example.beadando.core.component;

import com.example.beadando.security.config.SecurityUtils;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MenuComponent extends HorizontalLayout {

    public MenuComponent() {
        Anchor bookLink = new Anchor();
        bookLink.setHref("/carmanager");
        bookLink.setText("Books");

        Anchor authorLink = new Anchor();
        authorLink.setHref("/manufacturermanager");
        authorLink.setText("Authors");
        add(bookLink, authorLink);

        if (SecurityUtils.isAdmin()) {
            Anchor userLink = new Anchor();
            userLink.setHref("/usermanager");
            userLink.setText("Users");
            add(userLink);
        }


    }
}
