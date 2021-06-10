package com.example.beadando.manufacturer.view;

import com.example.beadando.manufacturer.entity.ManufacturerEntity;
import com.example.beadando.manufacturer.service.ManufacturerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Route
public class ManufacturerManagerView extends VerticalLayout {
private  ManufacturerEntity selectedManufacturer;
    @Autowired
    private ManufacturerService service;
    @PostConstruct
    public void init(){
        Grid<ManufacturerEntity> grid=new Grid<>();
        grid.setItems(service.findAll());
        grid.addColumn(ManufacturerEntity::getId).setHeader("ID");
        grid.addColumn(ManufacturerEntity::getName).setHeader("Neve");

        Button deleteBTN=new Button();
        deleteBTN.setEnabled(false);
        deleteBTN.setText("Törlés");
        deleteBTN.addClickListener(buttonClickEvent -> {

           service.deteteById(selectedManufacturer.getId());
            grid.setItems(service.findAll());
            selectedManufacturer=null;
            deleteBTN.setEnabled(false);
        });

        grid.asSingleSelect().addValueChangeListener(event ->{
            selectedManufacturer=event.getValue();
            deleteBTN.setEnabled(selectedManufacturer!=null);
        });
        add(deleteBTN);
        add(grid);


    }
}
