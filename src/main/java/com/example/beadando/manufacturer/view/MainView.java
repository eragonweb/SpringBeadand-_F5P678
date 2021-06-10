package com.example.beadando.manufacturer.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route
public class MainView extends VerticalLayout {
    public  MainView(){
        add(new Text("Ez a fö oldala."));
        Button btn=new Button();
        btn.setText("Upload");
        btn.setIcon(VaadinIcon.UPLOAD.create());
        btn.addClickListener(buttonClickEvent -> {
            Notification.show("Valami történt");
        });
        add(btn);
    }
}
