package com.example.beadando.manufacturer.view;

import com.example.beadando.manufacturer.entity.ManufacturerEntity;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route
public class ManufacturerManagerView extends VerticalLayout {
private  ManufacturerEntity selectedManufacturer;
    public ManufacturerManagerView(){
        //adat
        List<ManufacturerEntity> list=new ArrayList<>();
        for (int i=0; i<100;i++){
            ManufacturerEntity entity=new ManufacturerEntity();
            entity.setId(Long.parseLong(i+" "));
            entity.setName("Gyár "+ i);

        }
        Grid<ManufacturerEntity> grid=new Grid<>();
        grid.setItems(list);
        grid.addColumn(ManufacturerEntity::getId).setHeader("ID");
        grid.addColumn(ManufacturerEntity::getName).setHeader("Neve");

        Button deleteBTN=new Button();
        deleteBTN.setEnabled(false);
        deleteBTN.setText("Törlés");
        deleteBTN.addClickListener(buttonClickEvent -> {

            list.remove(selectedManufacturer);
            grid.setItems(list);
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
