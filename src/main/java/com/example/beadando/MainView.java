package com.example.beadando;

import com.example.beadando.core.component.MenuComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route()
public class MainView extends VerticalLayout {

    public MainView(){
        add(new MenuComponent());
        add("Main page");
    }

}
