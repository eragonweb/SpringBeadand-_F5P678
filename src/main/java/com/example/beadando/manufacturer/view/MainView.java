package com.example.beadando.manufacturer.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    public  MainView(){
        add(new Text("Ez a fö oldala."));
    }
}
